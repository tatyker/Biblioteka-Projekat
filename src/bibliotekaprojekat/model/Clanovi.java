/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotekaprojekat.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Taty
 */
@Entity
@Table(name = "clanovi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clanovi.findAll", query = "SELECT c FROM Clanovi c")
    , @NamedQuery(name = "Clanovi.findById", query = "SELECT c FROM Clanovi c WHERE c.id = :id")
    , @NamedQuery(name = "Clanovi.findByIme", query = "SELECT c FROM Clanovi c WHERE c.ime = :ime")
    , @NamedQuery(name = "Clanovi.findByPrezime", query = "SELECT c FROM Clanovi c WHERE c.prezime = :prezime")
    , @NamedQuery(name = "Clanovi.findByBrDokumenta", query = "SELECT c FROM Clanovi c WHERE c.brDokumenta = :brDokumenta")
    , @NamedQuery(name = "Clanovi.findByAdresa", query = "SELECT c FROM Clanovi c WHERE c.adresa = :adresa")
    , @NamedQuery(name = "Clanovi.findByGrad", query = "SELECT c FROM Clanovi c WHERE c.grad = :grad")
    , @NamedQuery(name = "Clanovi.findByGodinaRodj", query = "SELECT c FROM Clanovi c WHERE c.godinaRodj = :godinaRodj")
    , @NamedQuery(name = "Clanovi.findByPol", query = "SELECT c FROM Clanovi c WHERE c.pol = :pol")
    , @NamedQuery(name = "Clanovi.findByBrClanske", query = "SELECT c FROM Clanovi c WHERE c.brClanske = :brClanske")})
public class Clanovi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @Column(name = "prezime")
    private String prezime;
    @Basic(optional = false)
    @Column(name = "br_dokumenta")
    private String brDokumenta;
    @Basic(optional = false)
    @Column(name = "adresa")
    private String adresa;
    @Basic(optional = false)
    @Column(name = "grad")
    private String grad;
    @Basic(optional = false)
    @Column(name = "godina_rodj")
    private int godinaRodj;
    @Basic(optional = false)
    @Column(name = "pol")
    private String pol;
    @Basic(optional = false)
    @Column(name = "br_clanske")
    private String brClanske;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClan")
    private List<Izdavanje> izdavanjeList;

    public Clanovi() {
    }

    public Clanovi(Integer id) {
        this.id = id;
    }

    public Clanovi(Integer id, String ime, String prezime, String brDokumenta, String adresa, String grad, int godinaRodj, String pol, String brClanske) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.brDokumenta = brDokumenta;
        this.adresa = adresa;
        this.grad = grad;
        this.godinaRodj = godinaRodj;
        this.pol = pol;
        this.brClanske = brClanske;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBrDokumenta() {
        return brDokumenta;
    }

    public void setBrDokumenta(String brDokumenta) {
        this.brDokumenta = brDokumenta;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public int getGodinaRodj() {
        return godinaRodj;
    }

    public void setGodinaRodj(int godinaRodj) {
        this.godinaRodj = godinaRodj;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getBrClanske() {
        return brClanske;
    }

    public void setBrClanske(String brClanske) {
        this.brClanske = brClanske;
    }

    @XmlTransient
    public List<Izdavanje> getIzdavanjeList() {
        return izdavanjeList;
    }

    public void setIzdavanjeList(List<Izdavanje> izdavanjeList) {
        this.izdavanjeList = izdavanjeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clanovi)) {
            return false;
        }
        Clanovi other = (Clanovi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return brClanske+" - "+ ime + " " + prezime ;//vraca broj clanske ime i prezime za potrebe CB
    }
    
}
