package persistencia;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import tprog.logica.dt.DTFacturaF;
import tprog.logica.dt.DTPromocionF;
import tprog.logica.dt.DTServicioF;

/**
 *
 * @author User
 */
@Entity
public class FacturaF implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long identi;
    private int idReserva;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private double monto;
    private String nicknameCliente;
    @ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
    @JoinTable(name="FACT_SERV", joinColumns=@JoinColumn(name="FACT_ID"), inverseJoinColumns=@JoinColumn(name="SERV_ID"))
    private Collection<ServicioF> servicios;
    @ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
    @JoinTable(name="FACT_PROM", joinColumns=@JoinColumn(name="FACT_ID"), inverseJoinColumns=@JoinColumn(name="PROM_ID"))
    private Collection<PromocionF> promociones;

    public int getIdReserva() {
        return idReserva;
    }
/*
    public Date getFecha() {
        return fecha;
    }
*/
    public double getMonto() {
        return monto;
    }

    public String getNicknameCliente() {
        return nicknameCliente;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
/*
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
*/
    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setNicknameCliente(String nicknameCliente) {
        this.nicknameCliente = nicknameCliente;
    }

    public void setServicios(Collection<ServicioF> servicios) {
        this.servicios = servicios;
    }

    public Collection<ServicioF> getServicios() {
        return servicios;
    }

    public void setPromociones(Collection<PromocionF> promociones) {
        this.promociones = promociones;
    }

    public Collection<PromocionF> getPromociones() {
        return promociones;
    }
    public Long getId() {
        return identi;
    }

    public void setId(Long identificador) {
        this.identi = identificador;
    }
    
    public DTFacturaF crearDTFacturaF(){
        //creo los dt de los servicios y promociones
        Set<DTServicioF> dtServicios = new HashSet();
		Iterator<ServicioF> iterador = servicios.iterator();
		while (iterador.hasNext()) {
			ServicioF servicio = iterador.next();
			DTServicioF temp = servicio.crearDTServicioF();
			dtServicios.add(temp);
		}
		Set<DTPromocionF> dtPromociones = new HashSet();
		Iterator<PromocionF> iterador2 = promociones.iterator();
		while (iterador2.hasNext()) {
			PromocionF promocion = iterador2.next();
			DTPromocionF temp2 = promocion.crearDTPromocionF();
			dtPromociones.add(temp2);
		}
        //ahora si creo el dt de la factura
        DTFacturaF dtF = new DTFacturaF(idReserva, fecha, monto, nicknameCliente, dtServicios, dtPromociones);
        return dtF;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identi != null ? identi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the identificador fields are not set
        if (!(object instanceof FacturaF)) {
            return false;
        }
        FacturaF other = (FacturaF) object;
        if ((this.identi == null && other.identi != null) || (this.identi != null && !this.identi.equals(other.identi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Factura[ id=" + identi + " ]";
    }
    
}
