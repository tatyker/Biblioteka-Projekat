package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.gui.PretragaFrejm;
import bibliotekaprojekat.kontroler.Kontroler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * Slusa dugme Pretraga na GlavniFrejm i dugme pronadji na IzdavanjeFrejm.
 * Otvara PretragaFrejm. Ako je pritisnuto dugme Pronadji onda i zatvara
 * IzdavanjeFrejm.
 *
 */
public class SlusacPretrage implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Kontroler.getInstanca().getIzdavanjeFrejm() != null && Kontroler.getInstanca().getIzdavanjeFrejm().isActive()) {
            Kontroler.getInstanca().getIzdavanjeFrejm().dispose();
        }
        PretragaFrejm pf = new PretragaFrejm();
        pf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pf.setVisible(true);
        Kontroler.getInstanca().setPretragaFrejm(pf);
    }

}
