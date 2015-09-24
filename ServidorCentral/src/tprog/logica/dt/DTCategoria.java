package tprog.logica.dt;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.directory.InvalidAttributeValueException;

public class DTCategoria {

	private String idCategoria;
	private Set<DTCategoria> subCategorias;

	public DTCategoria(String idCategoria, Set<DTCategoria> subCategorias) {
		try {
			if (idCategoria == null || idCategoria.equals("")) {
				throw new InvalidAttributeValueException("No se ingresó un idCategoria");
			}
		} catch (InvalidAttributeValueException ex) {
			Logger.getLogger(DTCategoria.class.getName()).log(Level.SEVERE, null, ex);
		}
		this.idCategoria = idCategoria;
		this.subCategorias = subCategorias;
	}

	public String getIdCategoria() {
		return this.idCategoria;
	}

	public Set<DTCategoria> getSubCategorias() {
		return this.subCategorias;
	}

	@Override
	public String toString() {
		return this.idCategoria;
	}
}
