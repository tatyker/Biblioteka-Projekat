package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.gui.ClanoviFrejm;
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
public class SlusacIspravkeClana implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        int id = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleClanova().dobiId();
        String ime = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleClanova().dobiIme();
        String prezime = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleClanova().dobiPrezime();
        String brDokumenta = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleClanova().dobiBrDokumenta();
        String adresa = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleClanova().dobiAdresu();
        String grad = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleClanova().dobiGrad();
        String godRodjenja = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleClanova().dobiGodRodjenja();
        String pol = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleClanova().dobiPol();
        String brClanske = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleClanova().dobiBrClanske();
        
        if (ime == null || ime.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("naziv knjige");
            return;
        }

        if (prezime == null || prezime.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("autor");
            return;
        }

        if (brDokumenta == null || brDokumenta.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("ISBN");
            return;
        }
        if (adresa == null || adresa.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("god. izdanja");
            return;
        }
        if (grad == null || grad.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("izdavac");
            return;
        }
        if (godRodjenja == null || godRodjenja.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("zanr");
            return;
        }
        LocalDate danas = LocalDate.now();
        int godina = danas.getYear(); //dobijanje koja je sad godina

        Pattern p = Pattern.compile("^[0-9]{4}$"); //regex proverava da li je unet cetvorocifren broj 
        Matcher m = p.matcher(godRodjenja);
        if (m.find() == false) {
            JOptionPane.showMessageDialog(null, "Morate uneti cetvorocifren broj", "Poruka", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (Integer.parseInt(godRodjenja) > godina || Integer.parseInt(godRodjenja) < 1900) { //proverava se da li je uneta stvarna godina rodjenja
            JOptionPane.showMessageDialog(null, "Unesite stvarnu godinu rodjenja", "Poruka", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (pol == null || pol.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("Zanr");
            return;
        }
        if ("muski".equals(pol) || "zenski".equals(pol) || "ostalo".equals(pol)) {
        } else {
            JOptionPane.showMessageDialog(null, "Pol moze da bude muski, zenski ili ostalo", "Poruka", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (brClanske == null || brClanske.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("Zanr");
            return;
        }

        boolean rezultat = Transakcije.ispraviClana(id, ime, prezime, brDokumenta, adresa, grad, godRodjenja, pol, brClanske);

        if (rezultat) {
            JOptionPane.showMessageDialog(null, "Clan je uspesno izmenjen", "Poruka", JOptionPane.INFORMATION_MESSAGE);

            Kontroler.getInstanca().getClanoviFrejm().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Kontroler.getInstanca().getClanoviFrejm().dispose();
            ClanoviFrejm cf = new ClanoviFrejm();
            cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            cf.setVisible(true);
            Kontroler.getInstanca().setClanoviFrejm(cf);

        } else {
            JOptionPane.showMessageDialog(null, "Izmena nije uspela", "Poruka", JOptionPane.ERROR_MESSAGE);
        }
    }

}
