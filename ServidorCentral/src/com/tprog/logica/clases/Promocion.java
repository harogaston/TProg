/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.clases;

import com.tprog.logica.dt.DTMinPromocion;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTMiniItem;
import com.tprog.logica.dt.DTPromocion;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Promocion {

	private String idPromocion;
	private float descuento;
	//private float total;

	private Proveedor proveedor;
	private Map<String, ItemPromocion> servicios;

	public Promocion(String idPromocion, float descuento, Proveedor proveedor) {
            this.idPromocion = idPromocion;
            this.descuento = descuento;
            this.proveedor = proveedor;
            servicios = new HashMap();
            //this.total = 0;
	}

	public DTMinPromocion crearDTMin() {
		DTMinPromocion nuevoDT = new DTMinPromocion(this.proveedor.getNickname(), this.idPromocion);
		return nuevoDT;
	}

	public DTPromocion crearDT() {
            Set<DTMiniItem> nuevoSet = new HashSet();
            if (servicios != null) {
                for (ItemPromocion it : servicios.values()) {
                    nuevoSet.add(new DTMiniItem(it.getServicio().getIdServicio(), it.getCantidad()));
                }
            }
            DTPromocion nuevoDT = new DTPromocion(this.idPromocion, this.descuento, this.getTotal(), nuevoSet);
            return nuevoDT;
	}

	public void addServicio(Servicio s) {
            if (servicios.containsKey(s.getIdServicio())){
                servicios.get(s.getIdServicio()).addServicio();
            } else {
                servicios.put(s.getIdServicio(), new ItemPromocion(s));
            }    
            //this.total += (s.getPrecio() * ((100 - this.descuento) / 100));
	}

	public void setIdPromocion(String idPromocion) {
		this.idPromocion = idPromocion;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public String getIdPromocion() {
		return this.idPromocion;
	}

	public float getDescuento() {
		return this.descuento;
	}

	public float getTotal() {
            float result = 0;
            for(ItemPromocion it : servicios.values()){
                float precioUnit = it.getServicio().getPrecio();
                float precioPromocional = (precioUnit * (100-this.descuento))/100;
                result += precioPromocional*it.getCantidad();
            }
            return result;
	}

	public String getNicknameProveedor() {
		return this.proveedor.getNickname();
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}
        
        public Map<String, ItemPromocion> getServicios(){
            return this.servicios;
        }
}
