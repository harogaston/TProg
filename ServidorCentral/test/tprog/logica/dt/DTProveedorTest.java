/*
 * Header Test
 */
package tprog.logica.dt;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author gaston
 */
public class DTProveedorTest {

    public DTProveedorTest() {
    }

    @Test
    public void testGetEmpresa() {
        System.out.println("getEmpresa");
        Date fecha = new Date();
        DTProveedor instance = new DTProveedor("juanpe", "Juan", "Pérez", "juanpe@gmail.com", "imagen", fecha, "empresa", "empresa.com");
        String expResult = "empresa";
        String result = instance.getEmpresa();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetWebEmpresa() {
        System.out.println("getWebEmpresa");
        Date fecha = new Date();
        DTProveedor instance = new DTProveedor("juanpe", "Juan", "Pérez", "juanpe@gmail.com", "imagen", fecha, "empresa", "empresa.com");
        String expResult = "empresa.com";
        String result = instance.getWebEmpresa();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Date fecha = new Date();
        DTProveedor instance = new DTProveedor("juanpe", "Juan", "Pérez", "juanpe@gmail.com", "imagen", fecha, "empresa", "empresa.com");
        String expResult = "Nickname: " + "juanpe"
                + "\n" + "Nombre: " + "Juan"
                + "\n" + "Apellido: " + "Pérez"
                + "\n" + "Email: " + "juanpe@gmail.com"
                + "\n" + "Fecha de nacimiento: "
                + Integer.toString(fecha.getDate()) + "-"
                + Integer.toString(fecha.getMonth() + 1) + "-"
                + Integer.toString(fecha.getYear()) + "\n"
                + "Empresa: " + "empresa" + "\n"
                + "Web Empresa: " + "empresa.com" + "\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
