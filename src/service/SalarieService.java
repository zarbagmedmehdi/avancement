/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Classe;
import bean.Echelle;
import bean.Echellon;
import bean.EntiteAdministrative;
import bean.Mandat;
import bean.Region;
import bean.Responsabilité;
import bean.Salarie;
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
public class SalarieService  extends AbstractFacade<Salarie> {
    EchelleService es=new EchelleService();
    EchellonService ees=new EchellonService();
    RegionService rs= new RegionService();
    EntiteService ens=new EntiteService();
    MandatService ms=new MandatService();
    
    public SalarieService() {
        super(Salarie.class);
    }
    public int creerSalarie(String id, String nom, String prenom, String dateDeNaissance, String dateDEmbauche, 
 String idEntite,String idEchelle,String grade,  String echellon, String idchef, 
 boolean celibataire,  String idRegion, int nbEnfent,  float commission){
  Salarie sal= new Salarie();
  Salarie chef =new Salarie();
  chef=find(idchef);
  
  if(chef==null){
      return -1;
  } else {
  sal.setChef(chef);
  sal.setCelibataire(celibataire);
  sal.setNbEnfent(nbEnfent);
  sal.setNom(nom);
  sal.setPrenom(prenom);
  sal.setCommission(commission);
  
  sal.setGrade(grade);
  sal.setEchelle(es.find(idEchelle));
  sal.setRegion(rs.find(idRegion));
  sal.setEntiteADministrative(ens.find(idEntite));
  sal.setSalaire(calculSalaire(sal));
  return 1;
    }
}
public float calculSalaire(Salarie sal)
{ Echelle echelle=sal.getEchelle();
  Echellon echellon=sal.getEchellon();
  Region reg=sal.getRegion();
  Classe c=reg.getClasse();
  float salaire ;
    salaire =echelle.getSalaireBase();
    salaire=salaire*c.getCoef()+echellon.getMantant();
     List<Mandat> mandats=getEntityManager().createQuery("select m From Mandat m"
             +" WHERE m.salarie.id='" +sal.getId()+ "'").getResultList();
     for (int i = 0; i < mandats.size(); i++) {
                Mandat mandat=mandats.get(i);
                Responsabilité respo=mandat.getResponsabilite();
                salaire=salaire+respo.getMontant();
                
                
            }
     return salaire;
    
    
}

    
    
}