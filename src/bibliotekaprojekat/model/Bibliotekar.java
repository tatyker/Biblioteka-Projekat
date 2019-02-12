/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotekaprojekat.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Taty
 */
@Entity
@Table(name = "bibliotekar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bibliotekar.findAll", query = "SELECT b FROM Bibliotekar b")
    , @NamedQuery(name = "Bibliotekar.findById", query = "SELECT b FROM Bibliotekar b WHERE b.id = :id")
    , @NamedQuery(name = "Bibliotekar.findByKorisnickoIme", query = "SELECT b FROM Bibliotekar b WHERE b.korisnickoIme = :korisnickoIme")
    , @NamedQuery(name = "Bibliotekar.findByKorisnickoImeSifra", query = "SELECT b FROM Bibliotekar b WHERE b.korisnickoIme = :korisnickoIme AND b.sifra = :sifra")
    , @NamedQuery(name = "Bibliotekar.findBySifra", query = "SELECT b FROM Bibliotekar b WHERE b.sifra = :sifra")
    , @NamedQuery(name = "Bibliotekar.findByIme", query = "SELECT b FROM Bibliotekar b WHERE b.ime = :ime")
    , @NamedQuery(name = "Bibliotekar.findByPrezime", query = "SELECT b FROM Bibliotekar b WHERE b.prezime = :prezime")})
public class Bibliotekar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "korisnicko_ime", unique = true) //dodato unique u DB - exportovati novu verziju
    private String korisnickoIme;
    @Basic(optional = false)
    @Column(name = "sifra")
    private String sifra;
    @Column(name = "ime")
    private String ime;
    @Column(name = "prezime")
    private String prezime;

    public Bibliotekar() {
    }

    public Bibliotekar(Integer id) {
        this.id = id;
    }

    public Bibliotekar(Integer id, String korisnickoIme, String sifra) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bibliotekar)) {
            return false;
        }
        Bibliotekar other = (Bibliotekar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + " " + korisnickoIme; //vraca id i korisnicko ime bibliotekara koa string (potrebno za CB na AdminFrejm)
    }
    
}
