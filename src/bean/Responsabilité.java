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
import javax.persistence.ManyToOne;

/**
 *
 * @author user
 */
@Entity
public class Responsabilité implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
   
    private String id;
     private String nom;
    @ManyToOne
    private Echelle echelleMin;
    private float montant;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Echelle getEchelleMin() {
        return echelleMin;
    }

    public void setEchelleMin(Echelle echelleMin) {
        this.echelleMin = echelleMin;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant( float montant) {
        this.montant = montant;
    }

    public Responsabilité(String id, String nom, Echelle echelleMin,  float montant) {
        this.id = id;
        this.nom = nom;
        this.echelleMin = echelleMin;
        this.montant = montant;
    }

    public Responsabilité(String id) {
        this.id = id;
    }

    public Responsabilité() {
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
        if (!(object instanceof Responsabilité)) {
            return false;
        }
        Responsabilité other = (Responsabilité) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Responsabilit\u00e9{" + "id=" + id + ", nom=" + nom + ", echelleMin=" + echelleMin + ", montant=" + montant + '}';
    }

    
    
}
