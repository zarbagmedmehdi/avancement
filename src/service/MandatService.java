/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Util.DateUtil;
import bean.Mandat;
import bean.Responsabilité;
import bean.Salarie;
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
public class MandatService  extends AbstractFacade<Mandat>{
    ResponsabiliteService rs=new ResponsabiliteService();
    
            
    public MandatService() {
        super(Mandat.class);
        
    }
    public int creerMandat(String id, String idResponsa, String dd, String df) 
    {
        Mandat mandat= new Mandat();
        mandat.setId(id);
         Date dateD=DateUtil.parse(dd);
       mandat.setDateDebut(dateD);
          Date dateF=DateUtil.parse(df);
       
        mandat.setDateFin(dateF);
        
        Responsabilité resp=rs.find(idResponsa);
       // Salarie sal=ss.find(idsal); 
     if (resp==null ){   
         
//         sal==null
            return -1;}
        
            else{  mandat.setResponsabilite(resp);
                   
                   create(mandat);
                    return 1;
                    }
        }
        
        
        
      public void InitDb(){
          creerMandat("M1", "R1", "09-12-2017", "08-12-2021");
           creerMandat("M2", "R2", "09-12-2017", "08-12-2022");
            creerMandat("M3", "R3", "09-12-2017", "08-12-2019");
      }
      public List<Mandat>findCourant(Salarie salarie) 
      {
          return getEntityManager().createQuery("SELECT m FROM Mandat M WHERE M.salarie.id='" +salarie.getId()+ "'").getResultList();
   
      }
     

        
    
    
}
