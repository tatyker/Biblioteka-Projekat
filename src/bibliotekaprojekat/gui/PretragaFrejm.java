package bibliotekaprojekat.gui;

import bibliotekaprojekat.gui.dodaci.Boja;
import bibliotekaprojekat.gui.dodaci.KorisniDodaci;
import bibliotekaprojekat.gui.dodaci.MojFont;
import bibliotekaprojekat.kontroler.Kontroler;
import bibliotekaprojekat.model.Clanovi;
import bibliotekaprojekat.model.Knjige;
import bibliotekaprojekat.model.Transakcije;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
 *
 * Pretraga po nazivu ili autoru i izdavanje knjiga
 */
public class PretragaFrejm extends JFrame {

    static final int SIRINA_FREJMA = 400;
    static final int VISINA_FREJMA = 260;

    private JLabel clanLbl = new JLabel("Clan:");
    private JLabel knjigaLbl = new JLabel("Knjiga:");
   
    private JTextField pretragaNazivFld = new JTextField(20);
    private JTextField pretragaAutorFld = new JTextField(20);
    
    private JButton pretragaNazivBtn = new JButton("Pretrazi Nazive");
    private JButton pretragaAutorBtn = new JButton("Pretrazi Autore");
    private JButton izdajKnjiguBtn = new JButton("Izdaj");
    
    private JComboBox<Knjige> pretragaCB = new JComboBox<>();
    private JComboBox<Clanovi> clanCB = new JComboBox<>();

    public PretragaFrejm() {
        setSize(SIRINA_FREJMA, VISINA_FREJMA);
        setLocation((int) KorisniDodaci.dobijanjeSirineEkrana() / 2 - (SIRINA_FREJMA / 2), (int) KorisniDodaci.dobijanjeVisineEkrana() / 2 - (VISINA_FREJMA / 2));
        setTitle("Pretraga knjiga");

        JPanel panelSever = new JPanel(new BorderLayout());
        JPanel gornjiPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        gornjiPnl.setBackground(Boja.jorgovan);
        pretragaNazivBtn.setForeground(Boja.plavoljubicasta);
        pretragaNazivBtn.setBackground(Boja.jorgovan);
        pretragaNazivBtn.setFont(MojFont.fontManjiCambri);
        gornjiPnl.add(pretragaNazivFld);
        gornjiPnl.add(pretragaNazivBtn);//setuje fild i dugme za pretragu po nazivu knjige

        JPanel srednjiPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        srednjiPnl.setBackground(Boja.jorgovan);
        pretragaAutorBtn.setForeground(Boja.plavoljubicasta);
        pretragaAutorBtn.setBackground(Boja.jorgovan);
        pretragaAutorBtn.setFont(MojFont.fontManjiCambri);
        srednjiPnl.add(pretragaAutorFld);
        srednjiPnl.add(pretragaAutorBtn); //setuje fild i dugme za pretragu po autoru 

        panelSever.add(gornjiPnl, BorderLayout.NORTH);
        panelSever.add(srednjiPnl, BorderLayout.CENTER);//dodaje ih na sever

        JPanel panelCenter = new JPanel();
        panelCenter.setBackground(Boja.jorgovan);

        GroupLayout gLayout = new GroupLayout(panelCenter);//dodaje labele i CB na centralni panel
        panelCenter.setLayout(gLayout);
        gLayout.setAutoCreateContainerGaps(true);

        panelCenter.setBackground(Boja.jorgovan);
        panelCenter.setBorder(BorderFactory.createLineBorder(Boja.jorgovan, 6, false));
        clanLbl.setForeground(Boja.plavoljubicasta);
        clanLbl.setFont(MojFont.fontManjiCambri);
        knjigaLbl.setForeground(Boja.plavoljubicasta);
        knjigaLbl.setFont(MojFont.fontManjiCambri);
        pretragaCB.setBackground(Boja.jorgovan);
        clanCB.setBackground(Boja.jorgovan);
        pretragaCB.setForeground(Boja.plavoljubicasta);

        gLayout.setHorizontalGroup(gLayout.createParallelGroup()
                .addGroup(gLayout.createSequentialGroup()
                        .addGroup(gLayout.createParallelGroup().addGap(16)
                                .addComponent(clanLbl).addGap(16)
                                .addComponent(knjigaLbl)).addGap(15)
                        .addGroup(gLayout.createParallelGroup().addGap(10)
                                .addComponent(clanCB).addGap(5)
                                .addComponent(pretragaCB))));
        gLayout.setVerticalGroup(gLayout.createSequentialGroup()
                .addGroup(gLayout.createParallelGroup()
                        .addGroup(gLayout.createSequentialGroup().addGap(16)
                                .addComponent(clanLbl).addGap(16)
                                .addComponent(knjigaLbl)).addGap(15)
                        .addGroup(gLayout.createSequentialGroup().addGap(10)
                                .addComponent(clanCB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(5)
                                .addComponent(pretragaCB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))));
        popuniClanoviCB(); //popunjava CB sa clanovima

        JPanel donjiPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        donjiPnl.setBackground(Boja.jorgovan);
        izdajKnjiguBtn.setForeground(Boja.plavoljubicasta);
        izdajKnjiguBtn.setBackground(Boja.jorgovan);
        izdajKnjiguBtn.setFont(MojFont.fontManjiCambri);
        donjiPnl.add(izdajKnjiguBtn);

        add(panelSever, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
        add(donjiPnl, BorderLayout.SOUTH);

        pretragaNazivBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacPretragaKnjiga());
        pretragaAutorBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacPretrageAutora());
        izdajKnjiguBtn.addActionListener(Kontroler.getInstanca().getMenadzerSlusaca().getSlusacPretragaIzdavanje());
    }

    public void popuniKnjigeCB(String nazivKnjige) {//metode za popunjavanje pretragaCB ako je pretraga isla po nazivu

        List<Knjige> knjige = Transakcije.pretraziKnjige(nazivKnjige);
        for (Knjige knjiga : knjige) {
            pretragaCB.addItem(knjiga);

        }
    }

    public void popuniKnjigeAutorCB(String autor) {//metode za popunjavanje pretragaCB ako je pretraga isla po autoru

        List<Knjige> knjige = Transakcije.pretraziKnjigeAutor(autor);
        for (Knjige knjiga : knjige) {
            pretragaCB.addItem(knjiga);
        }
    }

    public JTextField getPretragaNazivFld() {
        return pretragaNazivFld;
    }

    public JComboBox<Knjige> getPretragaCB() {
        return pretragaCB;
    }

    public JTextField getPretragaAutorFld() {
        return pretragaAutorFld;
    }

    private void popuniClanoviCB() { //metoda za popunjavanje CB sa clanovima
        List<Clanovi> clanovi = Transakcije.uzmiSveClanove();
        for (Clanovi clan : clanovi) {
            clanCB.addItem(clan);

        }
    }

    public JComboBox<Clanovi> getClanCB() {
        return clanCB;
    }

}
