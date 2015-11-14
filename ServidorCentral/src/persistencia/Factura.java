/*
 * Header Test
 */
package persistencia;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author User
 */
@Entity
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int idReserva;
    private Date fecha;
    private double monto;
    private String nicknameCliente;
    @ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
    private Collection<ServicioF> servicios;
    @ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
    private Collection<PromocionF> promociones;

    public int getIdReserva() {
        return idReserva;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public String getNicknameCliente() {
        return nicknameCliente;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

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
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Factura[ id=" + id + " ]";
    }
    
}
