/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion2.proyectofinal.controllers;

import javax.swing.DefaultComboBoxModel;
import ni.edu.uni.programacion2.proyectofinal.panels.IngresarProductos;

/**
 *
 * @author LENOVO 17
 */
public class IngProdController {
    private IngresarProductos ip;
    private DefaultComboBoxModel cmbDepartamento;
    private DefaultComboBoxModel cmbCategoria;
    private String Departa[] = new String[]{"Cuidado del Hogar", "Alimentos", "Licores","Confiterias","Bebidas","Cuidado Personal"};
    private String categoria[] = new String[]{"Cereales", "Granos basicos", "Insecticidas","Jabones de baño","Jabones Ropa","vinos","Gaseosas","Chiverias"};

    public IngProdController(IngresarProductos ip) {
        this.ip = ip;
        initComponent();
    }

    private void initComponent() {
        cmbDepartamento=new DefaultComboBoxModel(Departa);
        ip.getCmbDepa().setModel(cmbDepartamento);
        cmbCategoria=new DefaultComboBoxModel(categoria);
        ip.getCmbCate().setModel(cmbCategoria);
    }
    
    
}
