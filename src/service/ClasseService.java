/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Classe;
import java.util.List;

/**
 *
 * @author user
 */
public class ClasseService extends AbstractFacade<Classe> {

    public ClasseService() {
        super(Classe.class);
    }

    public int creerClasse(String id, String nom, float coef) {

        Classe classe = new Classe();

        classe.setId(id);
        classe.setCoef(coef);
        classe.setNom(nom);
        create(classe);

        return 1;

    }

    public void initDb() {

        creerClasse("C3", "C", 1);
    }
    public Class findClass(String id)
    {
        
    return (Class) getEntityManager().createQuery("SELECT c  FROM Class C WHERE C.id='" +id+ "'").getSingleResult();
  
 }
    
            
}
