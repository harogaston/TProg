/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.dt;
import java.util.*;
/**
 *
 * @author sofia
 */
public class DTCategoria {
    private final String idCategoria;
    private final Set<DTCategoria> catHijas;
    
    public DTCategoria(String id, Set<DTCategoria> sons){
        this.idCategoria = id;
        this.catHijas = sons;
    }
    
    public String getIdCategoria(){
        return this.idCategoria;
    }
    
    public Set<DTCategoria> getCategoriasHijas(){
        return this.catHijas;
    }
}
