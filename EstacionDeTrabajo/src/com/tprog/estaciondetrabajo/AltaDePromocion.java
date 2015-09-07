/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTMinProveedor;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTProveedor;
import com.tprog.logica.interfaces.ICtrlProductos;
import com.tprog.logica.interfaces.ICtrlUsuarios;
import java.awt.Image;
import java.io.File;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AltaDePromocion extends javax.swing.JInternalFrame {

    /**
     * Creates new form VerInformacionDeCliente
     */
    public AltaDePromocion(ICtrlUsuarios ctrlUsuarios, ICtrlProductos ctrlProductos) {
        this.ctrlProductos = ctrlProductos;
        this.ctrlUsuarios = ctrlUsuarios;  
        initComponents();
        setTitle("Alta de Promoción");
    }

    void cargarDatos() {
        //listaClientes
        Set<DTMinProveedor> setProveedores = ctrlUsuarios.listarProveedores();
        if (!setProveedores.isEmpty()) {
            //construyo un vector con la informacion a mostrar, porque
            //el comboBox solo funciona con Vector o List
            for (DTMinProveedor dt : setProveedores) {
                listaProveedores.add(dt.getNickname());
            }
//		listaProveedoresInterfaz.updateUI();
            listaProveedores.sort(null);
            this.updateUI();
        } else {
            JOptionPane.showMessageDialog(this, "No hay proveedores en el sistema.", "Error", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listaProveedoresInterfaz = new javax.swing.JComboBox(listaProveedores);
        label = new javax.swing.JLabel();
        imagenUsuarioHolder = new javax.swing.JLabel();
        panelUsuario = new javax.swing.JScrollPane();
        detalleUsuario = new javax.swing.JTextArea();
        buttonSeleccionarProveedor = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setTitle("Alta de Promoción");
        setPreferredSize(new java.awt.Dimension(640, 480));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaProveedoresInterfaz.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                listaProveedoresInterfazInterfazComponentAdded(evt);
            }
        });
        listaProveedoresInterfaz.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listaProveedoresInterfazItemStateChanged(evt);
            }
        });
        listaProveedoresInterfaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaProveedoresInterfazInterfazActionPerformed(evt);
            }
        });
        getContentPane().add(listaProveedoresInterfaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 290, -1));

        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Seleccione el proveedor que va a dar de alta el Servicio.");
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));
        label.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(imagenUsuarioHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 140, 140));

        detalleUsuario.setEditable(false);
        detalleUsuario.setColumns(20);
        detalleUsuario.setLineWrap(true);
        detalleUsuario.setRows(5);
        detalleUsuario.setWrapStyleWord(true);
        panelUsuario.setViewportView(detalleUsuario);

        getContentPane().add(panelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 230, 190));

        buttonSeleccionarProveedor.setText("Siguiente >");
        buttonSeleccionarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSeleccionarProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSeleccionarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, 120, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        cargarDatos();
    }//GEN-LAST:event_formComponentShown

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        listaProveedores.clear();
        servicios = null;
        imagenUsuarioHolder.setIcon(null);
        listaProveedoresInterfaz.setSelectedItem(null);
        detalleUsuario.setText("");
    }//GEN-LAST:event_formComponentHidden

    private void listaProveedoresInterfazInterfazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaProveedoresInterfazInterfazActionPerformed
        //seleccionarProveedor
        String proveedor = (String) listaProveedoresInterfaz.getSelectedItem();
        if (proveedor != null) {
            ctrlUsuarios.seleccionarProveedor(proveedor);
            //muestro Text Area para la información del proveedor
            detalleUsuario.setVisible(true);
            try {
                DTProveedor dt = ctrlUsuarios.infoProveedor();
                detalleUsuario.setText(dt.toString());
                String imagen = dt.getImagen();
                if (imagen != null) {
                    File f = new File(dt.getImagen());
                    Image img = ImageIO.read(f);
                    Image dimg = img.getScaledInstance(imagenUsuarioHolder.getWidth(), imagenUsuarioHolder.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon imageIcon = new ImageIcon(dimg);
                    imagenUsuarioHolder.setIcon(imageIcon);
                } else {
                    imagenUsuarioHolder.setIcon(null);
                }
                servicios = ctrlUsuarios.listarServiciosProveedor();
            } catch (Exception ex) {
                Logger.getLogger(AltaDePromocion.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("La imagen no pudo ser cargada");
                imagenUsuarioHolder.setIcon(null);
            }
        }
    }//GEN-LAST:event_listaProveedoresInterfazInterfazActionPerformed

    private void listaProveedoresInterfazInterfazComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_listaProveedoresInterfazInterfazComponentAdded

    }//GEN-LAST:event_listaProveedoresInterfazInterfazComponentAdded

    private void listaProveedoresInterfazItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listaProveedoresInterfazItemStateChanged

    }//GEN-LAST:event_listaProveedoresInterfazItemStateChanged

    private void buttonSeleccionarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSeleccionarProveedorActionPerformed

        String proveedor = (String) listaProveedoresInterfaz.getSelectedItem();
        if (proveedor != null) {
            ctrlUsuarios.seleccionarProveedor(proveedor);
            ctrlProductos.seleccionarProveedor(proveedor);
            AltaDePromocion2 ap2 = new AltaDePromocion2(this, servicios, ctrlUsuarios, ctrlProductos, proveedor);
            this.setVisible(false);
            getParent().add(ap2);
            ap2.setLocation(this.getLocation());
            ap2.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un proveedor.", "Alta de Promoción", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_buttonSeleccionarProveedorActionPerformed

    Set<DTMinServicio> servicios;
    ICtrlProductos ctrlProductos;
    ICtrlUsuarios ctrlUsuarios;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSeleccionarProveedor;
    private javax.swing.JTextArea detalleUsuario;
    private javax.swing.JLabel imagenUsuarioHolder;
    private javax.swing.JLabel label;
    private javax.swing.JComboBox listaProveedoresInterfaz;
    private Vector<String> listaProveedores = new Vector<>();
    private javax.swing.JScrollPane panelUsuario;
    // End of variables declaration//GEN-END:variables
}
