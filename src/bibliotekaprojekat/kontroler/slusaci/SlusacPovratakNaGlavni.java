package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.gui.GlavniFrejm;
import bibliotekaprojekat.kontroler.Kontroler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * SlusacPovratakNaGlavni osluskuje da li je pritisnuto dugme Izdavanje knjiga
 * ili selektovana opcija Izdavanje knjiga ne meniju. Ako jeste zatvara
 * KnjigeFrejm ili ClanoviFrejm i otvara GlavniFrejm (pravi novi objekat klase
 * GlavniFrejm i postavlja ga na visible).
 *
 */
public class SlusacPovratakNaGlavni implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        if (Kontroler.getInstanca().getClanoviFrejm() != null && Kontroler.getInstanca().getClanoviFrejm().isActive()) {
            Kontroler.getInstanca().getClanoviFrejm().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Kontroler.getInstanca().getClanoviFrejm().dispose();

        } else if (Kontroler.getInstanca().getKnjigeFrejm() != null && Kontroler.getInstanca().getKnjigeFrejm().isActive()) {
            Kontroler.getInstanca().getKnjigeFrejm().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Kontroler.getInstanca().getKnjigeFrejm().dispose();
        } else if (Kontroler.getInstanca().getGlavniFrejm() != null && Kontroler.getInstanca().getGlavniFrejm().isActive()) { //ako je jedan vec otvoren da ne otvara ponovo
            return;
        }

        GlavniFrejm gf = new GlavniFrejm();
        gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gf.setVisible(true);
        Kontroler.getInstanca().setGlavniFrejm(gf);

    }

}
