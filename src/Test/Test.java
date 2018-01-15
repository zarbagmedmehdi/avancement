/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import service.SalarieService;
import util.JasperUtil;

/**
 *
 * @author user
 */
public class Test {
    public static void main(String[] args) {
        SalarieService salarieService=new SalarieService();
        Map params=new HashMap();
        params.put("Salarie","Salarie");
        try {
            JasperUtil. generatePdf(salarieService.findAll(), "C:\\Users\\user\\Documents\\Avancement1\\src\\report\\Salarie_List.jasper", "E:\\Rapport\\cc.pdf", params, true);
        } catch (JRException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
}
