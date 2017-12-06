/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import bean.Classe;
import bean.Region;
import static bean.Region_.classe;
import static javax.xml.ws.Endpoint.create;

/**
 *
 * @author hp
 */
public class RegionService extends AbstractFacade<Region>{
    ClasseService cs= new ClasseService();
    public RegionService() {
        super(Region.class);
    }
    public int creerRegion(String id, String nomRegion, String idclasse)
    {
        
        Region region=new Region();
        if(region==null)
        {
            return -1;
        }
        else
           
         Classe classe=cs.find(idClasse);
        region.setId(id);
        region.setNomRegion(nomRegion);
        region.setClasse(classe);
        
        create(region);
        return 1;
        
    }
    public void initDb()
     { 
         
         creerRegion("R1","Tanger-Tétouan-Al Hoceïma",new Classe("C1"));
         creerRegion("R2","L'Oriental",new Classe("C2"));
         creerRegion("R3","Fès-Meknès",new Classe("C2"));
         creerRegion("R4","Rabat-Salé-Kénitra",new Classe("C1"));
         creerRegion("R5","Béni Mellal-Khénifra",new Classe("C2"));
         creerRegion("R6","Casablanca-Settat",new Classe("C1"));
         creerRegion("R7","Marrakech-Safi",new Classe("C1"));
         creerRegion("R8","Drâa-Tafilalet",new Classe("C3"));
         creerRegion("R9","Souss-Massa",new Classe("C2"));
         creerRegion("R10","Guelmim-Oued Noun",new Classe("C1"));
         creerRegion("R11","Laâyoune-Sakia El Hamra",new Classe("C1"));
         creerRegion("R12","Dakhla-Oued Ed-Dahab",new Classe("C1"));
         
    }
    
    
}
