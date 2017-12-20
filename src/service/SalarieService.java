/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Util.DateUtil;
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
    
    
    public SalarieService() {
        super(Salarie.class);
    }
    public int creerSalarie(String id, String nom, String prenom, String dateDeNaissance, String dateDEmbauche, 
 EntiteAdministrative  entiteAdministrative ,Echelle echelle,String grade,  String echellon, String idchef, 
 boolean celibataire, Region region, int nbEnfent,  float commission){
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
  Date dateN=DateUtil.parse(dateDeNaissance);
  Date dateE=DateUtil.parse(dateDEmbauche);
  sal.setDateDeNaissance(dateN);
  sal.setDateDEmbauche(dateE);
  
  
  sal.setGrade(grade);
  sal.setEchelle(echelle);
  sal.setRegion(region);
  sal.setEntiteADministrative( entiteAdministrative);
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
    public List<Salarie>findByEchelle(String iDechelle)
 {
    return getEntityManager().createQuery("SELECT s FROM Salarie S WHERE S.echelle.iDechelle='" +iDechelle+ "'").getResultList();
  
 }
//    a)	Vérifier que l’employé possède une échelle supérieure à l’échelle minimale exigée par la responsabilité.
       public int save(Mandat mandat,Salarie salarie) 
      {
          Responsabilité   res=new  Responsabilité();
          res=mandat.getResponsabilite();
          
           if(salarie.getEchelle().getId().equals(res.getEchelleMin().getId()))
           {
              return 1; 
           }
           else 
               return -1;

      }

}