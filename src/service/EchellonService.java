/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import bean.Echellon;
import bean.Region;
import static javax.xml.ws.Endpoint.create;

/**
 *
 * @author hp
 */
public class EchellonService extends AbstractFacade<Echellon> {
    
    public EchellonService() {
        super(Echellon.class);
    }
    public int creerEchellon (int Number, double mantant)
    {
       Echellon echellon=new Echellon();
        if(echellon==null)
        {
            return -1;
        }
        else
            
        echellon.setNumber(Number);
        echellon.setMantant(mantant);

        
        create(echellon);
        return 1;
    }
     public void initDb()
     {
         creerEchellon(366,100);
         creerEchellon(369,125);
         creerEchellon(403,150);
         creerEchellon(436,175);
         creerEchellon(472,200);
         creerEchellon(509,225);
         creerEchellon(542,250);
         creerEchellon(606,275);
         creerEchellon(639,300);
         creerEchellon(675,325);
         creerEchellon(680,350);
         creerEchellon(690,375);
         creerEchellon(704,400);
         
    }
    
}
