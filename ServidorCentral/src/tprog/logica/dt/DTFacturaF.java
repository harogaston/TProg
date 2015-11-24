/*
 * Header Test
 */
package tprog.logica.dt;

import java.util.Date;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author User
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DTFacturaF {

	//private Long id;

	private int idReserva;
	private Date fecha;
	private double monto;
	private String nicknameCliente;
	private Set<DTServicioF> servicios;
	private Set<DTPromocionF> promociones;

	public DTFacturaF(int idReserva, Date fecha, double monto, String nicknameCliente, Set<DTServicioF> servicios, Set<DTPromocionF> promociones) {
		this.idReserva = idReserva;
		this.fecha = fecha;
		this.monto = monto;
		this.nicknameCliente = nicknameCliente;
		this.servicios = servicios;
		this.promociones = promociones;
	}

	/*
	 public Long getId() {
	 return id;
	 }

	 public void setId(Long id) {
	 this.id = id;
	 }
	 */
	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getNicknameCliente() {
		return nicknameCliente;
	}

	public void setNicknameCliente(String nicknameCliente) {
		this.nicknameCliente = nicknameCliente;
	}

	public Set<DTServicioF> getServicios() {
		return servicios;
	}

	public void setServicios(Set<DTServicioF> servicios) {
		this.servicios = servicios;
	}

	public Set<DTPromocionF> getPromociones() {
		return promociones;
	}

	public void setPromociones(Set<DTPromocionF> promociones) {
		this.promociones = promociones;
	}

    public Date getFecha() {
        return fecha;
    }

    
}
