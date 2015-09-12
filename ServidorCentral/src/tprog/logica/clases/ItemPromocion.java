/*
 * Header Test
 */
package tprog.logica.clases;

/**
 *
 * @author gianc_000
 */
public class ItemPromocion {
    protected Servicio servicio;
    protected int cantidad;
    
    public ItemPromocion(Servicio s){
        servicio = s;
        cantidad = 1;
    }
    
    public void addServicio(){
        cantidad++;
    }
    
    public Servicio getServicio(){
        return servicio;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
}
