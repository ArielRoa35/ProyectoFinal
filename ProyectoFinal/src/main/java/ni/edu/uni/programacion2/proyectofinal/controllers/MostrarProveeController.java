/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion2.proyectofinal.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.table.TableRowSorter;
import ni.edu.uni.programacion2.proyectofinal.backend.dao.implementation.JsonProveedorDaoImpl;
import ni.edu.uni.programacion2.proyectofinal.backend.pojo.Proveedor;
import ni.edu.uni.programacion2.proyectofinal.models.ProveedoresTableModel;
import ni.edu.uni.programacion2.proyectofinal.view.panels.PnlMostrarProveedor;

/**
 *
 * @author LENOVO 17
 */
public class MostrarProveeController {
    private MostrarProveeController mproC;
    private PnlMostrarProveedor pnlMP;
    private JsonProveedorDaoImpl jsonProveedorDaoImpl;
    private ProveedoresTableModel tableModel;
    private List<Proveedor> proveedor;
    private String [] Headers=new String []{"Telefono","Codigo","Nombre","Direccion"};
    private TableRowSorter<ProveedoresTableModel>tblrowsorter;

    public MostrarProveeController(PnlMostrarProveedor pnlMP) {
        this.pnlMP = pnlMP;
        initComponent();
    }
    
    public ProveedoresTableModel getTableModel(){
        return tableModel;
    }

    private void initComponent() {
        try{
            jsonProveedorDaoImpl=new JsonProveedorDaoImpl();
            
            loadTable();
            
        }catch(FileNotFoundException ex) {
            Logger.getLogger(MostrarProveeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MostrarProveeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadTable() throws IOException{
        proveedor=jsonProveedorDaoImpl.getAll().stream().collect(Collectors.toList());
        tableModel=new ProveedoresTableModel(proveedor, Headers);
        tblrowsorter=new TableRowSorter<>(tableModel);
        
        pnlMP.getTblProveedor().setModel(tableModel);
        pnlMP.getTblProveedor().setRowSorter(tblrowsorter);
    }
    
}
