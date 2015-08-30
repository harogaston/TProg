/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTMinCliente;
import java.awt.Image;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.ImageIcon;

/**
 *
 * @author marccio.silva
 */
public class VerInformacionDeCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form VerInformacionDeCliente
     */
    public VerInformacionDeCliente() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        tabInfo = new javax.swing.JPanel();
        botonSalir = new javax.swing.JButton();
        listaClientesInterfaz = new javax.swing.JComboBox(listaClientes);
        botonMostrarCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        detalleCliente = new javax.swing.JTextArea();
        label = new javax.swing.JLabel();
        imagenUsuario = new javax.swing.JLabel();
        tabReserva = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        listaReservasInterfaz = new javax.swing.JComboBox(listaReservas);
        botonMostrarReserva = new javax.swing.JButton();
        botonSalir1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        detalleReserva = new javax.swing.JTextArea();

        setBorder(null);
        setToolTipText("");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jTabbedPane1.setBorder(null);
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(650, 450));

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        listaClientesInterfaz.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                listaClientesInterfazInterfazComponentAdded(evt);
            }
        });
        listaClientesInterfaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaClientesInterfazInterfazActionPerformed(evt);
            }
        });

        botonMostrarCliente.setText("Mostrar");
        botonMostrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarClienteActionPerformed(evt);
            }
        });

        detalleCliente.setEditable(false);
        detalleCliente.setColumns(20);
        detalleCliente.setLineWrap(true);
        detalleCliente.setRows(5);
        detalleCliente.setWrapStyleWord(true);
        jScrollPane1.setViewportView(detalleCliente);

        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("<html>Seleccione un cliente del Sistema y haga click en 'Mostrar' para ver su información</html>");

        javax.swing.GroupLayout tabInfoLayout = new javax.swing.GroupLayout(tabInfo);
        tabInfo.setLayout(tabInfoLayout);
        tabInfoLayout.setHorizontalGroup(
            tabInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabInfoLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(tabInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonSalir)
                    .addGroup(tabInfoLayout.createSequentialGroup()
                        .addComponent(imagenUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(tabInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tabInfoLayout.createSequentialGroup()
                    .addGroup(tabInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tabInfoLayout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(listaClientesInterfaz, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(botonMostrarCliente))
                        .addGroup(tabInfoLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(91, Short.MAX_VALUE)))
        );
        tabInfoLayout.setVerticalGroup(
            tabInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabInfoLayout.createSequentialGroup()
                .addContainerGap(165, Short.MAX_VALUE)
                .addGroup(tabInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imagenUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(botonSalir)
                .addGap(66, 66, 66))
            .addGroup(tabInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tabInfoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(32, 32, 32)
                    .addGroup(tabInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(listaClientesInterfaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonMostrarCliente))
                    .addContainerGap(245, Short.MAX_VALUE)))
        );

        label.getAccessibleContext().setAccessibleDescription("");

        jTabbedPane1.addTab("Ver información", tabInfo);

        label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setText("<html>Seleccione una reserva del cliente y haga click en 'Mostrar' para ver su información</html>");

        listaReservasInterfaz.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                listaReservasInterfazInterfazComponentAdded(evt);
            }
        });
        listaReservasInterfaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaReservasInterfazInterfazActionPerformed(evt);
            }
        });

        botonMostrarReserva.setText("Mostrar");
        botonMostrarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarReservaActionPerformed(evt);
            }
        });

        botonSalir1.setText("Salir");
        botonSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalir1ActionPerformed(evt);
            }
        });

        detalleReserva.setEditable(false);
        detalleReserva.setColumns(20);
        detalleReserva.setRows(5);
        jScrollPane2.setViewportView(detalleReserva);

        javax.swing.GroupLayout tabReservaLayout = new javax.swing.GroupLayout(tabReserva);
        tabReserva.setLayout(tabReservaLayout);
        tabReservaLayout.setHorizontalGroup(
            tabReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabReservaLayout.createSequentialGroup()
                .addGroup(tabReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(tabReservaLayout.createSequentialGroup()
                            .addGroup(tabReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(tabReservaLayout.createSequentialGroup()
                                    .addGap(44, 44, 44)
                                    .addComponent(listaReservasInterfaz, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonMostrarReserva))
                                .addGroup(tabReservaLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)))
                    .addGroup(tabReservaLayout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(botonSalir1)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        tabReservaLayout.setVerticalGroup(
            tabReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabReservaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(tabReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listaReservasInterfaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonMostrarReserva))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonSalir1)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reservas", tabReserva);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 899, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 462, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        detalleCliente.setText("");
        detalleCliente.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void listaClientesInterfazInterfazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaClientesInterfazInterfazActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaClientesInterfazInterfazActionPerformed

    private void listaClientesInterfazInterfazComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_listaClientesInterfazInterfazComponentAdded
    }//GEN-LAST:event_listaClientesInterfazInterfazComponentAdded

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        //Aca se trae un set de DTMinCliente para agregar al combobox
        hashClientes.clear();
        listaClientes.clear();
        imagenUsuario.setIcon(null);
        //listaClientes.removeAllItems();
        DTMinCliente dt0 = new DTMinCliente("pendorcho64", "juanperez@gmail.com");
        hashClientes.put(dt0.getNickname(), dt0.getEmail());
        DTMinCliente dt1 = new DTMinCliente("12340", "asdf@gmail.com");
        hashClientes.put(dt1.getNickname(), dt1.getEmail());
        DTMinCliente dt2 = new DTMinCliente("12341", "asdfasdf@gmail.com");
        hashClientes.put(dt2.getNickname(), dt2.getEmail());
        DTMinCliente dt3 = new DTMinCliente("12342", "qwer@gmail.com");
        hashClientes.put(dt3.getNickname(), dt3.getEmail());
        DTMinCliente dt4 = new DTMinCliente("12343", "fgd@gmail.com");
        hashClientes.put(dt4.getNickname(), dt4.getEmail());
        DTMinCliente dt5 = new DTMinCliente("12344", "qyu125@gmail.com");
        hashClientes.put(dt5.getNickname(), dt5.getEmail());
        listaClientesInterfaz.updateUI();
        //simulo lo que seria el listarClientes()
        //clientes.put("Pepito", "Pepito es un aventurero, le gusta pagar por travestis y después descuartizarlos/as y tirar las partes en contenedores separados por más de 3 km.");
        //clientes.put("Juan Carlos", "Él es Juan Carlos; el de los pantalones cortos y los huevos largos.");
        //clientes.put("Ramón", "A Ramón le gusta el helado");
        for (Map.Entry<String, String> cliente : hashClientes.entrySet()) {
            listaClientes.add(cliente.getKey());
        } 
    }//GEN-LAST:event_formComponentShown

    private void botonMostrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarClienteActionPerformed
        String cliente = (String) listaClientesInterfaz.getSelectedItem();
        if (cliente != null) {
            detalleCliente.setVisible(true);
            detalleCliente.setText(hashClientes.get(cliente));
            //imagenUsuario.setIcon(new ImageIcon("/home/marccio/Pictures/marco_horando_1.jpg"));
            if (cliente != "pendorcho64")
                imagenUsuario.setIcon(new ImageIcon(VerInformacionDeCliente.class.getResource("imagenes/avatar.jpg")));
            else imagenUsuario.setIcon(new ImageIcon(VerInformacionDeCliente.class.getResource("imagenes/avatar2.jpg")));
            
        }
    }//GEN-LAST:event_botonMostrarClienteActionPerformed

    private void listaReservasInterfazInterfazComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_listaReservasInterfazInterfazComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_listaReservasInterfazInterfazComponentAdded

    private void listaReservasInterfazInterfazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaReservasInterfazInterfazActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaReservasInterfazInterfazActionPerformed

    private void botonSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalir1ActionPerformed
        detalleCliente.setText("");
        detalleCliente.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_botonSalir1ActionPerformed

    private void botonMostrarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarReservaActionPerformed
        String reserva = (String) listaReservasInterfaz.getSelectedItem();
        if (reserva != null) {
            detalleReserva.setVisible(true);
            //detalleCliente.setText(hashClientes.get(cliente));
        }        
    }//GEN-LAST:event_botonMostrarReservaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonMostrarCliente;
    private javax.swing.JButton botonMostrarReserva;
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton botonSalir1;
    private javax.swing.JTextArea detalleCliente;
    private javax.swing.JTextArea detalleReserva;
    private javax.swing.JLabel imagenUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label1;
    private javax.swing.JComboBox listaClientesInterfaz;
    private LinkedHashMap<String, String> hashClientes = new LinkedHashMap<>();
    private Vector<String> listaClientes = new Vector<>();
    private javax.swing.JComboBox listaReservasInterfaz;
    private LinkedHashMap<String, String> hashReservas = new LinkedHashMap<>();
    private Vector<String> listaReservas = new Vector<>();
    private javax.swing.JPanel tabInfo;
    private javax.swing.JPanel tabReserva;
    // End of variables declaration//GEN-END:variables
}
