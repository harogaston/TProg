package tprog.logica.interfaces;

import java.util.Date;
import java.util.Set;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinReserva;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTReserva;
import tprog.logica.dt.EstadoReserva;

public interface ICtrlReservas {

	public void seleccionarCliente(String nickname);

	public void seleccionarProveedor(String nicknameP);

	public Set<DTMinPromocion> listarPromociones() throws Exception;

	public Set<DTMinServicio> listarServicios() throws Exception;

	public void seleccionarPromocion(DTMinPromocion dtP);

	public void seleccionarServicio(DTMinServicio dtS);

	public void ingresarLineaReserva(int cant, Date fInicial, Date fFinal);

	public Set<DTMinServicio> listarServiciosProveedor();

	public Set<DTMinPromocion> listarPromocionesProveedor();

	public DTReserva mostrarReservaTemporal();

	public void altaReserva(DTReserva dtR) throws Exception;

	public Set<DTMinReserva> listarReservas() throws Exception;

	public void seleccionarReserva(int idReserva);

	public DTReserva infoReserva();

	public boolean cambiarEstadoReserva(EstadoReserva nuevoEstado);

	public boolean eliminarReserva();

	public EstadoReserva getEstadoReserva();

	public void liberarMemoriaControlador();
}
