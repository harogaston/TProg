/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica;
import java.util.*;
        
/**
 *
 * @author gaston
 */
public class Categoria {
    private String idCategoria;
    private Set<Categoria> subCategorias;
    
    public Categoria(String id, Set<Categoria> cats){
        this.idCategoria = id;
        this.subCategorias = cats;
    }
    
    public Categoria(String id){
        this.idCategoria = id;
        this.subCategorias = new HashSet();
    }
    
    public abstract boolean esCategoriaSimple();

}
