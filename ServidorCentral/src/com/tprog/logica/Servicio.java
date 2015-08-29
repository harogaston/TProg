/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica;

import java.util.Set;
import com.tprog.logica.dt.DTServicio;
import com.tprog.logica.dt.DTUbicacion;
import java.util.HashSet;

/**
 *
 * @author gaston
 */
public class Servicio {
    
	private String idServicio;
	private String descripcion;
	private float precio;
	private String[] imagenes;

	private DTUbicacion origen;
	private DTUbicacion destino;
	private Proveedor proveedor;
	private Set<Simple> categorias;
	
	public Servicio(DTServicio data, Proveedor proveedor){
		this.idServicio = data.getIdServicio();
		this.descripcion = data.getDescripcion();
		this.precio = data.getPrecio();
		this.imagenes = data.getImagenes();
		this.origen = data.getOrigen();
		this.destino = data.getDestino();
		this.proveedor = proveedor;
		this.categorias = new HashSet(); //Y las categorías de dónde salen?? 
										// Hay que revisar el CU
	}

/*
+ crearDTMin() : DTMinServicio
+ crearDT(): DTServicio
+ listarImagenes() : Set(String)
+ agregarImagen(idImagen : String)
+ quitarImagen(idImagen : String)
+ listarCategorias() : Set(String)
+ agregarCategoria(cat : Categoria) : Bool
+ quitarCategoria(cat : Categoria) : Bool
*/


}
