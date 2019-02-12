
package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.gui.NoviClanFrejm;
import bibliotekaprojekat.kontroler.Kontroler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Osluskuje dugme Dodavanje na ClanoviFrejmu i otvara prozor za dodavanje novog
 * clana.
 */
public class SlusacNoviClan implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        NoviClanFrejm ncf = new NoviClanFrejm();
        Kontroler.getInstanca().setNoviClanFrejm(ncf);
        ncf.setVisible(true);
    }

}
