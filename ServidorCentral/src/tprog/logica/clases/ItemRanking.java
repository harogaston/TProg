package tprog.logica.clases;

import tprog.logica.dt.DTMinServicio;

public class ItemRanking {
    private final DTMinServicio servicio;
    private final int cantAccesos;
    
    public ItemRanking(Servicio servicio){
        this.servicio = servicio.crearDTMin();
        this.cantAccesos = servicio.getCantAccesos();
    }
    
    public ItemRanking(DTMinServicio dtMinServicio, int cantAccesos){
        this.servicio = dtMinServicio;
        this.cantAccesos = cantAccesos;
    }
    
    public DTMinServicio getServicio() {
        return servicio;
    }
    
    public int getCantAccesos(){
        return cantAccesos;
    }
}
