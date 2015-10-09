package tprog.logica.dt;

import java.util.Set;

public class DTServicio implements Comparable<DTServicio> {

	private final String idServicio;
	private final String nicknameProveedor;
	private final String descripcion;
	private final float precio;
	private final Set<String> imagenes;
	private final DTUbicacion origen;
	private final DTUbicacion destino;

	public DTServicio(String IdServicio, String NicknameP, String Descripcion, float Precio,
			Set<String> Imagenes, DTUbicacion Origen, DTUbicacion Destino) {
		this.idServicio = IdServicio;
		this.nicknameProveedor = NicknameP;
		this.descripcion = Descripcion;
		this.precio = Precio;
		this.imagenes = Imagenes;
		this.origen = Origen;
		this.destino = Destino;
	}

	public String getIdServicio() {
		return this.idServicio;
	}

	public String getNicknameProveedor() {
		return this.nicknameProveedor;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public float getPrecio() {
		return this.precio;
	}

	public Set<String> getImagenes() {
		return this.imagenes;
	}

	public DTUbicacion getOrigen() {
		return this.origen;
	}

	public DTUbicacion getDestino() {
		return this.destino;
	}

	@Override
	public String toString() {
		String salida = "ID de servicio: " + idServicio
				+ "\n" + "Descripcion: " + descripcion
				+ "\n" + "Precio: " + Float.toString(precio)
				+ "\n" + "Origen: " + origen.toString()
				+ "\n";
		if (destino != null) {
			salida = salida.concat("Destino: " + destino.toString() + "\n");
		}
		return salida;
	}

	@Override
	public int compareTo(DTServicio object) {
		if (this.idServicio.equals(object.getIdServicio())) {
			return this.nicknameProveedor.compareToIgnoreCase(object.getNicknameProveedor());
		} else {
			return this.idServicio.compareToIgnoreCase(object.getIdServicio());
		}
	}
	
	public int comparePrecio(DTServicio object) {
		if (Float.compare(precio, object.getPrecio()) == 0) {
			return this.compareTo(object);
		} else {
			return Float.compare(precio, object.getPrecio());
		}
	}
}
