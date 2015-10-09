package tprog.logica.clases;

import java.util.HashSet;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import tprog.logica.dt.DTMinServicio;

public class Compuesta implements Categoria {

	private String idCategoria;
	private Set<Categoria> subCategorias;
	protected Compuesta padre;

	public Compuesta(String IdCategoria) {
		this.idCategoria = IdCategoria;
		this.padre = null;
		this.subCategorias = new HashSet();
	}

	@Override
	public void setPadre(Compuesta Padre) {
		this.padre = Padre;
	}

	@Override
	public Compuesta getPadre() {
		return this.padre;
	}

	@Override
	public String getIdCategoria() {
		return this.idCategoria;
	}

	@Override
	public Set<DTMinServicio> listarServicios() {
		Set<DTMinServicio> result = new HashSet();
		if (!subCategorias.isEmpty()) {
			for (Categoria cat : this.subCategorias) {
				result.addAll(cat.listarServicios());
			}
		}
		return result;
	}

	@Override
	public boolean esCategoriaSimple() {
		return false;
	}

	public void add(Categoria cat) {
		this.subCategorias.add(cat);
		cat.setPadre(this);
	}

	public void remove(Categoria cat) {
		this.subCategorias.remove(cat);
	}

	@Override
	public boolean esCategoriaPadre() {
		return true;
	}

	@Override
	public DefaultMutableTreeNode listarCategorias() {
		DefaultMutableTreeNode result = new DefaultMutableTreeNode(this.idCategoria);
		if (!this.subCategorias.isEmpty()) {
			for (Categoria c : this.subCategorias) {
				result.add(c.listarCategorias());
			}
		}
		return result;
	}
}
