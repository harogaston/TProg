/*
 * Header Test
 */
package com.tprog.logica.clases;
import com.tprog.logica.dt.DTMinServicio;
import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author sofia
 */
public interface Categoria {

  
    public Set<DTMinServicio> listarServicios();
    public boolean esCategoriaSimple();
    public String getIdCategoria();
    public void setPadre(Compuesta padre);
    public Compuesta getPadre();
	

}
