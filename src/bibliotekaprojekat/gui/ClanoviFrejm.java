package bibliotekaprojekat.gui;

import bibliotekaprojekat.gui.dodaci.Boja;
import bibliotekaprojekat.gui.dodaci.KorisniDodaci;
import bibliotekaprojekat.kontroler.Kontroler;
import bibliotekaprojekat.model.Clanovi;
import bibliotekaprojekat.model.Knjige;
import bibliotekaprojekat.model.Transakcije;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *  ClanoviFrejm prikazuje listu clanova
 * 
 */
public class ClanoviFrejm extends JFrame {
    //Sirina frejma se dobija kad se od sirine ekrana oduzme sirina podeljena na 5 / Visina se dobija kad se od visime oduzme visina podeljena na 5 
    static final int SIRINA_FREJMA = (int)(KorisniDodaci.dobijanjeSirineEkrana()-(KorisniDodaci.dobijanjeSirineEkrana()/5));
    static final int VISINA_FREJMA = (int) (KorisniDodaci.dobijanjeVisineEkrana()-(KorisniDodaci.dobijanjeVisineEkrana()/5));
    
    private JButton dodavanjeClanovaBtn = new JButton("Dodavanje");
    private JButton ispravkaClanovaBtn = new JButton("Ispravka");
    private JButton clanoviListaBtn = new JButton("Clanovi");
    private JButton knjigeListaBtn = new JButton("Knjige");
    private JButton izdavanjeIVracanjeBtn = new JButton("Izdavanje Knjiga");
    
    private JTable listaClanovaTabela = new JTable();

    public ClanoviFrejm() {
        setTitle("Lista clanova - Bibliotekar: " + Kontroler.getInstanca().getPrijavljeniBibliotekar().getIme() + " " + Kontroler.getInstanca().getPrijavljeniBibliotekar().getPrezime());
        setSize(SIRINA_FREJMA, VISINA_FREJMA); //Velicina je u zavisnosti od velicine ekrana
        setLocation(((int) KorisniDodaci.dobijanjeSirineEkrana() / 2) - (SIRINA_FREJMA / 2), (int) KorisniDodaci.dobijanjeVisineEkrana() / 2 - (VISINA_FREJMA / 2));//centriranje lokacije
        setJMenuBar(new MeniFrejma());//dodavanje menija koji je isti na 3 velika frejma
        add(new JScrollPane(listaClanovaTabela));
        
        listaClanovaTabela.setSelectionBackground(Boja.tamnoljubicasta);//boji selekciju
        listaClanovaTabela.setSelectionForeground(Boja.jorgovan);
        UIManager.put("Table.alternateRowColor", Boja.jorgovan);
        
        popunjavanjeTabeleClanova(); //koristi metodu za popunjavanje tabele

        JPanel panelJug = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelJug.setBackground(Boja.jorgovan);
        dodavanjeClanovaBtn.setBackground(Boja.jorgovan);
        dodavanjeClanovaBtn.setForeground(Boja.plavoljubicasta);
        ispravkaClanovaBtn.setBackground(Boja.jorgovan);
        ispravkaClanovaBtn.setForeground(Boja.plavoljubicasta);
        panelJug.add(dodavanjeClanovaBtn);
        panelJug.add(ispravkaClanovaBtn);
        add(panelJug, BorderLayout.SOUTH);//bojenje i dodavanje dugmica na jug

        dodavanjeClanovaBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacNoviClan()); //postavljanje slusaca na dugmice
        ispravkaClanovaBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacIspravkeClana());

        Dimension d = izdavanjeIVracanjeBtn.getMaximumSize();//Odredjivanje maksimalne velicine najvceg i koriscenje te velicine kako bi svi dugmici bili jednaki
        clanoviListaBtn.setMaximumSize(new Dimension(d));
        knjigeListaBtn.setMaximumSize(new Dimension(d));
        JPanel panelIstok = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panelIstok, BoxLayout.Y_AXIS);
        panelIstok.setLayout(boxlayout);
        panelIstok.setBackground(Boja.tamnijorgovan);
        knjigeListaBtn.setBackground(Boja.tamnijorgovan);
        knjigeListaBtn.setForeground(Boja.plavoljubicasta);
        clanoviListaBtn.setBackground(Boja.tamnijorgovan);
        clanoviListaBtn.setForeground(Boja.plavoljubicasta);
        izdavanjeIVracanjeBtn.setBackground(Boja.tamnijorgovan);
        izdavanjeIVracanjeBtn.setForeground(Boja.plavoljubicasta);
        panelIstok.add(knjigeListaBtn);
        panelIstok.add(clanoviListaBtn);
        panelIstok.add(izdavanjeIVracanjeBtn);
        add(panelIstok, BorderLayout.EAST);//bojenje i dodavanje dugmica na istok

        knjigeListaBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacKnjiga());//postavljanja slusaca
        izdavanjeIVracanjeBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacPovratakNaGlavni());
    }

    public void popunjavanjeTabeleClanova() {
        List<Clanovi> clanovi = Transakcije.uzmiSveClanove();//uzimanje podataka o clanovima iz baze
        
        if (clanovi == null) {
            JOptionPane.showMessageDialog(null, "Doslo je do greske prilikom ucitavanja", "Poruka", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel dtm = new DefaultTableModel(new String[]{"Redni br.",
            "Ime", "Prezime", "Br. dokumenta", "Adresa", "Grad", "God. rodjenja", "Pol", "Br. clanske karte"}, clanovi.size()){//overajd konstruktora kako kolona 0 (u kojoj se nalaze ID) ne bi mogla da se edituje

            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0){
                    return false;
                }
                return true;
            }
        };

        for (int i = 0; i < clanovi.size(); i++) {
            dtm.setValueAt(clanovi.get(i).getId(), i, 0);//id kao redni broj
            dtm.setValueAt(clanovi.get(i).getIme(), i, 1); // ime clana
            dtm.setValueAt(clanovi.get(i).getPrezime(), i, 2);//prezime clana
            dtm.setValueAt(clanovi.get(i).getBrDokumenta(), i, 3); //br dokumenta (nije obavezno da bude broj)
            dtm.setValueAt(clanovi.get(i).getAdresa(), i, 4);//adresa
            dtm.setValueAt(clanovi.get(i).getGrad(), i, 5);//grad
            dtm.setValueAt(clanovi.get(i).getGodinaRodj(), i, 6); //godina rodjenja  //DOTERATI ISPRAVKU DA MOZE SAMO INTEGER 4 cifre
            dtm.setValueAt(clanovi.get(i).getPol(), i, 7);//pol  //DOTERATI ISPRAVKU DA MOZE SAMO DATI
            dtm.setValueAt(clanovi.get(i).getBrClanske(), i, 8); //br clanske karte (nije obavezno da bude broj)

        }
        JTableHeader zaglavlje = listaClanovaTabela.getTableHeader();
        zaglavlje.setForeground(Boja.tamnoljubicasta);

        listaClanovaTabela.setForeground(Boja.plavoljubicasta);
        
        listaClanovaTabela.setModel(dtm);//postavljanje modela na tabelu
        listaClanovaTabela.getSelectionModel().addListSelectionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleClanova()); //dodavanje slusaca

    }

    public JTable getListaClanovaTabela() {
        return listaClanovaTabela; //getter tabele
    }

}
