package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.gui.GlavniFrejm;
import bibliotekaprojekat.kontroler.Kontroler;
import bibliotekaprojekat.model.Clanovi;
import bibliotekaprojekat.model.Izdavanje;
import bibliotekaprojekat.model.Knjige;
import bibliotekaprojekat.model.Transakcije;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Slusa dugme Izdaj na PretragaFrejm.Uzima podatke iz ComboBox i
 * prosledjuje ih Transakcijama, gde se vrsi upis u bazu. Ako je knjiga vec
 * izdata obavestava da je knjiga vec izdata.
 */
public class SlusacPretragaIzdavanje implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Knjige odabranaKnjiga = (Knjige) Kontroler.getInstanca().getPretragaFrejm().getPretragaCB().getSelectedItem();
        if (odabranaKnjiga == null) { //ako nije selektovana knjiga u CB
            JOptionPane.showMessageDialog(null, "Morate odabrati knjigu", "Poruka", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Integer idKnjige = odabranaKnjiga.getId();

        Clanovi odabraniClan = (Clanovi) Kontroler.getInstanca().getPretragaFrejm().getClanCB().getSelectedItem();
        Integer idClan = odabraniClan.getId();

        List<Izdavanje> nadjene = Transakcije.nadjiKnjigu(idKnjige);
        for (Izdavanje nadjena : nadjene) {

            if (nadjena != null) {
                try {
                    if ("izdata".equals(nadjena.getIdStatus().getStatus().toString())) {
                        JOptionPane.showMessageDialog(null, "Knjiga je vec izdata", "Poruka", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        boolean result = Transakcije.izdajKnjigu(odabranaKnjiga, odabraniClan);
        if (result) {
            JOptionPane.showMessageDialog(null, "Knjiga je uspesno izdata", "Poruka", JOptionPane.INFORMATION_MESSAGE);
            Kontroler.getInstanca().getPretragaFrejm().dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Dodavanje nije uspelo", "Poruka", JOptionPane.ERROR_MESSAGE);
        }

        Kontroler.getInstanca().getGlavniFrejm().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Kontroler.getInstanca().getGlavniFrejm().dispose();

        GlavniFrejm gf = new GlavniFrejm();
        gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gf.setVisible(true);
        Kontroler.getInstanca().setGlavniFrejm(gf);
    }

}
