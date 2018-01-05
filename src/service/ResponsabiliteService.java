/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Echelle;
import bean.Responsabilité;
import java.util.List;

/**
 *
 * @author user
 */
public class ResponsabiliteService extends AbstractFacade<Responsabilité> {
    EchelleService es= new EchelleService();
    public ResponsabiliteService() {
        super(Responsabilité.class);
    }
    public int creerRes(String id, String nom, String idEchelleMin, float montant)
    {
        
        Responsabilité res=new Responsabilité();
      Echelle echelle=es.find(idEchelleMin);
      if (echelle==null){
          return -1;
      }
      
      res.setEchelleMin(echelle);
        res.setId(id);
       res.setNom(nom);
        res.setMontant(montant);
        
        create(res);
        return 1;
        
    
    }
//    public int update
   
                    
                     public void initDb(){
//      creerRes("R1", "doyen", "E11", 5000);
//     creerRes("R2", "vice doyen", "E11", 4000);
//     creerRes("R3", "cordinateur MIPC ", "E10",3000);
//     creerRes("R4", "cordinateur BCG ", "E10",3000);
//     creerRes("R5", "chef scolarité ", "E9",2500);
     }
   public List<Responsabilité> find (float montant,String idEchelleMin)
   {
        String requete ="SELECT r FROM Responsabilité  R WHERE 1=1";

 if (montant!=0){
         
         requete+=" and R.montant='"+montant+"'" ;
 }
 if (idEchelleMin!=null){
         
         requete+=" and R.id='"+idEchelleMin+"'" ;
 }
    return getEntityManager().createQuery(requete).getResultList();
  
 
   }
}
