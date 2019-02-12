
package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.gui.LogovanjeFrejm;
import bibliotekaprojekat.kontroler.Kontroler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * SlusacIzlaza slusa Izlaz iz programa stavku na meniju.Kad je kliknuto na tu
 * opciju, postavlja sve Frejmove koji nisu null da imaju DefaultCloseOperation
 * EXIT_ON_CLOSE i zatvara ih.
 *
 */
public class SlusacIzlaza implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        Kontroler.getInstanca().setPrijavljeniBibliotekar(null);
        Kontroler.getInstanca().getGlavniFrejm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Kontroler.getInstanca().getGlavniFrejm().dispose();
        if (Kontroler.getInstanca().getKnjigeFrejm() != null) {
            Kontroler.getInstanca().getKnjigeFrejm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Kontroler.getInstanca().getKnjigeFrejm().dispose();
        }
        if (Kontroler.getInstanca().getClanoviFrejm() != null) {
            Kontroler.getInstanca().getClanoviFrejm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Kontroler.getInstanca().getClanoviFrejm().dispose();
        }
        if (Kontroler.getInstanca().getNovaKnjigaFrejm() != null) {
            Kontroler.getInstanca().getNovaKnjigaFrejm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Kontroler.getInstanca().getNovaKnjigaFrejm().dispose();
        }
        if (Kontroler.getInstanca().getNoviClanFrejm() != null) {
            Kontroler.getInstanca().getNoviClanFrejm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Kontroler.getInstanca().getNoviClanFrejm().dispose();
        }
        if (Kontroler.getInstanca().getIzdavanjeFrejm() != null) {
            Kontroler.getInstanca().getIzdavanjeFrejm().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Kontroler.getInstanca().getIzdavanjeFrejm().dispose();
        }

    }

}
