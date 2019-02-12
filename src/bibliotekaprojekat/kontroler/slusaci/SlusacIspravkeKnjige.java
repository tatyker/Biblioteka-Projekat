
package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.gui.KnjigeFrejm;
import bibliotekaprojekat.gui.dodaci.KorisniDodaci;
import bibliotekaprojekat.kontroler.Kontroler;
import bibliotekaprojekat.model.Transakcije;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * SlusacIspravkeClana slusa dugme Ispravka na ClanoviFrejmu. Kad je dugme
 * pritisnuto dobija podatke iz selektovanog reda (sa ispravkama) i proverava da
 * li su validni. U slucaju da je sve u redu salje podatke u klasu Transakcije i
 * vrsi se upis u bazu.
 */
public class SlusacIspravkeKnjige implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        int id = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleKnjiga().dobiId();
        String naziv = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleKnjiga().dobiNaziv();
        String autor = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleKnjiga().dobiAutor();
        String isbn = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleKnjiga().dobiIsbn();
        String godIzdanja = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleKnjiga().dobiGodIzdanja();
        String izdavac = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleKnjiga().dobiIzdavaca();
        String zanr = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleKnjiga().dobiZanr();
        
        if (naziv == null || naziv.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("naziv knjige");
            return;
        }

        if (autor == null || autor.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("autor");
            return;
        }

        if (isbn == null || isbn.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("ISBN");
            return;
        }
        if (godIzdanja == null || godIzdanja.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("god. izdanja");
            return;
        }
        LocalDate danas = LocalDate.now();
        int godina = danas.getYear(); //dobijanje koja je sad godina

        Pattern p = Pattern.compile("^[0-9]{4}$");
        Matcher m = p.matcher(godIzdanja); //regex proverava da li je unet cetvorocifren broj 
        if (m.find() == false) {
            JOptionPane.showMessageDialog(null, "Morate uneti cetvorocifren broj", "Poruka", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (Integer.parseInt(godIzdanja) > godina) { //proverava da nije uneta godina u buducnosti
            JOptionPane.showMessageDialog(null, "Unesite stvarnu godinu izdanja", "Poruka", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (izdavac == null || izdavac.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("izdavac");
            return;
        }
        if (zanr == null || zanr.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("zanr");
            return;
        }

        boolean result = Transakcije.ispraviKnjigu(id, naziv, autor, isbn, godIzdanja, izdavac, zanr);

        if (result) {
            JOptionPane.showMessageDialog(null, "Knjiga je uspesno izmenjena", "Poruka", JOptionPane.INFORMATION_MESSAGE);
            
            Kontroler.getInstanca().getKnjigeFrejm().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Kontroler.getInstanca().getKnjigeFrejm().dispose();
            KnjigeFrejm kf = new KnjigeFrejm();
            kf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            kf.setVisible(true);
            Kontroler.getInstanca().setKnjigeFrejm(kf);

        } else {
            JOptionPane.showMessageDialog(null, "Izmena nije uspela", "Poruka", JOptionPane.ERROR_MESSAGE);
        }
    }

}
