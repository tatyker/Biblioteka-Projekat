package bibliotekaprojekat.gui.dodaci;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *Dobijanje sirine i visine ekrana da bi se program centrirao i podesile dimenzije.
 */
public class KorisniDodaci {

    public static double dobijanjeSirineEkrana() {
        Dimension velicinaEkrana = Toolkit.getDefaultToolkit().getScreenSize();  //dobijanje sirine ekrana
        double sirina = velicinaEkrana.getWidth();
        return sirina;
    }

    public static double dobijanjeVisineEkrana() {
        Dimension velicinaEkrana = Toolkit.getDefaultToolkit().getScreenSize(); //dobijanje visine ekrana
        double visina = velicinaEkrana.getHeight();
        return visina;
    }

    public static void prikaziObaveznoPoljePoruku(String polje) {
        JOptionPane.showMessageDialog(null, "Polje " + polje + " je obavezno", "Poruka", JOptionPane.WARNING_MESSAGE);
    }
}
