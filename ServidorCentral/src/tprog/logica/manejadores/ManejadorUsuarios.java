package tprog.logica.manejadores;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import tprog.logica.clases.Cliente;
import tprog.logica.clases.Proveedor;
import tprog.logica.dt.DTCliente;
import tprog.logica.dt.DTMinCliente;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinProveedor;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTProveedor;

public class ManejadorUsuarios {

	private static ManejadorUsuarios instace = null;
	private Map<String, Proveedor> proveedores;
	private Map<String, Cliente> clientes;

	private ManejadorUsuarios() {
		proveedores = new HashMap();
		clientes = new HashMap();
	}

	public static ManejadorUsuarios getInstance() {
		if (instace == null) {
			instace = new ManejadorUsuarios();
		}
		return instace;
	}

	public Set<DTMinProveedor> listarProveedores() throws Exception {
		Set<DTMinProveedor> lista = new HashSet();
		if (!proveedores.isEmpty()) {
			for (Proveedor prov : proveedores.values()) {
				DTMinProveedor dtMin = prov.crearDTMin();
				lista.add(dtMin);
			}
			return lista;
		} else {
			throw new Exception("No existen Proveedores registrados en el Sistema");
		}

	}

	public Set<DTMinServicio> listarServiciosProveedor(String nickname) {
		Proveedor prov = proveedores.get(nickname);
		return prov.listarServicios();
	}

	public Set<DTMinPromocion> listarPromocionesProveedor(String nickname) {
		Proveedor prov = proveedores.get(nickname);
		return prov.listarPromociones();
	}

	public Set<DTMinCliente> listarClientes() throws Exception {
		Set<DTMinCliente> nuevoSet = new HashSet();
		if (!clientes.isEmpty()) {
			for (Cliente client : clientes.values()) {
				nuevoSet.add(client.crearDTMin());
			}
			return nuevoSet;
		} else {
			throw new Exception("No existen Clientes registrados en el Sistema");
		}
	}

	public DTCliente infoCliente(String nickname) throws Exception {
		if (!clientes.isEmpty()) {
			if (clientes.containsKey(nickname)) {
				Cliente client = clientes.get(nickname);
				return client.crearDT();
			} else {
				throw new Exception("No ha seleccionado un Cliente válido.");
			}
		} else {
			throw new Exception("No existen Clientes registrados en el Sistema");
		}
	}

	public DTProveedor infoProveedor(String nicknameP) throws Exception {
		if (!proveedores.isEmpty()) {
			if (proveedores.containsKey(nicknameP)) {
				Proveedor prov = proveedores.get(nicknameP);
				return prov.crearDT();
			} else {
				throw new Exception("No ha seleccionado un Proveedor válido.");
			}
		} else {
			throw new Exception("No existen Proveedores registrados en el Sistema");
		}
	}

	public void altaCliente(DTCliente dtC) {
		Cliente nuevoCliente = new Cliente(dtC);
		clientes.put(dtC.getNickname(), nuevoCliente);
	}

	public void altaProveedor(DTProveedor dtP) {
		Proveedor nuevoProveedor = new Proveedor(dtP);
		proveedores.put(dtP.getNickname(), nuevoProveedor);
	}

	public Cliente getCliente(String nickname) {
		return clientes.get(nickname);
	}

	public Proveedor getProveedor(String nickname) {
		return proveedores.get(nickname);
	}

	public Map<String, Cliente> getClientes() {
		return this.clientes;
	}

	public Map<String, Proveedor> getProveedores() {
		return this.proveedores;
	}

	public boolean idCorrecta(String identificador) {
		boolean nickCorrecto = verificarNickname(identificador);
		boolean mailCorrecto = verificarEmail(identificador);
		//uno de los dos debe ser verdadero para que la función evalúe verdadero
		return nickCorrecto || mailCorrecto;
	}

	public boolean verificarNickname(String nicknameU) {
		if (nicknameU == null) {
			return false;
		} else {
			return clientes.containsKey(nicknameU);
		}
	}

	public boolean verificarEmail(String email) {
		if (email == null) {
			return false;
		}
		for (Cliente c : clientes.values()) {
			if (email.equals(c.getEmail())) {
				return true;
			}
		}
		return false;
	}

	public boolean pwCorrecta(String identificador, String password) {
		//intento encontrar al cliente por id
		Cliente cliente = clientes.get(identificador);
		if (cliente == null) { //si no encontré por id
			//pruebo por email
			for (Cliente client : clientes.values()) {
				if (client.getEmail().equals(identificador)) {
					cliente = client;
					break;
				}
			}
		}
		//si tras buscarlo no encontré, devuelvo false
		if (cliente == null) {
			return false;
		} else {
			return cliente.getPassword().equals(password);
		}
	}

	public String obtenerIdCliente(String idCliente, String pass) {
		Cliente cliente;
		cliente = clientes.get(idCliente);
		if (cliente == null) { //en caso de que sea un email (no se encontró por nickname)
			for (Cliente client : clientes.values()) {
				if (client.getEmail().equals(idCliente) && client.getPassword().equals(pass)) {
					return client.getNickname();
				}
			}
		}
		return idCliente; //en cualquier otro caso (no email)
	}

}
