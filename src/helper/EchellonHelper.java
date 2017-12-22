/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Echellon;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author YOUNES
 */
public class EchellonHelper extends AbstractHelper<Echellon> {

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
            new AbstractHelperItem("Number", "Number"),
            
        };

    }

    public EchellonHelper(JTable jTable, List<Echellon> list) {
        super(titres, jTable, list);
    }
    

    public EchellonHelper(AbstractHelperItem[] abstractHelperItem, JTable jTable) {
        super(titres, jTable);
    }

    public EchellonHelper(JTable jTable) {
        super(titres, jTable);
    }
}
