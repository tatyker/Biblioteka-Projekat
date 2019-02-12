package bibliotekaprojekat.gui;

import static bibliotekaprojekat.gui.GlavniFrejm.SIRINA_FREJMA;
import bibliotekaprojekat.gui.dodaci.Boja;
import bibliotekaprojekat.gui.dodaci.KorisniDodaci;
import bibliotekaprojekat.gui.dodaci.MojFont;
import bibliotekaprojekat.kontroler.Kontroler;
import bibliotekaprojekat.model.Bibliotekar;
import bibliotekaprojekat.model.Clanovi;
import bibliotekaprojekat.model.Knjige;
import bibliotekaprojekat.model.Transakcije;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 * AdminFrejm kome pristup ima samo Admin a na kome se moze dodati, izmeniti i
 * obrisati bibliotekar.
 */
public class AdminFrejm extends JFrame {

    static final int SIRINA_FREJMA = 900;
    static final int VISINA_FREJMA = 500;

    private JButton dodavanjeBtn = new JButton("Dodavanje");
    private JButton izmenaBtn = new JButton("Izmena");
    private JButton brisanjeBtn = new JButton("Brisanje");

    private JLabel uvodniTextLbl = new JLabel();
    private JLabel uvodniText2Lbl = new JLabel();
    private JLabel korImeLbl = new JLabel("Korisnicko Ime:");
    private JLabel sifraLbl = new JLabel("Sifra:");
    private JLabel imeLbl = new JLabel("Ime:");
    private JLabel prezimeLbl = new JLabel("Prezime:");
    private JLabel biblioLbl = new JLabel("Bibliotekar:");

    private JTextField korImeFld = new JTextField(10);
    private JTextField sifraFld = new JTextField(10);
    private JTextField imeFld = new JTextField(10);
    private JTextField prezimeFld = new JTextField(10);

    private JTable bibliotekariTabela = new JTable();

    private JComboBox<Bibliotekar> bibliotekarCB = new JComboBox<>();

    public AdminFrejm() {
        setSize(SIRINA_FREJMA, VISINA_FREJMA);
        setLocation(((int) KorisniDodaci.dobijanjeSirineEkrana() / 2) - (SIRINA_FREJMA / 2),
                (int) KorisniDodaci.dobijanjeVisineEkrana() / 2 - (VISINA_FREJMA / 2)); //postavljanje prozora na centar ekrana
        setTitle("Administratorski panel");
        add(new JScrollPane(bibliotekariTabela));//scroll pane i tabela su u centru

        popunjavanjeTabeleBibliotekari(); //metoda crta i popunjava tabelu

        bibliotekariTabela.setSelectionBackground(Boja.tamnoljubicasta);
        bibliotekariTabela.setSelectionForeground(Boja.jorgovan);
        UIManager.put("Table.alternateRowColor", Boja.jorgovan);

        JPanel dodavanjePnl = new JPanel(); //panel za dodavanje bibliotekara
        dodavanjePnl.setBackground(Boja.jorgovan);
        dodavanjePnl.setBorder(BorderFactory.createTitledBorder(createLineBorder(Color.white, 2, true),
                "Dodavanje bibliotekara", 1, 5, MojFont.fontBA, Boja.tamnoljubicasta)); //setovanje ivice
        GroupLayout gLayout = new GroupLayout(dodavanjePnl);
        dodavanjePnl.setLayout(gLayout);

        korImeLbl.setForeground(Boja.plavoljubicasta); //setovanje boje slova i fonta
        sifraLbl.setForeground(Boja.plavoljubicasta);
        imeLbl.setForeground(Boja.plavoljubicasta);
        prezimeLbl.setForeground(Boja.plavoljubicasta);
        korImeLbl.setFont(MojFont.fontManjiCambri);
        sifraLbl.setFont(MojFont.fontManjiCambri);
        imeLbl.setFont(MojFont.fontManjiCambri);
        prezimeLbl.setFont(MojFont.fontManjiCambri);

        gLayout.setAutoCreateContainerGaps(true);

        gLayout.setHorizontalGroup(gLayout.createParallelGroup() //grupisanje elemenata u GroupLayout
                .addGroup(gLayout.createSequentialGroup()
                        .addGroup(gLayout.createParallelGroup().addGap(15)
                                .addComponent(korImeLbl).addGap(18)
                                .addComponent(sifraLbl).addGap(18)
                                .addComponent(imeLbl).addGap(19)
                                .addComponent(prezimeLbl)).addGap(19)
                        .addGroup(gLayout.createParallelGroup().addGap(10)
                                .addComponent(korImeFld).addGap(5)
                                .addComponent(sifraFld).addGap(5)
                                .addComponent(imeFld).addGap(5)
                                .addComponent(prezimeFld))));
        gLayout.setVerticalGroup(gLayout.createSequentialGroup()
                .addGroup(gLayout.createParallelGroup()
                        .addGroup(gLayout.createSequentialGroup().addGap(15)
                                .addComponent(korImeLbl).addGap(18)
                                .addComponent(sifraLbl).addGap(18)
                                .addComponent(imeLbl).addGap(19)
                                .addComponent(prezimeLbl)).addGap(19)
                        .addGroup(gLayout.createSequentialGroup().addGap(10)
                                .addComponent(korImeFld, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(5)
                                .addComponent(sifraFld, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(5)
                                .addComponent(imeFld, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(5)
                                .addComponent(prezimeFld, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))));

        add(dodavanjePnl, BorderLayout.WEST); //panel za dodavanje bibliotekara je na zapadu BorderLayouta

        JPanel brisanjePnl = new JPanel(new GridLayout(1, 2, 5, 1));
        brisanjePnl.setBackground(Boja.jorgovan);
        brisanjePnl.setBorder(BorderFactory.createTitledBorder(createLineBorder(Color.white, 2, true),
                "Brisanje bibliotekara", 1, 5, MojFont.fontBA, Boja.tamnoljubicasta));

        JPanel pnlBiblio = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlBiblio.setPreferredSize(new Dimension(240, 25));

        biblioLbl.setForeground(Boja.plavoljubicasta);
        biblioLbl.setFont(MojFont.fontManjiCambri);
        pnlBiblio.add(biblioLbl);
        popuniBibliotekareCB();
        bibliotekarCB.setBackground(Boja.jorgovan);
        bibliotekarCB.setPreferredSize(new Dimension(160, 25));
        pnlBiblio.setBackground(Boja.jorgovan);
        pnlBiblio.add(bibliotekarCB);
        brisanjePnl.add(pnlBiblio);

        add(brisanjePnl, BorderLayout.EAST);//panel za brisanje bibliotekara je na istoku

        JPanel panelSever = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panelSever, BoxLayout.Y_AXIS);
        panelSever.setLayout(boxlayout);
        panelSever.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
        panelSever.setBackground(Boja.tamnijorgovan);
        uvodniTextLbl.setText("Ovo je administratorski panel");
        uvodniText2Lbl.setText("Ovde mozete dodati ili obrisati bibliotekara ili izmeniti njegove podatke");

        uvodniTextLbl.setForeground(Boja.tamnoljubicasta);
        uvodniText2Lbl.setForeground(Boja.tamnoljubicasta);

        uvodniTextLbl.setFont(MojFont.fontBA);
        uvodniText2Lbl.setFont(MojFont.fontBA);

        panelSever.add(uvodniTextLbl);
        panelSever.add(uvodniText2Lbl);

        uvodniTextLbl.setAlignmentX(CENTER_ALIGNMENT);
        uvodniText2Lbl.setAlignmentX(CENTER_ALIGNMENT);

        add(panelSever, BorderLayout.NORTH); //Na severnom panelu se nalazi samo tekst sa setovanom bojom i fontom

        JPanel panelJug = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelJug.setBackground(Boja.tamnijorgovan);
        dodavanjeBtn.setBackground(Boja.jorgovan);
        izmenaBtn.setBackground(Boja.jorgovan);
        brisanjeBtn.setBackground(Boja.jorgovan);
        dodavanjeBtn.setForeground(Boja.plavoljubicasta);
        izmenaBtn.setForeground(Boja.plavoljubicasta);
        brisanjeBtn.setForeground(Boja.plavoljubicasta);
        dodavanjeBtn.setFont(MojFont.fontManjiCambri);
        izmenaBtn.setFont(MojFont.fontManjiCambri);
        brisanjeBtn.setFont(MojFont.fontManjiCambri);
        panelJug.add(dodavanjeBtn);
        panelJug.add(izmenaBtn);
        panelJug.add(brisanjeBtn);
        add(panelJug, BorderLayout.SOUTH); //na jugu je panel sa dugmicima

        //dodavanje odgovarajuceg slusaca na dugmice
        dodavanjeBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacDodavanjaBibliotekara());
        izmenaBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacIspravkeBibliotekara());
        brisanjeBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacBrisanjaBibliotekara());
    }

    public void popunjavanjeTabeleBibliotekari() {
        List<Bibliotekar> bibliotekari = Transakcije.uzmiSveBibliotekare();
        if (bibliotekari == null) {
            JOptionPane.showMessageDialog(null, "Doslo je do greske prilikom ucitavanja", "Poruka", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DefaultTableModel dtm = new DefaultTableModel(new String[]{"Kor. ime", "Sifra", "Ime", "Prezime", "id"}, bibliotekari.size()) {

            @Override
            public boolean isCellEditable(int row, int column) { //metoda je overriden kako ne bi mogli da se menjaju podaci u kolonama u kojima ne smeju da se menjaju
                if (column == 0) {
                    return false;
                } else if (column == 4) {
                    return false;
                }
                return true;
            }
        };

        for (int i = 0; i < bibliotekari.size(); i++) {
            dtm.setValueAt(bibliotekari.get(i).getKorisnickoIme(), i, 0); //ono sta upisujem, red, kolona
            dtm.setValueAt(bibliotekari.get(i).getSifra(), i, 1);
            dtm.setValueAt(bibliotekari.get(i).getIme(), i, 2);
            dtm.setValueAt(bibliotekari.get(i).getPrezime(), i, 3);
            dtm.setValueAt(bibliotekari.get(i).getId(), i, 4);

        }

        JTableHeader zaglavlje = bibliotekariTabela.getTableHeader();
        zaglavlje.setForeground(Boja.tamnoljubicasta);

        bibliotekariTabela.setForeground(Boja.plavoljubicasta);
        bibliotekariTabela.setModel(dtm);
        bibliotekariTabela.getSelectionModel().addListSelectionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleBibliotekari());

    }

    private void popuniBibliotekareCB() { //metoda popunjava combo box za brisanje bibliotekara
        List<Bibliotekar> bibliotekari = Transakcije.uzmiSveBibliotekare();
        for (Bibliotekar bibliotekar : bibliotekari) {
            if (!"admin".equals(bibliotekar.getKorisnickoIme())) //da administrator ne bi mogao da izbrise svoj nalog ne pojavljuje se u CB
            {
                bibliotekarCB.addItem(bibliotekar);
            }

        }
    }

    public JComboBox<Bibliotekar> getBibliotekarCB() {
        return bibliotekarCB;
    }

    public JTable getBibliotekariTabela() {
        return bibliotekariTabela;
    }

    public JTextField getKorImeFld() {
        return korImeFld;
    }

    public JTextField getSifraFld() {
        return sifraFld;
    }

    public JTextField getImeFld() {
        return imeFld;
    }

    public JTextField getPrezimeFld() {
        return prezimeFld;
    }

}
