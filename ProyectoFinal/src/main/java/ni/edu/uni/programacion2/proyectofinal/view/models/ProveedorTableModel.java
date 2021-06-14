package ni.edu.uni.programacion2.proyectofinal.view.models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ni.edu.uni.programacion2.proyectofinal.backend.pojo.Productos;
import ni.edu.uni.programacion2.proyectofinal.backend.pojo.Proveedor;

public class ProveedorTableModel extends AbstractTableModel{

    private ArrayList<Proveedor> listProveedor = new ArrayList<>();
    private ArrayList<Productos> listProductos;
    private String[] nombreColumnas = {"Codigo", "Nombre", "Teléfono", "Dirección"};
    private int codigo = 0; //Código único para cada proveedor
    private int index;

    public ProveedorTableModel() {
    }
    
    public ProveedorTableModel(ArrayList<Proveedor> listProveedor, String[] nombreColumnas) {
        this.listProveedor = listProveedor;
        this.nombreColumnas = nombreColumnas;
    }
    
    public void add(Proveedor p){
        //Completando proveedor
        listProductos = new ArrayList<>();
        p.setCodigo(codigo++);
        p.setCatalogo(listProductos);
        
        listProveedor.add(p);
        fireTableDataChanged();
    }
    
    public void set(Proveedor p){
        //Seleccionado proveedor
        p.setCodigo(listProveedor.get(index).getCodigo());
        
        listProveedor.set(index, p);
        fireTableDataChanged();
    }
 
    public void remove(){
        listProveedor.remove(index);
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return listProveedor == null ? 0 : listProveedor.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas == null ? 0 : nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return listProveedor == null ? null : listProveedor.isEmpty() ? null : listProveedor.get(rowIndex).asArray()[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
    
    public ArrayList<Proveedor> getListProveedor() {
        return listProveedor;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
