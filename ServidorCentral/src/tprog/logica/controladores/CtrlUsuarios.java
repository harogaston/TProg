package tprog.logica.controladores;

import java.util.Set;
import tprog.logica.dt.DTCliente;
import tprog.logica.dt.DTMinCliente;
import tprog.logica.dt.DTMinProveedor;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTProveedor;
import tprog.logica.dt.DTReserva;
import tprog.logica.dt.DTServicio;
import tprog.logica.dt.DTUsuario;
import tprog.logica.interfaces.ICtrlUsuarios;
import tprog.logica.manejadores.ManejadorProductos;
import tprog.logica.manejadores.ManejadorReservas;
import tprog.logica.manejadores.ManejadorUsuarios;

public class CtrlUsuarios implements ICtrlUsuarios {

	private String nicknameU;
	private String nicknameP;
	private String email;
	private DTUsuario dtU;
	private boolean esProveedor;
	private String empresa;
	private String web;
	private int idReserva;
	private String idServicio;

	public CtrlUsuarios() {
		this.dtU = null;
		this.email = null;
		this.empresa = null;
		this.esProveedor = false;
		this.idReserva = -1;
		this.idServicio = null;
		this.nicknameP = null;
		this.nicknameU = null;
		this.web = null;
	}

	@Override
	public Set<DTMinCliente> listarClientes() throws Exception {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.listarClientes();
	}

	@Override
	public Set<DTMinProveedor> listarProveedores() throws Exception {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.listarProveedores();
	}

	@Override
	public void seleccionarCliente(String nickname) {
		this.nicknameU = nickname;
	}

	@Override
	public DTCliente infoCliente() throws Exception {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.infoCliente(this.nicknameU);
	}

	@Override
	public void seleccionarReserva(int IdReserva) {
		this.idReserva = IdReserva;
	}

	@Override
	public DTReserva infoReserva() {
		ManejadorReservas manejadorU = ManejadorReservas.getInstance();
		return manejadorU.infoReserva(this.idReserva);
	}

	@Override
	public boolean verificarNickname(String nickname) {
		this.nicknameU = nickname;
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.verificarNickname(this.nicknameU);
	}

	@Override
	public boolean verificarEmail(String Email) {
		this.email = Email;
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.verificarEmail(this.email);
	}

	@Override
	public void ingresarDatosUsuario(DTUsuario DTU, boolean EsProveedor) {
		this.dtU = DTU;
		this.esProveedor = EsProveedor;
	}

	@Override
	public void ingresarDatosProveedor(String Empresa, String Web) {
		this.empresa = Empresa;
		this.web = Web;
	}

	@Override
	public void altaUsuario() {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		if (esProveedor) {
			DTProveedor nuevoDT = new DTProveedor(dtU, this.empresa, this.web);
			manejadorU.altaProveedor(nuevoDT);

		} else {
			DTCliente nuevoDT = new DTCliente(dtU);
			manejadorU.altaCliente(nuevoDT);
		}
	}

	@Override
	public void seleccionarProveedor(String nickname) {
		this.nicknameP = nickname;
	}

	@Override
	public DTProveedor infoProveedor() throws Exception {
		try {
			ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
			return manejadorU.infoProveedor(this.nicknameP);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Set<DTMinServicio> listarServiciosProveedor() {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.listarServiciosProveedor(this.nicknameP);
	}

	@Override
	public void seleccionarServicio(String IdServicio) {
		this.idServicio = IdServicio;
	}

	@Override
	public DTServicio infoServicio() {
		ManejadorProductos manejadorP = ManejadorProductos.getInstance();
		DTMinServicio nuevoDT = new DTMinServicio(this.nicknameP, this.idServicio);
		return manejadorP.infoServicio(nuevoDT);
	}

	@Override
	public boolean idCorrecta(String identificador) {
		//tiene que verificar que la id pertenezca a un cliente
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.idCorrecta(identificador);
	}

	@Override
	public boolean pwCorrecta(String identificador, String password) {
		//tiene que verificar que la contraseña esté asociada al id
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.pwCorrecta(identificador, password);
	}

	@Override
	public String obtenerIdCliente(String identificador, String pass) {
		//en caso de que id sea un email, se devuelve el id asociado a ese cliente
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.obtenerIdCliente(identificador, pass);
	}

}
