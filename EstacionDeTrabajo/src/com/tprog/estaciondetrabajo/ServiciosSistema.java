/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTServicio;
import com.tprog.logica.interfaces.ICtrlProductos;
import java.awt.Image;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ServiciosSistema extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReservasCliente
     *
     * @param servicios
     * @param ctrlProductos
     * @param padre
     */
    public ServiciosSistema(VerInformacionDeServicio padre, Set<DTMinServicio> servicios, ICtrlProductos ctrlProductos) {
        this.padre = padre;
        this.servicios = servicios;
        this.ctrlProductos = ctrlProductos;
        initComponents();
        //construyo lista para la interfaz usando el set
        for (DTMinServicio dt : servicios) {
            String servicioActual = dt.getIdServicio();
            if (!listaServicios.contains(servicioActual)) {
                listaServicios.add(dt.getIdServicio());
            }
        }
        comboboxImagenes.setEnabled(false);
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
        panelUsuario = new javax.swing.JScrollPane();
        detalleServicio = new javax.swing.JTextArea();
        botonAtras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comboboxImagenes = new javax.swing.JComboBox(modelComboBox);
        jLabel2 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setTitle("Ver Información de Servicio");
        setPreferredSize(new java.awt.Dimension(640, 480));
        setVisible(true);
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
        getContentPane().add(listaServiciosInterfaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 418, -1));

        detalleServicio.setEditable(false);
        detalleServicio.setColumns(20);
        detalleServicio.setLineWrap(true);
        detalleServicio.setRows(5);
        detalleServicio.setWrapStyleWord(true);
        panelUsuario.setViewportView(detalleServicio);

        getContentPane().add(panelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 269, 230));

        botonAtras.setText("< Atras");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(botonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, -1, -1));

        jLabel1.setText("<html>Seleccione algun servicio del sistema para ver su información</html>");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));
        getContentPane().add(comboboxImagenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 190, 130));

        jLabel2.setText("<html> Imágenes del servicio </html>");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaServiciosInterfazInterfazComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_listaServiciosInterfazInterfazComponentAdded

    }//GEN-LAST:event_listaServiciosInterfazInterfazComponentAdded

    private void listaServiciosInterfazItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listaServiciosInterfazItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listaServiciosInterfazItemStateChanged

    private void listaServiciosInterfazInterfazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaServiciosInterfazInterfazActionPerformed
        String servicio = (String) listaServiciosInterfaz.getSelectedItem();
        if (servicio != null) {
            //buscar servicio
            DTMinServicio dt = null;
            Iterator it = servicios.iterator();
            boolean found = false;
            while (it.hasNext() && !found) {
                DTMinServicio tmp = (DTMinServicio) it.next();
                if (tmp.getIdServicio().equals(servicio)) {
                    dt = tmp; //es imposible que dt sea null al final del loop
                }
            }
            ctrlProductos.seleccionarServicio(dt);
            DTServicio dtServicio = ctrlProductos.infoServicio();
            //imagenes
            detalleServicio.setVisible(true);
            detalleServicio.setText(dtServicio.toString());
            modelComboBox.clear();
            comboboxImagenes.setSelectedItem(null);
            Set<String> imagenes = dtServicio.getImagenes();
            for (String ruta : imagenes) {
                try {
                    //obtengo archivo desde ruta
                    File f = new File(ruta);
                    //creo imagen
                    Image img = ImageIO.read(f);
                    //redimensiono para que entre en la JLabel
                    Image dimg = img.getScaledInstance(comboboxImagenes.getWidth(), comboboxImagenes.getWidth(), Image.SCALE_SMOOTH);
                    //armo el ImageIcon
                    ImageIcon imageIcon = new ImageIcon(dimg);
                    imageIcon.setDescription(ruta);
                    //lo asocio a la JLabel
                    modelComboBox.add(imageIcon);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    break;
                }
            }
            if (imagenes.size() > 0) {
                comboboxImagenes.setEnabled(true);
            } else {
                comboboxImagenes.setEnabled(false);
            }
            comboboxImagenes.updateUI();
        }
    }//GEN-LAST:event_listaServiciosInterfazInterfazActionPerformed

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        super.dispose();
        padre.setVisible(true);
    }//GEN-LAST:event_botonAtrasActionPerformed

    @Override
    public void dispose() {
        padre.dispose();
        super.dispose();
    }

    Vector<ImageIcon> modelComboBox = new Vector<>();
    ICtrlProductos ctrlProductos;
    Set<DTMinServicio> servicios;
    VerInformacionDeServicio padre;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JComboBox comboboxImagenes;
    private javax.swing.JTextArea detalleServicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox listaServiciosInterfaz;
    private Vector<String> listaServicios = new Vector<>();
    private javax.swing.JScrollPane panelUsuario;
    // End of variables declaration//GEN-END:variables
}
