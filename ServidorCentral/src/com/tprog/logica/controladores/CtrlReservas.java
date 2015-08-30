/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.controladores;

import com.tprog.logica.dt.DTMinPromocion;
import com.tprog.logica.dt.DTMinReserva;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTReserva;
import com.tprog.logica.dt.EstadoReserva;
import com.tprog.logica.interfaces.ICtrlReservas;
import java.util.Date;
import java.util.Set;
/**
 *
 * @author gaston
 */
public class CtrlReservas implements ICtrlReservas{

	@Override
	public void seleccionarCliente(String nickname) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Set<DTMinPromocion> listarPromociones() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Set<DTMinServicio> listarServicios() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void seleccionarPromocion(DTMinPromocion dtP) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void seleccionarServicio(DTMinServicio dtS) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void ingresarLineaReserva(int cant, Date fInicial, Date fFinal) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Set<DTMinServicio> listarServiciosProveedor() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Set<DTMinPromocion> listarPromocionesProveedor() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public DTReserva mostrarReservaTemporal() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void altaReserva() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Set<DTMinReserva> listarReservas() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void seleccionarReserva(int idReserva) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public DTReserva infoReserva() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean cambiarEstadoReserva(EstadoReserva nuevoEstado) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void eliminarReserva() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
