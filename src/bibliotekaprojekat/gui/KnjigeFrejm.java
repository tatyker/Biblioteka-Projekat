package bibliotekaprojekat.gui;

import bibliotekaprojekat.gui.dodaci.Boja;
import bibliotekaprojekat.gui.dodaci.KorisniDodaci;
import bibliotekaprojekat.kontroler.Kontroler;
import bibliotekaprojekat.model.Izdavanje;
import bibliotekaprojekat.model.Knjige;
import bibliotekaprojekat.model.Transakcije;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
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
 * KnjigeFrejm sadrzi listu knjiga
 * 
 */
public class KnjigeFrejm extends JFrame {
    //Sirina frejma se dobija kad se od sirine ekrana oduzme sirina podeljena na 5 / Visina se dobija kad se od visime oduzme visina podeljena na 5  
    static final int SIRINA_FREJMA = (int) (KorisniDodaci.dobijanjeSirineEkrana() - (KorisniDodaci.dobijanjeSirineEkrana() / 5));
    static final int VISINA_FREJMA = (int) (KorisniDodaci.dobijanjeVisineEkrana() - (KorisniDodaci.dobijanjeVisineEkrana() / 5));
  
    private JButton dodavanjeKnjigaBtn = new JButton("Dodavanje");
    private JButton ispravkaKnjigaBtn = new JButton("Ispravka");
    private JButton clanoviListaBtn = new JButton("Clanovi");
    private JButton knjigeListaBtn = new JButton("Knjige");
    private JButton izdavanjeIVracanjeBtn = new JButton("Izdavanje Knjiga");
  
    private JTable listaKnjigaTabela = new JTable();

    public KnjigeFrejm() {
        setTitle("Lista Knjiga - Bibliotekar: " + Kontroler.getInstanca().getPrijavljeniBibliotekar().getIme() + " " + Kontroler.getInstanca().getPrijavljeniBibliotekar().getPrezime());
        setSize(SIRINA_FREJMA, VISINA_FREJMA);//odredjivanje velicine frejma
        setLocation(((int) KorisniDodaci.dobijanjeSirineEkrana() / 2) - (SIRINA_FREJMA / 2), (int) KorisniDodaci.dobijanjeVisineEkrana() / 2 - (VISINA_FREJMA / 2));//odredjuje se lokacija odakle pocinje frejm
        setJMenuBar(new MeniFrejma());//dodaje se meni
        add(new JScrollPane(listaKnjigaTabela));//dodaje se Scroll pane sa tabelom

        listaKnjigaTabela.setSelectionBackground(Boja.tamnoljubicasta);//boja selekcije
        listaKnjigaTabela.setSelectionForeground(Boja.jorgovan);
        UIManager.put("Table.alternateRowColor", Boja.jorgovan);

        popunjavanjeTabeleKnjiga();//metoda za popunjavanje

        JPanel panelJug = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelJug.setBackground(Boja.jorgovan);

        dodavanjeKnjigaBtn.setBackground(Boja.jorgovan);
        dodavanjeKnjigaBtn.setForeground(Boja.plavoljubicasta);
        ispravkaKnjigaBtn.setBackground(Boja.jorgovan);
        ispravkaKnjigaBtn.setForeground(Boja.plavoljubicasta);
        panelJug.add(dodavanjeKnjigaBtn);
        panelJug.add(ispravkaKnjigaBtn);
        add(panelJug, BorderLayout.SOUTH);//boji i setuje dugmice na jug

        dodavanjeKnjigaBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacNovaKnjiga());//dodaju se slusaci na dugmice
        ispravkaKnjigaBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacIspravkeKnjige());

        Dimension d = izdavanjeIVracanjeBtn.getMaximumSize(); //uzimam dimenzije ovog btn i koristim ih za druga dva
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
        add(panelIstok, BorderLayout.EAST);//boje se i dodaju dugmici na istok

        clanoviListaBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacClanova());
        izdavanjeIVracanjeBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacPovratakNaGlavni());//dodaju se slusaci
    }

    public void popunjavanjeTabeleKnjiga() {
        List<Knjige> sveKnjige = Transakcije.uzmiSveKnjige();//uzima podatke o knjigama iz baze
        
        if (sveKnjige == null) {
            JOptionPane.showMessageDialog(null, "Doslo je do greske prilikom ucitavanja", "Poruka", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel dtm = new DefaultTableModel(new String[]{"Redni br.", "Naziv", "Autor", "ISBN",
            "God. izdanja", "Izdavac", "Zanr"}, sveKnjige.size()) {
                //onemogucuje editovanje kolone sa id
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return true;
            }
        };

        for (int i = 0; i < sveKnjige.size(); i++) {
            dtm.setValueAt(sveKnjige.get(i).getId(), i, 0); //id knjige - kao redni broj
            dtm.setValueAt(sveKnjige.get(i).getNaziv(), i, 1); //naziv knjige
            dtm.setValueAt(sveKnjige.get(i).getAutor(), i, 2); //autor
            dtm.setValueAt(sveKnjige.get(i).getIsbn(), i, 3); //isbn
            dtm.setValueAt(sveKnjige.get(i).getGodinaIzdanja(), i, 4); //godina izdanja
            dtm.setValueAt(sveKnjige.get(i).getIzdavac(), i, 5); //izdavac
            dtm.setValueAt(sveKnjige.get(i).getZanr(), i, 6); //zanr

        }

        JTableHeader zaglavlje = listaKnjigaTabela.getTableHeader();
        zaglavlje.setForeground(Boja.tamnoljubicasta);

        listaKnjigaTabela.setForeground(Boja.plavoljubicasta);
        listaKnjigaTabela.setModel(dtm);//setuje model
        listaKnjigaTabela.getSelectionModel().addListSelectionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleKnjiga());//dodaje slusac

    }

    public JTable getListaKnjigaTabela() {
        return listaKnjigaTabela;  //getter tabele
    }

}
