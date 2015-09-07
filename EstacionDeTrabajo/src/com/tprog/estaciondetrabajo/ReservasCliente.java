/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTMinReserva;
import com.tprog.logica.dt.DTReserva;
import com.tprog.logica.interfaces.ICtrlUsuarios;
import java.util.Set;
import java.util.Vector;

/**
 *
 * @author marccio
 */
public class ReservasCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReservasCliente
     *
     * @param reservas
     * @param ctrlUsuarios
     * @param padre
     */
    public ReservasCliente(VerInformacionDeCliente padre, Set<DTMinReserva> reservas, ICtrlUsuarios ctrlUsuarios) {
        this.padre = padre;
        this.reservas = reservas;
        this.ctrlUsuarios = ctrlUsuarios;
        initComponents();
        //construyo lista para la interfaz usando el set
        for (DTMinReserva dt : reservas) {
            listaReservas.add(Integer.toString(dt.getIdReserva()));
        }
        listaReservas.sort(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listaReservasInterfaz = new javax.swing.JComboBox(listaReservas);
        panelUsuario = new javax.swing.JScrollPane();
        detalleUsuario = new javax.swing.JTextArea();
        botonAtras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setTitle("Ver Información de Cliente - Reservas");
        setPreferredSize(new java.awt.Dimension(640, 480));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaReservasInterfaz.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                listaReservasInterfazInterfazComponentAdded(evt);
            }
        });
        listaReservasInterfaz.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listaReservasInterfazItemStateChanged(evt);
            }
        });
        listaReservasInterfaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaReservasInterfazInterfazActionPerformed(evt);
            }
        });
        getContentPane().add(listaReservasInterfaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 418, -1));

        detalleUsuario.setEditable(false);
        detalleUsuario.setColumns(20);
        detalleUsuario.setLineWrap(true);
        detalleUsuario.setRows(5);
        detalleUsuario.setWrapStyleWord(true);
        panelUsuario.setViewportView(detalleUsuario);

        getContentPane().add(panelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 269, 210));

        botonAtras.setText("< Atras");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(botonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, -1, -1));

        jLabel1.setText("<html>Seleccione alguna reserva del cliente para ver su información</html>");
        jLabel1.setAlignmentX(0.5F);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaReservasInterfazInterfazComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_listaReservasInterfazInterfazComponentAdded

    }//GEN-LAST:event_listaReservasInterfazInterfazComponentAdded

    private void listaReservasInterfazItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listaReservasInterfazItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listaReservasInterfazItemStateChanged

    private void listaReservasInterfazInterfazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaReservasInterfazInterfazActionPerformed
        String reservaSeleccionada = (String) listaReservasInterfaz.getSelectedItem();
        if (reservaSeleccionada != null) {
            int reserva = Integer.parseInt(reservaSeleccionada);
            ctrlUsuarios.seleccionarReserva(reserva);
            DTReserva dt = ctrlUsuarios.infoReserva();
            detalleUsuario.setVisible(true);
            detalleUsuario.setText(dt.toString()); //imprimir lineas de reserva
        }
    }//GEN-LAST:event_listaReservasInterfazInterfazActionPerformed

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        this.dispose();
        padre.setVisible(true);
    }//GEN-LAST:event_botonAtrasActionPerformed

    ICtrlUsuarios ctrlUsuarios;
    Set<DTMinReserva> reservas;
    VerInformacionDeCliente padre;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JTextArea detalleUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox listaReservasInterfaz;
    private Vector<String> listaReservas = new Vector<>();
    private javax.swing.JScrollPane panelUsuario;
    // End of variables declaration//GEN-END:variables
}
