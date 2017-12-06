/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import bean.Classe;
import bean.Region;
import static javax.xml.ws.Endpoint.create;

/**
 *
 * @author hp
 */
public class RegionService extends AbstractFacade<Region>{
    
    public RegionService() {
        super(Region.class);
    }
    public int creerRegion(String id, String nomRegion, Classe classe)
    {
        
        Region region=new Region();
        if(region==null)
        {
            return -1;
        }
        else
            
        region.setId(id);
        region.setNomRegion(nomRegion);
        region.setClasse(classe);
        
        create(region);
        return 1;
        
    }
    public void initDb()
     {
         creerRegion("R1","Tanger-Tétouan-Al Hoceïma",null);
         creerRegion("R2","L'Oriental",null);
         creerRegion("R3","Fès-Meknès",null);
         creerRegion("R4","Rabat-Salé-Kénitra",null);
         creerRegion("R5","Béni Mellal-Khénifra",null);
         creerRegion("R6","Casablanca-Settat",null);
         creerRegion("R7","Marrakech-Safi",null);
         creerRegion("R8","Drâa-Tafilalet",null);
         creerRegion("R9","Souss-Massa",null);
         creerRegion("R10","Guelmim-Oued Noun",null);
         creerRegion("R11","Laâyoune-Sakia El Hamra",null);
         creerRegion("R12","Dakhla-Oued Ed-Dahab",null);
         
    }
    
    
}
