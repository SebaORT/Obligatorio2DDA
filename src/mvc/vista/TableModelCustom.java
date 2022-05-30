/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.vista;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sebastian
 */
public class TableModelCustom extends AbstractTableModel {
          private  String[] columnNames ;
            //private Object[][] data;
            private ArrayList<Object[]> data;

    public TableModelCustom() {
        columnNames = new String[]{};
        data = new ArrayList<Object[]>();
    }

    public TableModelCustom(String[] columnNanes, ArrayList<Object[]> data) {
        this.columnNames = columnNanes;
        this.data = data;
    }
            
    public int getRowCount() {
        return data.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }

}
