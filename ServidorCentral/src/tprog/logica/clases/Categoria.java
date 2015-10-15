package tprog.logica.clases;

import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import tprog.logica.dt.DTMinServicio;

public interface Categoria {

    /**
     *
     * @return
     */
    abstract Set<DTMinServicio> listarServicios();

    /**
     *
     * @return
     */
    abstract boolean esCategoriaSimple();

    /**
     *
     * @return
     */
    String getIdCategoria();

    /**
     *
     * @return
     */
    Compuesta getPadre();

	public boolean esCategoriaPadre();

	public void setPadre(Compuesta padre);

	public DefaultMutableTreeNode listarCategorias();

}
