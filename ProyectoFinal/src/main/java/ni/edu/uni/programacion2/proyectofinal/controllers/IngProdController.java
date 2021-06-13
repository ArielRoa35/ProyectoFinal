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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import ni.edu.uni.programacion2.proyectofinal.backend.dao.implementation.JsonProdDaoImpl;
import ni.edu.uni.programacion2.proyectofinal.backend.pojo.Productos;
import ni.edu.uni.programacion2.proyectofinal.frame.IngresarProd;
import ni.edu.uni.programacion2.proyectofinal.frame.Pulperia;


/**
 *
 * @author LENOVO 17
 */
public class IngProdController {
    private IngresarProd ip;
    private DefaultComboBoxModel cmbDepartamento;
    private DefaultComboBoxModel cmbCategoria;
    private String Departa[] = new String[]{"Cuidado del Hogar", "Alimentos", "Licores","Confiterias","Bebidas","Cuidado Personal"};
    private String categoria[] = new String[]{"Cereales", "Granos basicos", "Insecticidas","Jabones de baño","Jabones Ropa","vinos","Gaseosas","Chiverias"};
    private PropertyChangeSupport propertySupport;
    private Productos productosC;
    private JsonProdDaoImpl jpdi;
    private Gson gson;

    public IngProdController(IngresarProd ip) {
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
        
       try{ 
        jpdi = new JsonProdDaoImpl();
        gson = new Gson();
        propertySupport = new PropertyChangeSupport(this);
        cmbDepartamento=new DefaultComboBoxModel(Departa);
        ip.getCmbDepa().setModel(cmbDepartamento);
        cmbCategoria=new DefaultComboBoxModel(categoria);
        ip.getCmbCatego().setModel(cmbCategoria);
        
        
        ip.getBtnSave().addActionListener(((e) -> {
            btnSaveActionListener(e);
        }));
        ip.getBtnVolver().addActionListener(((e) -> {
            getBtnVolverActionListener(e);
            
        }));
       }catch(FileNotFoundException ex) {
            Logger.getLogger(IngProdController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void btnSaveActionListener(ActionEvent e){
        int Codigo;
        String Nombre,Departamento,Categor;
        int Dispo;
        float precio;
        
        Codigo=Integer.parseInt(ip.getTxtCodigo().getText());
        Nombre=ip.getTxtProducto().getText();
        Departamento=ip.getCmbDepa().getSelectedItem().toString();
        Categor=ip.getCmbCatego().getSelectedItem().toString();
        Dispo=Integer.parseInt(ip.getSpDispo().getModel().getValue().toString());
        precio=Float.parseFloat(ip.getSpPrecio().getModel().getValue().toString());
        
        Productos p=new Productos(Codigo, Nombre, Departamento, Categor, Dispo, precio);
        
        try {
            ProductValidation(p);
            jpdi.create(p);
            propertySupport.firePropertyChange("Productos", productosC, p);
            JOptionPane.showMessageDialog(null, "Product save sucessfully.",
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
            throw new Exception("Producto cannot be empty or blank.");
        }
    }
    
    private void getBtnVolverActionListener(ActionEvent e){
            ip.setVisible(false);
            Pulperia pul=new Pulperia();
            pul.setVisible(true);
        }
}
