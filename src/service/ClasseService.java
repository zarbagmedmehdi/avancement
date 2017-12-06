/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Classe;

/**
 *
 * @author user
 */
public class ClasseService extends AbstractFacade<Classe> {

    public ClasseService() {
        super(Classe.class);
    }

    public int creerClasse(String id, String nom, double coef) {

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
}
