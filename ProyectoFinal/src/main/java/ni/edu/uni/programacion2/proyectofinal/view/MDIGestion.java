/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion2.proyectofinal.view;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author Ariel Roa
 */
public class MDIGestion extends javax.swing.JFrame {

    private IFrmMostrarProveedor iFrmMostrarProveedor;
    private IFrmMostrarCatalogo iFrmMostrarCatalogo;
    private IFrmComprar iFrmComprar;
    private IFrmVender iFrmVender;
    private IFrmMostrarInventario iFrmMostrarInventario;
            
    /**
     * Creates new form FrmPrincipal
     */
    public MDIGestion() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBotones = new javax.swing.JPanel();
        btnVender = new javax.swing.JButton();
        btnComprar = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnFactura = new javax.swing.JButton();
        btnDevolucion = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        btnCatalogo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dskContenido = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de gestión inventario");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new java.awt.Dimension(800, 500));

        pnlBotones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlBotones.setLayout(new java.awt.GridLayout(0, 1));

        btnVender.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        btnVender.setText("Vender");
        btnVender.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });
        pnlBotones.add(btnVender);

        btnComprar.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        btnComprar.setText("Comprar");
        btnComprar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        pnlBotones.add(btnComprar);

        btnInventario.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        btnInventario.setText("Inventario");
        btnInventario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });
        pnlBotones.add(btnInventario);

        btnFactura.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        btnFactura.setText("Facturas");
        btnFactura.setEnabled(false);
        btnFactura.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pnlBotones.add(btnFactura);

        btnDevolucion.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        btnDevolucion.setText("Devolución");
        btnDevolucion.setEnabled(false);
        btnDevolucion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pnlBotones.add(btnDevolucion);

        btnProveedor.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        btnProveedor.setText("Proveedores");
        btnProveedor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });
        pnlBotones.add(btnProveedor);

        btnCatalogo.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        btnCatalogo.setText("Catálogo");
        btnCatalogo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatalogoActionPerformed(evt);
            }
        });
        pnlBotones.add(btnCatalogo);

        getContentPane().add(pnlBotones, java.awt.BorderLayout.LINE_START);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Pulperia \"Doña Ignacia\" - Todo lo que quieras al alcance de tu barrio.");
        jPanel3.add(jLabel1);

        getContentPane().add(jPanel3, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout dskContenidoLayout = new javax.swing.GroupLayout(dskContenido);
        dskContenido.setLayout(dskContenidoLayout);
        dskContenidoLayout.setHorizontalGroup(
            dskContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );
        dskContenidoLayout.setVerticalGroup(
            dskContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );

        getContentPane().add(dskContenido, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed

        iFrmMostrarProveedor = new IFrmMostrarProveedor();
        iFrmMostrarProveedor.getPnlMostrarProveedor().setDesktopComponent(dskContenido);
        
        agregarComponente(iFrmMostrarProveedor);
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatalogoActionPerformed

        iFrmMostrarCatalogo = new IFrmMostrarCatalogo();
        iFrmMostrarCatalogo.getPnlMostrarCatalogo().setDesktopComponent(dskContenido);

        agregarComponente(iFrmMostrarCatalogo);
    }//GEN-LAST:event_btnCatalogoActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed

        iFrmComprar = new IFrmComprar();
        iFrmComprar.getPnlComprar().setDesktopComponent(dskContenido);
        
        agregarComponente(iFrmComprar);
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        iFrmVender = new IFrmVender();
        iFrmVender.getPnlVender().setDesktopComponent(dskContenido);
        
        agregarComponente(iFrmVender);
    }//GEN-LAST:event_btnVenderActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        iFrmMostrarInventario = new IFrmMostrarInventario();
        iFrmMostrarInventario.getPnlMostrarInventario().setDesktopComponent(dskContenido);
        
        agregarComponente(iFrmMostrarInventario);
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void agregarComponente(JComponent component){
        dskContenido.removeAll();
        dskContenido.repaint();
        dskContenido.add(component);
        component.setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MDIGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDIGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDIGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDIGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDIGestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCatalogo;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnDevolucion;
    private javax.swing.JButton btnFactura;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnVender;
    private javax.swing.JDesktopPane dskContenido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel pnlBotones;
    // End of variables declaration//GEN-END:variables
}
