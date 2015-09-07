/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.clases;

import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTServicio;
import java.util.HashSet;
import java.util.Set;

public class Servicio {

	private String idServicio;
	private String descripcion;
	private float precio;
	private Set<String> imagenes;

	private Ciudad origen;
	private Ciudad destino;
	private Proveedor proveedor;
	private Set<Simple> categorias;

	public Servicio(String idServicio, String descripcion, float precio, Set<String> imagenes, 
                    Ciudad origen, Ciudad destino, Proveedor proveedor) {
		this.idServicio = idServicio;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagenes = imagenes;
		this.origen = origen;
		this.destino = destino;
		this.proveedor = proveedor;
		this.categorias = new HashSet(); //Se crea vacío
	}

	public DTServicio crearDT() {
		if (this.destino != null) {
			return new DTServicio(idServicio, descripcion, precio, imagenes, origen.crearDT(), destino.crearDT());
		} else {
			return new DTServicio(idServicio, descripcion, precio, imagenes, origen.crearDT(), null);
		}
	}

	public DTMinServicio crearDTMin() {
		DTMinServicio nuevoDT = new DTMinServicio(this.proveedor.getNickname(), this.idServicio);
		return nuevoDT;
	}

	public Set<String> listarImagenes() {
		return this.imagenes;
	}

	public void agregarImagen(String imagen) {
		if (imagenes.size() < 3) {
			imagenes.add(imagen);
		}
	}

	public void quitarImagen(String imagen) {
		if (!imagenes.isEmpty() && imagenes.contains(imagen)) {
			imagenes.remove(imagen);
		}
	}

	public Set<String> listarCategorias() {
		Set<String> nuevoSet = new HashSet();
		for (Simple c : categorias) {
			nuevoSet.add(c.getIdCategoria());
		}
		return nuevoSet;
	}

	public boolean agregarCategoria(Categoria nueva_categoria) {
		Simple cs = (Simple) nueva_categoria;
		if (categorias.isEmpty() || !categorias.contains(cs)) {
			categorias.add(cs);
			cs.agregarServicio(this);
			return true;
		} else {
			return false;
		}
	}

	public boolean quitarCategoria(Categoria categoria_a_quitar) {
		Simple cs = (Simple) categoria_a_quitar;
		if (!categorias.isEmpty() && categorias.contains(cs)) {
			categorias.remove(cs);
			cs.quitarServicio(this);
			return true;
		} else {
			return false;
		}
	}

	public String getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(String idServicio) {
		this.idServicio = idServicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Set<String> getImagenes() {
		return imagenes;
	}

	public void setImagenes(Set<String> imagenes) {
		this.imagenes = imagenes;
	}

	public Ciudad getOrigen() {
		return origen;
	}

	public void setOrigen(Ciudad origen) {
		this.origen = origen;
	}

	public Ciudad getDestino() {
		return destino;
	}

	public void setDestino(Ciudad destino) {
		this.destino = destino;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
        
        @Override
        public String toString(){
            String output = "IdServicio: " + idServicio + "\n"
                + "Proveedor: " + proveedor.getNickname() + "\n"
                + "Descripción: " + descripcion + "\n" 
                + "Precio: " + Float.toString(precio) + "\n"
                + "Origen: " + origen.toString() + "\n";
                if (destino != null){
                    output = output.concat("Destino: " + destino.toString() + "\n");
                }
            return output;        
        }
}
