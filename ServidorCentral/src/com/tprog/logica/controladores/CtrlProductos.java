/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.controladores;
import com.tprog.logica.dt.*;
import com.tprog.logica.*;
import com.tprog.logica.manejadores.*;
import java.util.*;
/**
 *
 * @author sofia
 */
public class CtrlProductos {
    private DTMinPromocion dtP;
    private DTMinServicio dtS;
    private String categoriaPadre;
    private String nicknameP;
    private Set<String> listaServicios;
    private Set<String> listaCategorias;
    private DTUbicacion origen;
    private DTUbicacion destino;
    
    public CtrlProductos(){
     this.dtP = null;
     this.dtS = null;
     this.categoriaPadre = "";
     this.nicknameP = "";
     this.listaServicios = new HashSet();
     this.listaCategorias = new HashSet();
     this.origen = null;
     this.destino = null;
    }
    
    public Set<DTMinPromocion> listarPromociones(){
        return null;
    }
    
    public void seleccionarPromocion(DTMinPromocion dtP){
        this.dtP = dtP;
    }
    
    public DTPromocion infoPromocion(){
        return null;
    }
    
    public void seleccionarServicio(DTMinServicio dtS){
        this.dtS = dtS;
    }
    
    public DTServicio infoServicio(){
        return null;
    }
    
    public Set<String> listarCategorias(){
        return null;
    }
    
    public Set<DTMinServicio> listarServiciosCategoria(String idCategoria){
        return null;
    }
    
    public Set<DTMinServicio> listarServicios(){
        return null;
    }
    
    public void cambiarPrecio(float nuevoPrecio){
    }
    
    public void cambiarDescripcion(String nuevaD){
    }
    
    public void agregarImagen(String idImagen){
    }
    
    public void quitarImagen(String idImagen){
    }
    
    public Set<DTUbicacion> listarCiudades(){
        return null;
    }
    
    public void cambiarOrigen(DTUbicacion dtU){
    }
    
    public void cambiarDestino (DTUbicacion dtU){
    }
    
    public Set<String> listarCategoriasServicio(){
        return null;
    }
    
    public boolean agregarCategoria(String idCategoria){
        return true;
    }
    
    public boolean quitarCategoria (String idCategoria){
        return true;
    }
    
    public boolean seleccionarCategoriaPadre (String padre){
        this.categoriaPadre = padre;
        return true;
    }
    
    public boolean idCategoriaDisponible(String idCategoria){
        return true;
    }
    
    public void altaCategoria(){
    }
    
    public Set<DTMinProveedor> listarProveedores(){
        ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
        return mu.listarProveedores();
    }
    
    public void seleccionarProveedor(String nick){
        this.nicknameP = nick;
    }
    
    public boolean idServicioDisponible(String idServicio){
        this.dtS = new DTMinServicio(this.nicknameP, idServicio);
        ManejadorProductos mp = ManejadorProductos.getInstance();
        return mp.idServicioDisponible(idServicio, this.nicknameP);
    }
    
    public void seleccionarOrigen(DTUbicacion dtU){
        this.origen = dtU;
    }
    
    public void seleccionarDestino (DTUbicacion dtU){
        this.destino = dtU;
    }
    
    public boolean seleccionarCategoriaSimple(String idCat){
        ManejadorProductos mp = ManejadorProductos.getInstance();
        return mp.esCategoriaSimple(idCat);
    }
    
    public void altaServicio(String descripcion, float Precio, Set<String> imagenes){
    }
    
    public Set<String> listarServiciosProveedor(){
        return null;
    }
    
    public void agregarServicio(String idServicio){
        
    }
    
    public boolean idPromocionDisponible(String idPromocion){
        return true;
    }
    
    public void altaPromocion(float descuento){
    }
      
}
