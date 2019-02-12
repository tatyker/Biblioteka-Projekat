package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.kontroler.Kontroler;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Slusa tabelu bibliotekari - koji je red selektovan. U metodama vraca dobijene
 * vrednosti u kolonama selektovanog reda.
 */
public class SlusacTabeleBibliotekari implements ListSelectionListener {

    private int selektovanRed;

    @Override
    public void valueChanged(ListSelectionEvent e) {
        selektovanRed = Kontroler.getInstanca().getAdminFrejm().getBibliotekariTabela().
                convertRowIndexToModel(Kontroler.getInstanca().getAdminFrejm().getBibliotekariTabela().getSelectedRow());
    }

    public int getSelektovanRed() {
        return selektovanRed;
    }

    public String dobiKorIme() {
        return Kontroler.getInstanca().getAdminFrejm().getBibliotekariTabela().
                getValueAt(selektovanRed, 0).toString();
    }

    public String dobiSifru() {
        return Kontroler.getInstanca().getAdminFrejm().getBibliotekariTabela().
                getValueAt(selektovanRed, 1).toString();
    }

    public String dobiIme() {
        try {
            return Kontroler.getInstanca().getAdminFrejm().getBibliotekariTabela().
                    getValueAt(selektovanRed, 2).toString();
        } catch (NullPointerException npe) {
            return null;
        }
    }

    public String dobiPrezime() {
        try {
            return Kontroler.getInstanca().getAdminFrejm().getBibliotekariTabela().
                    getValueAt(selektovanRed, 3).toString();
        } catch (NullPointerException npe) {
            return null;
        }
    }

    public int dobiId() {
        return Integer.parseInt(Kontroler.getInstanca().getAdminFrejm().getBibliotekariTabela().
                getValueAt(selektovanRed, 4).toString());
    }

}
