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
 * SlusacDodavanjaClana osluskuje da li je kliknuto na dugme Dodaj clana na
 * NoviClanFrejmu. Ako jeste proverava da li su uneti svi neophodni podaci i u
 * zavisnosti od toga ili dodaje novog clana u bazu (salje podatke klasi
 * Transakcije u modelu) ili ispisuje odgovarajucu poruku.
 *
 */
public class SlusacDodavanjeClana implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String ime = Kontroler.getInstanca().getNoviClanFrejm().getImeFld().getText();
        String prezime = Kontroler.getInstanca().getNoviClanFrejm().getPrezimeFld().getText();
        String brDokumenta = Kontroler.getInstanca().getNoviClanFrejm().getBrDokumentaFld().getText();
        String adresa = Kontroler.getInstanca().getNoviClanFrejm().getAdresaFld().getText();
        String grad = Kontroler.getInstanca().getNoviClanFrejm().getGradFld().getText();
        String godRodjenja = Kontroler.getInstanca().getNoviClanFrejm().getGodRodjenjaFld().getText();
        String pol;
        try {
            pol = Kontroler.getInstanca().getNoviClanFrejm().getPolGrupa().getSelection().getActionCommand();
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, "Morate selektovati pol", "Poruka", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String brClanske = Kontroler.getInstanca().getNoviClanFrejm().getBrClanskeFld().getText();

        if (ime == null || ime.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("ime");
            return;
        }

        if (prezime == null || prezime.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("prezime");
            return;
        }

        if (brDokumenta == null || brDokumenta.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("br. dokumenta");
            return;
        }
        if (adresa == null || adresa.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("adresa");
            return;
        }
        if (grad == null || grad.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("grad");
            return;
        }
        if (godRodjenja == null || godRodjenja.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("god. rodjenja");
            return;
        }

        LocalDate danas = LocalDate.now();
        int godina = danas.getYear();

        Pattern p = Pattern.compile("^[0-9]{4}$");  //Regex proverava da li je unet cetvorocifren broj
        Matcher m = p.matcher(godRodjenja);
        if (m.find() == false) {
            JOptionPane.showMessageDialog(null, "Morate uneti cetvorocifren broj", "Poruka", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (Integer.parseInt(godRodjenja) > godina || Integer.parseInt(godRodjenja) < 1900) {
            JOptionPane.showMessageDialog(null, "Unesite stvarnu godinu rodjenja", "Poruka", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (pol == null || pol.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Morate selektovati pol", "Poruka", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (Kontroler.getInstanca().getNoviClanFrejm().getPolGrupa().getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Morate selektovati pol", "Poruka", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (brClanske == null || brClanske.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("br. clanske");
            return;
        }

        boolean result = Transakcije.dodajClana(ime, prezime, brDokumenta, adresa, grad, godRodjenja, pol, brClanske); //dobijeni podaci se salju u transakcije gde se upisuju u bazu

        if (result) {
            JOptionPane.showMessageDialog(null, "Clan je uspesno dodat", "Poruka", JOptionPane.INFORMATION_MESSAGE);
            Kontroler.getInstanca().getNoviClanFrejm().dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Dodavanje clana nije uspelo", "Poruka", JOptionPane.ERROR_MESSAGE);
        }
        
        Kontroler.getInstanca().getClanoviFrejm().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Kontroler.getInstanca().getClanoviFrejm().dispose();
        ClanoviFrejm cf = new ClanoviFrejm();
        cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cf.setVisible(true);
        Kontroler.getInstanca().setClanoviFrejm(cf);
    }

}
