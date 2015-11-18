/*
 * Header Test
 */
package tprog.logica.dt;

import java.util.Collection;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import persistencia.PromocionF;
import persistencia.ServicioF;

/**
 *
 * @author User
 */
public class DTFacturaF {
    //private Long id;
    private int idReserva;
    //private Date fecha;
    private double monto;
    private String nicknameCliente;
    private Set<DTServicioF> servicios;
    private Set<DTPromocionF> promociones;

    public DTFacturaF(int idReserva, double monto, String nicknameCliente, Set<DTServicioF> servicios, Set<DTPromocionF> promociones) {
        this.idReserva = idReserva;
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

    
    
    
}
