package bibliotekaprojekat.gui;

import bibliotekaprojekat.gui.dodaci.Boja;
import bibliotekaprojekat.gui.dodaci.KorisniDodaci;
import bibliotekaprojekat.gui.dodaci.MojFont;
import bibliotekaprojekat.kontroler.Kontroler;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *Frejm za unos podataka o clanovima
 * 
 */
public class NoviClanFrejm extends JFrame {

    private static final int SIRINA = 420;
    private static final int VISINA = 400;

    private JLabel imeLbl = new JLabel("Ime:");
    private JLabel prezimeLbl = new JLabel("Prezime:");
    private JLabel brDokumentaLbl = new JLabel("Br. dokumenta:");
    private JLabel adresaLbl = new JLabel("Adresa:");
    private JLabel gradLbl = new JLabel("Grad:");
    private JLabel godRodjenjaLbl = new JLabel("God. rodjenja:");
    private JLabel polLbl = new JLabel("Pol:");
    private JLabel brClanskeLbl = new JLabel("Br. clanske karte:");

    private JTextField imeFld = new JTextField(20);
    private JTextField prezimeFld = new JTextField(20);
    private JTextField brDokumentaFld = new JTextField(20);
    private JTextField adresaFld = new JTextField(20);
    private JTextField gradFld = new JTextField(20);
    private JTextField godRodjenjaFld = new JTextField(20);
    private JTextField brClanskeFld = new JTextField(20);

    final ButtonGroup polGrupa = new ButtonGroup();
    private JRadioButton muski = new JRadioButton("muski");
    private JRadioButton zenski = new JRadioButton("zenski");
    private JRadioButton ostalo = new JRadioButton("ostalo");

    private JButton dodajBtn = new JButton("Dodaj clana");

    public NoviClanFrejm() {
        setSize(SIRINA, VISINA);
        setLocation(((int) KorisniDodaci.dobijanjeSirineEkrana() / 2) - (SIRINA / 2), (int) KorisniDodaci.dobijanjeVisineEkrana() / 2 - (VISINA / 2));
        setTitle("Dodavanje clana na listu");

        JPanel glavniPnl = new JPanel(new GridLayout(8, 2, 5, 5));
        glavniPnl.setBackground(Boja.jorgovan);
        glavniPnl.setBorder(BorderFactory.createLineBorder(Boja.jorgovan, 10, false));

        imeLbl.setForeground(Boja.plavoljubicasta);
        imeLbl.setFont(MojFont.fontManjiCambri);
        prezimeLbl.setForeground(Boja.plavoljubicasta);
        prezimeLbl.setFont(MojFont.fontManjiCambri);
        brDokumentaLbl.setForeground(Boja.plavoljubicasta);
        brDokumentaLbl.setFont(MojFont.fontManjiCambri);
        adresaLbl.setForeground(Boja.plavoljubicasta);
        adresaLbl.setFont(MojFont.fontManjiCambri);
        gradLbl.setForeground(Boja.plavoljubicasta);
        gradLbl.setFont(MojFont.fontManjiCambri);
        godRodjenjaLbl.setForeground(Boja.plavoljubicasta);
        godRodjenjaLbl.setFont(MojFont.fontManjiCambri);
        brClanskeLbl.setForeground(Boja.plavoljubicasta);
        brClanskeLbl.setFont(MojFont.fontManjiCambri);
        polLbl.setForeground(Boja.plavoljubicasta);
        polLbl.setFont(MojFont.fontManjiCambri);

        imeFld.setBorder(new LineBorder(Boja.tamnoljubicasta, 1, false));
        prezimeFld.setBorder(new LineBorder(Boja.tamnoljubicasta, 1, false));
        brDokumentaFld.setBorder(new LineBorder(Boja.tamnoljubicasta, 1, false));
        adresaFld.setBorder(new LineBorder(Boja.tamnoljubicasta, 1, false));
        gradFld.setBorder(new LineBorder(Boja.tamnoljubicasta, 1, false));
        godRodjenjaFld.setBorder(new LineBorder(Boja.tamnoljubicasta, 1, false));
        brClanskeFld.setBorder(new LineBorder(Boja.tamnoljubicasta, 1, false));

        glavniPnl.add(imeLbl);
        glavniPnl.add(imeFld);
        glavniPnl.add(prezimeLbl);
        glavniPnl.add(prezimeFld);
        glavniPnl.add(brDokumentaLbl);
        glavniPnl.add(brDokumentaFld);
        glavniPnl.add(adresaLbl);
        glavniPnl.add(adresaFld);
        glavniPnl.add(gradLbl);
        glavniPnl.add(gradFld);
        glavniPnl.add(godRodjenjaLbl);
        glavniPnl.add(godRodjenjaFld);
        glavniPnl.add(brClanskeLbl);
        glavniPnl.add(brClanskeFld);

        JPanel pnlPol = napraviPanel();
        glavniPnl.add(polLbl);
        glavniPnl.add(pnlPol);

        JPanel donjiPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        donjiPnl.setBackground(Boja.jorgovan);
        dodajBtn.setBackground(Boja.jorgovan);
        dodajBtn.setForeground(Boja.plavoljubicasta);
        dodajBtn.setFont(MojFont.fontManjiCambri);
        donjiPnl.add(dodajBtn);

        dodajBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacDodavanjeClana());

        add(glavniPnl, BorderLayout.CENTER);
        add(donjiPnl, BorderLayout.SOUTH);
    }

    public JPanel napraviPanel() { //pravi panel za pol 
        JPanel pnlPol = new JPanel(new FlowLayout(FlowLayout.LEFT));

        pnlPol.setBackground(Boja.jorgovan);
        muski.setBackground(Boja.jorgovan);
        zenski.setBackground(Boja.jorgovan);
        ostalo.setBackground(Boja.jorgovan);
        muski.setForeground(Boja.plavoljubicasta);
        zenski.setForeground(Boja.plavoljubicasta);
        ostalo.setForeground(Boja.plavoljubicasta);
        muski.setFont(MojFont.fontManjiCambri);
        zenski.setFont(MojFont.fontManjiCambri);
        ostalo.setFont(MojFont.fontManjiCambri);
        pnlPol.add(muski);
        muski.setActionCommand("muski");
        polGrupa.add(muski);
        pnlPol.add(zenski);
        zenski.setActionCommand("zenski");
        polGrupa.add(zenski);
        pnlPol.add(ostalo);
        ostalo.setActionCommand("ostalo");
        polGrupa.add(ostalo);

        return pnlPol;
    }

    public JTextField getImeFld() {
        return imeFld;
    }

    public JTextField getPrezimeFld() {
        return prezimeFld;
    }

    public JTextField getBrDokumentaFld() {
        return brDokumentaFld;
    }

    public JTextField getAdresaFld() {
        return adresaFld;
    }

    public JTextField getGradFld() {
        return gradFld;
    }

    public JTextField getGodRodjenjaFld() {
        return godRodjenjaFld;
    }

    public JTextField getBrClanskeFld() {
        return brClanskeFld;
    }

    public ButtonGroup getPolGrupa() {
        return polGrupa;
    }

}
