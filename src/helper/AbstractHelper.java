/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import util.DaoEngigne;

/**
 *
 * @author dell
 */
public abstract class AbstractHelper<T> extends AbstractTableModel {

    protected AbstractHelperItem[] abstractHelperItem;
    protected List<T> list = new ArrayList<T>();
    protected JTable jTable = new JTable();

    public JTable getjTable() {
        return jTable;
    }

    public void setjTable(JTable jTable) {
        this.jTable = jTable;
    }

    public AbstractHelper(AbstractHelperItem[] abstractHelperItem, JTable jTable, List<T> list) {
        this.abstractHelperItem = abstractHelperItem;
        this.jTable = jTable;
        this.list = list;
        jTable.setModel(this);
    }
     public AbstractHelper(AbstractHelperItem[] abstractHelperItem, JTable jTable) {
         List<T> myList = new ArrayList<>();
        this.abstractHelperItem = abstractHelperItem;
        this.jTable = jTable;
        this.list = myList;
        jTable.setModel(this);
    }

    public void save(T t) {
        list.add(t);
        for (int i = 0; i <  abstractHelperItem.length; i++) {
            fireTableRowsInserted(abstractHelperItem.length- 1, i);
        }
    }

    public void remove(T t) {
        int selected = jTable.getSelectedRow();
        list.remove(selected);
        for (int i = 0; i <  abstractHelperItem.length; i++) {
            fireTableRowsDeleted(selected, i);

        }
    }

    public void update(T t) {
        int selected = jTable.getSelectedRow();
        list.set(selected, t);
        for (int i = 0; i <  abstractHelperItem.length; i++) {
            fireTableRowsUpdated(selected, i);
        }
    }

    public T getSelected() {
        if (getSelectedIdex() != -1) {
            return list.get(jTable.getSelectedRow());
        }
        return null;
    }

    public int getSelectedIdex() {
        return jTable.getSelectedRow();
    }

    @Override
    public int getRowCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return abstractHelperItem.length;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
        fireTableDataChanged();
    }

    public T getValueAt(int rowIndex) {
        if (list!=null && rowIndex < list.size()) {
            return list.get(rowIndex);
        }

        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return abstractHelperItem[columnIndex].getColumnName();
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (list!=null && rowIndex < list.size()) {
            for (int i = 0; i < abstractHelperItem.length; i++) {
                if (columnIndex == i) {
                    System.out.println("ana daba f i ==> "+i);
                    try {
                        return DaoEngigne.lunchGetterByParamName(list.get(rowIndex), abstractHelperItem[i].getAttributeName());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

}
