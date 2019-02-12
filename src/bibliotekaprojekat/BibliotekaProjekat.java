package bibliotekaprojekat;

import bibliotekaprojekat.gui.LogovanjeFrejm;
import bibliotekaprojekat.kontroler.Kontroler;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * Postavlja da izgled bude Nimbus.Otvara LogovanjeFrejm.
 */
public class BibliotekaProjekat {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel()); //da program koristi Nimbus izgled
        } catch (Exception e) {
            e.printStackTrace();
        }
        InputMap im = (InputMap) UIManager.get("Button.focusInputMap"); //resenje kako da Nimbus prihvati i koriscenje enter umesto klika misom
        im.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
        im.put(KeyStroke.getKeyStroke("released ENTER"), "released");

        LogovanjeFrejm lf = new LogovanjeFrejm();  //kreiranje frejma za logovanje
        lf.setVisible(true);
        lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Kontroler.getInstanca().setLogovanjeFrejm(lf);

    }
}
