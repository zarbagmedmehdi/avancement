/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Echelle;
import bean.Responsabilité;

/**
 *
 * @author user
 */
public class ResponsabiliteService extends AbstractFacade<Responsabilité> {
    EchelleService es= new EchelleService();
    public ResponsabiliteService() {
        super(Responsabilité.class);
    }
                    public int creerRes(String id, String nom, String idEchelleMin, double montant)
    {
        
        Responsabilité res=new Responsabilité();
      Echelle e=es.find(idEchelleMin);
      
         
        res.setId(id);
       res.setNom(nom);
        res.setMontant(montant);
        
        create(res);
        return 1;
        
    
    } 
                    
                     public void initDb(){
//      creerRes("R1", "doyen", "E11", 5000);
//     creerRes("R2", "vice doyen", "E11", 4000);
//     creerRes("R3", "cordinateur MIPC ", "E10",3000);
     creerRes("R4", "cordinateur BCG ", "E10",3000);
     creerRes("R5", "chef scolarité ", "E9",2500);
     }
}