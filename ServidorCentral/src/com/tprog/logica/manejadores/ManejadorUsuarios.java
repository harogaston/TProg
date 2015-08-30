/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.manejadores;
import com.tprog.logica.clases.Proveedor;
import com.tprog.logica.clases.Cliente;
import com.tprog.logica.clases.LineaReserva;
import com.tprog.logica.clases.Reserva;
import com.tprog.logica.dt.*;
import java.util.*;

/**
 *
 * @author sofia
 */
public class ManejadorUsuarios {
    
    private ManejadorUsuarios() {
        proveedores = new HashMap();
        clientes = new HashMap();
    }
    
    public static ManejadorUsuarios getInstance() {
        return ManejadorUsuariosHolder.INSTANCE;
    }
    
    private static class ManejadorUsuariosHolder {

        private static final ManejadorUsuarios INSTANCE = new ManejadorUsuarios();
    }
    
    private Map<String, Proveedor> proveedores;
    private Map<String, Cliente> clientes;

    public Set<DTMinProveedor> listarProveedores(){
        Set<DTMinProveedor> result = new HashSet();
        if (!proveedores.isEmpty()){
            for(Proveedor p : proveedores.values()){
                DTMinProveedor dtMin = p.crearDTMin();
                result.add(dtMin);
            }  
        }
        return result;
    }
    
    public Set<DTMinServicio> listarServiciosProveedor(String nickname){
            Proveedor prov = proveedores.get(nickname);
            return prov.listarServicios();
    }
    
    public Set<DTMinPromocion> listarPromocionesProveedor(String nickname){
            Proveedor prov = proveedores.get(nickname);
            return prov.listarPromociones();
    }
    public void agregarReserva(String nickname, DTReserva dt){
            Reserva res = new Reserva(dt.getFCreacion(),dt.getEstadoReserva(),0);
            Iterator<DTLineaReserva> it = dt.getLineasReserva().iterator();
            while (it.hasNext()) {
                    DTLineaReserva l = it.next();
                    LineaReserva temp = new LineaReserva(l.getCantidad(),l.getFechaInicio(),
                            l.getFechaFin(),l.getServicio(),l.getPromocion(),l.getPrecio());
                    res.agregarLineaReserva(temp);
            }
            ManejadorReservas mr = ManejadorReservas.getInstance();
            mr.agregarReserva(res);
            Cliente cliente = clientes.get(nickname);
            cliente.agregarReserva(res);
    }
}
