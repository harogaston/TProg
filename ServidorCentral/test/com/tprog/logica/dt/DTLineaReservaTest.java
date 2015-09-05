/*
 * Header Test
 */
package com.tprog.logica.dt;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DTLineaReservaTest {

    public DTLineaReservaTest() {
    }

    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        DTLineaReserva instance = new DTLineaReserva(5, new Date(), new Date(), "servicio", "promo", 186.53F);
        int expResult = 5;
        int result = instance.getCantidad();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFechaInicio() {
        System.out.println("getFechaInicio");
        Date fInicio = new Date();
        DTLineaReserva instance = new DTLineaReserva(5, fInicio, new Date(), "servicio", "promo", 186.53F);
        Date expResult = fInicio;
        Date result = instance.getFechaInicio();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFechaFin() {
        System.out.println("getFechaFin");
        Date fFin = new Date();
        DTLineaReserva instance = new DTLineaReserva(5, fFin, new Date(), "servicio", "promo", 186.53F);
        Date expResult = fFin;
        Date result = instance.getFechaFin();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetServicio() {
        System.out.println("getServicio");
        DTLineaReserva instance = new DTLineaReserva(5, new Date(), new Date(), "servicio", "promo", 186.53F);
        String expResult = "servicio";
        String result = instance.getServicio();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPromocion() {
        System.out.println("getPromocion");
        DTLineaReserva instance = new DTLineaReserva(5, new Date(), new Date(), "servicio", "promo", 186.53F);
        String expResult = "promo";
        String result = instance.getPromocion();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        DTLineaReserva instance = new DTLineaReserva(5, new Date(), new Date(), "servicio", "promo", 186.53F);
        float expResult = 186.53F;
        float result = instance.getPrecio();
        assertEquals(expResult, result, 0.001F);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Date fInicio = new Date();
        Date fFin = new Date();
        DTLineaReserva instance = new DTLineaReserva(5, fInicio, fFin, "servicio", "promo", 186.53F);
        String expResult = "Cantidad: " + Integer.toString(5)
                + "\n" + "Fecha de inicio=" + fInicio.toString()
                + "\n" + "Fecha de fin=" + fFin.toString()
                + "\n" + "Servicio=" + "servicio"
                + "\n" + "Promocion=" + "promo"
                + "\n" + "Precio=" + Float.toString(186.53F) + "\n";;
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
