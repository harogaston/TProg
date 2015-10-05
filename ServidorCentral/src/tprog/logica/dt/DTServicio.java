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

	public DTServicio(String idServicio, String nicknameP, String descripcion, float precio,
			Set<String> imagenes, DTUbicacion origen, DTUbicacion destino) {
		this.idServicio = idServicio;
		this.nicknameProveedor = nicknameP;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagenes = imagenes;
		this.origen = origen;
		this.destino = destino;
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
	public int compareTo(DTServicio o) {
		if (this.idServicio.equals(o.getIdServicio())) {
			return (this.nicknameProveedor.compareToIgnoreCase(o.getNicknameProveedor()));
		} else {
			return (this.idServicio.compareToIgnoreCase(o.getIdServicio()));
		}
	}
	
	public int comparePrecio(DTServicio o){
		if (Float.compare(precio, o.getPrecio()) == 0) {
			return this.compareTo(o);
		} else {
			return Float.compare(precio, o.getPrecio());
		}
	}
}
