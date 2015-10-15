package tprog.logica.interfaces;

import java.util.Set;
import tprog.logica.dt.DTCliente;
import tprog.logica.dt.DTMinCliente;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinProveedor;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTProveedor;
import tprog.logica.dt.DTReserva;
import tprog.logica.dt.DTServicio;
import tprog.logica.dt.DTUsuario;

public interface ICtrlUsuarios {

	Set<DTMinCliente> listarClientes() throws Exception;

	public void seleccionarCliente(String nickname);

	public DTCliente infoCliente() throws Exception;

	public void seleccionarReserva(int idReserva);

	public DTReserva infoReserva();

	public boolean verificarNickname(String nickname);

	public boolean verificarEmail(String email);

	public void ingresarDatosUsuario(DTUsuario dtU, boolean esProveedor);

	public void ingresarDatosProveedor(String empresa, String web);

	public void altaUsuario();

	public Set<DTMinProveedor> listarProveedores() throws Exception;

	public void seleccionarProveedor(String nickname);

	public DTProveedor infoProveedor() throws Exception;

	public Set<DTMinServicio> listarServiciosProveedor();
	
	public Set<DTMinPromocion> listarPromocionesProveedor();

	public void seleccionarServicio(String idServicio);

	public DTServicio infoServicio();

	public boolean idCorrecta(String identificador);

	public boolean pwCorrecta(String identificador, String password);

	public String obtenerIdCliente(String identificador, String pass);
}
