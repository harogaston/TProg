package tprog.estaciondetrabajo.ui;

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
import tprog.estaciondetrabajo.carga.CtrlCarga;
import tprog.logica.dt.DTFacturaF;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlReservas;

public class VentanaPrincipal extends javax.swing.JFrame {

    public VentanaPrincipal() {
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
                    String directorioImagenes = (new File(".")).getCanonicalPath();
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
        menuAltas = new javax.swing.JMenu();
        menuItemAltaUsuario = new javax.swing.JMenuItem();
        menuItemAltaCategoria = new javax.swing.JMenuItem();
        menuItemAltaServicio = new javax.swing.JMenuItem();
        menuItemAltaPromocion = new javax.swing.JMenuItem();
        menuItemRealizarReserva = new javax.swing.JMenuItem();
        cargarDatos = new javax.swing.JMenuItem();
        menuConsultas = new javax.swing.JMenu();
        menuItemVerInfoCliente = new javax.swing.JMenuItem();
        menuItemVerInfoProveedor = new javax.swing.JMenuItem();
        menuItemVerInfoServicio = new javax.swing.JMenuItem();
        menuItemVerInfoPromocion = new javax.swing.JMenuItem();
        menuItemVerInfoReserva = new javax.swing.JMenuItem();
        menuModificaciones = new javax.swing.JMenu();
        menuItemActualizarEstadoReserva = new javax.swing.JMenuItem();
        menuItemActualizarServicio = new javax.swing.JMenuItem();
        menuItemCancelarReserva = new javax.swing.JMenuItem();

        jMenuItem6.setText("jMenuItem6");

        jMenuItem7.setText("jMenuItem7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Help4Traveling Administrador");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("Venatana Principal"); // NOI18N
        setResizable(false);

        desktop.setPreferredSize(new java.awt.Dimension(1024, 768));
        getContentPane().add(desktop, java.awt.BorderLayout.CENTER);

        menu.setMaximumSize(new java.awt.Dimension(480, 20));
        menu.setMinimumSize(new java.awt.Dimension(240, 20));
        menu.setPreferredSize(new java.awt.Dimension(240, 20));

        menuAltas.setText("Altas");

        menuItemAltaUsuario.setText("Alta de Usuario");
        menuItemAltaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAltaUsuarioActionPerformed(evt);
            }
        });
        menuAltas.add(menuItemAltaUsuario);

        menuItemAltaCategoria.setText("Alta de Categoría");
        menuItemAltaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAltaCategoriaActionPerformed(evt);
            }
        });
        menuAltas.add(menuItemAltaCategoria);

        menuItemAltaServicio.setText("Alta de Servicio");
        menuItemAltaServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAltaServicioActionPerformed(evt);
            }
        });
        menuAltas.add(menuItemAltaServicio);

        menuItemAltaPromocion.setText("Alta de Promoción");
        menuItemAltaPromocion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAltaPromocionActionPerformed(evt);
            }
        });
        menuAltas.add(menuItemAltaPromocion);

        menuItemRealizarReserva.setText("Realizar Reserva");
        menuItemRealizarReserva.setEnabled(false);
        menuItemRealizarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRealizarReservaActionPerformed(evt);
            }
        });
        menuAltas.add(menuItemRealizarReserva);

        cargarDatos.setText("Cargar datos");
        cargarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarDatosActionPerformed(evt);
            }
        });
        menuAltas.add(cargarDatos);

        menu.add(menuAltas);

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

        menuModificaciones.setText("Modificaciones");

        menuItemActualizarEstadoReserva.setText("Actualizar Estado Reserva");
        menuItemActualizarEstadoReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemActualizarEstadoReservaActionPerformed(evt);
            }
        });
        menuModificaciones.add(menuItemActualizarEstadoReserva);

        menuItemActualizarServicio.setText("Actualizar Servicio");
        menuItemActualizarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemActualizarServicioActionPerformed(evt);
            }
        });
        menuModificaciones.add(menuItemActualizarServicio);

        menuItemCancelarReserva.setText("Cancelar Reserva");
        menuItemCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCancelarReservaActionPerformed(evt);
            }
        });
        menuModificaciones.add(menuItemCancelarReserva);

        menu.add(menuModificaciones);

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
        verInfoCliente.initCheck();
    }//GEN-LAST:event_menuItemVerInfoClienteActionPerformed

    private void menuItemVerInfoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVerInfoProveedorActionPerformed
        VerInformacionDeProveedor verInfoProveedor = new VerInformacionDeProveedor(fabrica.getICtrlUsuarios());
        center(verInfoProveedor);
        verInfoProveedor.initCheck();
    }//GEN-LAST:event_menuItemVerInfoProveedorActionPerformed

    private void menuItemVerInfoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVerInfoServicioActionPerformed
        VerInformacionDeServicio verInfoServicio = new VerInformacionDeServicio(fabrica.getICtrlProductos());
        center(verInfoServicio);
    }//GEN-LAST:event_menuItemVerInfoServicioActionPerformed

    private void menuItemVerInfoPromocionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVerInfoPromocionActionPerformed
        VerInformacionDePromocion verInfoPromocion = new VerInformacionDePromocion(fabrica.getICtrlProductos());
        center(verInfoPromocion);
        verInfoPromocion.initCheck();
    }//GEN-LAST:event_menuItemVerInfoPromocionActionPerformed

    private void menuItemVerInfoReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVerInfoReservaActionPerformed
        VerInformacionDeReserva verInfoReserva = new VerInformacionDeReserva(fabrica.getICtrlReservas());
        center(verInfoReserva);
        verInfoReserva.initCheck();
    }//GEN-LAST:event_menuItemVerInfoReservaActionPerformed

    private void menuItemCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCancelarReservaActionPerformed
        CancelarReserva cancelarReserva = new CancelarReserva(fabrica.getICtrlReservas());
        center(cancelarReserva);
        cancelarReserva.initCheck();
    }//GEN-LAST:event_menuItemCancelarReservaActionPerformed

    private void menuItemAltaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAltaCategoriaActionPerformed
        AltaCategoria altaCategoria = new AltaCategoria(fabrica.getICtrlProductos());
        center(altaCategoria);
    }//GEN-LAST:event_menuItemAltaCategoriaActionPerformed

    private void menuItemRealizarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRealizarReservaActionPerformed
        //RealizarReserva1 realizarReserva = new RealizarReserva1(fabrica.getICtrlUsuarios(), fabrica.getICtrlReservas());
        //center(realizarReserva);
        ICtrlReservas ddd = fabrica.getICtrlReservas();
        ddd.limpiarBD();
        /*ddd.confirmarFactura(1);
        System.out.println("oh");
        DTFacturaF dtf = ddd.verFactura(1);
        System.out.println("ooohh");
                */
        
    }//GEN-LAST:event_menuItemRealizarReservaActionPerformed

    private void menuItemActualizarEstadoReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemActualizarEstadoReservaActionPerformed
        ActualizarEstadoReserva actualizarEstadoReserva = new ActualizarEstadoReserva(fabrica.getICtrlReservas());
        center(actualizarEstadoReserva);
        actualizarEstadoReserva.initCheck();
    }//GEN-LAST:event_menuItemActualizarEstadoReservaActionPerformed

    private void menuItemActualizarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemActualizarServicioActionPerformed
        ActualizarServicio1 actualizarServicio = new ActualizarServicio1(fabrica.getICtrlProductos());
        center(actualizarServicio);
        actualizarServicio.initCheck();
    }//GEN-LAST:event_menuItemActualizarServicioActionPerformed

    private void cargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarDatosActionPerformed
        CtrlCarga ctrl = new CtrlCarga();
        ctrl.cargarDatos();
        JOptionPane.showMessageDialog(desktop, "Datos cargados con exito.", "Carga de datos", JOptionPane.INFORMATION_MESSAGE);
        cargarDatos.setEnabled(false);
    }//GEN-LAST:event_cargarDatosActionPerformed

    private void menuItemAltaServicioActionPerformed(java.awt.event.ActionEvent evt) {
        AltaDeServicio1 altaDeServicio = new AltaDeServicio1(fabrica.getICtrlUsuarios(), fabrica.getICtrlProductos());
        center(altaDeServicio);
        altaDeServicio.initCheck();
    }

    private void menuItemAltaPromocionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAltaPromocionActionPerformed
        AltaDePromocion altaDePromocion = new AltaDePromocion(fabrica.getICtrlUsuarios(), fabrica.getICtrlProductos());
        center(altaDePromocion);
        altaDePromocion.initCheck();
    }//GEN-LAST:event_menuItemAltaPromocionActionPerformed

    public static void main(String args[]) {
        VentanaPrincipal v = new VentanaPrincipal();
        v.setVisible(true);
    }

    Fabrica fabrica = Fabrica.getInstance();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cargarDatos;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuAltas;
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
    private javax.swing.JMenu menuModificaciones;
    // End of variables declaration//GEN-END:variables
}
