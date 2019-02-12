package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.gui.AdminFrejm;
import bibliotekaprojekat.gui.GlavniFrejm;
import bibliotekaprojekat.gui.dodaci.KorisniDodaci;

import bibliotekaprojekat.kontroler.Kontroler;
import bibliotekaprojekat.model.Bibliotekar;
import bibliotekaprojekat.model.Transakcije;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Slusa dugme logovanjeBtn na LogovanjeFrejmu. U slucaju da polja nisu
 * popunjena ispisuje odgovarajuce poruke. Salje dobijene podatke u bazu i ako u
 * bazi postoji korisnik sa tim korisnickim imenom i sifrom setuje objekat klase
 * GlavniFrejm. U slucaju logovanja administratora setuje objekat klase
 * AdminFrejm
 *
 */
public class SlusacLogovanja implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String korIme = Kontroler.getInstanca().getLogovanjeFrejm().getKorisnickoImeFld().getText();
        String sifra = Kontroler.getInstanca().getLogovanjeFrejm().getSifraFld().getText();

        if (korIme == null || korIme.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("korisnicko ime");
            return;
        }
        if (sifra == null || sifra.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("sifra");
            return;
        }
        
        Bibliotekar prijavljeniBibliotekar = Transakcije.logovanje(korIme, sifra);

        if (prijavljeniBibliotekar == null) {
            JOptionPane.showMessageDialog(null, "Uneti podaci nisu validni", "Poruka", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Kontroler.getInstanca().setPrijavljeniBibliotekar(prijavljeniBibliotekar);
        Kontroler.getInstanca().getLogovanjeFrejm().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Kontroler.getInstanca().getLogovanjeFrejm().dispose();

        //ako se administrator uloguje, vodi ga direktno na AdminFrame, za sve ostale otvara GlavniFrejm 
        if ("admin".equalsIgnoreCase(prijavljeniBibliotekar.getKorisnickoIme())) {
            AdminFrejm af = new AdminFrejm();
            af.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            af.setVisible(true);
            Kontroler.getInstanca().setAdminFrejm(af);
        } else {
            GlavniFrejm gf = new GlavniFrejm();
            gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gf.setVisible(true);
            Kontroler.getInstanca().setGlavniFrejm(gf);
        }
    }

}
