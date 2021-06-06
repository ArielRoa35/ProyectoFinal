/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion2.proyectofinal.controllers;

import com.google.gson.Gson;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import ni.edu.uni.programacion2.proyectofinal.backend.dao.implementation.prov.JsonProveDaoImpl;
import ni.edu.uni.programacion2.proyectofinal.backend.pojo.Proveedor;
import ni.edu.uni.programacion2.proyectofinal.frame.Proveedores;
import ni.edu.uni.programacion2.proyectofinal.frame.Pulperia;
import ni.edu.uni.programacion2.proyectofinal.models.ProveedoresTableModel;

/**
 *
 * @author LENOVO 17
 */
public class ProveedoresController {
    private Proveedores proveedores;
    private Proveedor p;
    private Gson gson;
    private JsonProveDaoImpl jpdi;
    private PropertyChangeSupport propertySupport;
    private List<Proveedor> pro;
    private String[] Headers=new String[]{"Telefono","Proveedor","Direccion","Ruc"};
    private TableRowSorter<ProveedoresTableModel>tblrowSorter;
    private ProveedoresTableModel tblviewmodel;

    public ProveedoresController(Proveedores proveedores) {
        this.proveedores = proveedores;
        initComponent();
    }

    
    
    public ProveedoresTableModel getTblViewModel(){
        return tblviewmodel;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        propertySupport.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        propertySupport.removePropertyChangeListener(pcl);
    }

    private void initComponent() {
        try{ 
        jpdi = new JsonProveDaoImpl();
        gson = new Gson();
        propertySupport = new PropertyChangeSupport(this);
        
        proveedores.getBtnSave().addActionListener(((e) -> {
            btnSaveActionListener(e);
            
        }));
        
        loadTable();
        
        proveedores.getBtnVolver().addActionListener(((e) -> {
            getBtnVolverActionListener(e);
            
        }));
        
       }catch(FileNotFoundException ex) {
            Logger.getLogger(ProveedoresController.class.getName()).log(Level.SEVERE, null, ex);
       }catch (IOException ex) {
            Logger.getLogger(InventarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }
    
    private void btnSaveActionListener(ActionEvent e){
        int servicioN;
        String Nombre,Ruc,Direccion;
        
        servicioN=Integer.parseInt(proveedores.getTxtNumero().getText());
        Nombre=proveedores.getTxtProveedor().getText();
        Direccion=proveedores.getTxtDirec().getText();
        Ruc=proveedores.getTxtRuc().getText();
        
        Proveedor pr=new Proveedor(servicioN, Nombre, Direccion, Ruc);
        
        try {
            ProveeValidation(pr);
            jpdi.create(pr);
            propertySupport.firePropertyChange("Proveedores", p, pr);
            JOptionPane.showMessageDialog(null, "Proveedores save sucessfully.",
                    "Saved message", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(ProveedoresController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ProveedoresController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        private void ProveeValidation(Proveedor pr) throws Exception{
            if(proveedores.getTxtNumero().getText().isBlank()||proveedores.getTxtNumero().getText().isEmpty()){
                throw new Exception("Numero cannot be empty or blank.");
            }
            
            if(proveedores.getTxtProveedor().getText().isBlank() || proveedores.getTxtProveedor().getText().isEmpty()){
                throw new Exception("Nombre Proveedor cannot be empty or blank");   
        }
            
        }
        
        private void loadTable() throws IOException{
        pro=jpdi.getAll().stream().collect(Collectors.toList());
        tblviewmodel=new ProveedoresTableModel(pro, Headers);
        tblrowSorter=new TableRowSorter<>(tblviewmodel);
        
        proveedores.getTblProveedores().setModel(tblviewmodel);
        proveedores.getTblProveedores().setRowSorter(tblrowSorter);
    }
        
        private void getBtnVolverActionListener(ActionEvent e){
            proveedores.setVisible(false);
            Pulperia pul=new Pulperia();
            pul.setVisible(true);
        }
}
    
    

