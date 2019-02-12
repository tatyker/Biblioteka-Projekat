package bibliotekaprojekat.gui;

import bibliotekaprojekat.gui.dodaci.Boja;
import bibliotekaprojekat.gui.dodaci.KorisniDodaci;
import bibliotekaprojekat.kontroler.Kontroler;
import bibliotekaprojekat.kontroler.slusaci.SlusacLogovanja;
import bibliotekaprojekat.model.Izdavanje;
import bibliotekaprojekat.model.Transakcije;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 * GlavniFrejm prikazuje Izdavanje knjiga
 *
 */
public class GlavniFrejm extends JFrame {

    //Sirina frejma se dobija kad se od sirine ekrana oduzme sirina podeljena na 5 / Visina se dobija kad se od visime oduzme visina podeljena na 5 
    static final int SIRINA_FREJMA = (int) (KorisniDodaci.dobijanjeSirineEkrana() - (KorisniDodaci.dobijanjeSirineEkrana() / 5));
    static final int VISINA_FREJMA = (int) (KorisniDodaci.dobijanjeVisineEkrana() - (KorisniDodaci.dobijanjeVisineEkrana() / 5));

    private JButton izdavanjeKnjigaBtn = new JButton("Izdavanje");
    private JButton vracanjeKnjigaBtn = new JButton("Vracanje");
    private JButton pretragaKnjigaBtn = new JButton("Pretraga");
    private JButton clanoviListaBtn = new JButton("Clanovi");
    private JButton knjigeListaBtn = new JButton("Knjige");
    private JButton izdavanjeIVracanjeBtn = new JButton("Izdavanje Knjiga");

    private JTable izdavanjeTabela = new JTable();

    public GlavniFrejm() {
        //Velicina je u zavisnosti od velicine ekrana
        setSize(SIRINA_FREJMA, VISINA_FREJMA);
        //na osnovu sirine i visine ekrana locira se frejm na ekranu
        setLocation(((int) KorisniDodaci.dobijanjeSirineEkrana() / 2) - (SIRINA_FREJMA / 2), (int) KorisniDodaci.dobijanjeVisineEkrana() / 2 - (VISINA_FREJMA / 2));
        //svaki bibliotekar ce imati upisano svoje ime, ako je ime uneto
        setTitle("Izdavanje knjiga - Bibliotekar: " + Kontroler.getInstanca().getPrijavljeniBibliotekar().getIme() + " " + Kontroler.getInstanca().getPrijavljeniBibliotekar().getPrezime());
        //postavlja se meni na frejm - meni je isti na sva tri velika frejma
        setJMenuBar(new MeniFrejma());

        izdavanjeTabela.setSelectionBackground(Boja.tamnoljubicasta);//selekcija je custom boja tamno ljubicasta
        izdavanjeTabela.setSelectionForeground(Boja.jorgovan);//tekst na selekciji je boja jorgovana
        UIManager.put("Table.alternateRowColor", Boja.jorgovan);//svaki drugi red je boje jorgovana, setuje se u samom UIManageru

        add(new JScrollPane(izdavanjeTabela));//dodaje panel koji moze da se skroluje i na njega tabelu

        popunjavanjeTabele();//popunjava tabelu podacima iz DB

        JPanel panelJug = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelJug.setBackground(Boja.jorgovan);
        izdavanjeKnjigaBtn.setBackground(Boja.jorgovan);
        izdavanjeKnjigaBtn.setForeground(Boja.plavoljubicasta);
        vracanjeKnjigaBtn.setBackground(Boja.jorgovan);
        vracanjeKnjigaBtn.setForeground(Boja.plavoljubicasta);
        pretragaKnjigaBtn.setBackground(Boja.jorgovan);
        pretragaKnjigaBtn.setForeground(Boja.plavoljubicasta);
        panelJug.add(pretragaKnjigaBtn);
        panelJug.add(izdavanjeKnjigaBtn);
        panelJug.add(vracanjeKnjigaBtn);
        add(panelJug, BorderLayout.SOUTH);//setuje boje dugmica i postavlja ih na jug

        Dimension d = izdavanjeIVracanjeBtn.getMaximumSize();//Odredjivanje maksimalne velicine najvceg i prosledjivanje ostalim kako bi svi dugmici bili jednaki
        clanoviListaBtn.setMaximumSize(new Dimension(d));
        knjigeListaBtn.setMaximumSize(new Dimension(d));

        JPanel PanelIstok = new JPanel();
        BoxLayout boxlayout = new BoxLayout(PanelIstok, BoxLayout.Y_AXIS);
        PanelIstok.setLayout(boxlayout);
        PanelIstok.setBackground(Boja.tamnijorgovan);
        knjigeListaBtn.setBackground(Boja.tamnijorgovan);
        knjigeListaBtn.setForeground(Boja.plavoljubicasta);
        clanoviListaBtn.setBackground(Boja.tamnijorgovan);
        clanoviListaBtn.setForeground(Boja.plavoljubicasta);
        izdavanjeIVracanjeBtn.setBackground(Boja.tamnijorgovan);
        izdavanjeIVracanjeBtn.setForeground(Boja.plavoljubicasta);
        PanelIstok.add(knjigeListaBtn);
        PanelIstok.add(clanoviListaBtn);
        PanelIstok.add(izdavanjeIVracanjeBtn);
        add(PanelIstok, BorderLayout.EAST);//setuje boje i dodaje dugmice na istok

        knjigeListaBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacKnjiga());//postavlja slusace na sve dugmice
        clanoviListaBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacClanova());

        pretragaKnjigaBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacPretrage());
        izdavanjeKnjigaBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacIzdavanja());
        vracanjeKnjigaBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacVracanja());
    }

    public void popunjavanjeTabele() {
        List<Izdavanje> izdateKnjige = Transakcije.uzmiSveIzdateKnjige();//Transakcija koja uzima podatke o svim knjigama iz DB

        if (izdateKnjige == null) {
            JOptionPane.showMessageDialog(null, "Doslo je do greske prilikom ucitavanja", "Poruka", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel dtm = new DefaultTableModel(new String[]{"Redni br.", "Clan", "Knjiga", "Datum Izdavanja",
            "Datum vracanja", "Status"}, izdateKnjige.size()) {  //pravi novi model tabele, s obzirom da na ovoj tabeli se ne vrse ispravke overajduje se metoda isCellEditable da bude false tako da tabela ne moze biti editovana

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); //formatira prikazivanje datuma

        for (int i = 0; i < izdateKnjige.size(); i++) {
            dtm.setValueAt(izdateKnjige.get(i).getId(), i, 0); //id izdavanje - da bi bilo lakse za 
            dtm.setValueAt(izdateKnjige.get(i).getIdClan().getIme() + " " + izdateKnjige.get(i).getIdClan().getPrezime(), i, 1); // ime i prezime clana
            dtm.setValueAt(izdateKnjige.get(i).getIdKnjiga().getNaziv(), i, 2); // Knjiga - naslov
            dtm.setValueAt(sdf.format(izdateKnjige.get(i).getDatumIzdavanja()), i, 3); // datum izdavanja
            try {
                dtm.setValueAt(sdf.format(izdateKnjige.get(i).getDatumVracanja()), i, 4);
            } catch (java.lang.NullPointerException ex) { }// datum vracanja je prazan kod izdavanja, zato koristim try/catch NullPointerException 
            dtm.setValueAt(izdateKnjige.get(i).getIdStatus().getStatus(), i, 5); // status knjige (izdata ili vracena)

        }
        JTableHeader zaglavlje = izdavanjeTabela.getTableHeader();
        zaglavlje.setForeground(Boja.tamnoljubicasta);

        izdavanjeTabela.setForeground(Boja.plavoljubicasta);//boja teksta u tabeli
        izdavanjeTabela.setModel(dtm);//postavlja se model na tabelu
        izdavanjeTabela.getSelectionModel().addListSelectionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacTabeleIzdavanja()); //stavlja se slusac

    }

    public JTable getIzdavanjeTabela() {
        return izdavanjeTabela; //getter tabele
    }
}
