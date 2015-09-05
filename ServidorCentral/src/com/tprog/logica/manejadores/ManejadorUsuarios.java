/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.manejadores;

import com.tprog.logica.clases.Cliente;
import com.tprog.logica.clases.Proveedor;
import com.tprog.logica.dt.DTCliente;
import com.tprog.logica.dt.DTMinCliente;
import com.tprog.logica.dt.DTMinPromocion;
import com.tprog.logica.dt.DTMinProveedor;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTProveedor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

	public Set<DTMinProveedor> listarProveedores() {
		Set<DTMinProveedor> lista = new HashSet();
		if (!proveedores.isEmpty()) {
			for (Proveedor p : proveedores.values()) {
				DTMinProveedor dtMin = p.crearDTMin();
				lista.add(dtMin);
			}
		}
		return lista;
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
        
        public Map<String,Proveedor> getProveedores(){
                return proveedores;
        }
        
        public Map<String,Cliente> getClientes(){
                return clientes;
        }
}
