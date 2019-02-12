package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.gui.PretragaFrejm;
import bibliotekaprojekat.kontroler.Kontroler;
import bibliotekaprojekat.model.Knjige;
import bibliotekaprojekat.model.Transakcije;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;

/**
 * Uzima tekst is polja nazivField na PretragaFrejm i onda koristi metodu odatle
 * da popuni CB sa knjigama u zavisnosti od unetog teksta.
 */
public class SlusacPretragaKnjiga implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        String nazivKnjige = Kontroler.getInstanca().getPretragaFrejm().getPretragaNazivFld().getText();

        Kontroler.getInstanca().getPretragaFrejm().popuniKnjigeCB(nazivKnjige);

    }

}
