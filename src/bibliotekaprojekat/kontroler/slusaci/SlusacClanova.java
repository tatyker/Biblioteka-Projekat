
package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.gui.ClanoviFrejm;
import bibliotekaprojekat.kontroler.Kontroler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * SlusacClanova osluskuje da li je pritisnuto dugme Clanovi ili selektovana
 * opcija Lista clanova na meniju. Ako jeste zatvara GlavniFrejm ili
 * KnjigeFrejm i otvara ClanoviFrejm (pravi novi objekat klase ClanoviFrejm i
 * postavlja ga na visible)
 *
 */
public class SlusacClanova implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
           //proverava da li su otvoreni Glavni i Knjiga i ako jesu zatvara ih. Ako je vec otvoren Clanovi ne radi nista
        if (Kontroler.getInstanca().getGlavniFrejm() != null && Kontroler.getInstanca().getGlavniFrejm().isActive()) {
            Kontroler.getInstanca().getGlavniFrejm().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Kontroler.getInstanca().getGlavniFrejm().dispose();
        } else if (Kontroler.getInstanca().getKnjigeFrejm() != null && Kontroler.getInstanca().getKnjigeFrejm().isActive()) {
            Kontroler.getInstanca().getKnjigeFrejm().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Kontroler.getInstanca().getKnjigeFrejm().dispose();
        } else if (Kontroler.getInstanca().getClanoviFrejm() != null && Kontroler.getInstanca().getClanoviFrejm().isActive()) {
            return;
        }
        //otvara novi ClanoviFrejm
        ClanoviFrejm cf = new ClanoviFrejm();
        cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cf.setVisible(true);
        Kontroler.getInstanca().setClanoviFrejm(cf);

    }

}
