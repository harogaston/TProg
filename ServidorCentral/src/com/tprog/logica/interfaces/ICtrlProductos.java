/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.interfaces;

import java.util.Set;

import com.tprog.logica.dt.DTMinPromocion;
import com.tprog.logica.dt.DTPromocion;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTServicio;
import com.tprog.logica.dt.DTUbicacion;
import com.tprog.logica.dt.DTMinProveedor;

/**
 *
 * @author gaston
 */
public interface ICtrlProductos {

	public Set<DTMinPromocion> listarPromociones();
	public void seleccionarPromocion(DTMinPromocion dtP);
	public DTPromocion infoPromocion();
	public void seleccionarServicio(DTMinServicio dtS);
	public DTServicio infoServicio();
	public Set<String> listarCategorias();
	public Set<DTMinServicio> listarServiciosCategoria(String idCategoria);
	public Set<DTMinServicio> listarServicios();
	public void cambiarPrecio(float nuevoPrecio);
	public void cambiarDescripcion(String nuevaDescripcion);
	public void agregarImagen(String idImagen);
	public void quitarImagen(String idImagen);
	public Set<DTUbicacion> listarCiudades();
	public void cambiarOrigen(DTUbicacion origen);
	public void cambiarDestino(DTUbicacion destino);
	public Set<String> listarCategoriasServicio();
	public boolean agregarCategoria(String idCategoria);
	public boolean quitarCategoria(String idCategoria);
	public boolean seleccionarCategoriaPadre(String padre);
	public boolean idCategoriaDisponible(String idCategoria);
	public void altaCategoria();
	public Set<DTMinProveedor> listarProveedores();
	public void seleccionarProveedor(String nickname);
	public boolean idServicioDisponible(String idServicio);
	public void seleccionarOrigen(DTUbicacion origen);
	public void seleccionarDestino(DTUbicacion destino);
	public boolean seleccionarCategoriaSimple(String idCategoria);
	public void altaServicio(String descripcion, float precio, Set<String> imagenes);
	public Set<String> listarServiciosProveedor();
	public void agregarServicio(String idServicio);
	public boolean idPromocionDisponible(String idPromocion);
	public void altaPromocion(float descuento);
}
