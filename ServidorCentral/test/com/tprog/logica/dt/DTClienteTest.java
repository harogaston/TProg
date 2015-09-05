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
        DTMinReserva r1 = new DTMinReserva(123, new Date());
        Set<DTMinReserva> set = new HashSet();
        set.add(r1);
        Date fechaN = new Date();
        DTCliente instance = new DTCliente("juanpe", "Juan", "Pérez", "juanpe@gmail.com", "imagen", fechaN, set);
        String expResult = "Nickname: " + "juanpe"
                + "\n" + "Nombre: " + "Juan"
                + "\n" + "Apellido: " + "Pérez"
                + "\n" + "Email: " + "juanpe@gmail.com"
                + "\n" + "Fecha de nacimiento: " + fechaN.toString() + "\n"
                + "Reserva 1\n" + "ID de reserva: " + "123" + "\n"
                + "Fecha de creacion: "
                + r1.getFechaCreacion().toString() + "\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
