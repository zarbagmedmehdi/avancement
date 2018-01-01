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
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
      private String nomRegion;
    @ManyToOne
    private Classe classe;
  
    public String getId() {
        return id;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Region(String id, String nomRegion, Classe classe) {
        this.id = id;
        this.nomRegion = nomRegion;
        this.classe = classe;
    }

    public Region(String id) {
        this.id = id;
    }

    public Region() {
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
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Region{" + "id=" + id + ", nomRegion=" + nomRegion + ", classe=" + classe + '}';
    }

    
}
