/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author moulaYounes
 */
public class JasperUtil {

//    public static void generatePDFUser(List myList, Map params, String cheminExport, String cheminJasper, int flag) throws JRException, IOException {
//        // List<User> users est une liste qui va etre afficher dans jasper ==> $F
//        //  Map params ==> les parametre 
//        //String nom1 ==> chemin d'export de pdf
//        // chemin1 ==> chemin fixe de votre fichier jrxml (le user ne le voit pas)
//
//        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(myList);
//        // creation d'une liste de jasper a partir de notre liste users
//
//        runPdf(cheminExport, cheminJasper, params, beanCollectionDataSource, flag);
//        // methode private permet de generer le pdf + afficher le pdf en question
//    }
//
//    private static void runPdf(String cheminExport, String cheminJasper, Map params, JRBeanCollectionDataSource beanCollectionDataSource, int flag) throws JRException, IOException {
//        // creation de pdf
//        JasperDesign jasperDesign = JRXmlLoader.load(cheminJasper);
//        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, beanCollectionDataSource);
//        JasperExportManager.exportReportToPdfFile(jasperPrint, cheminExport);
//
//            // affichage pdf
//        // nom="BC-"+code+".pdf"
//        if (flag == 1) {
//            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + cheminExport);
//        }
//
//    }

    public static void generatePdf(List list, String cheminJapser, String cheminExport, Map params, boolean isPdfVisible) throws FileNotFoundException, JRException, IOException {
        InputStream reportSource = null;
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(list);
        reportSource = new FileInputStream(cheminJapser);
        JasperPrint jasperPrint = JasperFillManager.fillReport(reportSource, params, beanCollectionDataSource);
        //  JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\monpremierpdf.pdf");
        JasperExportManager.exportReportToPdfFile(jasperPrint, cheminExport);
        if (isPdfVisible) {
            showPdf(cheminExport);
        }
          reportSource.close();
    }

      public static void generatePdf(List list, Map params, boolean isPdfVisible) throws FileNotFoundException, JRException, IOException {
          generatePdf(list, Config.getCheminJasper(), Config.getCheminExport(), params, isPdfVisible);
    }

    public static void showPdf(String chemin) throws IOException {
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + chemin);
    }
}
