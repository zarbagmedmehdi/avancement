/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import static Util.DateUtil.parse;
import bean.Mandat;
import bean.Responsabilité;
import bean.Salarie;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author user
 */
public class MandatService  extends AbstractFacade<Mandat>{
    ResponsabiliteService rs=new ResponsabiliteService();
    SalarieService ss=new SalarieService();
            
    public MandatService() {
        super(Mandat.class);
        
    }
    public int creerMandat(String id, String idResponsa, String dd, String df) throws ParseException
    {
        Mandat mandat= new Mandat();
        mandat.setId(id);
         Date dateD=parse(dd);
       mandat.setDateDebut(dateD);
          Date dateF=parse(df);
       
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
        
        
        
      public void InitDb() throws ParseException{
          creerMandat("M1", "R1", "09-12-2017", "08-12-2021");
           creerMandat("M2", "R2", "09-12-2017", "08-12-2022");
            creerMandat("M3", "R3", "09-12-2017", "08-12-2019");
      }  

        
    
    
}
