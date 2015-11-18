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

/**
 *
 * @author User
 */
@Entity
public class ServicioF implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int cantidad;
    private double precio;
    private String nombre;
    private String nicknameProveedor;
    @ManyToMany(cascade=CascadeType.PERSIST)
    private Collection<FacturaF> facturas;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNicknameProveedor() {
        return nicknameProveedor;
    }

    public void setNicknameProveedor(String nicknameProveedor) {
        this.nicknameProveedor = nicknameProveedor;
    }
    
    public Collection<FacturaF> getFacturas() {
        return facturas;
    }

    public void setFacturas(Collection<FacturaF> facturas) {
        this.facturas = facturas;
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
        if (!(object instanceof ServicioF)) {
            return false;
        }
        ServicioF other = (ServicioF) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.ServicioF[ id=" + id + " ]";
    }
    
}
