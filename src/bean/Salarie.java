/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author user
 */
@Entity
public class Salarie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
   
    private String id;

    private String nom;
    private String prenom;
   
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDeNaissance;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDEmbauche;
    @ManyToOne
    private EntiteAdministrative entiteAdministrative;
    private String grade;
    @ManyToOne
    private Echelle echelle;
    @ManyToOne
    private Echellon echellon;
    @ManyToOne
    private Salarie chef;
    private boolean celibataire;
    @ManyToOne
    private Region region;
    private int nbEnfent;
    private float salaire;
    private float commission;

    public EntiteAdministrative getEntiteADministrative() {
        return entiteAdministrative;
    }

    public void setEntiteADministrative(EntiteAdministrative entiteADministrative) {
        this.entiteAdministrative = entiteAdministrative;
    }

    public Echelle getEchelle() {
        return echelle;
    }

    public void setEchelle(Echelle echelle) {
        this.echelle = echelle;
    }

    public Echellon getEchellon() {
        return echellon;
    }

    public void setEchellon(Echellon echellon) {
        this.echellon = echellon;
    }

    public Salarie getChef() {
        return chef;
    }

    public void setChef(Salarie chef) {
        this.chef = chef;
    }

    public Salarie(String id, String nom, String prenom, Date dateDeNaissance, Date dateDEmbauche, 
 EntiteAdministrative entiteAdministrative, String grade, Echelle echelle, Echellon echellon, Salarie chef, 
 boolean celibataire, Region region, int nbEnfent, float salaire, float commission) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.dateDEmbauche = dateDEmbauche;
        this.entiteAdministrative = entiteAdministrative;
        this.grade = grade;
        this.echelle = echelle;
        this.echellon = echellon;
        this.chef = chef;
        this.celibataire = celibataire;
        this.region = region;
        this.nbEnfent = nbEnfent;
        this.salaire = salaire;
        this.commission = commission;
    }

 

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public Date getDateDEmbauche() {
        return dateDEmbauche;
    }

    public void setDateDEmbauche(Date dateDEmbauche) {
        this.dateDEmbauche = dateDEmbauche;
    }

   

   
   

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

  
   

    

    
   

    public boolean isCelibataire() {
        return celibataire;
    }

    public void setCelibataire(boolean celibataire) {
        this.celibataire = celibataire;
    }

   

    public int getNbEnfent() {
        return nbEnfent;
    }

    public void setNbEnfent(int nbEnfent) {
        this.nbEnfent = nbEnfent;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

   

    public Salarie(String id) {
        this.id = id;
    }

    public Salarie() {
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
        if (!(object instanceof Salarie)) {
            return false;
        }
        Salarie other = (Salarie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Salarie{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateDeNaissance=" + dateDeNaissance + ", dateDEmbauche=" + dateDEmbauche + ", grade=" + grade + ", echelle=" + echelle + ", echellon=" + echellon + ", celibataire=" + celibataire + ", region=" + region + ", nbEnfent=" + nbEnfent + ", salaire=" + salaire + ", commission=" + commission + '}';
    }

  
   
}
