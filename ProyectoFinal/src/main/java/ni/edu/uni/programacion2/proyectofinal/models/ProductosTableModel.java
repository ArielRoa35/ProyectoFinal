/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion2.proyectofinal.models;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import ni.edu.uni.programacion2.proyectofinal.backend.pojo.Productos;

/**
 *
 * @author LENOVO 17
 */
public class ProductosTableModel extends AbstractTableModel implements PropertyChangeListener{
    private List<Productos> data;
    private final String[] columnNames;

    public ProductosTableModel(List<Productos> data, String[] columnNames) {
        this.data = data;
        this.columnNames = columnNames;
    }
    
    public void add(Productos p){
        this.data.add(p);
    }
        
    @Override
    public int getRowCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames == null ? 0 : columnNames.length;
    }
    
    public void RemoveRow(int row) {
    data.remove(row);
    fireTableRowsDeleted(row,row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data == null ? null : data.isEmpty() ? null : data.get(rowIndex).asArray()[columnIndex];
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        add((Productos)evt.getNewValue());
        fireTableDataChanged();
    }
    
}
