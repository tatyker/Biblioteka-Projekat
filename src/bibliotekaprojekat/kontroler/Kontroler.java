
package bibliotekaprojekat.kontroler;

import bibliotekaprojekat.gui.AdminFrejm;
import bibliotekaprojekat.gui.ClanoviFrejm;
import bibliotekaprojekat.gui.NovaKnjigaFrejm;
import bibliotekaprojekat.gui.GlavniFrejm;
import bibliotekaprojekat.gui.InstrukcijeFrejm;
import bibliotekaprojekat.gui.IzdavanjeFrejm;
import bibliotekaprojekat.gui.KnjigeFrejm;
import bibliotekaprojekat.gui.LogovanjeFrejm;
import bibliotekaprojekat.gui.NoviClanFrejm;
import bibliotekaprojekat.gui.PretragaFrejm;
import bibliotekaprojekat.kontroler.slusaci.MenadzerSlusaca;
import bibliotekaprojekat.model.Bibliotekar;

/**
 *
 * @author Taty
 */
public class Kontroler {
    private static Kontroler instanca = null;
    
    private Bibliotekar prijavljeniBibliotekar = null;
    private LogovanjeFrejm logovanjeFrejm = null;
    private GlavniFrejm glavniFrejm = null;
    private KnjigeFrejm knjigeFrejm = null;
    private ClanoviFrejm clanoviFrejm = null;
    private NovaKnjigaFrejm novaKnjigaFrejm = null;
    private NoviClanFrejm noviClanFrejm = null;
    private IzdavanjeFrejm izdavanjeFrejm = null;
    private AdminFrejm adminFrejm = null;
    private InstrukcijeFrejm instrukcijeFrejm =null;
    private PretragaFrejm pretragaFrejm = null;
        
    private MenadzerSlusaca menadzerSlusaca = new MenadzerSlusaca();
    
    private Kontroler() {
    }
    
    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public Bibliotekar getPrijavljeniBibliotekar() {
        return prijavljeniBibliotekar;
    }

    public void setPrijavljeniBibliotekar(Bibliotekar prijavljeniBibliotekar) {
        this.prijavljeniBibliotekar = prijavljeniBibliotekar;
    }

    public LogovanjeFrejm getLogovanjeFrejm() {
        return logovanjeFrejm;
    }

    public void setLogovanjeFrejm(LogovanjeFrejm logovanjeFrejm) {
        this.logovanjeFrejm = logovanjeFrejm;
    }

    public MenadzerSlusaca getMenadzerSlusaca() {
        return menadzerSlusaca;
    }

    public void setMenadzerSlusaca(MenadzerSlusaca menadzerSlusaca) {
        this.menadzerSlusaca = menadzerSlusaca;
    }
    public GlavniFrejm getGlavniFrejm() {
        return glavniFrejm;
    }

    public void setGlavniFrejm(GlavniFrejm glavniFrejm) {
        this.glavniFrejm = glavniFrejm;
    }

    public KnjigeFrejm getKnjigeFrejm() {
        return knjigeFrejm;
    }

    public void setKnjigeFrejm(KnjigeFrejm knjigeFrejm) {
        this.knjigeFrejm = knjigeFrejm;
    }

    public ClanoviFrejm getClanoviFrejm() {
        return clanoviFrejm;
    }

    public void setClanoviFrejm(ClanoviFrejm clanoviFrejm) {
        this.clanoviFrejm = clanoviFrejm;
    }

    public NovaKnjigaFrejm getNovaKnjigaFrejm() {
        return novaKnjigaFrejm;
    }

    public void setNovaKnjigaFrejm(NovaKnjigaFrejm novaKnjigaFrejm) {
        this.novaKnjigaFrejm = novaKnjigaFrejm;
    }

    public NoviClanFrejm getNoviClanFrejm() {
        return noviClanFrejm;
    }

    public void setNoviClanFrejm(NoviClanFrejm noviClanFrejm) {
        this.noviClanFrejm = noviClanFrejm;
    }

    public IzdavanjeFrejm getIzdavanjeFrejm() {
        return izdavanjeFrejm;
    }

    public void setIzdavanjeFrejm(IzdavanjeFrejm izdavanjeFrejm) {
        this.izdavanjeFrejm = izdavanjeFrejm;
    }

    public AdminFrejm getAdminFrejm() {
        return adminFrejm;
    }

    public void setAdminFrejm(AdminFrejm adminFrejm) {
        this.adminFrejm = adminFrejm;
    }

    public InstrukcijeFrejm getInstrukcijeFrejm() {
        return instrukcijeFrejm;
    }

    public void setInstrukcijeFrejm(InstrukcijeFrejm instrukcijeFrejm) {
        this.instrukcijeFrejm = instrukcijeFrejm;
    }

    public PretragaFrejm getPretragaFrejm() {
        return pretragaFrejm;
    }

    public void setPretragaFrejm(PretragaFrejm pretragaFrejm) {
        this.pretragaFrejm = pretragaFrejm;
    }
    
    
}
