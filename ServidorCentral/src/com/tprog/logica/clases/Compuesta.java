/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.clases;

import java.util.Set;
import java.util.HashSet;
import com.tprog.logica.dt.DTMinServicio;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author gaston
 */
public class Compuesta implements Categoria{

    private String idCategoria;
    private Set<Categoria> subCategorias;
    protected Compuesta padre;

    public Compuesta(String idCategoria){
        this.idCategoria = idCategoria;
        this.padre = null;
        this.subCategorias = new HashSet();
    }
    
    @Override
    public void setPadre(Compuesta padre){
        this.padre = padre;
    };
    
    @Override
    public Compuesta getPadre(){
        return this.padre;
    }
    
    @Override
    public String getIdCategoria(){
        return this.idCategoria;
    }
    
    @Override
    public Set<DTMinServicio> listarServicios(){
        Set<DTMinServicio> result = new HashSet(); 
        if (!subCategorias.isEmpty()){
            subCategorias.stream().forEach((cat) -> {
                result.addAll(cat.listarServicios());
            }); 
        }
        return result;
    }
    
    @Override
    public boolean esCategoriaSimple(){
        return false;
    }
    
    public void add (Categoria cat){
        this.subCategorias.add(cat);
        cat.setPadre(this);
    }
    
    public void remove (Categoria cat) {
        this.subCategorias.remove(cat);
    }
    
    @Override
    public boolean esCategoriaPadre(){
        return true;
    }
    
    @Override 
    public DefaultMutableTreeNode listarCategorias(){
        DefaultMutableTreeNode result = new DefaultMutableTreeNode(this.idCategoria);
        if (!this.subCategorias.isEmpty()){
            for (Categoria c : this.subCategorias){
                result.add (c.listarCategorias());
            }
        }
        return result;
    }
}
