/*
 * Header Test
 */
package tprog.logica.clases;

import tprog.logica.dt.DTMinServicio;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;

public interface Categoria {

	public Set<DTMinServicio> listarServicios();

	public boolean esCategoriaSimple();

	public String getIdCategoria();

	public Compuesta getPadre();

	public boolean esCategoriaPadre();

	public void setPadre(Compuesta padre);

	public DefaultMutableTreeNode listarCategorias();

}
