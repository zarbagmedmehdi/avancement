/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import bean.Region;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author YOUNES
 */
public class RegionHelper extends AbstractHelper<Region> {

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
            new AbstractHelperItem("nomRegion", "nomRegion"),
            
        };

    }

    


    public RegionHelper(JTable jTable, List<Region> list) {
        super(titres, jTable, list);
    }
    

    public RegionHelper(AbstractHelperItem[] abstractHelperItem, JTable jTable) {
        super(titres, jTable);
    }

    public RegionHelper(JTable jTable) {
        super(titres, jTable);
    }
}
