package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.gui.AdminFrejm;
import bibliotekaprojekat.kontroler.Kontroler;
import bibliotekaprojekat.model.Bibliotekar;
import bibliotekaprojekat.model.Transakcije;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * SlusacBrisanjaBibliotekara osluskuje da li je kliknuto na dugme Brisanje na
 * AdminFrejmu. Ako jeste proverava da li stvarno zelimo da pbrisemo
 * bibliotekara i u slucaju potvrdnog odgovora ga brise iz baze.
 *
 */
public class SlusacBrisanjaBibliotekara implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Bibliotekar odabraniBibliotekar = (Bibliotekar) Kontroler.getInstanca().getAdminFrejm().getBibliotekarCB().getSelectedItem();
        Integer idBibliotekara = odabraniBibliotekar.getId();

        System.out.println(idBibliotekara);

        //provera da li stvarno zelimo da obrisemo bibliotekara ili je kliknuto slucajno
        int odabir = JOptionPane.showConfirmDialog(null, "Da li stvarno zelite da obrisete Bibliotekara?",
                 "Potvrda brisanja", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE); // 0=da, 1=ne

        //u slucaju potvrdnog odgovora daje poruku da li je brisanje uspelo i resetuje frejm
        if (odabir == 0) { 
            if (Transakcije.obrisiBibliotekara(idBibliotekara)) {
                JOptionPane.showMessageDialog(null, "Bibliotekar je obrisan", "Poruka", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Brisanje nije uspelo", "Poruka", JOptionPane.ERROR_MESSAGE);
            }
            Kontroler.getInstanca().getAdminFrejm().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Kontroler.getInstanca().getAdminFrejm().dispose();
            AdminFrejm af = new AdminFrejm();
            af.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            af.setVisible(true);
            Kontroler.getInstanca().setAdminFrejm(af);

        }  //u slucaju negativnog odgovora daje poruku da do brisanja nije doslo
        if (odabir == 1) {
            JOptionPane.showMessageDialog(null, "Bibliotekar nije obrisan", "Poruka", JOptionPane.INFORMATION_MESSAGE);
        }

    }

}
