/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.clases;

import com.tprog.logica.dt.DTLineaReserva;
import com.tprog.logica.dt.DTMinPromocion;
import com.tprog.logica.dt.DTMinReserva;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTReserva;
import com.tprog.logica.dt.EstadoReserva;
import com.tprog.logica.manejadores.ManejadorProductos;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Reserva {

	private int idReserva;
	private static int contador = 1;
	private Date fCreacion;
	private EstadoReserva estado;
	private float precioTotal;
	private Set<LineaReserva> lineasReserva;

	public Reserva(DTReserva dtR, String nicknameP) throws Exception {
		this.idReserva = Reserva.contador;
		Reserva.contador++;
		this.fCreacion = dtR.getFCreacion();
		this.estado = dtR.getEstadoReserva();
		this.lineasReserva = new HashSet();
		this.precioTotal = dtR.getPrecioTotal();

		// Creo y agrego las lineasReserva
		ManejadorProductos mp = ManejadorProductos.getInstance();
		LineaReserva linea; // debe declararse fuera de los if
		for (DTLineaReserva dtLinea : dtR.getLineasReserva()) {
			if (!dtLinea.getServicio().equals("")) {
				DTMinServicio dtMinS = new DTMinServicio(nicknameP, dtLinea.getServicio());
				Servicio s = mp.getServicio(dtMinS);
				linea = new LineaReserva(dtLinea.getCantidad(), dtLinea.getFechaInicio(), dtLinea.getFechaFin(), s, null, dtLinea.getPrecio());
			} else if (!dtLinea.getPromocion().equals("")) {
				DTMinPromocion dtMinP = new DTMinPromocion(nicknameP, dtLinea.getPromocion());
				Promocion p = mp.getPromocion(dtMinP);
				linea = new LineaReserva(dtLinea.getCantidad(), dtLinea.getFechaInicio(), dtLinea.getFechaFin(), null, p, dtLinea.getPrecio());
			} else {
				throw new Exception("DTLineaReserva sin Servicio o Promocion especificado");
			}
			lineasReserva.add(linea);
		}
	}

	public Reserva(Date fCreacion, EstadoReserva estado, float precioTotal, Set<DTLineaReserva> lineas, String nicknameP) throws Exception {
		this.idReserva = Reserva.contador;
		Reserva.contador++;
		this.fCreacion = fCreacion;
		this.estado = estado;
		this.lineasReserva = new HashSet();
		this.precioTotal = precioTotal;

		// Creo y agrego las lineasReserva
		ManejadorProductos mp = ManejadorProductos.getInstance();
		LineaReserva linea; // debe declararse fuera de los if
		for (DTLineaReserva dtLinea : lineas) {
			if (!dtLinea.getServicio().equals("")) {
				DTMinServicio dtMinS = new DTMinServicio(nicknameP, dtLinea.getServicio());
				Servicio s = mp.getServicio(dtMinS);
				linea = new LineaReserva(dtLinea.getCantidad(), dtLinea.getFechaInicio(), dtLinea.getFechaFin(), s, null, dtLinea.getPrecio());
			} else if (!dtLinea.getPromocion().equals("")) {
				DTMinPromocion dtMinP = new DTMinPromocion(nicknameP, dtLinea.getPromocion());
				Promocion p = mp.getPromocion(dtMinP);
				linea = new LineaReserva(dtLinea.getCantidad(), dtLinea.getFechaInicio(), dtLinea.getFechaFin(), null, p, dtLinea.getPrecio());
			} else {
				throw new Exception("DTLineaReserva sin Servicio o Promocion especificado");
			}
			lineasReserva.add(linea);
		}
	}

	public int getIdReserva() {
		return idReserva;
	}

	public Date getFCreacion() {
		return fCreacion;
	}

	public EstadoReserva getEstadoReserva() {
		return estado;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void agregarLineaReserva(LineaReserva linea) {
		lineasReserva.add(linea);
		precioTotal += linea.getPrecio();
	}

	public void setEstadoReserva(EstadoReserva est) {
		this.estado = est;
	}

	public void setPrecioTotal(float p) {
		this.precioTotal = p;
	}

	public DTReserva crearDTReserva() {
		Set<DTLineaReserva> dtsLR = new HashSet();

		Iterator<LineaReserva> it = lineasReserva.iterator();
		while (it.hasNext()) {
			LineaReserva l = it.next();
			DTLineaReserva temp = l.crearDTLineaReserva();
			dtsLR.add(temp);
		}
		DTReserva dt = new DTReserva(this.idReserva, this.fCreacion, this.estado,
				this.precioTotal, dtsLR);
		return dt;
	}

	public DTMinReserva crearDTMinReserva() {
		DTMinReserva dt = new DTMinReserva(this.idReserva, this.fCreacion);
		return dt;
	}

	public boolean cambiarEstadoReserva(EstadoReserva nuevoEstado) {
		if (nuevoEstado != null) {
			if (("Registrada".equals(this.getEstadoReserva().toString())) && (!"Facturada".equals(nuevoEstado.toString()))) {
				setEstadoReserva(nuevoEstado);
				return true;
			}
		}

		return false;

	}

	public void eliminar() {
		this.lineasReserva.clear();

	}
}
