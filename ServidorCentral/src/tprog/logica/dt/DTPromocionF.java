/*
 * Header Test
 */
package tprog.logica.dt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author User
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DTPromocionF {
    //private Long id;
    private int cantidad;
    private double precio;
    private String nombre;
    private String nicknameProveedor;

    public DTPromocionF(int cantidad, double precio, String nombre, String nicknameProveedor) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.nombre = nombre;
        this.nicknameProveedor = nicknameProveedor;
    }

    
    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
*/
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
    
}
