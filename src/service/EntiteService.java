/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import bean.EntiteAdministrative;
import bean.Salarie;
/**
 *
 * @author user
 */
public class EntiteService extends AbstractFacade<EntiteAdministrative> {
    
    public EntiteService() {
        super(EntiteAdministrative.class);
    }
     public int creerEntite(String id, String nom) {

        EntiteAdministrative e = new EntiteAdministrative();

        e.setId(id);
        e.setNom(nom);
        
       
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
}