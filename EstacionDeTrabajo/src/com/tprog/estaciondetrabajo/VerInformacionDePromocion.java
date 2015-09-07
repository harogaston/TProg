/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTMinPromocion;
import com.tprog.logica.dt.DTMinReserva;
import com.tprog.logica.dt.DTPromocion;
import com.tprog.logica.interfaces.ICtrlProductos;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import javax.swing.JOptionPane;

public class VerInformacionDePromocion extends javax.swing.JInternalFrame {

    /**
     * Creates new form VerInformacionDeCliente
     */
    public VerInformacionDePromocion(ICtrlProductos ctrlProductos) {
        this.ctrlProductos = ctrlProductos;
        initComponents();
    }

    void cargarDatos() {
        setPromociones = ctrlProductos.listarPromociones();
        //construyo un vector con la informacion a mostrar, porque
        //el comboBox solo funciona con Vector o List
        if (!setPromociones.isEmpty()) {
            for (DTMinPromocion promocion : setPromociones) {
                listaPromociones.add(promocion.getIdPromocion());
            }
            listaPromociones.sort(null);
        } else {
            JOptionPane.showMessageDialog(this, "No hay promociones en el sistema.", "Error", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
		getRootPane().setDefaultButton(botonServicios);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listaPromocionesInterfaz = new javax.swing.JComboBox(listaPromociones);
        label = new javax.swing.JLabel();
        botonServicios = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        detallePromocion = new javax.swing.JTextArea();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setTitle("Ver Información de Promoción");
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

        listaPromocionesInterfaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaPromocionesInterfazInterfazActionPerformed(evt);
            }
        });
        getContentPane().add(listaPromocionesInterfaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 270, -1));

        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Seleccione una promocion del Sistema, y haga click en 'Ver Servicios'");
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 500, 20));
        label.getAccessibleContext().setAccessibleDescription("");

        botonServicios.setText("Ver servicios");
        botonServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonServiciosActionPerformed(evt);
            }
        });
        getContentPane().add(botonServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 130, -1));

        detallePromocion.setColumns(20);
        detallePromocion.setRows(5);
        jScrollPane1.setViewportView(detallePromocion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        //pido de nuevo los datos en caso de que hayan cambiado
        cargarDatos();
    }//GEN-LAST:event_formComponentShown

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        listaPromociones.clear();
        servicios = null;
        listaPromocionesInterfaz.setSelectedItem(null);
    }//GEN-LAST:event_formComponentHidden

    DTMinPromocion buscarDTMinPromocion(String id) {
        DTMinPromocion dt = null;
        Iterator it = setPromociones.iterator();
        boolean found = false;
        while (it.hasNext() && !found) {
            DTMinPromocion tmp = (DTMinPromocion) it.next();
            if (tmp.getIdPromocion().equals(id)) {
                dt = tmp; //es imposible que dt sea null al final del loop
            }
        }
        return dt;
    }

    private void listaPromocionesInterfazInterfazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaPromocionesInterfazInterfazActionPerformed
        //seleccionarCliente
        String promocion = (String) listaPromocionesInterfaz.getSelectedItem();
        if (promocion != null) {
            DTMinPromocion dt = buscarDTMinPromocion(promocion);
            ctrlProductos.seleccionarPromocion(dt);
            //System.out.println(dt.getNicknameP());
            detallePromocion.setVisible(true);
            dtPromocionActual = ctrlProductos.infoPromocion();
            detallePromocion.setText(dt.toString());
        }
    }//GEN-LAST:event_listaPromocionesInterfazInterfazActionPerformed

    private void botonServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonServiciosActionPerformed
        String promocion = (String) listaPromocionesInterfaz.getSelectedItem();
        if (promocion != null) {
            ServiciosPromocion s = new ServiciosPromocion(this, dtPromocionActual.getServicios(), ctrlProductos);
            this.setVisible(false);
            getParent().add(s);
            s.setLocation(this.getLocation());
            s.setVisible(true);
        }
    }//GEN-LAST:event_botonServiciosActionPerformed

    DTPromocion dtPromocionActual;
    Set<DTMinPromocion> setPromociones;
    Set<DTMinReserva> servicios;
    ICtrlProductos ctrlProductos;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonServicios;
    private javax.swing.JTextArea detallePromocion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JComboBox listaPromocionesInterfaz;
    private Vector<String> listaPromociones = new Vector<>();
    // End of variables declaration//GEN-END:variables
}
