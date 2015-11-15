package tprog.logica.clases;

import java.util.HashSet;
import java.util.Set;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTServicio;

public class Servicio {

	private String idServicio;
	private String descripcion;
	private float precio;
	private Set<String> imagenes;

	private Ciudad origen;
	private Ciudad destino;
	private Proveedor proveedor;
	private Set<Simple> categorias;

	public Servicio(String IdServicio, String Descripcion, float Precio, Set<String> Imagenes,
			Ciudad Origen, Ciudad Destino, Proveedor Proveedor) {
		this.idServicio = IdServicio;
		this.descripcion = Descripcion;
		this.precio = Precio;
		this.imagenes = Imagenes;
		this.origen = Origen;
		this.destino = Destino;
		this.proveedor = Proveedor;
		this.categorias = new HashSet(); //Se crea vacío
	}

	public DTServicio crearDT() {
		if (this.destino != null) {
			return new DTServicio(idServicio, proveedor.getNickname(), descripcion, precio, imagenes, origen.crearDT(), destino.crearDT());
		} else {
			return new DTServicio(idServicio, proveedor.getNickname(), descripcion, precio, imagenes, origen.crearDT(), null);
		}
	}

	public DTMinServicio crearDTMin() {
		DTMinServicio nuevoDT = new DTMinServicio(this.proveedor.getNickname(), this.idServicio);
		return nuevoDT;
	}

	public Set<String> listarImagenes() {
		return this.imagenes;
	}

	public void agregarImagen(String imagen) {
		if (imagenes.size() < 3) {
			imagenes.add(imagen);
		}
	}

	public void quitarImagen(String imagen) {
		if (!imagenes.isEmpty() && imagenes.contains(imagen)) {
			imagenes.remove(imagen);
		}
	}

	public Set<String> listarCategorias() {
		Set<String> nuevoSet = new HashSet();
		for (Simple c : categorias) {
			nuevoSet.add(c.getIdCategoria());
		}
		return nuevoSet;
	}

	public boolean agregarCategoria(Categoria nueva_categoria) {
		Simple catSimple = (Simple) nueva_categoria;
		if (categorias.isEmpty() || !categorias.contains(catSimple)) {
			categorias.add(catSimple);
			catSimple.agregarServicio(this);
			return true;
		} else {
			return false;
		}
	}

	public boolean quitarCategoria(Categoria categoria_a_quitar) {
		Simple catSimple = (Simple) categoria_a_quitar;
		if (!categorias.isEmpty() && categorias.contains(catSimple)) {
			categorias.remove(catSimple);
			catSimple.quitarServicio(this);
			return true;
		} else {
			return false;
		}
	}

	public String getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(String IdServicio) {
		this.idServicio = IdServicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String Descripcion) {
		this.descripcion = Descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float Precio) {
		this.precio = Precio;
	}

	public Set<String> getImagenes() {
		return imagenes;
	}

	public void setImagenes(Set<String> Imagenes) {
		this.imagenes = Imagenes;
	}

	public Ciudad getOrigen() {
		return origen;
	}

	public void setOrigen(Ciudad Origen) {
		this.origen = Origen;
	}

	public Ciudad getDestino() {
		return destino;
	}

	public void setDestino(Ciudad Destino) {
		this.destino = Destino;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}
	
	public String getNicknameProveedor() {
		return proveedor.getNickname();
	}

	public void setProveedor(Proveedor Proveedor) {
		this.proveedor = Proveedor;
	}

	@Override
	public String toString() {
		String output = "IdServicio: " + idServicio + "\n"
				+ "Proveedor: " + proveedor.getNickname() + "\n"
				+ "Descripción: " + descripcion + "\n"
				+ "Precio: " + Float.toString(precio) + "\n"
				+ "Origen: " + origen.toString() + "\n";
		if (destino != null) {
			output = output.concat("Destino: " + destino.toString() + "\n");
		}
		return output;
	}
    
    public boolean contieneTermino(String termino){
        boolean contains = false;
        if (idServicio.toLowerCase().contains(termino.toLowerCase()) 
                || descripcion.toLowerCase().contains(termino.toLowerCase())){
            contains = true;
        } else {
            for (Simple categoria : categorias) {
                if (categoria.getIdCategoria().toLowerCase().contains(termino.toLowerCase())){
                    contains = true;
                    break;
                }
            }
        }
        return contains;
    }
}
