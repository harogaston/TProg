package tprog.logica.clases;

import java.util.HashSet;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import tprog.logica.dt.DTMinServicio;

public class Simple implements Categoria {

	private final String idCategoria;
	protected Compuesta padre;
	private Set<Servicio> servicios;

	public Simple(String idCategoria, Compuesta padre) {
		this.idCategoria = idCategoria;
		this.padre = padre;
		this.servicios = new HashSet();
	}

	public Simple(String idCategoria) {
		this.idCategoria = idCategoria;
		this.padre = null;
		this.servicios = new HashSet();
	}

	public void agregarServicio(Servicio s) {
		this.servicios.add(s);
	}

	public void quitarServicio(Servicio s) {
		this.servicios.remove(s);
	}

	@Override
	public String getIdCategoria() {
		return this.idCategoria;
	}

	public Set<Servicio> getServicios() {
		return this.servicios;
	}

	@Override
	public Compuesta getPadre() {
		return this.padre;
	}

	@Override
	public void setPadre(Compuesta padre) {
		this.padre = padre;
	}

	@Override
	public Set<DTMinServicio> listarServicios() {
		Set<DTMinServicio> result = new HashSet();
		if (!servicios.isEmpty()) {
			for (Servicio s : servicios) {
				result.add(s.crearDTMin());
			}
		}
		return result;
	}

	@Override
	public boolean esCategoriaSimple() {
		return true;
	}

	@Override
	public boolean esCategoriaPadre() {
		return servicios.isEmpty();
	}

	@Override
	public DefaultMutableTreeNode listarCategorias() {
		return new DefaultMutableTreeNode(this.idCategoria, false);
	}
}
