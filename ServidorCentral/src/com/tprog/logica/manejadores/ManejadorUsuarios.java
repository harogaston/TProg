/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.manejadores;
import com.tprog.logica.clases.Proveedor;
import com.tprog.logica.clases.Cliente;
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
}
