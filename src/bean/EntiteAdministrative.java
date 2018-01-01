/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author user
 */
@Entity
public class EntiteAdministrative implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
  private String nom;
    @OneToOne
    private Salarie chef;

    public EntiteAdministrative() {
    }

    public EntiteAdministrative(String id, String nom, Salarie chef) {
        this.id = id;
        this.nom = nom;
        this.chef = chef;
    }

    public EntiteAdministrative(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Salarie getChef() {
        return chef;
    }

    public void setChef(Salarie chef) {
        this.chef = chef;
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
        if (!(object instanceof EntiteAdministrative)) {
            return false;
        }
        EntiteAdministrative other = (EntiteAdministrative) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntiteAdministrative{" + "id=" + id + ", nom=" + nom + ", chef=" + chef + '}';
    }

    
}
