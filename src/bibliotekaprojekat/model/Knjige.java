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
@Table(name = "knjige")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Knjige.findAll", query = "SELECT k FROM Knjige k")
    , @NamedQuery(name = "Knjige.findById", query = "SELECT k FROM Knjige k WHERE k.id = :id")
    , @NamedQuery(name = "Knjige.findByNaziv", query = "SELECT k FROM Knjige k WHERE k.naziv = :naziv")
    , @NamedQuery(name = "Knjige.findByAutor", query = "SELECT k FROM Knjige k WHERE k.autor = :autor")
    , @NamedQuery(name = "Knjige.findByIsbn", query = "SELECT k FROM Knjige k WHERE k.isbn = :isbn")
    , @NamedQuery(name = "Knjige.findByGodinaIzdanja", query = "SELECT k FROM Knjige k WHERE k.godinaIzdanja = :godinaIzdanja")
    , @NamedQuery(name = "Knjige.findByIzdavac", query = "SELECT k FROM Knjige k WHERE k.izdavac = :izdavac")
    , @NamedQuery(name = "Knjige.findByZanr", query = "SELECT k FROM Knjige k WHERE k.zanr = :zanr")})
public class Knjige implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @Column(name = "autor")
    private String autor;
    @Basic(optional = false)
    @Column(name = "isbn")
    private String isbn;
    @Basic(optional = false)
    @Column(name = "godina_izdanja")
    private int godinaIzdanja;
    @Basic(optional = false)
    @Column(name = "izdavac")
    private String izdavac;
    @Basic(optional = false)
    @Column(name = "zanr")
    private String zanr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKnjiga")
    private List<Izdavanje> izdavanjeList;

    public Knjige() {
    }

    public Knjige(Integer id) {
        this.id = id;
    }

    public Knjige(Integer id, String naziv, String autor, String isbn, int godinaIzdanja, String izdavac, String zanr) {
        this.id = id;
        this.naziv = naziv;
        this.autor = autor;
        this.isbn = isbn;
        this.godinaIzdanja = godinaIzdanja;
        this.izdavac = izdavac;
        this.zanr = zanr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getGodinaIzdanja() {
        return godinaIzdanja;
    }

    public void setGodinaIzdanja(int godinaIzdanja) {
        this.godinaIzdanja = godinaIzdanja;
    }

    public String getIzdavac() {
        return izdavac;
    }

    public void setIzdavac(String izdavac) {
        this.izdavac = izdavac;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
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
        if (!(object instanceof Knjige)) {
            return false;
        }
        Knjige other = (Knjige) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id+". "+naziv+ " - " + autor;//vraca id, naziv i autora za potrebe CB 
    }
    
}
