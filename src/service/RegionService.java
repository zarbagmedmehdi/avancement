/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Classe;
import bean.Region;
import bean.Salarie;
import java.util.List;

/**
 *
 * @author hp
 */
public class RegionService extends AbstractFacade<Region>{
    ClasseService cs= new ClasseService();
    public RegionService() {
        super(Region.class);
    }
    public int creerRegion(String id, String nomRegion,String cc)
    {
        
        Region region=new Region();
      
      
          Classe classe;
        classe = cs.find(cc);
        region.setId(id);
        region.setNomRegion(nomRegion);
        region.setClasse(classe);
        
        create(region);
        return 1;
        
    
    }
    public void initDb()
     { 
         
         creerRegion("R1","Tanger-Tétouan-Al Hoceïma","C1");
         creerRegion("R2","L'Oriental","C2");
         creerRegion("R3","Fès-Meknès","C2");
         creerRegion("R4","Rabat-Salé-Kénitra","C2");
         creerRegion("R5","Béni Mellal-Khénifra","C3");
         creerRegion("R6","Casablanca-Settat","C1");
         creerRegion("R7","Marrakech-Safi","C1");
         creerRegion("R8","Drâa-Tafilalet","C3");
         creerRegion("R9","Souss-Massa","C2");
         creerRegion("R10","Guelmim-Oued Noun","C1");
         creerRegion("R11","Laâyoune-Sakia El Hamra","C1");
         creerRegion("R12","Dakhla-Oued Ed-Dahab","C1");
         
    }
       public List<Region> findByClass(String cc)
    {

    
    return getEntityManager().createQuery(" select r FROM Region r "
                + " WHERE r.classe.id='" +cc + "'").getResultList();
  
 } 
    
    
}
