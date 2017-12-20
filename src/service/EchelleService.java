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
    public int creerEchelle( String id,String nom,float  salaireBase ,int nb)
    {
        Echelle echelle=new Echelle();
        echelle.setNb(nb);
        echelle.setNom(nom);
        echelle.setSalaireBase(salaireBase);
        echelle.setId(id);
        create(echelle);
        return 1;
    }
    public void initDb()
     {
         creerEchelle("E4","echelle4",2000,4);
         creerEchelle("E5","agentDeSecurite",2100,5);
         creerEchelle("E6","jardinier",2000,6);
         creerEchelle("E7","Doctorant",2500,7);
         creerEchelle("E8","Technicien",4000,8);
         creerEchelle("E9","FonctionnaireAdministrative",5000,9);
         creerEchelle("E10","ProfAsssistant",7500,10);
         creerEchelle("E11","PES",9000,11);
     }
    
}
