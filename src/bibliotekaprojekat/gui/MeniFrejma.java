package bibliotekaprojekat.gui;

import bibliotekaprojekat.gui.dodaci.Boja;
import bibliotekaprojekat.kontroler.Kontroler;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Meni koji se nalazi na 3 frejma i moze da zameni dugmice sa istocnog dela frejma, sadrzi izlaz iz programa, kao i pomoc i informacije o programu
 */
public class MeniFrejma extends JMenuBar {

    private JMenu meniBiblioteke = new JMenu("Biblioteka");
    private JMenuItem listaKnjigaStavka = new JMenuItem("Lista knjiga");
    private JMenuItem listaClanovaStavka = new JMenuItem("Lista clanova");
    private JMenuItem izdavanjeKnjigaStavka = new JMenuItem("Izdavanje knjiga");
    private JMenuItem izlazStavka = new JMenuItem("Izlaz iz programa");
    
    private JMenu meniPomoc = new JMenu("Pomoc");
    private JMenuItem pomocStavka = new JMenuItem("Instrukcije");
    private JMenuItem oProgramu = new JMenuItem("O programu");

    public MeniFrejma() {
        meniBiblioteke.add(listaKnjigaStavka);//dodaje stavke
        meniBiblioteke.add(listaClanovaStavka);
        meniBiblioteke.add(izdavanjeKnjigaStavka);
        listaKnjigaStavka.setMnemonic('k');//setuje za upravljanje preko tastature
        listaClanovaStavka.setMnemonic('c');
        izdavanjeKnjigaStavka.setMnemonic('z');
        meniBiblioteke.setMnemonic('B');
        meniBiblioteke.addSeparator();//dodaje separator zbog preglednosti
        meniBiblioteke.add(izlazStavka);
        izlazStavka.setMnemonic('I');

        meniBiblioteke.setForeground(Boja.tamnoljubicasta);
        add(meniBiblioteke);

        meniPomoc.add(pomocStavka);
        meniPomoc.addSeparator();
        meniPomoc.add(oProgramu);
        meniPomoc.setMnemonic('P');
        pomocStavka.setMnemonic('n');
        oProgramu.setMnemonic('o');

        meniPomoc.setForeground(Boja.tamnoljubicasta);
        add(meniPomoc);

        listaKnjigaStavka.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacKnjiga());//dodaje slusace na stavke
        listaClanovaStavka.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacClanova());
        izdavanjeKnjigaStavka.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacPovratakNaGlavni());
        izlazStavka.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacIzlaza());

        pomocStavka.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacPomoci());
        oProgramu.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacOProgramu());
    }
}
