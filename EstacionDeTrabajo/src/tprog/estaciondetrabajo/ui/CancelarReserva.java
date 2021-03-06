package tprog.estaciondetrabajo.ui;

import java.util.Set;
import java.util.Vector;
import javax.swing.JOptionPane;
import tprog.logica.dt.DTMinReserva;
import tprog.logica.dt.DTReserva;
import tprog.logica.dt.EstadoReserva;
import tprog.logica.interfaces.ICtrlReservas;

public class CancelarReserva extends javax.swing.JInternalFrame {

	public CancelarReserva(ICtrlReservas ctrlReservas) {
		this.ctrlReservas = ctrlReservas;
		initComponents();
		cargarDatos();
		getRootPane().setDefaultButton(botonEliminar);
	}

	public void initCheck() {
		try {
			ctrlReservas.listarReservas();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
	}

	private void cargarDatos() {
		Set<DTMinReserva> setReservas;
		listaReservas.clear();

		try {
			setReservas = ctrlReservas.listarReservas();
			if (!setReservas.isEmpty()) {
				for (DTMinReserva dt : setReservas) {
					listaReservas.add(Integer.toString(dt.getIdReserva()));
				}
				listaReservas.sort(null);
			}
		} catch (Exception ex) {
			System.out.println("No hay reservas que mostrar.");
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

        listaReservasInterfaz = new javax.swing.JComboBox(listaReservas);
        jLabel1 = new javax.swing.JLabel();
        botonEliminar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setTitle("Cancelar Reserva");
        setPreferredSize(new java.awt.Dimension(640, 480));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaReservasInterfaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaReservasInterfazInterfazActionPerformed(evt);
            }
        });
        getContentPane().add(listaReservasInterfaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 350, -1));

        jLabel1.setText("<html>Seleccione alguna reserva del sistema para eliminarla</html>");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaReservasInterfazInterfazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaReservasInterfazInterfazActionPerformed
		String reservaSeleccionada = (String) listaReservasInterfaz.getSelectedItem();
		if (reservaSeleccionada != null) {
			int reserva = Integer.parseInt(reservaSeleccionada);
			ctrlReservas.seleccionarReserva(reserva);
			DTReserva dt = ctrlReservas.infoReserva();
		}
    }//GEN-LAST:event_listaReservasInterfazInterfazActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
		String reservaSeleccionada = (String) listaReservasInterfaz.getSelectedItem();
		if (reservaSeleccionada != null) {
			DTReserva dt = ctrlReservas.infoReserva();
			EstadoReserva estado = dt.getEstadoReserva();
			boolean eliminada = ctrlReservas.eliminarReserva();
			if (eliminada) {
				JOptionPane.showMessageDialog(this, "La reserva fue eliminada exitosamente", "Cancelación de Reserva", JOptionPane.INFORMATION_MESSAGE);
				listaReservasInterfaz.setSelectedItem(null);
				cargarDatos();
			} else {
				if (estado.equals(EstadoReserva.Pagada)) {
					JOptionPane.showMessageDialog(this, "La reserva no pudo ser eliminada.\nLa misma ya se encuentra pagada.", "Cancelación de Reserva", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, "La reserva no pudo ser eliminada.\nLa misma ya se encuentra facturada.", "Cancelación de Reserva", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
    }//GEN-LAST:event_botonEliminarActionPerformed

	ICtrlReservas ctrlReservas;
	Set<DTMinReserva> reservas;
	VerInformacionDeCliente padre;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox listaReservasInterfaz;
    private Vector<String> listaReservas = new Vector<>();
    // End of variables declaration//GEN-END:variables
}
