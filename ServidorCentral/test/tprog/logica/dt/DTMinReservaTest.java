/*
 * Header Test
 */
package tprog.logica.dt;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DTMinReservaTest {

    public DTMinReservaTest() {
    }

    @Test
    public void testGetIdReserva() {
        System.out.println("getIdReserva");
        Date fecha = new Date();
        DTMinReserva instance = new DTMinReserva(123, fecha);
        int expResult = 123;
        int result = instance.getIdReserva();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFechaCreacion() {
        System.out.println("getFechaCreacion");
        Date fecha = new Date();
        DTMinReserva instance = new DTMinReserva(123, fecha);
        Date expResult = fecha;
        Date result = instance.getFechaCreacion();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Date fecha = new Date();
        DTMinReserva instance = new DTMinReserva(123, fecha);
        String expResult = "ID de reserva: " + Integer.toString(123)
                + "\n" + "Fecha de creacion: "
                + Integer.toString(fecha.getDate()) + "-"
                + Integer.toString(fecha.getMonth() + 1) + "-"
                + Integer.toString(fecha.getYear()) + "\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
