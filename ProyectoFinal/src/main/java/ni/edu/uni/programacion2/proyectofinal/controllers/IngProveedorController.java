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
import javax.swing.JOptionPane;
import ni.edu.uni.programacion2.proyectofinal.backend.dao.implementation.JsonProveedorDaoImpl;
import ni.edu.uni.programacion2.proyectofinal.backend.pojo.Proveedor;
import ni.edu.uni.programacion2.proyectofinal.view.panels.PnlMostrarProveedor;
import ni.edu.uni.programacion2.proyectofinal.view.panels.PnlProveedor;

/**
 *
 * @author LENOVO 17
 */
public class IngProveedorController {
    PnlMostrarProveedor mpro;
    PnlProveedor pnlpro;
    private PropertyChangeSupport propertySupport;
    private Proveedor provee;
    private JsonProveedorDaoImpl jsonProveedorDaoImpl;
    private Gson gson;

    public IngProveedorController(PnlProveedor pnlpro) {
        this.pnlpro = pnlpro;
        initComponent();
    }

    private void initComponent() {
        try{ 
        jsonProveedorDaoImpl=new JsonProveedorDaoImpl();
        gson = new Gson();
        propertySupport = new PropertyChangeSupport(this);
        
        pnlpro.getBtnAceptar().addActionListener(((e) -> {
            btnAceptarActionListener(e);
        }));
        pnlpro.getBtnCancelar().addActionListener(((e) -> {
            btnCancelarActionListener(e);
        }));

       }catch(FileNotFoundException ex) {
            Logger.getLogger(IngProveedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        propertySupport.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        propertySupport.removePropertyChangeListener(pcl);
    }
    
    private void btnAceptarActionListener(ActionEvent e){
        String Nombre,Direccion;
        int Telefono,codigo;
        int n=1;
        
        Nombre=pnlpro.getTxtNombre().getText();
        Direccion=pnlpro.getTxtDirección().getText();
        Telefono=Integer.parseInt(pnlpro.getFtxtTelefono().getText());
        codigo=n;
        int codig=codigo++;
        
        Proveedor p=new Proveedor(Telefono, codig, Nombre, Direccion);
        
         try {
            ProveeValidation(p);
            jsonProveedorDaoImpl.create(p);
            propertySupport.firePropertyChange("Proveedores", provee, p);
            JOptionPane.showMessageDialog(null, "Suppliers were saved sucessfully.",
                    "Saved message", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(IngProveedorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(IngProveedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ProveeValidation(Proveedor p) throws Exception {
        if (pnlpro.getTxtNombre().getText().isEmpty()||pnlpro.getTxtNombre().getText().isBlank()) {
            throw new Exception("Supplier name cannot be empty or blank.");
        }

        if (pnlpro.getTxtDirección().getText().isEmpty()||pnlpro.getTxtDirección().getText().isBlank()) {
            throw new Exception("Adress cannot be empty or blank.");
        }
    }
    private void btnCancelarActionListener(ActionEvent e){
        pnlpro.getTxtNombre().setText(" ");
        pnlpro.getTxtDirección().setText(" ");
        pnlpro.getFtxtTelefono().setText(" ");
        
    }
}
