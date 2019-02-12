package bibliotekaprojekat.gui;

import bibliotekaprojekat.gui.dodaci.Boja;
import bibliotekaprojekat.gui.dodaci.KorisniDodaci;
import bibliotekaprojekat.gui.dodaci.MojFont;
import bibliotekaprojekat.kontroler.Kontroler;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
/**
 * Frejm preko koga se logujemo u program
 * 
 */
public class LogovanjeFrejm extends JFrame {

    private static final int SIRINA_FREJMA = 300;
    private static final int VISINA_FREJMA = 120;

    private JLabel korisnickoImeLbl = new JLabel("Korisnicko ime:");
    private JLabel sifraLbl = new JLabel("Sifra:");
    private JTextField korisnickoImeFld = new JTextField(0); //sa 0 bi trebalo bi da sam odredi preferred width
    private JPasswordField sifraFld = new JPasswordField(0);
    private JButton logovanjeBtn = new JButton("Prijava");
    private JButton odustajanjeBtn = new JButton("Odustani");
   
    public LogovanjeFrejm() {
        setSize(SIRINA_FREJMA, VISINA_FREJMA);
        setLocation(((int) KorisniDodaci.dobijanjeSirineEkrana() / 2) - (SIRINA_FREJMA / 2), (int) KorisniDodaci.dobijanjeVisineEkrana() / 2 - (VISINA_FREJMA / 2));
        setTitle("Logovanje");

        JPanel logovanjePnl = new JPanel(new GridLayout(2, 2, 5, 5));
        logovanjePnl.setBackground(Boja.jorgovan);
        logovanjePnl.setBorder(BorderFactory.createLineBorder(Boja.jorgovan, 6, false)); //da se dobije odbijanje od ivice frejma
        korisnickoImeLbl.setFont(MojFont.fontManjiCambri);
        korisnickoImeLbl.setForeground(Boja.plavoljubicasta);
        korisnickoImeFld.setBorder(new LineBorder(Boja.tamnoljubicasta, 1, false));//stavlja ljubicastu liniju na ivice polja
        sifraLbl.setFont(MojFont.fontManjiCambri);
        sifraLbl.setForeground(Boja.plavoljubicasta);
        sifraFld.setBorder(new LineBorder(Boja.tamnoljubicasta, 1, false));
        logovanjePnl.add(korisnickoImeLbl);
        logovanjePnl.add(korisnickoImeFld);
        logovanjePnl.add(sifraLbl);
        logovanjePnl.add(sifraFld);
        add(logovanjePnl);//setovanje, bojenje, selekcija fonta i dodavanje na panel

        JPanel dugmiciPnl = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        dugmiciPnl.setBackground(Boja.jorgovan);
        logovanjeBtn.setBackground(Boja.jorgovan);
        logovanjeBtn.setFont(MojFont.fontManjiCambri);
        odustajanjeBtn.setFont(MojFont.fontManjiCambri);
        odustajanjeBtn.setBackground(Boja.jorgovan);
        logovanjeBtn.setForeground(Boja.plavoljubicasta);
        odustajanjeBtn.setForeground(Boja.plavoljubicasta);
        logovanjeBtn.setFocusPainted(rootPaneCheckingEnabled);
        dugmiciPnl.add(logovanjeBtn);
        dugmiciPnl.add(odustajanjeBtn);
        add(dugmiciPnl, BorderLayout.SOUTH);//setovanje dugmica (boja, font) i dodavanje na jug

        setResizable(false); //ne moze da se menja velicina frejma

        logovanjeBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacLogovanja());//dodaje slusace na dugmice
        odustajanjeBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacOdustajanja());

    }
    //getteri za korisnicko ime i sifru, kako bi mogli da ih koristimo u drugim klasama
    public JTextField getKorisnickoImeFld() {
        return korisnickoImeFld;
    }

    public JPasswordField getSifraFld() {
        return sifraFld;
    }
}
