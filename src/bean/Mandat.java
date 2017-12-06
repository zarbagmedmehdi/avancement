/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author user
 */
@Entity
public class Mandat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
    private String id;
     @ManyToOne
    private Responsabilité responsabilité;
    @ManyToOne
    private Salarie salarie;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebut;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin;

    public Responsabilité getResponsabilite() {
        return responsabilité;
    }

    public void setResponsabilite(Responsabilité responsabilité) {
        this.responsabilité = responsabilité;
    }

    public Salarie getSalarie() {
        return salarie;
    }

    public void setSalarie(Salarie salarie) {
        this.salarie = salarie;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Mandat(String id, Responsabilité responsabilité, Salarie salarie, Date dateDebut, Date dateFin) {
        this.id = id;
        this.responsabilité = responsabilité;
        this.salarie = salarie;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Mandat(String id) {
        this.id = id;
    }

    public Mandat() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        if (!(object instanceof Mandat)) {
            return false;
        }
        Mandat other = (Mandat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mandat{" + "id=" + id + ", responsabilité=" + responsabilité + ", salarie=" + salarie + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + '}';
    }

  
    
}
