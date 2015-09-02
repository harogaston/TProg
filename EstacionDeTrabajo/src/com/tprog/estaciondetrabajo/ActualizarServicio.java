/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.interfaces.Fabrica;
import com.tprog.logica.interfaces.ICtrlProductos;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author marccio
 */
public class ActualizarServicio extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReservasCliente
     */
    public ActualizarServicio() {
        initComponents();
        BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
        for (MouseListener listener : basicInternalFrameUI.getNorthPane().getMouseListeners()) {
            basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
        }        
    }
    
    void cargarDatos() {
        Fabrica f = Fabrica.getInstance();
        ctrlProductos = f.getICtrlProductos();
        //listaClientes
        servicios = ctrlProductos.listarServicios();
        //construyo un vector con la informacion a mostrar, porque
        //el comboBox solo funciona con Vector o List
        if (servicios != null) {
            for (DTMinServicio dt : servicios) {
                listaServicios.add(dt.getIdServicio());
            }
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

        listaServiciosInterfaz = new javax.swing.JComboBox(listaServicios);
        botonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botonModificar = new javax.swing.JButton();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(690, 435));
        setVisible(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaServiciosInterfaz.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                listaServiciosInterfazInterfazComponentAdded(evt);
            }
        });
        listaServiciosInterfaz.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listaServiciosInterfazItemStateChanged(evt);
            }
        });
        listaServiciosInterfaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaServiciosInterfazInterfazActionPerformed(evt);
            }
        });
        getContentPane().add(listaServiciosInterfaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 418, -1));

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, -1, -1));

        jLabel1.setText("<html>Seleccione algun servicio del sistema para modificar sus datos</html>");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        botonModificar.setText("Modificar");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        getContentPane().add(botonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaServiciosInterfazInterfazComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_listaServiciosInterfazInterfazComponentAdded

    }//GEN-LAST:event_listaServiciosInterfazInterfazComponentAdded

    private void listaServiciosInterfazItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listaServiciosInterfazItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listaServiciosInterfazItemStateChanged

    DTMinServicio buscarDTMinServicio(String id) {
        DTMinServicio dt = null;
        Iterator it = servicios.iterator();
        boolean found = false;
        while (it.hasNext() && !found) {
            DTMinServicio tmp = (DTMinServicio) it.next();
            if (tmp.getIdServicio().equals(id))
                dt = tmp; //es imposible que dt sea null al final del loop
        }
        return dt;
    }
    
    private void listaServiciosInterfazInterfazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaServiciosInterfazInterfazActionPerformed
        String servicioSeleccionado = (String) listaServiciosInterfaz.getSelectedItem();
        if (servicioSeleccionado != null) {
            DTMinServicio dt = buscarDTMinServicio(servicioSeleccionado);
            ctrlProductos.seleccionarServicio(dt);
        }
    }//GEN-LAST:event_listaServiciosInterfazInterfazActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        cargarDatos();
    }//GEN-LAST:event_formComponentShown

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        listaServicios.clear();
        servicios = null;
        listaServiciosInterfaz.setSelectedItem(null);
    }//GEN-LAST:event_formComponentHidden

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        /*
        String reservaSeleccionada = (String) listaServiciosInterfaz.getSelectedItem();
        if (reservaSeleccionada != null) {
            ctrlProductos.eliminarReserva();
            JOptionPane.showMessageDialog(this, "La reserva fue eliminada exitosamente", "Cancelación de Reserva", JOptionPane.INFORMATION_MESSAGE);            
        }
        */
        String cliente = (String) listaServiciosInterfaz.getSelectedItem();
        if (cliente != null) {
            ModificacionServicio m = new ModificacionServicio(this, ctrlProductos.infoServicio(), ctrlProductos);
            getContentPane().add(m, BorderLayout.CENTER);
            m.setBounds(10, 10, 100, 100);
            this.setVisible(false);
            m.setVisible(true);
            getParent().add(m);
        }        
    }//GEN-LAST:event_botonModificarActionPerformed

    ICtrlProductos ctrlProductos;
    Set<DTMinServicio> servicios;
    VerInformacionDeCliente padre;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonModificar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox listaServiciosInterfaz;
    private Vector<String> listaServicios = new Vector<>();
    // End of variables declaration//GEN-END:variables
}
