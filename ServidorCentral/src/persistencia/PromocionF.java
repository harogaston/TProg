/*
 * Header Test
 */
package persistencia;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import tprog.logica.dt.DTPromocionF;

/**
 *
 * @author User
 */
@Entity
public class PromocionF implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long identificador;
	private int cantidad;
	private double precio;
	private String nombre;
	private String nicknameProveedor;
	@ManyToMany(cascade = CascadeType.PERSIST)
	private Collection<FacturaF> facturas; 

	public Collection<FacturaF> getFacturas() {
		return facturas;
	}

	public void setFacturas(Collection<FacturaF> facturas) {
		this.facturas = facturas;
	}

	public Long getId() {
		return identificador;
	}

	public void setId(Long id) {
		this.identificador = identificador;
	}

	public int getCantidad() {
		return cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNicknameProveedor() {
		return nicknameProveedor;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNicknameProveedor(String nicknameProveedor) {
		this.nicknameProveedor = nicknameProveedor;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += ( identificador  != null ?  identificador .hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PromocionF)) {
			return false;
		}
		PromocionF other = (PromocionF) object;
		if ((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "persistencia.PromocionF[ id=" + identificador + " ]";
	}

	DTPromocionF crearDTPromocionF() {
		DTPromocionF dtP = new DTPromocionF(cantidad, precio, nombre, nicknameProveedor);
		return dtP;
	}

}
