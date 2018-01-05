/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import bean.EntiteAdministrative;
import bean.Mandat;

import bean.Salarie;
import java.util.List;
/**
 *
 * @author user
 */
public class EntiteService extends AbstractFacade<EntiteAdministrative> {
    SalarieService salarieService=new SalarieService();
    
    public EntiteService() {
        super(EntiteAdministrative.class);
    }
     public int creerEntite(String id, String nom,Salarie chef) {

        EntiteAdministrative e = new EntiteAdministrative();
      Salarie salarie=salarieService.find(id);
      if (salarie==null){
          return -1;
      }

        e.setId(id);
        e.setNom(nom);
        e.setChef(salarie);
        
       
        create(e);

        return 1;

    }
//     void initDb(){
//            
//     creerEntite("EN1","decanat" , null);
//      creerEntite("EN2","scolarité" , null);
//       creerEntite("EN3","bibliotheque" , null);
//       creerEntite("EN4","depMath" , null);
//        creerEntite("EN5","depInfo" , null);
//         creerEntite("EN6","depchimie" , null);
//       
//    
//}
     public List<EntiteAdministrative> find (Salarie chef)
   {
            return   getEntityManager().createQuery("SELECT e  FROM EntiteAdministrative E WHERE E.salarie.id='" +chef.getId()+ "'").getResultList();
   }
      
//

}