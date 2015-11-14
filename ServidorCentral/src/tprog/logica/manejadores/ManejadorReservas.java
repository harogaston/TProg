package tprog.logica.manejadores;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import tprog.logica.clases.Cliente;
import tprog.logica.clases.LineaReserva;
import tprog.logica.clases.Proveedor;
import tprog.logica.clases.Reserva;
import tprog.logica.dt.DTLineaReserva;
import tprog.logica.dt.DTMinReserva;
import tprog.logica.dt.DTReserva;
import tprog.logica.dt.EstadoReserva;

public class ManejadorReservas {

	private Map<Integer, Reserva> reservas;
	private static ManejadorReservas instance = null;

	public static ManejadorReservas getInstance() {
		if (instance == null) {
			instance = new ManejadorReservas();
		}
		return instance;
	}

	private ManejadorReservas() {
		reservas = new HashMap();
	}

	public Set<DTMinReserva> listarReservas() throws Exception {
		Set<DTMinReserva> set = new HashSet();
		if (!reservas.isEmpty()) {
			for (Reserva r : reservas.values()) {
				DTMinReserva dtMin = r.crearDTMin();
				set.add(dtMin);
			}
			return set;
		} else {
			throw new Exception("No hay Reservas en el Sistema.");
		}

	}

	public DTReserva infoReserva(int idReserva) {
		Reserva reserva = reservas.get(idReserva);
		if (reserva != null) {
			return reserva.crearDT();
		} else {
			return null;
		}
	}

	public boolean cambiarEstadoReserva(int idReserva, EstadoReserva nuevoEstado) {
		Reserva reserva = reservas.get(idReserva);
		if (reserva != null) {
			return reserva.cambiarEstadoReserva(nuevoEstado);
		}
		return false;
	}

	public boolean eliminarReserva(int idReserva) {
		Reserva reserva = reservas.get(idReserva);
		if (reserva != null) {
			EstadoReserva estado = reserva.getEstado();
			if (estado == EstadoReserva.Registrada || estado == EstadoReserva.Cancelada) {
				reserva.getCliente().quitarReserva(idReserva);
				reservas.remove(idReserva);
				return true;
			}
		}
		return false;
	}

	public void agregarReserva(Cliente cliente, DTReserva dtR) throws Exception {
		if (dtR != null) {
			Reserva nuevaReserva = new Reserva(cliente, dtR);
			reservas.put(nuevaReserva.getIdReserva(), nuevaReserva);
			cliente.agregarReserva(nuevaReserva);
			//identifico proveedores y los asocio
			Set<DTLineaReserva> lineasReserva = dtR.getLineasReserva();
			Set<String> proveedoresAsociados = new HashSet<>();
			//recolecto los nicknames de los proveedores
			for (DTLineaReserva dt : lineasReserva) {
				proveedoresAsociados.add(dt.getNicknameProveedor());
			}
			for (String nickname : proveedoresAsociados) {
				Proveedor proveedor = ManejadorUsuarios.getInstance().getProveedor(nickname);
				proveedor.addReserva(nuevaReserva);
			}
		} else {
			System.out.println("El DTReserva que se paso hacia agregarReserva era nulo");
		}

	}

	public EstadoReserva getEstadoReserva(int idReserva) {
		Reserva reserva = reservas.get(idReserva);
		if (reserva != null) {
			return reserva.getEstado();
		} else {
			return null;
		}
	}

	public Map<Integer, Reserva> getReservas() {
		return this.reservas;
	}
}
