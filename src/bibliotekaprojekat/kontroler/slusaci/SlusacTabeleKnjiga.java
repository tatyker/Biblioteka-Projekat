
package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.kontroler.Kontroler;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Slusa tabelu knjige - koji je red selektovan. U metodama vraca dobijene
 * vrednosti u kolonama selektovanog reda.
 */
public class SlusacTabeleKnjiga implements ListSelectionListener{
    private int selektovaniRed;
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        
        selektovaniRed = Kontroler.getInstanca().getKnjigeFrejm().getListaKnjigaTabela().
                convertRowIndexToModel(Kontroler.getInstanca().getKnjigeFrejm().getListaKnjigaTabela().getSelectedRow());

    }

    public int getSelektovaniRed() {
        return selektovaniRed;
    }
    
    public int dobiId(){
        return Integer.parseInt(Kontroler.getInstanca().getKnjigeFrejm().getListaKnjigaTabela().getValueAt(selektovaniRed, 0).toString());
    }
    public String dobiNaziv(){
        return Kontroler.getInstanca().getKnjigeFrejm().getListaKnjigaTabela().getValueAt(selektovaniRed, 1).toString();
    }
    public String dobiAutor(){
        return Kontroler.getInstanca().getKnjigeFrejm().getListaKnjigaTabela().getValueAt(selektovaniRed, 2).toString();
    }
    public String dobiIsbn(){
        return Kontroler.getInstanca().getKnjigeFrejm().getListaKnjigaTabela().getValueAt(selektovaniRed, 3).toString();
    }
    public String dobiGodIzdanja(){
        return Kontroler.getInstanca().getKnjigeFrejm().getListaKnjigaTabela().getValueAt(selektovaniRed, 4).toString();
    }
    public String dobiIzdavaca(){
        return Kontroler.getInstanca().getKnjigeFrejm().getListaKnjigaTabela().getValueAt(selektovaniRed, 5).toString();
    }
    public String dobiZanr(){
        return Kontroler.getInstanca().getKnjigeFrejm().getListaKnjigaTabela().getValueAt(selektovaniRed, 6).toString();
    }
}
