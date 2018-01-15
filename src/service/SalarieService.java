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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
public class SalarieService  extends AbstractFacade<Salarie> {
//    EchelleService es=new EchelleService();
//    EchellonService ees=new EchellonService();
//    RegionService rs= new RegionService();
//    EntiteService ens=new EntiteService();
    
    
    public SalarieService() {
        super(Salarie.class);
    }
    public int creerSalarie(String id, String nom, String prenom, String dateDeNaissance, String dateDEmbauche, 
 EntiteAdministrative  entiteAdministrative ,Echelle echelle,String grade,  Echellon echellon, Salarie chef, 
 boolean celibataire, Region region, int nbEnfent,  float commission){
  
        
        Salarie sal= new Salarie();
  
 
//  
//  if(chef==null){
//      return -1;
//  } else {
sal.setId(id);
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
  sal.setEchellon(echellon);
  
  sal.setGrade(grade);
  sal.setEchelle(echelle);
  sal.setRegion(region);
  sal.setEntiteADministrative( entiteAdministrative);
  
 
  create(sal);
    sal.setSalaire(calculSalaire(sal));
    edit(sal);
  return 1;
//    }
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
    public List<Salarie>findSalarieByEchelle(Echelle echelle,Region region)
 {   
    return getEntityManager().createQuery("SELECT s FROM Salarie S WHERE S.echelle.id='" +echelle.getId()+ "'AND s.region.id='"+region.getId()+"'").getResultList();
  
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
public List<Salarie>findSalarieByCriteria(Echelle echelle , EntiteAdministrative entiteAdministrative ,Region region)
 {   String requete ="SELECT s FROM Salarie s WHERE 1=1";
 if (echelle!=null){
         
         requete+=" and s.echelle.id='"+echelle.getId()+"'" ;
 }if (region!=null){
         
         requete+=" and s.region.id='"+region.getId()+"'" ;
 }
 if (entiteAdministrative!=null){
         
         requete+=" and s.entiteAdministrative.id='"+entiteAdministrative.getId()+"'" ;
 }
    return getEntityManager().createQuery(requete).getResultList();
  
 }

public int nombreSalarie(Echelle echelle,Region region)
{
    List<Salarie>es=findSalarieByEchelle( echelle, region);
    int count=0;
    for (int i = 0; i < es.size(); i++) {
      Salarie salarie=es.get(i);
     
         count++;
   
        
    }
    return count;
        
    }
public int SubstituerRegion(Salarie s1,Salarie s2)
{
   
  
  Region e1=s1.getRegion();
  Region e2=s2.getRegion();
  EntiteAdministrative entite1=s1.getEntiteADministrative();
   EntiteAdministrative entite2=s2.getEntiteADministrative();
  
  if(entite1==entite2) {
   s1.setRegion(e2);
   s2.setRegion(e1);
   edit(s1);
   edit(s2);
   return 1;
  }
  else {return -1;
  }
   
           
}
public int changerRegion(Region region,Salarie salarie)
{
    Classe cc= region.getClasse();
   Region n=salarie.getRegion();
   Classe nn=n.getClasse();
    if(cc.getCoef()>nn.getCoef())
    {
        salarie.setRegion(region);
        edit(salarie);
        calculSalaire(salarie);
        edit(salarie);
         return 1;
    }
    else
    {
        return -1;
    }
   
        


    
    
        
}
public float SalaireDeEntite(EntiteAdministrative entiteAdministrative,Region region )
 {
     float Deponse=0;
     
     List<Salarie>e=findSalarieByCriteria( null, entiteAdministrative,region);
        int i;
     for(i=0;i<e.size();i++)
     {
        Salarie salarie=e.get(i);
        Deponse= Deponse+salarie.getSalaire();
        
        
     }
    return Deponse;
 }
 public float m(EntiteAdministrative entiteAdministrative,Region region )
 {
     
  
     List<Salarie>e=findSalarieByCriteria( null, entiteAdministrative,region);
    Salarie salarie=e.get(0);
     float min=salarie.getSalaire();
     
        int i;
     for(i=0;i<e.size();i++)
     {
        Salarie s=e.get(i);
        if(s.getSalaire()<min)
        {
            min=s.getSalaire();
        }
        
        
        
        
     }
     return min;
 }
 public float k(EntiteAdministrative entiteAdministrative,Region region )
 {
     
     Salarie salarie=new Salarie();
     List<Salarie>e=findSalarieByCriteria( null, entiteAdministrative,region);
     salarie=e.get(0);
     float max=salarie.getSalaire();
     
        int i;
     for(i=0;i<e.size();i++)
     {
        Salarie s=e.get(i);
        if(s.getSalaire()>max)
        {
            max=s.getSalaire();
        }
        
        
        
        
     }
     return max;
 }
        
     public int Promotion (Salarie salarie,Echelle echelle,Echellon echellon)
    {
      
        Echelle a=salarie.getEchelle();
        if(a.getSalaireBase()<echelle.getSalaireBase())
        {
            salarie.setEchelle(echelle);
            edit(salarie);
            salarie.setEchellon(echellon);
            edit(salarie);
            calculSalaire(salarie);
            edit(salarie);
            
             
        }
        else
        {
            return -1;
        }
        return 1;
    }
        
    }
    

