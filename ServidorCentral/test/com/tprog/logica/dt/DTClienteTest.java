/*
 * Header Test
 */
package com.tprog.logica.dt;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DTClienteTest {

    public DTClienteTest() {
    }

    @Test
    public void testGetReservas() {
        System.out.println("getReservas");
        DTMinReserva r1 = new DTMinReserva(5, new Date());
        DTMinReserva r2 = new DTMinReserva(7, new Date());
        Set<DTMinReserva> set = new HashSet();
        set.add(r1);
        set.add(r2);
        DTCliente instance = new DTCliente("juanpe", "Juan", "Pérez", "juanpe@gmail.com", null, null, set);
        Set<DTMinReserva> expResult = set;
        Set<DTMinReserva> result = instance.getReservas();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        DTMinReserva r1 = new DTMinReserva(123, new Date(2015, 9, 7));
        Set<DTMinReserva> set = new HashSet();
        set.add(r1);
        Date fechaN = new Date(1992, 1, 8);
        DTCliente instance = new DTCliente("juanpe", "Juan", "Pérez", "juanpe@gmail.com", "imagen", fechaN, set);
        String expResult = "Nickname: " + "juanpe"
                + "\n" + "Nombre: " + "Juan"
                + "\n" + "Apellido: " + "Pérez"
                + "\n" + "Email: " + "juanpe@gmail.com"
                + "\n" + "Fecha de nacimiento: "
                + Integer.toString(fechaN.getDate()) + "-"
                + Integer.toString(fechaN.getMonth() + 1) + "-"
                + Integer.toString(fechaN.getYear()) + "\n"
                + "\n" + "Reserva 1" + "\n"
                + "ID de reserva: " + "123"
                + "\n" + "Fecha de creacion: "
                + Integer.toString(r1.getFechaCreacion().getDate()) + "-"
                + Integer.toString(r1.getFechaCreacion().getMonth() + 1) + "-"
                + Integer.toString(r1.getFechaCreacion().getYear()) + "\n";

        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
