/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTCliente;
import com.tprog.logica.dt.DTMinCliente;
import com.tprog.logica.dt.DTMinReserva;
import com.tprog.logica.interfaces.Fabrica;
import com.tprog.logica.interfaces.ICtrlReservas;
import com.tprog.logica.interfaces.ICtrlUsuarios;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author marccio.silva
 */
public class RealizarReserva1 extends javax.swing.JInternalFrame {

	/**
	 * Creates new form VerInformacionDeCliente
	 */
	public RealizarReserva1() {
		setTitle("Realizar Reserva");
		initComponents();
		BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
		for (MouseListener listener : basicInternalFrameUI.getNorthPane().getMouseListeners()) {
			basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
		}
	}

	void cargarDatos() throws Exception {
		//pedir controlador
		Fabrica f = Fabrica.getInstance();
		ctrlUsuarios = f.getICtrlUsuarios();
		ctrlReservas = f.getICtrlReservas();
		//listaClientes
                try{
                    Set<DTMinCliente> setClientes = ctrlUsuarios.listarClientes();
                    if (setClientes != null) {
                            for (DTMinCliente dt : setClientes) {
                                    listaClientes.add(dt.getNickname());
                            }
                    }                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "No hay clientes en el sistema", "Error", JOptionPane.ERROR_MESSAGE);
                    this.dispose();
                }
        //construyo un vector con la informacion a mostrar, porque
		//el comboBox solo funciona con Vector o List

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabInfo = new javax.swing.JPanel();
        botonSalir = new javax.swing.JButton();
        listaClientesInterfaz = new javax.swing.JComboBox(listaClientes);
        label = new javax.swing.JLabel();
        imagenUsuario = new javax.swing.JLabel();
        panelUsuario = new javax.swing.JScrollPane();
        detalleUsuario = new javax.swing.JTextArea();
        buttonSiguiente = new javax.swing.JButton();

        setBorder(null);
        setToolTipText("");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

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
        listaClientesInterfaz.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listaClientesInterfazItemStateChanged(evt);
            }
        });
        listaClientesInterfaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaClientesInterfazInterfazActionPerformed(evt);
            }
        });

        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Seleccione el Cliente que desea realizar la Reserva.");

        detalleUsuario.setEditable(false);
        detalleUsuario.setColumns(20);
        detalleUsuario.setLineWrap(true);
        detalleUsuario.setRows(5);
        detalleUsuario.setWrapStyleWord(true);
        panelUsuario.setViewportView(detalleUsuario);

        buttonSiguiente.setText("Siguiente");
        buttonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabInfoLayout = new javax.swing.GroupLayout(tabInfo);
        tabInfo.setLayout(tabInfoLayout);
        tabInfoLayout.setHorizontalGroup(
            tabInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabInfoLayout.createSequentialGroup()
                .addGroup(tabInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabInfoLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabInfoLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(tabInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabInfoLayout.createSequentialGroup()
                                .addComponent(imagenUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(listaClientesInterfaz, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tabInfoLayout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(buttonSiguiente)
                        .addGap(35, 35, 35)
                        .addComponent(botonSalir)))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        tabInfoLayout.setVerticalGroup(
            tabInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabInfoLayout.createSequentialGroup()
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(listaClientesInterfaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tabInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagenUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonSalir)
                    .addComponent(buttonSiguiente))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        label.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(tabInfo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
		try {
			//pido de nuevo los datos en caso de que hayan cambiado
			cargarDatos();
		} catch (Exception ex) {
			Logger.getLogger(RealizarReserva1.class.getName()).log(Level.SEVERE, null, ex);
		}
    }//GEN-LAST:event_formComponentShown

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
		listaClientes.clear();
		reservas = null;
		imagenUsuario.setIcon(null);
		listaClientesInterfaz.setSelectedItem(null);
		detalleUsuario.setText("");
		detalleUsuario.setVisible(false);
    }//GEN-LAST:event_formComponentHidden

    private void listaClientesInterfazInterfazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaClientesInterfazInterfazActionPerformed
		//seleccionarCliente
		String cliente = (String) listaClientesInterfaz.getSelectedItem();
		if (cliente != null) {
			ctrlUsuarios.seleccionarCliente(cliente);
			//muestro Text Area para la información del cliente
			detalleUsuario.setVisible(true);
			try {
				DTCliente dt = ctrlUsuarios.infoCliente();
				detalleUsuario.setText(dt.toString());
                                //cargar imagen
                                File f = new File(dt.getImagen());
				Image img = ImageIO.read(f);
				Image dimg = img.getScaledInstance(imagenUsuario.getWidth(), imagenUsuario.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageIcon = new ImageIcon(dimg);
				imagenUsuario.setIcon(imageIcon);
                                //obtener reservas
				reservas = dt.getReservas();
				//cargo la lista de reservas del usuario acá, y cuando se pidan las reservas se muestran
			} catch (Exception ex) {
				Logger.getLogger(RealizarReserva1.class.getName()).log(Level.SEVERE, null, ex);
				System.out.println(ex.getMessage());
			}

		}
    }//GEN-LAST:event_listaClientesInterfazInterfazActionPerformed

    private void listaClientesInterfazInterfazComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_listaClientesInterfazInterfazComponentAdded

    }//GEN-LAST:event_listaClientesInterfazInterfazComponentAdded

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
		this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void listaClientesInterfazItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listaClientesInterfazItemStateChanged
		// TODO add your handling code here:
    }//GEN-LAST:event_listaClientesInterfazItemStateChanged

    private void buttonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSiguienteActionPerformed
		String cliente = (String) listaClientesInterfaz.getSelectedItem();
		if (cliente != null) {
			ctrlReservas.seleccionarCliente(cliente);
			RealizarReserva2 rr2 = new RealizarReserva2(this, ctrlUsuarios, ctrlReservas);
			getContentPane().add(rr2, BorderLayout.CENTER);
			rr2.setBounds(10, 10, 100, 100);
			this.setVisible(false);
			rr2.setVisible(true);
			getParent().add(rr2);
		}
                else{
                    JOptionPane.showMessageDialog(this, "Seleccione un cliente por favor.", "Realizar Reserva", JOptionPane.INFORMATION_MESSAGE);
                }
    }//GEN-LAST:event_buttonSiguienteActionPerformed
	ICtrlReservas ctrlReservas;
	Set<DTMinReserva> reservas;
	ICtrlUsuarios ctrlUsuarios;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton buttonSiguiente;
    private javax.swing.JTextArea detalleUsuario;
    private javax.swing.JLabel imagenUsuario;
    private javax.swing.JLabel label;
    private javax.swing.JComboBox listaClientesInterfaz;
    private Vector<String> listaClientes = new Vector<>();
    private javax.swing.JScrollPane panelUsuario;
    private javax.swing.JPanel tabInfo;
    // End of variables declaration//GEN-END:variables
}
