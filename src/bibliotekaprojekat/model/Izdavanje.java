/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotekaprojekat.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Taty
 */
@Entity
@Table(name = "izdavanje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Izdavanje.findAll", query = "SELECT i FROM Izdavanje i")
    , @NamedQuery(name = "Izdavanje.findById", query = "SELECT i FROM Izdavanje i WHERE i.id = :id")
    , @NamedQuery(name = "Izdavanje.findByDatumIzdavanja", query = "SELECT i FROM Izdavanje i WHERE i.datumIzdavanja = :datumIzdavanja")
    , @NamedQuery(name = "Izdavanje.findByDatumVracanja", query = "SELECT i FROM Izdavanje i WHERE i.datumVracanja = :datumVracanja")})
public class Izdavanje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "datum_izdavanja")
    @Temporal(TemporalType.DATE)
    private Date datumIzdavanja;
    @Column(name = "datum_vracanja")
    @Temporal(TemporalType.DATE)
    private Date datumVracanja;
    @JoinColumn(name = "id_clan", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clanovi idClan;
    @JoinColumn(name = "id_knjiga", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Knjige idKnjiga;
    @JoinColumn(name = "id_status", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Status idStatus;

    
    public Izdavanje() {
    }

    public Izdavanje(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public Date getDatumVracanja() {
        return datumVracanja;
    }

    public void setDatumVracanja(Date datumVracanja) {
        this.datumVracanja = datumVracanja;
    }

    public Clanovi getIdClan() {
        return idClan;
    }

    public void setIdClan(Clanovi idClan) {
        this.idClan = idClan;
    }

    public Knjige getIdKnjiga() {
        return idKnjiga;
    }

    public void setIdKnjiga(Knjige idKnjiga) {
        this.idKnjiga = idKnjiga;
    }

    public Status getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Status idStatus) {
        this.idStatus = idStatus;
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
        if (!(object instanceof Izdavanje)) {
            return false;
        }
        Izdavanje other = (Izdavanje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bibliotekaprojekat.model.Izdavanje[ id=" + id + " ]";
    }
    
}
