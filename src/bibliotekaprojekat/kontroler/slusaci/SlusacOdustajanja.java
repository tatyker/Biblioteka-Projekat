
package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.kontroler.Kontroler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Pri pritisku na dugme Odustani zatvara LogovanjeFrejm i gasi program.
 */

public class SlusacOdustajanja implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Kontroler.getInstanca().getLogovanjeFrejm().dispose();
    }
    
}
