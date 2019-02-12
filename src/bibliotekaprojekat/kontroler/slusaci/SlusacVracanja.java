package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.gui.GlavniFrejm;
import bibliotekaprojekat.kontroler.Kontroler;
import bibliotekaprojekat.model.Izdavanje;
import bibliotekaprojekat.model.Transakcije;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Slusa dugme Vracanje. Ako knjiga nije vec vracena belezi datum vracanja i
 * postavlja status knjige na vracena.
 */
public class SlusacVracanja implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        int id = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleIzdavanja().dobiId();
        String datumVracanja = Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleIzdavanja().dobiDatumVracanja();

        try {
            if (datumVracanja != null || !datumVracanja.isEmpty()) { //ako ima datum vracanja, ne moze ponovo da se vrati
                JOptionPane.showMessageDialog(null, "Knjiga je vec vracena", "Poruka", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NullPointerException npe) {}
        
        boolean rezultat = Transakcije.vratiKnjigu(id);

        if (rezultat) {
            JOptionPane.showMessageDialog(null, "Knjiga je vracena", "Poruka", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Vracanje nije uspelo", "Poruka", JOptionPane.ERROR_MESSAGE);
        }
        Kontroler.getInstanca().getGlavniFrejm().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Kontroler.getInstanca().getGlavniFrejm().dispose();

        GlavniFrejm gf = new GlavniFrejm();
        gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gf.setVisible(true);
        Kontroler.getInstanca().setGlavniFrejm(gf);
    }
}
