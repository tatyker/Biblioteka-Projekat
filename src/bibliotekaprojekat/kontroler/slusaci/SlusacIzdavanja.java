package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.gui.IzdavanjeFrejm;
import bibliotekaprojekat.kontroler.Kontroler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * SlusacIzdavanja osluskuje da li je pritisnuto dugme Izdavanje na
 * GlavnomFrejmu. Kad je pritisnuto pravi novi objekat klase IzdavanjeFrejm.
 *
 */
public class SlusacIzdavanja implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        IzdavanjeFrejm izf = new IzdavanjeFrejm();
        izf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        izf.setVisible(true);
        Kontroler.getInstanca().setIzdavanjeFrejm(izf);
    }
}
