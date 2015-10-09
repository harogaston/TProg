/*
 * Header Test
 */
package tprog.logica.dt;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DTLineaReservaTest {

    public DTLineaReservaTest() {
    }

    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        DTLineaReserva instance = new DTLineaReserva(5, new Date(), new Date(), "servicio", "promo", null, 186.53F);
        int expResult = 5;
        int result = instance.getCantidad();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFechaInicio() {
        System.out.println("getFechaInicio");
        Date fInicio = new Date();
        DTLineaReserva instance = new DTLineaReserva(5, fInicio, new Date(), "servicio", "promo", null, 186.53F);
        Date expResult = fInicio;
        Date result = instance.getFechaInicio();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFechaFin() {
        System.out.println("getFechaFin");
        Date fFin = new Date();
        DTLineaReserva instance = new DTLineaReserva(5, fFin, new Date(), "servicio", "promo", null, 186.53F);
        Date expResult = fFin;
        Date result = instance.getFechaFin();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetServicio() {
        System.out.println("getServicio");
        DTLineaReserva instance = new DTLineaReserva(5, new Date(), new Date(), "servicio", "promo", null, 186.53F);
        String expResult = "servicio";
        String result = instance.getServicio();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPromocion() {
        System.out.println("getPromocion");
        DTLineaReserva instance = new DTLineaReserva(5, new Date(), new Date(), "servicio", "promo", null, 186.53F);
        String expResult = "promo";
        String result = instance.getPromocion();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        DTLineaReserva instance = new DTLineaReserva(5, new Date(), new Date(), "servicio", "promo", null, 186.53F);
        float expResult = 186.53F;
        float result = instance.getPrecio();
        assertEquals(expResult, result, 0.001F);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        //servicio
        Date fInicio = new Date();
        Date fFin = new Date();
        DTLineaReserva instance = new DTLineaReserva(5, fInicio, fFin, "servicio", null, null, (float) 1.5);
        String expResult = "Cantidad: " + Integer.toString(5)
                + "\n" + "Fecha de inicio: "
                + Integer.toString(fInicio.getDate()) + "-"
                + Integer.toString(fInicio.getMonth() + 1) + "-"
                + Integer.toString(fInicio.getYear())
                + "\n" + "Fecha de fin: "
                + Integer.toString(fFin.getDate()) + "-"
                + Integer.toString(fFin.getMonth() + 1) + "-"
                + Integer.toString(fFin.getYear())
                + "\n" + "Servicio: " + "servicio"
                + "\n" + "Precio: " + Float.toString((float) 1.5) + "\n";
        String result = instance.toString();
        assertEquals(expResult, result);
        //promocion
        fInicio = new Date();
        fFin = new Date();
        instance = new DTLineaReserva(5, fInicio, fFin, null, "promo", null, (float) 1.5);
        expResult = "Cantidad: " + Integer.toString(5)
                + "\n" + "Fecha de inicio: "
                + Integer.toString(fInicio.getDate()) + "-"
                + Integer.toString(fInicio.getMonth() + 1) + "-"
                + Integer.toString(fInicio.getYear())
                + "\n" + "Fecha de fin: "
                + Integer.toString(fFin.getDate()) + "-"
                + Integer.toString(fFin.getMonth() + 1) + "-"
                + Integer.toString(fFin.getYear())
                + "\n" + "Promocion: " + "promo"
                + "\n" + "Precio: " + Float.toString((float) 1.5) + "\n";
        result = instance.toString();
        assertEquals(expResult, result);
    }

}
