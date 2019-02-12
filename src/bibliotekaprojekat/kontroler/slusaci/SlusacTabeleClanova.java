package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.kontroler.Kontroler;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Slusa tabelu clanova - koji je red selektovan. U metodama vraca dobijene
 * vrednosti u kolonama selektovanog reda.
 */

public class SlusacTabeleClanova implements ListSelectionListener {

    private int selektovanRed;

    @Override
    public void valueChanged(ListSelectionEvent e) {
         
        selektovanRed = Kontroler.getInstanca().getClanoviFrejm().getListaClanovaTabela().
                convertRowIndexToModel(Kontroler.getInstanca().getClanoviFrejm().getListaClanovaTabela().getSelectedRow());
        
    }
    
    public int getSelektovanRed() {
        return selektovanRed;
    }
    
    public int dobiId(){
        return Integer.parseInt(Kontroler.getInstanca().getClanoviFrejm().getListaClanovaTabela().getValueAt(selektovanRed, 0).toString());
    }
    public String dobiIme(){
        return Kontroler.getInstanca().getClanoviFrejm().getListaClanovaTabela().getValueAt(selektovanRed, 1).toString();
    }
    public String dobiPrezime(){
        return Kontroler.getInstanca().getClanoviFrejm().getListaClanovaTabela().getValueAt(selektovanRed, 2).toString();
    }
    public String dobiBrDokumenta(){
        return Kontroler.getInstanca().getClanoviFrejm().getListaClanovaTabela().getValueAt(selektovanRed, 3).toString();
    }
    public String dobiAdresu(){
        return Kontroler.getInstanca().getClanoviFrejm().getListaClanovaTabela().getValueAt(selektovanRed, 4).toString();
    }
    public String dobiGrad(){
        return Kontroler.getInstanca().getClanoviFrejm().getListaClanovaTabela().getValueAt(selektovanRed, 5).toString();
    }
    public String dobiGodRodjenja(){
        return Kontroler.getInstanca().getClanoviFrejm().getListaClanovaTabela().getValueAt(selektovanRed, 6).toString();
    }
    public String dobiPol(){
        return Kontroler.getInstanca().getClanoviFrejm().getListaClanovaTabela().getValueAt(selektovanRed, 7).toString();
    }
    public String dobiBrClanske(){
        return Kontroler.getInstanca().getClanoviFrejm().getListaClanovaTabela().getValueAt(selektovanRed, 8).toString();
    }

}
