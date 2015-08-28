/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.DT;



/**
 *
 * @author MarG
 */
import java.util.HashSet;
import java.util.Set;

public class DTReserva {
    private String idReserva;
    private String fcreacion; // pasar a date en un futuro muy cercano
    private EstadoReserva estado;
    private float precioTotal;
    Set<DTLineaReserva> lineasReserva = new HashSet<DTLineaReserva>(); // agregar al agregar Linea reserva
    
    public enum EstadoReserva{
        Registrada,Cancelada,Pagada,Facturada
    }
    
    public DTReserva(String id, String creacion, EstadoReserva estado, float p){
        this.idReserva = id;
        this.fcreacion = creacion;
        this.estado = estado;
        this.precioTotal = p;
    }
    public String getIdReserva(){
        return idReserva;
    }    
    
    public String getFCreacion(){
        return fcreacion;
    }
    
    public EstadoReserva getEstadoReserva(){
        return estado;
    }
    
    public float getPrecioTotal(){
        return precioTotal;
    }
    public Set<DTLineaReserva> getDTLineasReserva(){
        return this.lineasReserva;
    }
}
