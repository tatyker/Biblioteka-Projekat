
package bibliotekaprojekat.gui;

import bibliotekaprojekat.gui.dodaci.Boja;
import bibliotekaprojekat.gui.dodaci.KorisniDodaci;
import bibliotekaprojekat.gui.dodaci.MojFont;
import bibliotekaprojekat.kontroler.Kontroler;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

/**
 *Frejm za unos podataka o knjigama
 */
public class NovaKnjigaFrejm extends JFrame {

    private static final int SIRINA = 340;
    private static final int VISINA = 340;

    private JLabel nazivLbl = new JLabel("Naziv:");
    private JLabel autorLbl = new JLabel("Autor:");
    private JLabel isbnLbl = new JLabel("ISBN:");
    private JLabel godIzdanjaLbl = new JLabel("God. izdanja:");
    private JLabel izdavacLbl = new JLabel("Izdavac:");
    private JLabel zanrLbl = new JLabel("Zanr:");

    private JTextField nazivFld = new JTextField(20);
    private JTextField autorFld = new JTextField(20);
    private JTextField isbnFld = new JTextField(20);
    private JTextField godIzdanjaFld = new JTextField(20);
    private JTextField izdavacFld = new JTextField(20);
    private JTextField zanrFld = new JTextField(20);

    private JButton dodajBtn = new JButton("Dodaj knjigu");

    public NovaKnjigaFrejm() {
        setSize(SIRINA, VISINA);
        setLocation(((int) KorisniDodaci.dobijanjeSirineEkrana() / 2) - (SIRINA / 2), (int) KorisniDodaci.dobijanjeVisineEkrana() / 2 - (VISINA / 2));
        setTitle("Dodavanje knjige na listu");
       

        nazivLbl.setForeground(Boja.plavoljubicasta);
        nazivLbl.setFont(MojFont.fontManjiCambri);
        autorLbl.setForeground(Boja.plavoljubicasta);
        autorLbl.setFont(MojFont.fontManjiCambri);
        isbnLbl.setForeground(Boja.plavoljubicasta);
        isbnLbl.setFont(MojFont.fontManjiCambri);
        godIzdanjaLbl.setForeground(Boja.plavoljubicasta);
        godIzdanjaLbl.setFont(MojFont.fontManjiCambri);
        izdavacLbl.setForeground(Boja.plavoljubicasta);
        izdavacLbl.setFont(MojFont.fontManjiCambri);
        zanrLbl.setForeground(Boja.plavoljubicasta);
        zanrLbl.setFont(MojFont.fontManjiCambri);
        
        nazivFld.setBorder(new LineBorder(Boja.tamnoljubicasta, 1, false));
        autorFld.setBorder(new LineBorder(Boja.tamnoljubicasta, 1, false));
        isbnFld.setBorder(new LineBorder(Boja.tamnoljubicasta, 1, false));
        godIzdanjaFld.setBorder(new LineBorder(Boja.tamnoljubicasta, 1, false));
        izdavacFld.setBorder(new LineBorder(Boja.tamnoljubicasta, 1, false));
        zanrFld.setBorder(new LineBorder(Boja.tamnoljubicasta, 1, false));  //setuje izgled labela i fildova
        
        JPanel glavniPnl = new JPanel(new GridLayout(7, 2, 5, 5));
        glavniPnl.setBackground(Boja.jorgovan);
        glavniPnl.setBorder(BorderFactory.createLineBorder(Boja.jorgovan, 10, false));

        glavniPnl.add(nazivLbl);
        glavniPnl.add(nazivFld);
        glavniPnl.add(autorLbl);
        glavniPnl.add(autorFld);
        glavniPnl.add(isbnLbl);
        glavniPnl.add(isbnFld);
        glavniPnl.add(godIzdanjaLbl);
        glavniPnl.add(godIzdanjaFld);
        glavniPnl.add(izdavacLbl);
        glavniPnl.add(izdavacFld);
        glavniPnl.add(zanrLbl);
        glavniPnl.add(zanrFld); //dodaje labele i fildova na glavni panel

        JPanel donjiPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        donjiPnl.setBackground(Boja.jorgovan);
        dodajBtn.setBackground(Boja.jorgovan);
        dodajBtn.setForeground(Boja.plavoljubicasta);
        dodajBtn.setFont(MojFont.fontManjiCambri);
        donjiPnl.add(dodajBtn);//boji i setuje dugme na donji panel

        dodajBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacDodavanjeKnjige());//dodaje slusac na dugme

        add(glavniPnl, BorderLayout.CENTER);
        add(donjiPnl, BorderLayout.SOUTH); //dodaje gornji i donji panel na frejm
    }
    
    //getteri fildova preko kojih se dobija uneti tekst korisnika
    public JTextField getNazivFld() {
        return nazivFld;
    }

    public JTextField getAutorFld() {
        return autorFld;
    }

    public JTextField getIsbnFld() {
        return isbnFld;
    }

    public JTextField getGodIzdanjaFld() {
        return godIzdanjaFld;
    }

    public JTextField getIzdavacFld() {
        return izdavacFld;
    }

    public JTextField getZanrFld() {
        return zanrFld;
    }

}
