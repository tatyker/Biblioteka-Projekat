package bibliotekaprojekat.kontroler.slusaci;

/**
 * Reference svih slusaca, koje se instanciraju u default konstruktoru kao i
 * njihovi getteri
 *
 */
public class MenadzerSlusaca {

    private SlusacLogovanja slusacLogovanja = null;
    private SlusacOdustajanja slusacOdustajanja = null;
    private SlusacKnjiga slusacKnjiga = null;
    private SlusacClanova slusacClanova = null;
    private SlusacDodavanjeKnjige slusacDodavanjeKnjige = null;
    private SlusacNovaKnjiga slusacNovaKnjiga = null;
    private SlusacDodavanjeClana slusacDodavanjeClana = null;
    private SlusacNoviClan slusacNoviClan = null;
    private SlusacPovratakNaGlavni slusacPovratakNaGlavni = null;
    private SlusacTabeleKnjiga slusacTabeleKnjiga = null;
    private SlusacIspravkeKnjige slusacIspravkeKnjige = null;
    private SlusacTabeleClanova slusacTabeleClanova = null;
    private SlusacIspravkeClana slusacIspravkeClana = null;
    private SlusacIzlaza slusacIzlaza = null;
    private SlusacIzdavanja slusacIzdavanja = null;
    private SlusacNovoIzdavanje slusacNovoIzdavanje = null;
    private SlusacTabeleIzdavanja slusacTabeleIzdavanja = null;
    private SlusacVracanja slusacVracanja = null;
    private SlusacDodavanjaBibliotekara slusacDodavanjaBibliotekara = null;
    private SlusacTabeleBibliotekari slusacTabeleBibliotekari = null;
    private SlusacIspravkeBibliotekara slusacIspravkeBibliotekara = null;
    private SlusacBrisanjaBibliotekara slusacBrisanjaBibliotekara = null;
    private SlusacOProgramu slusacOProgramu = null;
    private SlusacPomoci slusacPomoci = null;
    private SlusacZatvaranjaPomoci slusacZatvaranjaPomoci = null;
    private SlusacPretrage slusacPretrage = null;
    private SlusacPretragaKnjiga slusacPretragaKnjiga = null;
    private SlusacPretrageAutora slusacPretrageAutora = null;
    private SlusacPretragaIzdavanje slusacPretragaIzdavanje = null;

    public MenadzerSlusaca() {
        slusacLogovanja = new SlusacLogovanja();
        slusacOdustajanja = new SlusacOdustajanja();
        slusacKnjiga = new SlusacKnjiga();
        slusacClanova = new SlusacClanova();
        slusacDodavanjeKnjige = new SlusacDodavanjeKnjige();
        slusacNovaKnjiga = new SlusacNovaKnjiga();
        slusacDodavanjeClana = new SlusacDodavanjeClana();
        slusacNoviClan = new SlusacNoviClan();
        slusacPovratakNaGlavni = new SlusacPovratakNaGlavni();
        slusacTabeleKnjiga = new SlusacTabeleKnjiga();
        slusacIspravkeKnjige = new SlusacIspravkeKnjige();
        slusacTabeleClanova = new SlusacTabeleClanova();
        slusacIspravkeClana = new SlusacIspravkeClana();
        slusacIzlaza = new SlusacIzlaza();
        slusacIzdavanja = new SlusacIzdavanja();
        slusacNovoIzdavanje = new SlusacNovoIzdavanje();
        slusacTabeleIzdavanja = new SlusacTabeleIzdavanja();
        slusacVracanja = new SlusacVracanja();
        slusacDodavanjaBibliotekara = new SlusacDodavanjaBibliotekara();
        slusacTabeleBibliotekari = new SlusacTabeleBibliotekari();
        slusacIspravkeBibliotekara = new SlusacIspravkeBibliotekara();
        slusacBrisanjaBibliotekara = new SlusacBrisanjaBibliotekara();
        slusacOProgramu = new SlusacOProgramu();
        slusacPomoci = new SlusacPomoci();
        slusacZatvaranjaPomoci = new SlusacZatvaranjaPomoci();
        slusacPretrage = new SlusacPretrage();
        slusacPretragaKnjiga = new SlusacPretragaKnjiga();
        slusacPretrageAutora = new SlusacPretrageAutora();
        slusacPretragaIzdavanje = new SlusacPretragaIzdavanje();

    }

    public SlusacLogovanja getSlusacLogovanja() {
        return slusacLogovanja;
    }

    public SlusacOdustajanja getSlusacOdustajanja() {
        return slusacOdustajanja;
    }

    public SlusacKnjiga getSlusacKnjiga() {
        return slusacKnjiga;
    }

    public SlusacClanova getSlusacClanova() {
        return slusacClanova;
    }

    public SlusacDodavanjeKnjige getSlusacDodavanjeKnjige() {
        return slusacDodavanjeKnjige;
    }

    public SlusacNovaKnjiga getSlusacNovaKnjiga() {
        return slusacNovaKnjiga;
    }

    public SlusacDodavanjeClana getSlusacDodavanjeClana() {
        return slusacDodavanjeClana;
    }

    public SlusacNoviClan getSlusacNoviClan() {
        return slusacNoviClan;
    }

    public SlusacPovratakNaGlavni getSlusacPovratakNaGlavni() {
        return slusacPovratakNaGlavni;
    }

    public SlusacTabeleKnjiga getSlusacTabeleKnjiga() {
        return slusacTabeleKnjiga;
    }

    public SlusacIspravkeKnjige getSlusacIspravkeKnjige() {
        return slusacIspravkeKnjige;
    }

    public SlusacTabeleClanova getSlusacTabeleClanova() {
        return slusacTabeleClanova;
    }

    public SlusacIspravkeClana getSlusacIspravkeClana() {
        return slusacIspravkeClana;
    }

    public SlusacIzlaza getSlusacIzlaza() {
        return slusacIzlaza;
    }

    public SlusacIzdavanja getSlusacIzdavanja() {
        return slusacIzdavanja;
    }

    public SlusacNovoIzdavanje getSlusacNovoIzdavanje() {
        return slusacNovoIzdavanje;
    }

    public SlusacTabeleIzdavanja getSlusacTabeleIzdavanja() {
        return slusacTabeleIzdavanja;
    }

    public SlusacVracanja getSlusacVracanja() {
        return slusacVracanja;
    }

    public SlusacDodavanjaBibliotekara getSlusacDodavanjaBibliotekara() {
        return slusacDodavanjaBibliotekara;
    }

    public SlusacTabeleBibliotekari getSlusacTabeleBibliotekari() {
        return slusacTabeleBibliotekari;
    }

    public SlusacIspravkeBibliotekara getSlusacIspravkeBibliotekara() {
        return slusacIspravkeBibliotekara;
    }

    public SlusacBrisanjaBibliotekara getSlusacBrisanjaBibliotekara() {
        return slusacBrisanjaBibliotekara;
    }

    public SlusacOProgramu getSlusacOProgramu() {
        return slusacOProgramu;
    }

    public SlusacPomoci getSlusacPomoci() {
        return slusacPomoci;
    }

    public SlusacZatvaranjaPomoci getSlusacZatvaranjaPomoci() {
        return slusacZatvaranjaPomoci;
    }

    public SlusacPretrage getSlusacPretrage() {
        return slusacPretrage;
    }

    public SlusacPretragaKnjiga getSlusacPretragaKnjiga() {
        return slusacPretragaKnjiga;
    }

    public SlusacPretrageAutora getSlusacPretrageAutora() {
        return slusacPretrageAutora;
    }

    public SlusacPretragaIzdavanje getSlusacPretragaIzdavanje() {
        return slusacPretragaIzdavanje;
    }

}
