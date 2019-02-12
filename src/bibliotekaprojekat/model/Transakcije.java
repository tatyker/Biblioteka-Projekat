package bibliotekaprojekat.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Svi upiti za bazu podataka, pocevsi od dobijanja EntityManagera.
 *
 */
public class Transakcije {

    public static Bibliotekar logovanje(String username, String password) {//nalazi korisnika po unetom korisnickom imenu i sifri
        try {
            EntityManager em = uzmiEM();
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Bibliotekar.findByKorisnickoImeSifra");
            query.setParameter("korisnickoIme", username);
            query.setParameter("sifra", password);
            Bibliotekar bibliotekar = (Bibliotekar) query.getSingleResult();
            em.getTransaction().commit();
            em.close();
            return bibliotekar;
        } catch (Exception e) {
            return null;
        }
    }

    public static List<Izdavanje> nadjiKnjigu(int idKnjiga) {//nalazi izdate knjige
        try {
            EntityManager em = uzmiEM();
            Query q = em.createQuery("SELECT i FROM Izdavanje i WHERE i.idKnjiga.id = :idKnjiga");
            q.setParameter("idKnjiga", idKnjiga);
            List<Izdavanje> izdate = (List<Izdavanje>) q.getResultList();

            em.close();
            return izdate;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Knjige> pretraziKnjige(String nazivKnjige) {//pretrazuje knjige po nazivu
        try {
            EntityManager em = uzmiEM();
            Query q = em.createQuery("SELECT k FROM Knjige k WHERE lower(k.naziv) like :unesenNaziv");
            q.setParameter("unesenNaziv", "%" + nazivKnjige + "%");
            List<Knjige> nadjene = (List<Knjige>) q.getResultList();
            em.close();

            return nadjene;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Knjige> pretraziKnjigeAutor(String autor) {//pretrazuje knjige po autoru
        try {
            EntityManager em = uzmiEM();
            Query q = em.createQuery("SELECT k FROM Knjige k WHERE lower(k.autor) like :unesenAutor");
            q.setParameter("unesenAutor", "%" + autor + "%");
            List<Knjige> nadjene = (List<Knjige>) q.getResultList();
            em.close();

            return nadjene;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean ispraviClana(int id, String ime, String prezime, String brDokumenta,
            String adresa, String grad, String godRodjenja, String pol, String brClanske) { //ispravlja podatke o clanu nadjenom preko id

        EntityManager em = uzmiEM();
        em.getTransaction().begin();
        Query q = em.createNamedQuery("Clanovi.findById");
        q.setParameter("id", id);
        Clanovi clan = (Clanovi) q.getSingleResult();

        clan.setIme(ime);
        clan.setPrezime(prezime);
        clan.setBrDokumenta(brDokumenta);
        clan.setAdresa(adresa);
        clan.setGrad(grad);
        clan.setGodinaRodj(Integer.parseInt(godRodjenja));
        clan.setPol(pol);
        clan.setBrClanske(brClanske);

        em.getTransaction().commit();
        em.close();

        return true;
    }

    public static boolean dodajClana(String ime, String prezime, String brDokumenta,
            String adresa, String grad, String godRodjenja, String pol, String brClanske) {//dodaje novog clana u bazu

        try {
            EntityManager em = uzmiEM();
            em.getTransaction().begin();

            Clanovi clan = new Clanovi();
            clan.setIme(ime);
            clan.setPrezime(prezime);
            clan.setBrDokumenta(brDokumenta);
            clan.setAdresa(adresa);
            clan.setGrad(grad);
            clan.setGodinaRodj(Integer.parseInt(godRodjenja));
            clan.setPol(pol);
            clan.setBrClanske(brClanske);

            em.persist(clan);

            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean vratiKnjigu(int id) {//nalazi izdavanje po id i dodaje mu trenutni datum kao datum vracanja a postavlja status na vracena
        try {
            
            EntityManager em = uzmiEM();
            em.getTransaction().begin();
            Query q = em.createNamedQuery("Izdavanje.findById");
            q.setParameter("id", id);
            Izdavanje izdataKnjiga = (Izdavanje) q.getSingleResult();

            Status idStatus = new Status();
            idStatus.setId(2);

            Date date = new Date();

            izdataKnjiga.setDatumVracanja(date);

            izdataKnjiga.setIdStatus(idStatus);
            

            em.getTransaction().commit();
            em.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean izdajKnjigu(Knjige knjiga, Clanovi clan) {//setuje zajedno clana i knjigu, dodaje im trenutni datum kao datum izdavanja i postavlja status na izdata

        try {
            EntityManager em = uzmiEM();
            em.getTransaction().begin();

            Izdavanje novoIzdavanje = new Izdavanje();
            Status idStatus = new Status();
            idStatus.setId(1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String datum = sdf.format(date);

            novoIzdavanje.setIdKnjiga(knjiga);
            novoIzdavanje.setIdClan(clan);
            novoIzdavanje.setDatumIzdavanja((new java.sql.Date(sdf.parse(datum).getTime())));

            novoIzdavanje.setIdStatus(idStatus);

            em.persist(novoIzdavanje);

            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Clanovi> uzmiSveClanove() {//uzma sve podatke o clanovima iz baze
        try {
            EntityManager em = uzmiEM();
            Query q = em.createNamedQuery("Clanovi.findAll");
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean ispraviKnjigu(int id, String naziv, String autor, String isbn, String godIzdanja, String izdavac, String zanr) {
                                        //ispravlja podatke o knjizi (koju nalazi po prosledjenom id) u bazi
        EntityManager em = uzmiEM();
        em.getTransaction().begin();
        Query q = em.createNamedQuery("Knjige.findById");
        q.setParameter("id", id);
        Knjige knjiga = (Knjige) q.getSingleResult();

        knjiga.setNaziv(naziv);
        knjiga.setAutor(autor);
        knjiga.setIsbn(isbn);
        knjiga.setGodinaIzdanja(Integer.parseInt(godIzdanja));
        knjiga.setIzdavac(izdavac);
        knjiga.setZanr(zanr);

        em.getTransaction().commit();
        em.close();

        return true;
    }

    public static boolean dodajKnjigu(String naziv,
            String autor, String isbn,
            String godIzdanja, String izdavac, String zanr) {
                    //dodaje podatke o novoj knjizi u bazu
        try {
            EntityManager em = uzmiEM();
            em.getTransaction().begin();

            Knjige knjiga = new Knjige();
            knjiga.setNaziv(naziv);
            knjiga.setAutor(autor);
            knjiga.setIsbn(isbn);
            knjiga.setGodinaIzdanja(Integer.parseInt(godIzdanja));
            knjiga.setIzdavac(izdavac);
            knjiga.setZanr(zanr);

            em.persist(knjiga);

            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Knjige> uzmiSveKnjige() {//uzma sve podatke o knjigama iz baze
        try {
            EntityManager em = uzmiEM();
            Query q = em.createNamedQuery("Knjige.findAll");
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Izdavanje> uzmiSveIzdateKnjige() {//pronalazenje svih izdatih knjiga
        try {
            EntityManager em = uzmiEM();
            Query query = em.createNamedQuery("Izdavanje.findAll");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Izdavanje ispraviIzdavanje(Izdavanje izdavanje) {
        EntityManager em = uzmiEM();
        em.getTransaction().begin();
        izdavanje = em.merge(izdavanje);
        em.getTransaction().commit();
        return izdavanje;
    }

    public static List<Bibliotekar> uzmiSveBibliotekare() {//uzimanje podataka o bibliotekarima iz baze
        try {
            EntityManager em = uzmiEM();
            Query q = em.createNamedQuery("Bibliotekar.findAll");
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean dodajNovogBibliotekara(Bibliotekar bibliotekar) {//dodavanje novog objekra bibliotekar u bazu
        if (bibliotekar == null) {
            return false;
        }

        try {
            EntityManager em = uzmiEM();
            em.getTransaction().begin();

            em.persist(bibliotekar);

            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean ispraviBibliotekara(int id, String sifra, String ime, String prezime) {//ispravlja sifru, ime ili prezime bibliotekara ciji su podaci prosledjeni

        EntityManager em = uzmiEM();
        em.getTransaction().begin();
        Query q = em.createNamedQuery("Bibliotekar.findById");//bibliotekar se locira po id
        q.setParameter("id", id);
        Bibliotekar bibliotekar = (Bibliotekar) q.getSingleResult();

        bibliotekar.setSifra(sifra);

        if (ime == null || ime.isEmpty()) {
            bibliotekar.setIme(""); //u slucaju da je prazno jer nije obavezno polje

        } else {
            bibliotekar.setIme(ime);
        }
        if (prezime == null || prezime.isEmpty()) {
            bibliotekar.setPrezime("");//u slucaju da je prazno jer nije obavezno polje

        } else {
            bibliotekar.setPrezime(prezime);
        }

        em.getTransaction().commit();
        em.close();

        return true;
    }

    public static boolean obrisiBibliotekara(int id) {//brise bibliotekara ciji id je prosledjen

        EntityManager em = uzmiEM();
        em.getTransaction().begin();
        Query q = em.createNamedQuery("Bibliotekar.findById");
        q.setParameter("id", id);
        Bibliotekar bibliotekar = (Bibliotekar) q.getSingleResult();

        em.remove(bibliotekar);

        em.getTransaction().commit();
        em.close();
        return true;
    }

    private static EntityManager uzmiEM() {
        return Persistence.createEntityManagerFactory("BibliotekaProjekatPU").createEntityManager(); //setuje EntityManager preko koga ide veza sa bazom 
    }
}
