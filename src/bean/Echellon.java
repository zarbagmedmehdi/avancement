/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author user
 */
@Entity
public class Echellon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
     private int Number;
    @ManyToOne
    private Echelle echelle;
    private float mantant;

    public Echellon(String id, int Number, Echelle echelle, float mantant) {
        this.id = id;
        this.Number = Number;
        this.echelle = echelle;
        this.mantant = mantant;
    }

    public Echellon(String id) {
        this.id = id;
    }

    public Echellon() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public Echelle getEchelle() {
        return echelle;
    }

    public void setEchelle(Echelle echelle) {
        this.echelle = echelle;
    }

    public float getMantant() {
        return mantant;
    }

    public void setMantant(float mantant) {
        this.mantant = mantant;
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
        if (!(object instanceof Echellon)) {
            return false;
        }
        Echellon other = (Echellon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Echellon{" + "id=" + id + ", Number=" + Number + ", echelle=" + echelle + ", mantant=" + mantant + '}';
    }

  
    
}
