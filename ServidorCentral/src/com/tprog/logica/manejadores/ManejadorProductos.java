/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.manejadores;
import com.tprog.logica.*;
import com.tprog.logica.dt.*;
import java.util.*;

/**
 *
 * @author sofia
 */
public class ManejadorProductos {
    
    private ManejadorProductos() {
        categorias = new HashMap();
        servicios = new HashMap();
        promociones = new HashMap();
        ubicaciones = new HashMap();
        raices = new HashSet();
    }
    
    public static ManejadorProductos getInstance() {
        return ManejadorProductosHolder.INSTANCE;
    }
    
    private static class ManejadorProductosHolder {
        private static final ManejadorProductos INSTANCE = new ManejadorProductos();
    }
    
    private Map<String, Categoria> categorias;
    private Set<Categoria> raices;
    private Map<String, Pais> ubicaciones;
    private Map<String, Map<String, Servicio>> servicios;
    private Map<String, Map<String, Promocion>> promociones;
    
    public Set<DTMinPromocion> listarPromociones(){
        return null;
    }
    
    public DTPromocion infoPromocion(DTMinPromocion dtP){
        DTPromocion result = null;
        if (!promociones.isEmpty() && promociones.containsKey(dtP.getNicknameP())){
            if(!promociones.get(dtP.getNicknameP()).isEmpty() 
                    && !promociones.get(dtP.getIdPromocion()).containsKey(dtP.getIdPromocion())){
                Promocion p = promociones.get(dtP.getNicknameP()).get(dtP.getIdPromocion());
                result =i p.crearDT();
            }        
        }
        return result;
    }
    
    public DTServicio infoServicio (DTMinServicio dtS) {
        DTServicio result = null;
        if (!servicios.isEmpty() && servicios.containsKey(dtS.getNicknameP())){
            if(!servicios.get(dtS.getNicknameP()).isEmpty() 
                    && !servicios.get(dtS.getIdServicio()).containsKey(dtS.getIdServicio())){
                Servicio s = servicios.get(dtS.getNicknameP()).get(dtS.getIdServicio());
                result = s.crearDT();
            }        
        }
        return result;
    }
    
    public Set<String> listarCategorias(){
        return null;
    }
    
    public Set<DTMinServicio> listarServiciosCategoria(String cat){
        return null;
    }
    
    public Set<DTMinServicio> listarServicios(){
        return null;
    }
    
    public void cambiarPrecio(String nicknameP, String idServicio, 
        float nuevoPrecio){
    }
    
    public void cambiarDescripcion(String nicknameP, String idServicio, 
            String nuevaD){
    }
    
    public String[] listarImagenes (String nicknameP, String idServicio){
        return null;
    }
    
    public void agregarImagen(String nicknameP, String idServicio, String img){
    }
    
    public void quitarImagen(String nicknameP, String idServicio){
    }
    
    public Set<DTUbicacion> listarCiudades(){
        return null;
    }
    
    public void cambiarOrigen(DTMinServicio dtS, DTUbicacion dtU){
    }
    
    public void cambiarDestino(DTMinServicio dtS, DTUbicacion dtU){
    }
    
    public Set<String> listarCategoriasServicio(DTMinServicio dtS){
        return null;
    }
    
    public boolean esCategoriaSimpleAgregar(DTMinServicio dtS, String cat){
        return true;
    }
    
    public boolean esCategoriaSimpleQuitar(DTMinServicio dtS, String cat){
        return true;
    }
    
    public boolean idCategoriaDisponible(String idCategoria){
        return true;
    }
    
    public void altaCategoria(String idCategoria, String idPadre){
    }
    
    public boolean idServicioDisponible(String idServicio, String nicknameP){
        boolean result = true;
        if (!servicios.isEmpty() && servicios.containsKey(nicknameP) &&
                !servicios.get(nicknameP).isEmpty() && 
                servicios.get(nicknameP).containsKey(idServicio)){
            result = false;
        }
        return result;
    }
    
    public boolean esCategoriaSimple(String cat){
        boolean result = false;
        if (!categorias.isEmpty() && categorias.containsKey(cat)){
            Categoria c = categorias.get(cat);
            result = cat.esCategoriaSimple();
        }
        return result;
    }
    
    public void altaServicio(DTServicio dtS){
    }
    
    public void agregarServicio(String idServicio){
    }
    
    public boolean idPromocionDisponible(String idPromocion, String nicknameP){
        return true;
    }
    
    public void altaPromocion(DTPromocion dtP){
    }
   
}
