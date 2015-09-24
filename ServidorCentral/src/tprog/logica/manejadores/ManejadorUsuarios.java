package tprog.logica.manejadores;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;
import tprog.logica.clases.Cliente;
import tprog.logica.clases.Proveedor;
import tprog.logica.dt.DTCliente;
import tprog.logica.dt.DTMinCliente;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinProveedor;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTProveedor;
import tprog.logica.dt.DTUsuario;

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
			for (Proveedor p : proveedores.values()) {
				DTMinProveedor dtMin = p.crearDTMin();
				lista.add(dtMin);
			}
			return lista;
		} else {
			throw new Exception("No existen Proveedores registrados en el Sistema");
		}

	}

	public Set<DTMinServicio> listarServiciosProveedor(String nickname) {
		Proveedor p = proveedores.get(nickname);
		return p.listarServicios();
	}

	public Set<DTMinPromocion> listarPromocionesProveedor(String nickname) {
		Proveedor p = proveedores.get(nickname);
		return p.listarPromociones();
	}

	public Set<DTMinCliente> listarClientes() throws Exception {
		Set<DTMinCliente> nuevoSet = new HashSet();
		if (!clientes.isEmpty()) {
			for (Cliente c : clientes.values()) {
				nuevoSet.add(c.crearDTMin());
			}
			return nuevoSet;
		} else {
			throw new Exception("No existen Clientes registrados en el Sistema");
		}
	}

	public DTCliente infoCliente(String nickname) throws Exception {
		if (!clientes.isEmpty()) {
			if (clientes.containsKey(nickname)) {
				Cliente c = clientes.get(nickname);
				return c.crearDT();
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
				Proveedor p = proveedores.get(nicknameP);
				return p.crearDT();
			} else {
				throw new Exception("No ha seleccionado un Proveedor válido.");
			}
		} else {
			throw new Exception("No existen Proveedores registrados en el Sistema");
		}
	}

	public boolean verificarNickname(String nicknameU) {
		return !proveedores.containsKey(nicknameU) && !clientes.containsKey(nicknameU);
	}

	public boolean verificarEmail(String email) {
		if (!proveedores.isEmpty()) {
			for (Proveedor p : proveedores.values()) {
				if (email.equals(p.getEmail())) {
					return false;
				}
			}
		}
		if (!clientes.isEmpty()) {
			for (Cliente c : clientes.values()) {
				if (email.equals(c.getEmail())) {
					return false;
				}
			}
		}
		return true;
	}

	public void altaUsuario(DTUsuario dtU, boolean esProveedor, Image imagen) throws IOException {
		if (dtU.getImagen()) {
			try {
				File archivo = new File("resources/images/usuarios/" + dtU.getNickname());
				BufferedImage buff = (BufferedImage) imagen;
				ImageIO.write(buff, "jpg", archivo);
			} catch (IOException ex) {
				System.err.println(ex.toString());
				throw new IOException("No se pudo crear la imágen");
			}
		}
		if (esProveedor) {
			Proveedor nuevoProveedor = new Proveedor((DTProveedor) dtU);
			proveedores.put(dtU.getNickname(), nuevoProveedor);
		} else {
			Cliente nuevoCliente = new Cliente((DTCliente) dtU);
			clientes.put(dtU.getNickname(), nuevoCliente);
		}
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
}
