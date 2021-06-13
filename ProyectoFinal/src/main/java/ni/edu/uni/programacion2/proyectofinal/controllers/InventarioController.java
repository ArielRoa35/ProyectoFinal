/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion2.proyectofinal.controllers;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.table.TableRowSorter;
import ni.edu.uni.programacion2.proyectofinal.backend.dao.implementation.JsonProdDaoImpl;
import ni.edu.uni.programacion2.proyectofinal.backend.pojo.Productos;
import ni.edu.uni.programacion2.proyectofinal.frame.Inventario;
import ni.edu.uni.programacion2.proyectofinal.frame.Pulperia;
import ni.edu.uni.programacion2.proyectofinal.models.ProductosTableModel;

/**
 *
 * @author LENOVO 17
 */
public class InventarioController {
    private InventarioController ic;
    private Inventario inventario;
    private JsonProdDaoImpl jsonProdDaoImpl;
    private ProductosTableModel tblviewmodel;
    private List<Productos> productos;
    private String[] Headers=new String[]{"Codigo","Producto","Departamento","Categoria","Disponible","Precio"};
    private TableRowSorter<ProductosTableModel>tblrowSorter;

    public InventarioController(Inventario inventario) {
        this.inventario = inventario;
        initComponent();
    }
    
    public ProductosTableModel getTblViewModel(){
        return tblviewmodel;
    }
    

    private void initComponent() {
        try{
            jsonProdDaoImpl=new JsonProdDaoImpl();
            
            loadTable();
            
            inventario.getBtnVolver().addActionListener(((e) -> {
            getBtnVolverActionListener(e);
            
        }));
            
        }catch(FileNotFoundException ex) {
            Logger.getLogger(InventarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InventarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadTable() throws IOException{
        productos=jsonProdDaoImpl.getAll().stream().collect(Collectors.toList());
        tblviewmodel=new ProductosTableModel(productos, Headers);
        tblrowSorter=new TableRowSorter<>(tblviewmodel);
        
        inventario.getTblViewProduct().setModel(tblviewmodel);
        inventario.getTblViewProduct().setRowSorter(tblrowSorter);
    }
    
    private void getBtnVolverActionListener(ActionEvent e){
            inventario.setVisible(false);
            Pulperia pul=new Pulperia();
            pul.setVisible(true);
        }
}
