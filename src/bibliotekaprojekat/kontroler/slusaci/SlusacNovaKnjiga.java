package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.gui.NovaKnjigaFrejm;
import bibliotekaprojekat.kontroler.Kontroler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Osluskuje dugme Dodavanje na KnjigeFrejmu i otvara prozor za dodavanje nove
 * knjige.
 */
public class SlusacNovaKnjiga implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        NovaKnjigaFrejm nkf = new NovaKnjigaFrejm();
        Kontroler.getInstanca().setNovaKnjigaFrejm(nkf);
        nkf.setVisible(true);
    }

}
