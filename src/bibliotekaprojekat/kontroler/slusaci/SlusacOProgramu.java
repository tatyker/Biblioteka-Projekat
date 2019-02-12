package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.gui.dodaci.Boja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Osluskuje stavku O Programu na meniju. Otvara prozor sa ispisanom verzijom
 * programa i imenom autora
 */
public class SlusacOProgramu implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        ImageIcon ikona = new ImageIcon("knjige.png","slika knjiga");
      
        JOptionPane.showMessageDialog(null, "Biblioteka - 1.0\nTatjana Kercu", "O programu", JOptionPane.DEFAULT_OPTION, ikona);
    }

}
