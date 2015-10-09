package tprog.logica.clases;

import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import tprog.logica.dt.DTMinServicio;

public interface Categoria {

    /**
     *
     * @return
     */
    public abstract Set<DTMinServicio> listarServicios();

    /**
     *
     * @return
     */
    public abstract boolean esCategoriaSimple();

    /**
     *
     * @return
     */
    public String getIdCategoria();

    /**
     *
     * @return
     */
    public Compuesta getPadre();

	public boolean esCategoriaPadre();

	public void setPadre(Compuesta padre);

	public DefaultMutableTreeNode listarCategorias();

}
