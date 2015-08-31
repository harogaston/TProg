/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.controladores;

import com.tprog.logica.clases.Cliente;
import com.tprog.logica.dt.DTLineaReserva;
import com.tprog.logica.dt.DTMinPromocion;
import com.tprog.logica.dt.DTMinReserva;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTReserva;
import com.tprog.logica.dt.EstadoReserva;
import com.tprog.logica.interfaces.ICtrlReservas;
import com.tprog.logica.manejadores.ManejadorProductos;
import com.tprog.logica.manejadores.ManejadorReservas;
import com.tprog.logica.manejadores.ManejadorUsuarios;
import java.util.Date;
import java.util.Set;

public class CtrlReservas implements ICtrlReservas {

	private String nickname;
	private DTMinPromocion dtP;
	private DTMinServicio dtS;
	private DTReserva dtR;
	private int idReserva;
	private Set<DTLineaReserva> lineasReserva;
	private float precioTotal;

	public CtrlReservas() {
		this.nickname = "";
		this.dtP = null;
		this.dtS = null;
		this.dtR = null;
		this.idReserva = -1;
		this.precioTotal = 0;

	}
        //ManejadorUsuarios mu = ManejadorUsuarios.getInstance();

	@Override
	public void seleccionarCliente(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public Set<DTMinPromocion> listarPromociones() {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		return mp.listarPromociones();
	}

	@Override
	public Set<DTMinServicio> listarServicios() {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		return mp.listarServicios();
	}

	@Override
	public void seleccionarPromocion(DTMinPromocion dtP) {
		this.dtP = dtP;
	}

	@Override
	public void seleccionarServicio(DTMinServicio dtS) {
		this.dtS = dtS;
	}

	@Override
	public void ingresarLineaReserva(int cant, Date fInicial, Date fFinal) {
		ManejadorProductos mp = ManejadorProductos.getInstance();
		ManejadorReservas mr = ManejadorReservas.getInstance();
		if (dtS == null) {
			float precio = mp.getPrecioPromocion(dtP);
			DTLineaReserva dtLR = new DTLineaReserva(cant, fInicial, fFinal, "", dtP.getNicknameP(), precio);
			lineasReserva.add(dtLR);
			this.precioTotal += precio;
		} else {
			float precio = mp.getPrecioServicio(dtS);
			DTLineaReserva dtLR = new DTLineaReserva(cant, fInicial, fFinal, dtS.getIdServicio(), "", precio);
			lineasReserva.add(dtLR);
			this.precioTotal += precio;
		}
	}

	@Override
	public Set<DTMinServicio> listarServiciosProveedor() {
		ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
		return mu.listarServiciosProveedor(nickname);
	}

	@Override
	public Set<DTMinPromocion> listarPromocionesProveedor() {
		ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
		return mu.listarPromocionesProveedor(nickname);
	}

	@Override
	public DTReserva mostrarReservaTemporal() {
		Date fecha = new Date();
		EstadoReserva estado = EstadoReserva.Registrada;
		return (dtR = new DTReserva(-1, fecha, estado, precioTotal, lineasReserva));
	}

	@Override
	public void altaReserva() throws Exception{
		ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
		Cliente cliente = mu.getCliente(nickname);
		ManejadorReservas mr = ManejadorReservas.getInstance();
		if (!dtS.equals("")) {
			mr.agregarReserva(cliente, dtR, dtS.getNicknameP());
		}
		else if(!dtP.equals("")){
			mr.agregarReserva(cliente, dtR, dtP.getNicknameP());
		}
		else {
			throw new Exception("No se seleccionó ningún servicio o promoción");
		}
		
	}

	@Override
	public Set<DTMinReserva> listarReservas() {
		ManejadorReservas mr = ManejadorReservas.getInstance();
		return mr.listarReservas();
	}

	@Override
	public void seleccionarReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	@Override
	public DTReserva infoReserva() {
		return this.dtR;
	}

	@Override
	public boolean cambiarEstadoReserva(EstadoReserva nuevoEstado) {
		ManejadorReservas mr = ManejadorReservas.getInstance();
		return mr.cambiarEstadoReserva(idReserva, nuevoEstado);
	}

	@Override
	public void eliminarReserva() {
		ManejadorReservas mr = ManejadorReservas.getInstance();
		mr.eliminarReserva(idReserva);
	}
}
