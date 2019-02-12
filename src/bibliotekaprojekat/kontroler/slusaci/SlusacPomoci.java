package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.gui.InstrukcijeFrejm;
import bibliotekaprojekat.kontroler.Kontroler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JFrame;

/**
 * Pri selekciji stavke pomoc na meniju otvara frejm sa napisanim instrukcijama
 * za koriscenje programa
 */
public class SlusacPomoci implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        //s obzirom da sam tekst dolazi iz .txt fajla postoji mogucnost FileNotFoundException
        try {
            InstrukcijeFrejm inf = new InstrukcijeFrejm();
            inf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            inf.setVisible(true);
            Kontroler.getInstanca().setInstrukcijeFrejm(inf);
        } catch (FileNotFoundException fnf) {

        }
    }

}
