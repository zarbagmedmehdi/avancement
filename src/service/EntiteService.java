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
     public int creerEntite(String id, String nom, Salarie chef) {

        EntiteAdministrative e = new EntiteAdministrative();

        e.setId(id);
        e.setNom(nom);
        
        e.setChef(chef);
        create(e);

        return 1;

    }
    
}