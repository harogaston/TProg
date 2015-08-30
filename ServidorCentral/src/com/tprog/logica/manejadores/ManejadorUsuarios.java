/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.manejadores;

import com.tprog.logica.clases.Cliente;
import com.tprog.logica.clases.Proveedor;
import com.tprog.logica.clases.LineaReserva;
import com.tprog.logica.clases.Reserva;
import com.tprog.logica.dt.DTCliente;
import com.tprog.logica.dt.DTMinCliente;
import com.tprog.logica.dt.DTMinPromocion;
import com.tprog.logica.dt.DTMinProveedor;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTProveedor;
import com.tprog.logica.dt.DTReserva;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


import com.tprog.logica.dt.*;



public class ManejadorUsuarios {
    
	private static ManejadorUsuarios instace = null;
	
	private Map<String, Proveedor> proveedores;
    private Map<String, Cliente> clientes;
    
	private ManejadorUsuarios() {
        proveedores = new HashMap();
        clientes = new HashMap();
    }
    
	public static ManejadorUsuarios getInstance(){
		if (instace == null)
			instace = new ManejadorUsuarios();
		return instace;
	}

    public Set<DTMinProveedor> listarProveedores(){
        Set<DTMinProveedor> result = new HashSet();
        if (!proveedores.isEmpty()){
            for(Proveedor p : proveedores.values()){
                DTMinProveedor dtMin = p.crearDTMin();
                result.add(dtMin);
            }  
        }
        return result;
    }
    
    public Set<DTMinServicio> listarServiciosProveedor(String nickname){
            Proveedor prov = proveedores.get(nickname);
            return prov.listarServicios();
    }
    
    public Set<DTMinPromocion> listarPromocionesProveedor(String nickname){
            Proveedor prov = proveedores.get(nickname);
            return prov.listarPromociones();
    }
    public void agregarReserva(String nickname, DTReserva dt){
            Reserva res = new Reserva(dt.getFCreacion(),dt.getEstadoReserva(),0);
            Iterator<DTLineaReserva> it = dt.getLineasReserva().iterator();
            while (it.hasNext()) {
                    DTLineaReserva l = it.next();
                    LineaReserva temp = new LineaReserva(l.getCantidad(),l.getFechaInicio(),
                            l.getFechaFin(),l.getServicio(),l.getPromocion(),l.getPrecio());
                    res.agregarLineaReserva(temp);
            }
            ManejadorReservas mr = ManejadorReservas.getInstance();
            mr.agregarReserva(res);
            Cliente cliente = clientes.get(nickname);
            cliente.agregarReserva(res);
    }

	public Set<DTMinCliente> listarClientes() {
		return null;
	}

	public DTCliente infoCliente(String nickname) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public DTProveedor infoProveedor(String nicknameP) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public boolean verificarNickname(String nicknameU) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public boolean verificarEmail(String email) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public void altaCliente(DTCliente nuevoDT) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public void altaProveedor(DTProveedor nuevoDT) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
