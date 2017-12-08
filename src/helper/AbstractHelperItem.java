/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author moulaYounes
 */
public class AbstractHelperItem {

    private String columnName;
    private String attributeName;

    public AbstractHelperItem(String columnName, String attributeName) {
        this.columnName = columnName;
        this.attributeName = attributeName;
    }

    public AbstractHelperItem(String name) {
        this.columnName = name;
        this.attributeName = name;
    }

    public AbstractHelperItem() {
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

}
