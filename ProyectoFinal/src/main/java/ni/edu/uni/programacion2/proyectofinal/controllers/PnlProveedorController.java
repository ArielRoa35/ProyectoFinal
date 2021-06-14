package ni.edu.uni.programacion2.proyectofinal.controllers;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import ni.edu.uni.programacion2.proyectofinal.backend.pojo.Proveedor;
import ni.edu.uni.programacion2.proyectofinal.view.panels.PnlProveedor;

public class PnlProveedorController {
    
    private PnlProveedor pnlProveedor;
    private Proveedor proveedor;

    public PnlProveedorController(PnlProveedor pnlProveedor) {
        this.pnlProveedor = pnlProveedor;
        initComponent();
    }
    
    private void initComponent(){
        
        pnlProveedor.getBtnAceptar().addActionListener((e) ->{
            btnAceptarActionListener(e); 
        });
        pnlProveedor.getBtnCancelar().addActionListener((e) ->{
            btnCancelarActionListener(e); 
        });
    }
    
    private void btnAceptarActionListener(ActionEvent e){
        
        if(!pnlProveedor.getTxtNombre().getText().isBlank() &&
                !pnlProveedor.getFtxtTelefono().getText().isBlank() &&
                !pnlProveedor.getTxtDireccion().getText().isBlank()){
            
            proveedor = new Proveedor();
            proveedor.setNombre(pnlProveedor.getTxtNombre().getText());
            proveedor.setTelefono(pnlProveedor.getFtxtTelefono().getText());
            proveedor.setDireccion(pnlProveedor.getTxtDireccion().getText());
            
            if(!pnlProveedor.getDglProveedor().getPnlMostrarProveedorController().isEditar()){
                pnlProveedor.getDglProveedor().getPnlMostrarProveedorController().getProveedorTableModel().add(proveedor);
                pnlProveedor.getDglProveedor().getPnlMostrarProveedorController().tablaVacia();
                pnlProveedor.getDglProveedor().dispose();
            }else{
                pnlProveedor.getDglProveedor().getPnlMostrarProveedorController().getProveedorTableModel().set(proveedor);
                pnlProveedor.getDglProveedor().dispose();
            }
            
        }else{
            
            JOptionPane.showMessageDialog(pnlProveedor.getDglProveedor(), "Rellene todos los valores.", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void btnCancelarActionListener(ActionEvent e){
        
        pnlProveedor.getDglProveedor().dispose();
    }
}
