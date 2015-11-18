package tprog.logica.interfaces;

import java.util.Date;
import java.util.Set;
import tprog.logica.dt.DTCliente;
import tprog.logica.dt.DTFacturaF;
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
        
    public void quitarLineaReserva(int idLineaReserva);

	public Set<DTMinServicio> listarServiciosProveedor();

	public Set<DTMinPromocion> listarPromocionesProveedor();

	public DTReserva mostrarReservaTemporal();

	public void altaReserva(DTReserva dtR) throws Exception;

	public Set<DTMinReserva> listarReservas() throws Exception;

	/**
	 * Devuelve el conjunto de reservas asociadas al proveedor seleccionado
	 * previamente con seleccionarProveedor(nickname)
	 *
	 * @return
	 */
	public Set<DTReserva> listarReservasProveedor();

	public void seleccionarReserva(int idReserva);

	public DTCliente getClienteAsociado();

	public DTReserva infoReserva();

	public boolean cambiarEstadoReserva(EstadoReserva nuevoEstado);

	public void facturarReserva(String idProveedor, String nickCliente, int idReserva);

    public void confirmarFactura(int idReserva);
    
    public DTFacturaF verFactura(int idReserva);
    
	/**
	 * Devuelve un set de string con las notificaciones que recibió un proveedor
	 *
	 * @return
	 */
	public Set<String> listarNotificacionesProveedor();

	public void limpiarNotificacionesProveedor();

	public boolean eliminarReserva();

	public EstadoReserva getEstadoReserva();

	public void liberarMemoriaControlador();
}
