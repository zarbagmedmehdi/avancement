/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.EntiteAdministrative;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author YOUNES
 */
public class EntiteAdministrativeHelper extends AbstractHelper<EntiteAdministrative> {

//    private String id;
//     private int Number;
//    @ManyToOne
//    private Echelle echelle;
//    private float mantant;
//    private static AbstractHelperItem[] titres;
private static AbstractHelperItem[] titres;
    static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem("id ", "id"),
            new AbstractHelperItem("nom", "nom"),
            
        };

    }

    public EntiteAdministrativeHelper(JTable jTable, List<EntiteAdministrative> list) {
        super(titres, jTable, list);
    }
    

    public EntiteAdministrativeHelper(AbstractHelperItem[] abstractHelperItem, JTable jTable) {
        super(titres, jTable);
    }

    public EntiteAdministrativeHelper(JTable jTable) {
        super(titres, jTable);
    }
}
