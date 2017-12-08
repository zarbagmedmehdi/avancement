/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Echelle;

/**
 *
 * @author hp
 */
public class EchelleService extends AbstractFacade<Echelle> {
    
    public EchelleService() {
        super(Echelle.class);
    }
    public int creerEchelle( String id,String nom,double salaireBase)
    {
        Echelle echelle=new Echelle(null, null, 0);
  
        echelle.setNom(nom);
        echelle.setSalaireBase(salaireBase);
        echelle.setId(id);
        create(echelle);
        return 1;
    }
    public void initDb()
     {
         creerEchelle("E4","femmeDeMenage",2000);
         creerEchelle("E5","agentDeSecurite",2100);
         creerEchelle("E6","jardinier",2000);
         creerEchelle("E7","Doctorant",2500);
         creerEchelle("E8","Technicien",4000);
         creerEchelle("E9","FonctionnaireAdministrative",5000);
         creerEchelle("E10","ProfAsssistant",7500);
         creerEchelle("E11","PES",9000);
     }
    
}
