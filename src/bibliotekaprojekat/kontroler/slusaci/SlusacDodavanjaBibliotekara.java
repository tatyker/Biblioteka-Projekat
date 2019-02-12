package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.gui.AdminFrejm;
import bibliotekaprojekat.gui.dodaci.KorisniDodaci;
import bibliotekaprojekat.kontroler.Kontroler;
import bibliotekaprojekat.model.Bibliotekar;
import bibliotekaprojekat.model.Transakcije;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * SlusacDodavanjaBibliotekara osluskuje da li je kliknuto na dugme Brisanje na
 * AdminFrejmu. Ako jeste proverava da li su uneti svi neophodni podaci i u
 * zavisnosti od toga ili dodaje novog bibliotekara u bazu ili ispisuje
 * odgovarajucu poruku.
 *
 */
public class SlusacDodavanjaBibliotekara implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        //uzimanje teksta iz odgovarajucih polja na AdminFrejmu
        String korIme = Kontroler.getInstanca().getAdminFrejm().getKorImeFld().getText();
        String sifra = Kontroler.getInstanca().getAdminFrejm().getSifraFld().getText();
        String ime = Kontroler.getInstanca().getAdminFrejm().getImeFld().getText();
        String prezime = Kontroler.getInstanca().getAdminFrejm().getPrezimeFld().getText();

        Bibliotekar noviBibliotekar = new Bibliotekar(); //novi objekat klase Bibliotekar

        if (korIme == null || korIme.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("korisnicko ime");
            return;
        }
        
        List<Bibliotekar> bibliotekari = Transakcije.uzmiSveBibliotekare();
        for (Bibliotekar bibliotekar : bibliotekari) {
            //proverava da li kor. ime vec postoji u bazi jer treba da je unique
            if (bibliotekar.getKorisnickoIme().equals(korIme)) {
                JOptionPane.showMessageDialog(null, "Vec postoji to korisnicko ime", "Poruka", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        if (sifra == null || sifra.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("sifra");
            return;
        }
        
        //setuje korisnicko ime is sifru objekta noviBibliotekar
        noviBibliotekar.setKorisnickoIme(korIme);
        noviBibliotekar.setSifra(sifra);

        //setuje ime i prezime novog bibliotekara ako nisu prazni, jer su opcioni za unos
        if (ime != null || !ime.isEmpty()) {
            noviBibliotekar.setIme(ime);
        }
        if (prezime != null || !prezime.isEmpty()) {
            noviBibliotekar.setPrezime(prezime);
        }
        
        //proverava da li je dodavanje bibliotekara uspelo i ispisuje odgovarajucu poruku
        if (Transakcije.dodajNovogBibliotekara(noviBibliotekar)) {
            JOptionPane.showMessageDialog(null, "Bibliotekar je uspesno dodat", "Poruka", JOptionPane.INFORMATION_MESSAGE);
           
            Kontroler.getInstanca().getAdminFrejm().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Kontroler.getInstanca().getAdminFrejm().dispose();
            AdminFrejm af = new AdminFrejm();
            af.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            af.setVisible(true);
            Kontroler.getInstanca().setAdminFrejm(af);
        } else {
            JOptionPane.showMessageDialog(null, "Bibliotekar nije dodat", "Poruka", JOptionPane.INFORMATION_MESSAGE);
        }

        
    }

}
