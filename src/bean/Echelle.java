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

/**
 *
 * @author user
 */
@Entity
public class Echelle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String nom;
    private float SalaireBase;
    private int nb;

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    public Echelle() {
    }

    public Echelle(String id) {
        this.id = id;
    }

    public Echelle(String id, String nom, float SalaireBase, int nb) {
        this.id = id;
        this.nom = nom;
        this.SalaireBase = SalaireBase;
        this.nb = nb;
    }

  

    
   

   
    public float getSalaireBase() {
        return SalaireBase;
    }

    public void setSalaireBase(float SalaireBase) {
        this.SalaireBase = SalaireBase;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
        if (!(object instanceof Echelle)) {
            return false;
        }
        Echelle other = (Echelle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Echelle{" + "id=" + id + ", nom=" + nom + ", SalaireBase=" + SalaireBase + ", nb=" + nb + '}';
    }

   

    
}