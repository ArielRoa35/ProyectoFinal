/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion2.proyectofinal.controllers;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import ni.edu.uni.programacion2.proyectofinal.backend.pojo.Productos;
import ni.edu.uni.programacion2.proyectofinal.panels.IngreProductos;

/**
 *
 * @author LENOVO 17
 */
public class IngProdController {
    private IngreProductos ip;
    private DefaultComboBoxModel cmbDepartamento;
    private DefaultComboBoxModel cmbCategoria;
    private String Departa[] = new String[]{"Cuidado del Hogar", "Alimentos", "Licores","Confiterias","Bebidas","Cuidado Personal"};
    private String categoria[] = new String[]{"Cereales", "Granos basicos", "Insecticidas","Jabones de baño","Jabones Ropa","vinos","Gaseosas","Chiverias"};
    private PropertyChangeSupport propertySupport;
    private Productos productosC;

    public IngProdController(IngreProductos ip) {
        this.ip = ip;
        initComponent();
    }
    
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        propertySupport.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        propertySupport.removePropertyChangeListener(pcl);
    }

    private void initComponent() {
        cmbDepartamento=new DefaultComboBoxModel(Departa);
        ip.getCmbDepa().setModel(cmbDepartamento);
        cmbCategoria=new DefaultComboBoxModel(categoria);
        ip.getCmbCate().setModel(cmbCategoria);
        
        
        ip.getBtnSave().addActionListener(((e) -> {
            btnSaveActionListener(e);
        }));
        
        
    }
    
    private void btnSaveActionListener(ActionEvent e){
        String Codigo,Nombre,Departamento,Categor;
        int Dispo;
        float precio;
        
        Codigo=ip.getTxtCodigo().getText();
        Nombre=ip.getTxtProducto().getText();
        Departamento=ip.getCmbDepa().getSelectedItem().toString();
        Categor=ip.getCmbCate().getSelectedItem().toString();
        Dispo=Integer.parseInt(ip.getSpDispo().getModel().getValue().toString());
        precio=Float.parseFloat(ip.getSpPrecio().getModel().getValue().toString());
        
        Productos p=new Productos(Codigo, Nombre, Departamento, Categor, Dispo, precio);
        
        try {
            ProductValidation(p);
            propertySupport.firePropertyChange("Productos", productosC, p);
            JOptionPane.showMessageDialog(null, "Vehicle save sucessfully.",
                    "Saved message", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(IngProdController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(IngProdController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ProductValidation(Productos v) throws Exception {
        if (ip.getTxtCodigo().getText().isEmpty()||ip.getTxtCodigo().getText().isBlank()) {
            throw new Exception("Codigo cannot be empty or blank.");
        }

        if (ip.getTxtProducto().getText().isEmpty()||ip.getTxtProducto().getText().isBlank()) {
            throw new Exception("StockNumber cannot be empty or blank.");
        }
    }
}
