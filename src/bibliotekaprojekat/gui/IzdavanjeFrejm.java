package bibliotekaprojekat.gui;

import bibliotekaprojekat.gui.dodaci.Boja;
import bibliotekaprojekat.gui.dodaci.KorisniDodaci;
import bibliotekaprojekat.gui.dodaci.MojFont;
import bibliotekaprojekat.kontroler.Kontroler;
import bibliotekaprojekat.model.Clanovi;
import bibliotekaprojekat.model.Knjige;
import bibliotekaprojekat.model.Transakcije;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Frejm za izdavanje knjiga. Sadrzi dva combo boxa sa svim knjigama i svim
 * clanovima
 *
 */
public class IzdavanjeFrejm extends JFrame {

    private static final int SIRINA_FREJMA = 400;
    private static final int VISINA_FREJMA = 160;

    private JLabel clanLbl = new JLabel("Clan:");
    private JLabel knjigaLbl = new JLabel("Knjiga:");

    private JComboBox<Clanovi> clanCB = new JComboBox<>();
    private JComboBox<Knjige> knjigaCB = new JComboBox<>();

    private JButton izdajKnjiguBtn = new JButton("Izdaj");
    private JButton pronadjiKnjiguBtn = new JButton("Pronadji");

    public IzdavanjeFrejm() {
        setSize(SIRINA_FREJMA, VISINA_FREJMA);
        setTitle("Izdavanje knjiga");
        setLocation(((int) KorisniDodaci.dobijanjeSirineEkrana() / 2) - (SIRINA_FREJMA / 2), (int) KorisniDodaci.dobijanjeVisineEkrana() / 2 - (VISINA_FREJMA / 2)); //odredjuje lokaciju odakle krece frejm

        JPanel panelCenter = new JPanel();
        panelCenter.setBackground(Boja.jorgovan);

        GroupLayout gLayout = new GroupLayout(panelCenter); //formira GroupLayout, dizajnira ga i postavlja komponente
        panelCenter.setLayout(gLayout);
        gLayout.setAutoCreateContainerGaps(true);

        panelCenter.setBackground(Boja.jorgovan);
        panelCenter.setBorder(BorderFactory.createLineBorder(Boja.jorgovan, 6, false));
        clanLbl.setForeground(Boja.plavoljubicasta);
        clanLbl.setFont(MojFont.fontManjiCambri);
        knjigaLbl.setForeground(Boja.plavoljubicasta);
        knjigaLbl.setFont(MojFont.fontManjiCambri);
        knjigaCB.setBackground(Boja.jorgovan);
        clanCB.setBackground(Boja.jorgovan);
        knjigaCB.setForeground(Boja.plavoljubicasta);

        gLayout.setHorizontalGroup(gLayout.createParallelGroup()
                .addGroup(gLayout.createSequentialGroup()
                        .addGroup(gLayout.createParallelGroup().addGap(16)
                                .addComponent(clanLbl).addGap(16)
                                .addComponent(knjigaLbl)).addGap(15)
                        .addGroup(gLayout.createParallelGroup().addGap(10)
                                .addComponent(clanCB).addGap(5)
                                .addComponent(knjigaCB))));
        gLayout.setVerticalGroup(gLayout.createSequentialGroup()
                .addGroup(gLayout.createParallelGroup()
                        .addGroup(gLayout.createSequentialGroup().addGap(16)
                                .addComponent(clanLbl).addGap(16)
                                .addComponent(knjigaLbl)).addGap(15)
                        .addGroup(gLayout.createSequentialGroup().addGap(10)
                                .addComponent(clanCB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(5)
                                .addComponent(knjigaCB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))));

        popuniClanoviCB();//koristi metode da se popune CB sa clanovima i knjigama
        popuniKnjigeCB();

        add(panelCenter);

        JPanel panelSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        izdajKnjiguBtn.setForeground(Boja.plavoljubicasta);
        izdajKnjiguBtn.setBackground(Boja.jorgovan);
        izdajKnjiguBtn.setFont(MojFont.fontManjiCambri);
        pronadjiKnjiguBtn.setForeground(Boja.plavoljubicasta);
        pronadjiKnjiguBtn.setBackground(Boja.jorgovan);
        pronadjiKnjiguBtn.setFont(MojFont.fontManjiCambri);
        panelSouth.add(izdajKnjiguBtn);
        panelSouth.add(pronadjiKnjiguBtn);
        panelSouth.setBackground(Boja.jorgovan);
        add(panelSouth, BorderLayout.SOUTH);//dodaje dugmice na jug

        izdajKnjiguBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacNovoIzdavanje());//dodaje slusace na dugmice
        pronadjiKnjiguBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacPretrage());

    }

    private void popuniClanoviCB() {//popunjava CB odredjenim podacima o clanovima iz baze (onima koji su u overajdovanoj metodi toString() u klasi Clanovi)
        List<Clanovi> clanovi = Transakcije.uzmiSveClanove();
        for (Clanovi clan : clanovi) {
            clanCB.addItem(clan);
        }
    }

    public void popuniKnjigeCB() {//popunjava CB odredjenim podacima o knigama iz baze (onima koji su u overajdovanoj metodi toString() u klasi Knjige)
        List<Knjige> knjige = Transakcije.uzmiSveKnjige();
        for (Knjige knjiga : knjige) {
            knjigaCB.addItem(knjiga);
        }
    }
    
    //getteri CB

    public JComboBox<Clanovi> getClanCB() {
        return clanCB;
    }

    public JComboBox<Knjige> getKnjigaCB() {
        return knjigaCB;
    }

}
