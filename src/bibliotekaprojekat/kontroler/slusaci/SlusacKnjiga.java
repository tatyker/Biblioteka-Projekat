package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.gui.KnjigeFrejm;
import bibliotekaprojekat.kontroler.Kontroler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * SlusacKnjiga osluskuje da li je pritisnuto dugme Knjige ili selektovana
 * opcija Lista Knjiga na meniju. Ako jeste zatvara GlavniFrejm ili ClanoviFrejm
 * i otvara KnjigeFrejm (pravi novi objekat klase KnjigeFrejm i postavlja ga na
 * visible)
 *
 */
public class SlusacKnjiga implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        if (Kontroler.getInstanca().getGlavniFrejm() != null && Kontroler.getInstanca().getGlavniFrejm().isActive()) {
            Kontroler.getInstanca().getGlavniFrejm().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Kontroler.getInstanca().getGlavniFrejm().dispose();
        } else if (Kontroler.getInstanca().getClanoviFrejm() != null && Kontroler.getInstanca().getClanoviFrejm().isActive()) {
            Kontroler.getInstanca().getClanoviFrejm().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Kontroler.getInstanca().getClanoviFrejm().dispose();
        } else if (Kontroler.getInstanca().getKnjigeFrejm() != null && Kontroler.getInstanca().getKnjigeFrejm().isActive()) { 
            return;
        }

        KnjigeFrejm kf = new KnjigeFrejm();
        kf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kf.setVisible(true);
        Kontroler.getInstanca().setKnjigeFrejm(kf);

    }

}
