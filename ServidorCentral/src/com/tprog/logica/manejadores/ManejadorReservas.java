/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.manejadores;
import com.tprog.logica.clases.*;
import com.tprog.logica.dt.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

/**
 *
 * @author MarG
 */
public class ManejadorReservas {
    
    private Map<String, Reserva> reservas;
    private static ManejadorReservas instancia=null;
    
    private ManejadorReservas(){
        reservas = new HashMap();
    }
    
    public static ManejadorReservas getinstance(){
        if (instancia==null)
            instancia = new ManejadorReservas();
        return instancia;
    }
    
    public void agregarReserva(Reserva r){
        reservas.put(r.getIdReserva(),r);
    }
    
    public Set<DTMinReserva> listarReservas(){
        Set<DTMinReserva> set = new HashSet();
        if (!reservas.isEmpty()){
            for(Reserva r : reservas.values()){
                DTMinReserva dtMin = r.crearDTMinReserva();
                set.add(dtMin);
            }  
        }
        return set;
    }
    
    public DTReserva infoReserva(String idReserva){
            Reserva  r = reservas.get(idReserva);
            return r.crearDTReserva();
    }
    public boolean cambiarEstadoReserva(String idReserva,EstadoReserva nuevoEstado){
            Reserva  r = reservas.get(idReserva);
            
            return r.cambiarEstadoReserva(nuevoEstado);
    }
    
    public void eliminarReserva(String idReserva){
            Reserva  r = reservas.get(idReserva);
            r.eliminar();
            // sacar del map
            this.reservas.remove(r);
             
        
    }
}
