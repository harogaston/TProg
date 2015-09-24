package tprog.logica.clases;

import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import tprog.logica.dt.DTMinServicio;

public interface Categoria {

	public Set<DTMinServicio> listarServicios();

	public boolean esCategoriaSimple();

	public String getIdCategoria();

	public Compuesta getPadre();

	public boolean esCategoriaPadre();

	public void setPadre(Compuesta padre);

	public DefaultMutableTreeNode listarCategorias();

}
