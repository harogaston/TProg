package tprog.logica.controladores;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import tprog.logica.clases.Cliente;
import tprog.logica.dt.DTLineaReserva;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinReserva;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTReserva;
import tprog.logica.dt.EstadoReserva;
import tprog.logica.interfaces.ICtrlReservas;
import tprog.logica.manejadores.ManejadorProductos;
import tprog.logica.manejadores.ManejadorReservas;
import tprog.logica.manejadores.ManejadorUsuarios;

public class CtrlReservas implements ICtrlReservas {

	private String nickname;
	private String nicknameP;
	private DTMinPromocion dtP;
	private DTMinServicio dtS;
	private DTReserva dtR;
	private int idReserva;
	private Set<DTLineaReserva> lineasReserva;
	private float precioTotal;

	public CtrlReservas() {
		this.nickname = null;
		this.nicknameP = null;
		this.dtP = null;
		this.dtS = null;
		this.dtR = null;
		this.idReserva = -1;
		this.precioTotal = 0;
		this.lineasReserva = new HashSet();
	}

	@Override
	public void seleccionarCliente(String Nickname) {
		this.nickname = Nickname;
	}

	@Override
	public void seleccionarProveedor(String NicknameP) {
		this.nicknameP = NicknameP;
	}

	@Override
	public Set<DTMinPromocion> listarPromociones() throws Exception {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		return manejadorP.listarPromociones();
	}

	@Override
	public Set<DTMinServicio> listarServicios() throws Exception {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		return manejadorP.listarServicios();
	}

	@Override
	public void seleccionarPromocion(DTMinPromocion DTP) {
		this.dtP = DTP;
	}

	@Override
	public void seleccionarServicio(DTMinServicio DTS) {
		this.dtS = DTS;
	}

	@Override
	public void ingresarLineaReserva(int cant, Date fInicial, Date fFinal) {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		if (dtS == null) {
			float precio = manejadorP.getPrecioPromocion(dtP);
			DTLineaReserva dtLR = new DTLineaReserva(cant, fInicial, fFinal, null, dtP.getIdPromocion(), dtP.getNicknameP(), precio);
			lineasReserva.add(dtLR);
			precioTotal += precio * cant;
		} else {
			float precio = manejadorP.getPrecioServicio(dtS);
			DTLineaReserva dtLR = new DTLineaReserva(cant, fInicial, fFinal, dtS.getIdServicio(), null, dtS.getNicknameP(), precio);
			lineasReserva.add(dtLR);
			precioTotal += precio * cant;
		}
	}

	@Override
	public Set<DTMinServicio> listarServiciosProveedor() {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.listarServiciosProveedor(nicknameP);
	}

	@Override
	public Set<DTMinPromocion> listarPromocionesProveedor() {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.listarPromocionesProveedor(nicknameP);
	}

	@Override
	public DTReserva mostrarReservaTemporal() {
		Date fechaTemp = new Date();
		int anio = fechaTemp.getYear() + 1900;
		int mes = fechaTemp.getMonth();
		int dia = fechaTemp.getDate();
		Date fecha = new Date(anio, mes, dia);
		EstadoReserva estado = EstadoReserva.Registrada;
		return new DTReserva(-1, fecha, estado, precioTotal, lineasReserva);
	}

	@Override
	public void altaReserva(DTReserva DTR) throws Exception {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		Cliente cliente = manejadorU.getCliente(nickname);
		ManejadorReservas manejadorR = ManejadorReservas.getInstance();
		manejadorR.agregarReserva(cliente, DTR);
	}

	@Override
	public Set<DTMinReserva> listarReservas() throws Exception {
		ManejadorReservas manejadorR = ManejadorReservas.getInstance();
		return manejadorR.listarReservas();
	}

	@Override
	public void seleccionarReserva(int IdReserva) {
		this.idReserva = IdReserva;
	}

	@Override
	public DTReserva infoReserva() {
		ManejadorReservas manejadorR = ManejadorReservas.getInstance();
		dtR = manejadorR.infoReserva(idReserva);
		return dtR;
	}

	@Override
	public boolean cambiarEstadoReserva(EstadoReserva nuevoEstado) {
		ManejadorReservas manejadorR = ManejadorReservas.getInstance();
		return manejadorR.cambiarEstadoReserva(idReserva, nuevoEstado);
	}

	@Override
	public boolean eliminarReserva() {
		ManejadorReservas manejadorR = ManejadorReservas.getInstance();
		return manejadorR.eliminarReserva(idReserva);
	}

	@Override
	public EstadoReserva getEstadoReserva() {
		ManejadorReservas manejadorR = ManejadorReservas.getInstance();
		return manejadorR.getEstadoReserva(this.idReserva);
	}

	@Override
	public void liberarMemoriaControlador() {
		this.nickname = null;
		this.nicknameP = null;
		this.dtP = null;
		this.dtS = null;
		this.dtR = null;
		this.idReserva = -1;
		this.precioTotal = 0;
		this.lineasReserva = new HashSet();
	}

	public String getNickname() {
		return nickname;
	}

	public String getNicknameP() {
		return nicknameP;
	}

	public DTMinPromocion getDtP() {
		return dtP;
	}

	public DTMinServicio getDtS() {
		return dtS;
	}

	public DTReserva getDtR() {
		return dtR;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public Set<DTLineaReserva> getLineasReserva() {
		return lineasReserva;
	}

}
