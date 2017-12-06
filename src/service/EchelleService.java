/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import bean.Echelle;
import bean.Echellon;
import java.util.List;
import static javax.xml.ws.Endpoint.create;

/**
 *
 * @author hp
 */
public class EchelleService extends AbstractFacade<Echelle> {
    
    public EchelleService() {
        super(Echelle.class);
    }
    public int creerEchelle( String nom)
    {
        Echelle echelle=new Echelle();
  
        echelle.setNom(nom);
        create(echelle);
        return 1;
    }
    public void initDb()
     {
         creerEchelle( "femmeDeMenege");
         creerEchelle("agentDeSecurite");
         creerEchelle("Gardinier");
         creerEchelle("Doctorant");
         creerEchelle("Technicien");
         creerEchelle("FonctionnaireAdministrative");
         creerEchelle("ProfAsssistant");
         creerEchelle("PES");
     }
    
}
