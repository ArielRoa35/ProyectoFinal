package ni.edu.uni.programacion2.proyectofinal.controllers;

import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import ni.edu.uni.programacion2.proyectofinal.backend.pojo.Proveedor;
import ni.edu.uni.programacion2.proyectofinal.view.DglProveedor;
import ni.edu.uni.programacion2.proyectofinal.view.IFrmMostrarCatalogo;
import ni.edu.uni.programacion2.proyectofinal.view.models.ProveedorTableModel;
import ni.edu.uni.programacion2.proyectofinal.view.panels.PnlMostrarProveedor;

public class PnlMostrarProveedorController {
    
    private PnlMostrarProveedor pnlMostrarProveedor;
    private JDesktopPane desktopComponent;
    private ProveedorTableModel proveedorTableModel;
    private DglProveedor dglProveedor;
    private IFrmMostrarCatalogo iFrmMostrarCatalogo;
    private boolean editar;

    public PnlMostrarProveedorController(PnlMostrarProveedor pnlMostrarProveedor) {
        this.pnlMostrarProveedor = pnlMostrarProveedor;
        initComponent();
    }
    
    private void initComponent(){
        
        proveedorTableModel = new ProveedorTableModel();
        pnlMostrarProveedor.getTblProveedor().setModel(proveedorTableModel);
        
        //Inhabilitar botónes "Editar", "Eliminar", "Mostrar Catálogo" cuando la tabla sea null
        tablaVacia();
        
        pnlMostrarProveedor.getBtnAgregar().addActionListener((e) ->{
            btnAgregarActionListener(e);
        });
        pnlMostrarProveedor.getBtnEditar().addActionListener((e) ->{
            btnEditarActionListener(e);
        });
        pnlMostrarProveedor.getBtnEliminar().addActionListener((e) ->{
            btnEliminarActionListener(e);
        });
        pnlMostrarProveedor.getBtnMostrarCatalogo().addActionListener((e) ->{
            btnMostrarCatalogoActionListener(e);
        });
        pnlMostrarProveedor.getBtnCancelar().addActionListener((e) ->{
            btnCancelarActionListener(e);
        });
    }
    
    private void btnAgregarActionListener(ActionEvent e){
        dglProveedor = new DglProveedor(null, true);
        editar = false; //Modo Agragar
        dglProveedor.setPnlMostrarProveedorController(this);
        dglProveedor.setVisible(true);
        
    }
    
    private void btnEditarActionListener(ActionEvent e){
        //Guardamos index seleccionado
        int index = pnlMostrarProveedor.getTblProveedor().getSelectedRow();
        
        //Validar
        if(index != -1){
            dglProveedor = new DglProveedor(null, true);
            Proveedor p = proveedorTableModel.getListProveedor().get(index);
            dglProveedor.getPnlProveedor().getTxtNombre().setText(p.getNombre());
            dglProveedor.getPnlProveedor().getFtxtTelefono().setValue(p.getTelefono());
            dglProveedor.getPnlProveedor().getTxtDireccion().setText(p.getDireccion());
            
            //Guardamos el index en el modelo
            proveedorTableModel.setIndex(index);
            
            editar = true; //Modo Editar
            dglProveedor.setPnlMostrarProveedorController(this);
            dglProveedor.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(pnlMostrarProveedor.getDesktopComponent(), "Debe seleccionar un proveedor.", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    private void btnEliminarActionListener(ActionEvent e){
        //Guardamos index seleccionado
        int index = pnlMostrarProveedor.getTblProveedor().getSelectedRow();
        
        if(index != -1){
            //Guardamos el index en el modelo
            proveedorTableModel.setIndex(index);
            proveedorTableModel.remove();
            tablaVacia();
        }else{
            JOptionPane.showMessageDialog(pnlMostrarProveedor.getDesktopComponent(), "Debe seleccionar un proveedor.", "Mensaje de error", JOptionPane.ERROR_MESSAGE);           
        }
    }
    
    private void btnMostrarCatalogoActionListener(ActionEvent e){
        //Inicializamos el panle de escritorio
        desktopComponent = pnlMostrarProveedor.getDesktopComponent();
        
        iFrmMostrarCatalogo = new IFrmMostrarCatalogo();
        iFrmMostrarCatalogo.getPnlMostrarCatalogo().setDesktopComponent(desktopComponent);
        
        desktopComponent.add(iFrmMostrarCatalogo);
        iFrmMostrarCatalogo.setVisible(true);
    }
    
    private void btnCancelarActionListener(ActionEvent e){
        //Inicializamos el panle de escritorio
        desktopComponent = pnlMostrarProveedor.getDesktopComponent();
        desktopComponent.removeAll();
        desktopComponent.repaint();
    }
    
    public void tablaVacia(){
        
        if(proveedorTableModel.getRowCount() == 0){
            pnlMostrarProveedor.getBtnEditar().setEnabled(false);
            pnlMostrarProveedor.getBtnEliminar().setEnabled(false);
            pnlMostrarProveedor.getBtnMostrarCatalogo().setEnabled(false);
        }else{
            pnlMostrarProveedor.getBtnEditar().setEnabled(true);
            pnlMostrarProveedor.getBtnEliminar().setEnabled(true);
            pnlMostrarProveedor.getBtnMostrarCatalogo().setEnabled(true);
        }
    }

    public ProveedorTableModel getProveedorTableModel() {
        return proveedorTableModel;
    }

    public boolean isEditar() {
        return editar;
    }
}
