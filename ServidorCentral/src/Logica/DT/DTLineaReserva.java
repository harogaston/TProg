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
import java.util.Date;
public class DTLineaReserva {
    private int Cantidad;
    private Date FechaInicio;
    private Date FechaFin;
    private String servicio;
    private String promocion;
    private float Precio;
    
    public DTLineaReserva(int c,Date fi, Date ff, String s, String p, float pre){
        this.Cantidad = c;
        this.FechaInicio = fi;
        this.FechaFin = ff;
        this.servicio = s;
        this.promocion = p;
        this.Precio = pre;
    }
    public int getCantidad(){
        return this.Cantidad;
    }
    
    public Date getFechaInicio(){
        return this.FechaInicio;
    }
    
    public Date getFechaFin(){
        return this.FechaFin;
    }
    
    public String getServicio(){
        return this.servicio;
    }
    
    public String getPromocion(){
        return this.promocion;
    }
    
    public float getPrecio(){
        return this.Precio;
    }
}
