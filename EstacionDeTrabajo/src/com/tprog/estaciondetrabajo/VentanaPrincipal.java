/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.estaciondetrabajo;

import com.tprog.estaciondetrabajo.carga.CtrlCarga;
import com.tprog.logica.interfaces.Fabrica;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends javax.swing.JFrame {

	public VentanaPrincipal() {
		//inicializacion autogenerada
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

        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        desktop = new javax.swing.JDesktopPane(){
            private Image image;
            {
                try {
                    File dir = new File(".");
                    String directorioImagenes = dir.getCanonicalPath();
                    String imagen = directorioImagenes + "/imagenes/background.jpg";
                    File f = new File(imagen);
                    image = ImageIO.read(f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        menu = new javax.swing.JMenuBar();
        menuRegistros = new javax.swing.JMenu();
        menuItemAltaUsuario = new javax.swing.JMenuItem();
        menuItemAltaCategoria = new javax.swing.JMenuItem();
        menuItemAltaServicio = new javax.swing.JMenuItem();
        menuItemAltaPromocion = new javax.swing.JMenuItem();
        menuItemActualizarServicio = new javax.swing.JMenuItem();
        menuItemRealizarReserva = new javax.swing.JMenuItem();
        menuItemActualizarEstadoReserva = new javax.swing.JMenuItem();
        cargarDatos = new javax.swing.JMenuItem();
        menuConsultas = new javax.swing.JMenu();
        menuItemVerInfoCliente = new javax.swing.JMenuItem();
        menuItemVerInfoProveedor = new javax.swing.JMenuItem();
        menuItemVerInfoServicio = new javax.swing.JMenuItem();
        menuItemVerInfoPromocion = new javax.swing.JMenuItem();
        menuItemVerInfoReserva = new javax.swing.JMenuItem();
        menuBorrados = new javax.swing.JMenu();
        menuItemCancelarReserva = new javax.swing.JMenuItem();

        jMenuItem6.setText("jMenuItem6");

        jMenuItem7.setText("jMenuItem7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Help4Traveling Administrador");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("Venatana Principal"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1024, 768));
        setResizable(false);
        getContentPane().add(desktop, java.awt.BorderLayout.CENTER);

        menu.setMaximumSize(new java.awt.Dimension(480, 20));
        menu.setMinimumSize(new java.awt.Dimension(240, 20));
        menu.setPreferredSize(new java.awt.Dimension(240, 20));

        menuRegistros.setText("Registros");

        menuItemAltaUsuario.setText("Alta de Usuario");
        menuItemAltaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAltaUsuarioActionPerformed(evt);
            }
        });
        menuRegistros.add(menuItemAltaUsuario);

        menuItemAltaCategoria.setText("Alta de Categoría");
        menuItemAltaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAltaCategoriaActionPerformed(evt);
            }
        });
        menuRegistros.add(menuItemAltaCategoria);

        menuItemAltaServicio.setText("Alta de Servicio");
        menuItemAltaServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAltaServicioActionPerformed(evt);
            }
        });
        menuRegistros.add(menuItemAltaServicio);

        menuItemAltaPromocion.setText("Alta de Promoción");
        menuItemAltaPromocion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAltaPromocionActionPerformed(evt);
            }
        });
        menuRegistros.add(menuItemAltaPromocion);

        menuItemActualizarServicio.setText("Actualizar Servicio");
        menuItemActualizarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemActualizarServicioActionPerformed(evt);
            }
        });
        menuRegistros.add(menuItemActualizarServicio);

        menuItemRealizarReserva.setText("Realizar Reserva");
        menuItemRealizarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRealizarReservaActionPerformed(evt);
            }
        });
        menuRegistros.add(menuItemRealizarReserva);

        menuItemActualizarEstadoReserva.setText("Actualizar Estado Reserva");
        menuItemActualizarEstadoReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemActualizarEstadoReservaActionPerformed(evt);
            }
        });
        menuRegistros.add(menuItemActualizarEstadoReserva);

        cargarDatos.setText("Cargar datos");
        cargarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarDatosActionPerformed(evt);
            }
        });
        menuRegistros.add(cargarDatos);

        menu.add(menuRegistros);

        menuConsultas.setText("Consultas");

        menuItemVerInfoCliente.setText("Ver Información de Cliente");
        menuItemVerInfoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVerInfoClienteActionPerformed(evt);
            }
        });
        menuConsultas.add(menuItemVerInfoCliente);

        menuItemVerInfoProveedor.setText("Ver Información de Proveedor");
        menuItemVerInfoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVerInfoProveedorActionPerformed(evt);
            }
        });
        menuConsultas.add(menuItemVerInfoProveedor);

        menuItemVerInfoServicio.setText("Ver Información de Servicio");
        menuItemVerInfoServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVerInfoServicioActionPerformed(evt);
            }
        });
        menuConsultas.add(menuItemVerInfoServicio);

        menuItemVerInfoPromocion.setText("Ver Información de Promoción");
        menuItemVerInfoPromocion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVerInfoPromocionActionPerformed(evt);
            }
        });
        menuConsultas.add(menuItemVerInfoPromocion);

        menuItemVerInfoReserva.setText("Ver Información de Reserva");
        menuItemVerInfoReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVerInfoReservaActionPerformed(evt);
            }
        });
        menuConsultas.add(menuItemVerInfoReserva);

        menu.add(menuConsultas);

        menuBorrados.setText("Borrados");

        menuItemCancelarReserva.setText("Cancelar Reserva");
        menuItemCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCancelarReservaActionPerformed(evt);
            }
        });
        menuBorrados.add(menuItemCancelarReserva);

        menu.add(menuBorrados);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

	public void closeAllInternalFrames() {

		JInternalFrame fram[] = this.desktop.getAllFrames();
		for (int i = 0; i < fram.length; i++) {
			fram[i].dispose();
		}
	}

	private void center(JInternalFrame v) {
		// Limpio jDesktop
		closeAllInternalFrames();

		// La ubico y le doy foco
		desktop.add(v);
		Dimension desktopSize = desktop.getSize();
		Dimension jInternalFrameSize = v.getSize();
		v.setLocation((desktopSize.width - jInternalFrameSize.width) / 2, (desktopSize.height - jInternalFrameSize.height) / 2);
		try {
			v.setSelected(true);
		} catch (PropertyVetoException ex) {
			Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
		}
		v.setVisible(true);
	}

    private void menuItemAltaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAltaUsuarioActionPerformed
		AltaDeUsuario1 altaDeUsuario = new AltaDeUsuario1(fabrica.getICtrlUsuarios());
		center(altaDeUsuario);
    }//GEN-LAST:event_menuItemAltaUsuarioActionPerformed

    private void menuItemVerInfoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVerInfoClienteActionPerformed
		VerInformacionDeCliente verInfoCliente = new VerInformacionDeCliente(fabrica.getICtrlUsuarios());
		center(verInfoCliente);
    }//GEN-LAST:event_menuItemVerInfoClienteActionPerformed

    private void menuItemVerInfoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVerInfoProveedorActionPerformed
		VerInformacionDeProveedor verInfoProveedor = new VerInformacionDeProveedor(fabrica.getICtrlUsuarios());
		center(verInfoProveedor);
    }//GEN-LAST:event_menuItemVerInfoProveedorActionPerformed

    private void menuItemVerInfoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVerInfoServicioActionPerformed
		VerInformacionDeServicio verInfoServicio = new VerInformacionDeServicio(fabrica.getICtrlProductos());
		center(verInfoServicio);
    }//GEN-LAST:event_menuItemVerInfoServicioActionPerformed

    private void menuItemVerInfoPromocionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVerInfoPromocionActionPerformed
		VerInformacionDePromocion verInfoPromocion = new VerInformacionDePromocion(fabrica.getICtrlProductos());
		center(verInfoPromocion);
    }//GEN-LAST:event_menuItemVerInfoPromocionActionPerformed

    private void menuItemVerInfoReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVerInfoReservaActionPerformed
		VerInformacionDeReserva verInfoReserva = new VerInformacionDeReserva(fabrica.getICtrlReservas());
		center(verInfoReserva);
    }//GEN-LAST:event_menuItemVerInfoReservaActionPerformed

    private void menuItemCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCancelarReservaActionPerformed
		CancelarReserva cancelarReserva = new CancelarReserva(fabrica.getICtrlReservas());
		center(cancelarReserva);
    }//GEN-LAST:event_menuItemCancelarReservaActionPerformed

    private void menuItemAltaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAltaCategoriaActionPerformed
		AltaCategoria altaCategoria = new AltaCategoria(fabrica.getICtrlProductos());
		center(altaCategoria);
    }//GEN-LAST:event_menuItemAltaCategoriaActionPerformed

    private void menuItemRealizarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRealizarReservaActionPerformed
		RealizarReserva1 realizarReserva = new RealizarReserva1(fabrica.getICtrlUsuarios(), fabrica.getICtrlReservas());
		center(realizarReserva);
    }//GEN-LAST:event_menuItemRealizarReservaActionPerformed

    private void menuItemActualizarEstadoReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemActualizarEstadoReservaActionPerformed
		ActualizarEstadoReserva actualizarEstadoReserva = new ActualizarEstadoReserva(fabrica.getICtrlReservas());
		center(actualizarEstadoReserva);
    }//GEN-LAST:event_menuItemActualizarEstadoReservaActionPerformed

    private void menuItemActualizarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemActualizarServicioActionPerformed
		ActualizarServicio actualizarServicio = new ActualizarServicio(fabrica.getICtrlProductos());
		center(actualizarServicio);
    }//GEN-LAST:event_menuItemActualizarServicioActionPerformed

    private void cargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarDatosActionPerformed
        CtrlCarga ctrl = new CtrlCarga();
        ctrl.cargarDatos();
        JOptionPane.showMessageDialog(desktop, "Datos cargados en el sistema", "Carga de datos", JOptionPane.INFORMATION_MESSAGE);
        cargarDatos.setEnabled(false);
    }//GEN-LAST:event_cargarDatosActionPerformed

	private void menuItemAltaServicioActionPerformed(java.awt.event.ActionEvent evt) {
		AltaDeServicio2 altaDeServicio = new AltaDeServicio2(fabrica.getICtrlUsuarios(), fabrica.getICtrlProductos());
		center(altaDeServicio);
	}

    private void menuItemAltaPromocionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAltaPromocionActionPerformed
        AltaDePromocion altaDePromocion = new AltaDePromocion(fabrica.getICtrlUsuarios(), fabrica.getICtrlProductos());
        center(altaDePromocion);
    }//GEN-LAST:event_menuItemAltaPromocionActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaPrincipal().setVisible(true);
			}
		});
	}

	Fabrica fabrica = Fabrica.getInstance();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cargarDatos;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuBorrados;
    private javax.swing.JMenu menuConsultas;
    private javax.swing.JMenuItem menuItemActualizarEstadoReserva;
    private javax.swing.JMenuItem menuItemActualizarServicio;
    private javax.swing.JMenuItem menuItemAltaCategoria;
    private javax.swing.JMenuItem menuItemAltaPromocion;
    private javax.swing.JMenuItem menuItemAltaServicio;
    private javax.swing.JMenuItem menuItemAltaUsuario;
    private javax.swing.JMenuItem menuItemCancelarReserva;
    private javax.swing.JMenuItem menuItemRealizarReserva;
    private javax.swing.JMenuItem menuItemVerInfoCliente;
    private javax.swing.JMenuItem menuItemVerInfoPromocion;
    private javax.swing.JMenuItem menuItemVerInfoProveedor;
    private javax.swing.JMenuItem menuItemVerInfoReserva;
    private javax.swing.JMenuItem menuItemVerInfoServicio;
    private javax.swing.JMenu menuRegistros;
    // End of variables declaration//GEN-END:variables
}
