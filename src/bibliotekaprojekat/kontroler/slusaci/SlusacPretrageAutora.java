package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.kontroler.Kontroler;
import bibliotekaprojekat.model.Knjige;
import bibliotekaprojekat.model.Transakcije;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Uzima tekst is polja autorFld na PretragaFrejm i onda koristi metodu odatle
 * da popuni CB sa knjigama u zavisnosti od unetog teksta.
 */
public class SlusacPretrageAutora implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String autor = Kontroler.getInstanca().getPretragaFrejm().getPretragaAutorFld().getText();

        Kontroler.getInstanca().getPretragaFrejm().popuniKnjigeAutorCB(autor);
    }

}
