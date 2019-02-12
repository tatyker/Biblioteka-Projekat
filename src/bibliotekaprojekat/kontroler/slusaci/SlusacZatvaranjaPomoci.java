
package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.kontroler.Kontroler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * Zatvara prozor InstrukcijeFrejm.
 */
public class SlusacZatvaranjaPomoci implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        Kontroler.getInstanca().getInstrukcijeFrejm().dispose();
    }
    
}
