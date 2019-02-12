
package bibliotekaprojekat.gui;

import bibliotekaprojekat.gui.dodaci.Boja;
import bibliotekaprojekat.gui.dodaci.KorisniDodaci;
import bibliotekaprojekat.gui.dodaci.MojFont;
import bibliotekaprojekat.kontroler.Kontroler;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *  InstrukcijeFrame sadrzi instrukcije za rad u programu
 */
public class InstrukcijeFrejm extends JFrame {
    static final int SIRINA_FREJMA = 600;
    static final int VISINA_FREJMA = 800;
    
    private JButton zatvoriBtn = new JButton("Zatvori");
    private JLabel tekstLbl = new JLabel();

    public InstrukcijeFrejm() throws FileNotFoundException {//throws FileNotFoundException u slucaju da ne moze da nadje fajl, pogresno je nazvan i sl.
        setSize(SIRINA_FREJMA, VISINA_FREJMA);
        setTitle("Instrukcije");
        setLocation(((int)KorisniDodaci.dobijanjeSirineEkrana()/2)-(SIRINA_FREJMA/2), ((int)KorisniDodaci.dobijanjeVisineEkrana()/2)- (VISINA_FREJMA/2));
        setAlwaysOnTop(true);//uvek na vrhu prekoostalih prozora
        
        JPanel panelNorth = new JPanel();
        panelNorth.setBorder(BorderFactory.createTitledBorder(" "));
        panelNorth.setBackground(Boja.jorgovan);
        panelNorth.add(tekstLbl, panelNorth);
        tekstLbl.setText(dobiTekst());//postavlja tekst is pomoc.txt fajla na labelu
        
        add(panelNorth);
        
        JPanel panelSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        zatvoriBtn.setBackground(Boja.jorgovan);
        zatvoriBtn.setForeground(Boja.plavoljubicasta);
        zatvoriBtn.setFont(MojFont.fontManjiCambri);
        
        panelSouth.add(zatvoriBtn);
        panelSouth.setBackground(Boja.jorgovan);
        add(panelSouth, BorderLayout.SOUTH);
        
        zatvoriBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacZatvaranjaPomoci());
        
    }
    
    public String dobiTekst() throws FileNotFoundException{//cita tekst iz fajla. Fajl je uredjen preko html-a
              
        Scanner skener = new Scanner(new File("pomoc.txt"));
        String text = skener.useDelimiter("\\A").next();
        skener.close();
        return text;
        
        
    }
    
}
