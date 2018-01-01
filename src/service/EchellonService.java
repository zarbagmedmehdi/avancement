/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Echelle;
import bean.Echellon;
import java.util.List;

/**
 *
 * @author hp
 */
public class EchellonService extends AbstractFacade<Echellon> {
    EchelleService es= new EchelleService();
    public EchellonService() {
        super(Echellon.class);
    }
    public int creerEchellon (String id , int Number,  float mantant,Echelle echelle)
    {
      Echellon echellon=new Echellon();
              
            echellon.setId(id);
        echellon.setNumber(Number);
        echellon.setMantant(mantant);
        echellon.setEchelle(echelle);
        

        
        create(echellon);
        return 1;
    }
//     public void initDb()
//     { 
//         creerEchellon("e1",366,100);
//         creerEchellon("e2",369,125);
//         creerEchellon("e3",403,150);
//         creerEchellon("e4",436,175);
//         creerEchellon("e5",472,200);
//         creerEchellon("e6",509,225);
//         creerEchellon("e7",542,250);
//         creerEchellon("e8",606,275);
//         creerEchellon("e9",639,300);
//         creerEchellon("e10",675,325);
//         creerEchellon("e11",680,350);
//         creerEchellon("e12",690,375);
//         creerEchellon("e13",704,400);
//        
//         
//         
//    }
       public List<Echellon>findByEchelle(String idEchelle) {
          
       return getEntityManager().createQuery(" select e FROM Echellon e "
                + " WHERE e.echelle.id='" +idEchelle + "'").getResultList();
     }
       
       
    
}
