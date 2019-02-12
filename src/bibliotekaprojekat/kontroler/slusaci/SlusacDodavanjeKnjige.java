
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
 * SlusacDodavanjeKnjige osluskuje dugme Dodaj Knjigu na NovaKnjigaFrejm Ako
 * jeste proverava da li su uneti svi neophodni podaci i u zavisnosti od toga
 * ili dodaje novu knjigu u bazu (salje podatke klasi Transakcije u modelu) ili
 * ispisuje odgovarajucu poruku.
 * 
 * * *
 */
public class SlusacDodavanjeKnjige implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String naziv = Kontroler.getInstanca().getNovaKnjigaFrejm().getNazivFld().getText();
        String autor = Kontroler.getInstanca().getNovaKnjigaFrejm().getAutorFld().getText();
        String isbn = Kontroler.getInstanca().getNovaKnjigaFrejm().getIsbnFld().getText();
        String godIzdanja = Kontroler.getInstanca().getNovaKnjigaFrejm().getGodIzdanjaFld().getText();
        String izdavac = Kontroler.getInstanca().getNovaKnjigaFrejm().getIzdavacFld().getText();
        String zanr = Kontroler.getInstanca().getNovaKnjigaFrejm().getZanrFld().getText();

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
        int godina = danas.getYear();

        Pattern p = Pattern.compile("^[0-9]{4}$"); //Regex proverava da li je unet cetvorocifren broj
        Matcher m = p.matcher(godIzdanja);
        if (m.find() == false) {
            JOptionPane.showMessageDialog(null, "Morate uneti cetvorocifren broj", "Poruka", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (Integer.parseInt(godIzdanja) > godina) {
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

        boolean result = Transakcije.dodajKnjigu(naziv, autor, isbn, godIzdanja, izdavac, zanr);  //dobijeni podaci se salju u transakcije gde se upisuju u bazu

        if (result) {
            JOptionPane.showMessageDialog(null, "Knjiga je uspesno dodata", "Poruka", JOptionPane.INFORMATION_MESSAGE);
            Kontroler.getInstanca().getNovaKnjigaFrejm().dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Dodavanje nije uspelo", "Poruka", JOptionPane.ERROR_MESSAGE);
        }
        
        Kontroler.getInstanca().getKnjigeFrejm().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Kontroler.getInstanca().getKnjigeFrejm().dispose();
        KnjigeFrejm kf = new KnjigeFrejm();
        kf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kf.setVisible(true);
        Kontroler.getInstanca().setKnjigeFrejm(kf);

    }

}
