package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.gui.AdminFrejm;
import bibliotekaprojekat.gui.dodaci.KorisniDodaci;
import bibliotekaprojekat.kontroler.Kontroler;
import bibliotekaprojekat.model.Bibliotekar;
import bibliotekaprojekat.model.Transakcije;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * SlusacIspravkeBibliotekara slusa dugme Ispravka na AdminFrejmu. Kad je dugme
 * pritisnuto dobija podatke iz selektovanog reda (sa ispravkama) i proverava da
 * li su validni. U slucaju da je sve u redu salje podatke u klasu Transakcije i
 * vrsi se upis u bazu.
 *  
 */
public class SlusacIspravkeBibliotekara implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String korIme = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleBibliotekari().dobiKorIme();
        String sifra = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleBibliotekari().dobiSifru();
        String ime = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleBibliotekari().dobiIme();
        String prezime = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleBibliotekari().dobiPrezime();
        int id = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleBibliotekari().dobiId();

        if ("admin".equals(korIme)) { //ako se pokusa sa promenom podataka na administratorskom nalogu dobija se poruka upozorenja
            JOptionPane.showMessageDialog(null, "Administratorske podatke ne mozete menjati", "Poruka", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (sifra == null || sifra.isEmpty()) {
            KorisniDodaci.prikaziObaveznoPoljePoruku("sifra");
            return;
        }

        boolean rezultat = Transakcije.ispraviBibliotekara(id, sifra, ime, prezime);
        
        if (rezultat) {
            JOptionPane.showMessageDialog(null, "Bibliotekar je uspesno izmenjen", "Poruka", JOptionPane.INFORMATION_MESSAGE);
            
            Kontroler.getInstanca().getAdminFrejm().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Kontroler.getInstanca().getAdminFrejm().dispose();
            AdminFrejm af = new AdminFrejm();
            af.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            af.setVisible(true);
            Kontroler.getInstanca().setAdminFrejm(af);

        } else {
            JOptionPane.showMessageDialog(null, "Izmena nije uspela", "Poruka", JOptionPane.ERROR_MESSAGE);
        }

    }

}
