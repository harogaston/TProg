/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.interfaces.ICtrlProductos;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author User
 */
public class AltaDeServicio3 extends javax.swing.JInternalFrame {
    private AltaDeServicio2 padre;
    private ICtrlProductos ctrlProductos;
    private String proveedor;

    /**
     * Creates new form AltaDeServicio3
     * @param padre
     * @param ctrlProductos
     */
    public AltaDeServicio3(AltaDeServicio2 padre, ICtrlProductos ctrlProductos, String proveedor) {
        setTitle("Alta de Servicio");
        this.proveedor = proveedor;
        this.padre = padre;
        this.ctrlProductos = ctrlProductos;
        initComponents();
        BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
        for (MouseListener listener : basicInternalFrameUI.getNorthPane().getMouseListeners()) {
            basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
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

        jLabel1 = new javax.swing.JLabel();
        buttonAceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPaneNombreServicio = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        buttonSalir = new javax.swing.JButton();
        buttonAtras = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(690, 435));

        jLabel1.setText("Ingrese el nombre del nuevo Servicio y haga click en \"Aceptar\".");

        buttonAceptar.setText("Aceptar");
        buttonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(textPaneNombreServicio);

        jLabel2.setText("Nombre del Servicio");

        buttonSalir.setText("Salir");
        buttonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalirActionPerformed(evt);
            }
        });

        buttonAtras.setText("Atras");
        buttonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(buttonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonAtras)
                .addGap(35, 35, 35)
                .addComponent(buttonSalir)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(buttonAceptar)
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSalir)
                    .addComponent(buttonAtras))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_buttonSalirActionPerformed

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarActionPerformed
        // TODO add your handling code here:
        String nombreServicio = textPaneNombreServicio.getText();
        String error = "";
        boolean ok1 = (!nombreServicio.isEmpty());   
        boolean ok2 = ((ok1) && (ctrlProductos.idServicioDisponible(nombreServicio)));
            if (ok2){
                DTMinServicio dtmServicio = new DTMinServicio(proveedor, nombreServicio);
                ctrlProductos.seleccionarServicio(dtmServicio);
                AltaDeServicio4 as4 = new AltaDeServicio4(this, ctrlProductos);
                getContentPane().add(as4, BorderLayout.CENTER);
                as4.setBounds(10, 10, 100, 100);
                this.setVisible(false);
                as4.setVisible(true);
                getParent().add(as4); 
            }
            else {
                 if (!ok1) error = "Por favor ingrese el nombre del Servicio.";
                 else if(!ok2) error ="Ya existe un Servicio con ese nombre.";
                JOptionPane.showMessageDialog(this, "Error! ", "Alta de Servicio", JOptionPane.INFORMATION_MESSAGE); 
            }
    }//GEN-LAST:event_buttonAceptarActionPerformed

    private void buttonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtrasActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.padre.setVisible(true);
    }//GEN-LAST:event_buttonAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAceptar;
    private javax.swing.JButton buttonAtras;
    private javax.swing.JButton buttonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane textPaneNombreServicio;
    // End of variables declaration//GEN-END:variables
}
