/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTMinReserva;
import com.tprog.logica.dt.EstadoReserva;
import com.tprog.logica.interfaces.ICtrlReservas;
import java.util.Set;
import java.util.Vector;
import javax.swing.JOptionPane;

public class ActualizarEstadoReserva extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReservasCliente
     */
    public ActualizarEstadoReserva(ICtrlReservas ctrlReservas) {
        this.ctrlReservas = ctrlReservas;
        initComponents();
        cargarDatos();
		getRootPane().setDefaultButton(botonCambiarEstado);
    }

    @SuppressWarnings("unchecked")
    private void cargarDatos() {
        Set<DTMinReserva> setReservas = ctrlReservas.listarReservas();
		listaReservas.clear();
		listaReservasInterfaz.setSelectedItem(null);
        //construyo un vector con la informacion a mostrar, porque
        //el comboBox solo funciona con Vector o List
        if (!setReservas.isEmpty()) {
            for (DTMinReserva dt : setReservas) {
                listaReservas.add(Integer.toString(dt.getIdReserva()));
            }
            listaReservas.sort(null);
            listaReservasInterfaz.setSelectedItem(null);
        } else {
            //JOptionPane.showMessageDialog(this, "No existen reservas en el sistema", "Información", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
//        this.updateUI();
    }
	
	private void cargarDatos2() {
        Set<DTMinReserva> setReservas = ctrlReservas.listarReservas();
        //construyo un vector con la informacion a mostrar, porque
        //el comboBox solo funciona con Vector o List
        if (!setReservas.isEmpty()) {
            for (DTMinReserva dt : setReservas) {
                listaReservas.add(Integer.toString(dt.getIdReserva()));
            }
            listaReservas.sort(null);
            listaReservasInterfaz.setSelectedItem(null);
        }
		else {
			JOptionPane.showMessageDialog(this, "No existen reservas en el sistema", "Información", JOptionPane.INFORMATION_MESSAGE);
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

        listaReservasInterfaz = new javax.swing.JComboBox<String>(listaReservas);
        jLabel1 = new javax.swing.JLabel();
        botonCambiarEstado = new javax.swing.JButton();
        listaEstados = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabelEstadoReservaSeleccionada = new javax.swing.JLabel();
        jLabelMensajeNoModificarEstado = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setTitle("Actualizar Estado de Reserva");
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

        listaReservasInterfaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaReservasInterfazInterfazActionPerformed(evt);
            }
        });
        getContentPane().add(listaReservasInterfaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 350, -1));

        jLabel1.setText("<html>Seleccione alguna reserva del sistema para cambiar su estado</html>");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));

        botonCambiarEstado.setText("Cambiar estado");
        botonCambiarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarEstadoActionPerformed(evt);
            }
        });
        getContentPane().add(botonCambiarEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, -1, -1));

        listaEstados.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cancelada", "Facturada", "Pagada", "Registrada" }));
        listaEstados.setSelectedItem(null);
        listaEstados.setEnabled(false);
        getContentPane().add(listaEstados, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 190, -1));

        jLabel2.setText("<html>Escoja el nuevo estado</html>");
        jLabel2.setEnabled(false);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        jLabelEstadoReservaSeleccionada.setVisible(false);
        jLabelEstadoReservaSeleccionada.setText("La reserva se encuentra en estado: ");
        getContentPane().add(jLabelEstadoReservaSeleccionada, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 440, -1));

        jLabelMensajeNoModificarEstado.setText("Su estado no puede ser modificado.");
        jLabelMensajeNoModificarEstado.setVisible(false);
        getContentPane().add(jLabelMensajeNoModificarEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaReservasInterfazInterfazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaReservasInterfazInterfazActionPerformed
        String reservaSeleccionada = (String) listaReservasInterfaz.getSelectedItem();
        if (reservaSeleccionada != null) {
            int reserva = Integer.parseInt(reservaSeleccionada);
            ctrlReservas.seleccionarReserva(reserva);
            estadoReservaSeleccionada = ctrlReservas.getEstadoReserva();
            jLabelEstadoReservaSeleccionada.setText("La reserva se encuentra en estado: " + estadoReservaSeleccionada.toString());
            jLabelEstadoReservaSeleccionada.setVisible(true);
            listaEstados.setSelectedItem(null);

            switch (estadoReservaSeleccionada) {
                case Registrada:
                case Pagada:
                    jLabel2.setEnabled(true);
                    listaEstados.setEnabled(true);
                    jLabelMensajeNoModificarEstado.setVisible(false);
                    break;
                case Cancelada:
                case Facturada:
                    jLabel2.setEnabled(false);
                    listaEstados.setEnabled(false);
                    jLabelMensajeNoModificarEstado.setVisible(true);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }//GEN-LAST:event_listaReservasInterfazInterfazActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        cargarDatos2();
    }//GEN-LAST:event_formComponentShown

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        listaReservas.clear();
        reservas = null;
        listaReservasInterfaz.setSelectedItem(null);
        jLabelEstadoReservaSeleccionada.setVisible(false);
        jLabelMensajeNoModificarEstado.setVisible(false);
    }//GEN-LAST:event_formComponentHidden

    private void botonCambiarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarEstadoActionPerformed
        // Leo la reserva y el estado seleccionados
        String reservaSeleccionada = (String) listaReservasInterfaz.getSelectedItem();
        String estadoNuevoStr = (String) listaEstados.getSelectedItem();

        // Si se han seleccionado ambos
        if (reservaSeleccionada != null && estadoNuevoStr != null) {
            //Casteo el nuevo estado a algo de tipo EstadoReserva
            EstadoReserva estadoNuevo;
            switch (estadoNuevoStr) {
                case "Facturada": {
                    estadoNuevo = EstadoReserva.Facturada;
                    break;
                }
                case "Pagada": {
                    estadoNuevo = EstadoReserva.Pagada;
                    break;
                }
                case "Cancelada": {
                    estadoNuevo = EstadoReserva.Cancelada;
                    break;
                }
                case "Registrada": {
                    estadoNuevo = EstadoReserva.Registrada;
                    break;
                }
                default:
                    throw new IllegalArgumentException();
            }

            // Ejecuto acción de acuerdo al estado seleccionado
            switch (estadoReservaSeleccionada) {
                case Registrada:
                    if (estadoNuevo == EstadoReserva.Cancelada || estadoNuevo == EstadoReserva.Pagada) {
                        ctrlReservas.cambiarEstadoReserva(estadoNuevo);
                        JOptionPane.showMessageDialog(this, "Estado cambiado con éxito", "Operación realizada", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "La reserva esta " + estadoReservaSeleccionada.toString().toLowerCase() + ", su estado solo puede cambiarse a Cancelada o Pagada", "Estado no cambiado", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case Pagada:
                    if (estadoNuevo == EstadoReserva.Facturada) {
                        ctrlReservas.cambiarEstadoReserva(estadoNuevo);
                        JOptionPane.showMessageDialog(this, "Estado cambiado con éxito", "Operación realizada", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "La reserva esta " + estadoReservaSeleccionada.toString().toLowerCase() + ", su estado solo puede cambiarse a Facturada", "Estado no cambiado", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (reservaSeleccionada != null) {
            JOptionPane.showMessageDialog(this, "Escoja un estado nuevo", "Estado no seleccionado", JOptionPane.INFORMATION_MESSAGE);
        } else if (estadoNuevoStr != null) {
            JOptionPane.showMessageDialog(this, "Escoja una reserva", "Reserva no seleccionada", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Escoja una reserva y un estado nuevo", "Estado y reserva no seleccionados", JOptionPane.INFORMATION_MESSAGE);
        }
		listaReservasInterfaz.setSelectedItem(null);
		listaEstados.setSelectedItem(null);
    }//GEN-LAST:event_botonCambiarEstadoActionPerformed

    ICtrlReservas ctrlReservas;
    Set<DTMinReserva> reservas;
    EstadoReserva estadoReservaSeleccionada;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCambiarEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelEstadoReservaSeleccionada;
    private javax.swing.JLabel jLabelMensajeNoModificarEstado;
    private javax.swing.JComboBox listaEstados;
    private javax.swing.JComboBox listaReservasInterfaz;
    private Vector<String> listaReservas = new Vector<>();
    // End of variables declaration//GEN-END:variables
}
