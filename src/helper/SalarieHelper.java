/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Salarie;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author YOUNES
 */
public class SalarieHelper extends AbstractHelper<Salarie> {

    private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem("ID ", "id"),
            new AbstractHelperItem("NOM", "nom"),
            new AbstractHelperItem("PRENOM", "prenom")};

    }

    public SalarieHelper(JTable jTable, List<Salarie> list) {
        super(titres, jTable, list);
    }
    

    public SalarieHelper(AbstractHelperItem[] abstractHelperItem, JTable jTable) {
        super(titres, jTable);
    }

    public SalarieHelper(JTable jTable) {
        super(titres, jTable);
    }
}
