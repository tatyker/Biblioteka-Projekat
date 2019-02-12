
package bibliotekaprojekat.kontroler.slusaci;

import bibliotekaprojekat.kontroler.Kontroler;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
        
/**
 * Slusa tabelu izdavanja - koji je red selektovan. U metodama vraca dobijene
 * vrednosti u koloni selektovanog reda.
 */

public class SlusacTabeleIzdavanja implements ListSelectionListener{
    private int selektovanRed;
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        
        selektovanRed = Kontroler.getInstanca().getGlavniFrejm().getIzdavanjeTabela().
                convertRowIndexToModel(Kontroler.getInstanca().getGlavniFrejm().getIzdavanjeTabela().getSelectedRow());
      }
    
    public int getSelektovanRed() {
        return selektovanRed;
    }
      public int dobiId(){
        return Integer.parseInt(Kontroler.getInstanca().getGlavniFrejm().getIzdavanjeTabela().getValueAt(selektovanRed, 0).toString());
    }
      public String dobiDatumVracanja(){
          try{
          return Kontroler.getInstanca().getGlavniFrejm().getIzdavanjeTabela().getValueAt(selektovanRed, 4).toString();
          } catch (NullPointerException npe){
              return null;
          }
      }
}
