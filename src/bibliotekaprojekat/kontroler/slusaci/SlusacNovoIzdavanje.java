package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.gui.GlavniFrejm;
import bibliotekaprojekat.gui.dodaci.KorisniDodaci;
import bibliotekaprojekat.kontroler.Kontroler;
import bibliotekaprojekat.model.Clanovi;
import bibliotekaprojekat.model.Izdavanje;
import bibliotekaprojekat.model.Knjige;
import bibliotekaprojekat.model.Transakcije;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Osluskuje dugme Izdaj na IzdavanjeFrejm. Uzima podatke iz ComboBox i
 * prosledjuje ih Transakcijama, gde se vrsi upis u bazu. Ako je knjiga vec
 * izdata obavestava da je knjiga izdata.
 *
 */
public class SlusacNovoIzdavanje implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        Knjige odabranaKnjiga = (Knjige) Kontroler.getInstanca().getIzdavanjeFrejm().getKnjigaCB().getSelectedItem();
        Integer idKnjige = odabranaKnjiga.getId();

        Clanovi odabraniClan = (Clanovi) Kontroler.getInstanca().getIzdavanjeFrejm().getClanCB().getSelectedItem();
        Integer idClan = odabraniClan.getId();

        List<Izdavanje> nadjene = Transakcije.nadjiKnjigu(idKnjige); //provera da li je knjiga vec izdata
        for (Izdavanje nadjena : nadjene) {
            if (nadjena != null) {
                try {
                    if ("izdata".equals(nadjena.getIdStatus().getStatus().toString())) {

                        JOptionPane.showMessageDialog(null, "Knjiga je vec izdata", "Poruka", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                } catch (NullPointerException npe) { }
            }
        }

        boolean rezultat = Transakcije.izdajKnjigu(odabranaKnjiga, odabraniClan); 

        if (rezultat) {
            JOptionPane.showMessageDialog(null, "Knjiga je uspesno izdata", "Poruka", JOptionPane.INFORMATION_MESSAGE);
            Kontroler.getInstanca().getIzdavanjeFrejm().dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Dodavanje nije uspelo", "Poruka", JOptionPane.ERROR_MESSAGE);
        }

        Kontroler.getInstanca().getGlavniFrejm().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Kontroler.getInstanca().getGlavniFrejm().dispose();

        GlavniFrejm gf = new GlavniFrejm();
        gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gf.setVisible(true);
        Kontroler.getInstanca().setGlavniFrejm(gf);

    }

}
