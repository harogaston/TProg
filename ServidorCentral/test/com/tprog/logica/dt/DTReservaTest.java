/*
 * Header Test
 */
package com.tprog.logica.dt;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class DTReservaTest {

	DTReserva instance;
	Date fecha;
	Set<DTLineaReserva> set;
	
	public DTReservaTest() {
	}

	@Before
	public void setUp() {
		fecha = new Date();
		DTLineaReserva l1 = new DTLineaReserva(1, fecha, fecha, "idServicio1", null, 10.0F);
		DTLineaReserva l2 = new DTLineaReserva(2, fecha, fecha, null, "idPromocion2", 20.0F);
		DTLineaReserva l3 = new DTLineaReserva(3, fecha, fecha, "idServicio3", null, 30.0F);
		set = new HashSet();
		set.add(l1);
		set.add(l2);
		set.add(l3);
		float precioTotal = l1.getPrecio() + l2.getPrecio() * 2 + l3.getPrecio() * 3;
		instance = new DTReserva(15, fecha, EstadoReserva.Pagada, precioTotal, set);
	}

	@Test
	public void testGetIdReserva() {
		System.out.println("getIdReserva");
		int expResult = 15;
		int result = instance.getIdReserva();
		assertEquals(expResult, result);
	}

	@Test
	public void testGetFCreacion() {
		System.out.println("getFCreacion");
		Date expResult = fecha;
		Date result = instance.getFCreacion();
		assertEquals(expResult, result);
	}

	@Test
	public void testGetEstadoReserva() {
		System.out.println("getEstadoReserva");
		EstadoReserva expResult = EstadoReserva.Pagada;
		EstadoReserva result = instance.getEstadoReserva();
		assertEquals(expResult, result);
	}

	@Test
	public void testGetPrecioTotal() {
		System.out.println("getPrecioTotal");
		float expResult = 140.0F;
		float result = instance.getPrecioTotal();
		assertEquals(expResult, result, 0.001);
	}

	@Test
	public void testGetLineasReserva() {
		System.out.println("getLineasReserva");
		Set<DTLineaReserva> expResult = set;
		Set<DTLineaReserva> result = instance.getLineasReserva();
		assertEquals(expResult, result);
	}

	@Test
	public void testToString() {
		System.out.println("toString");
		String expResult = "ID de reserva: " + Integer.toString(15)
				+ "\n" + "Fecha de creacion" + fecha.toString()
				+ "\n" + "Estado: " + EstadoReserva.Pagada.toString()
				+ "\n" + "Precio total: " + Float.toString(140.0F)
				+ "\n" + "Lineas de reserva: " + "\n"
				+ "Linea " + Integer.toString(1) + "\n"
				+ "Cantidad: " + "2"
				+ "\n" + "Fecha de inicio=" + fecha.toString()
				+ "\n" + "Fecha de fin=" + fecha.toString()
				+ "\n" + "Servicio=" + ""
				+ "\n" + "Promocion=" + "idPromocion2"
				+ "\n" + "Precio=" + Float.toString(20.0F) + "\n"
				+ "Linea " + Integer.toString(2) + "\n"
				+ "Cantidad: " + "3"
				+ "\n" + "Fecha de inicio=" + fecha.toString()
				+ "\n" + "Fecha de fin=" + fecha.toString()
				+ "\n" + "Servicio=" + "idServicio3"
				+ "\n" + "Promocion=" + ""
				+ "\n" + "Precio=" + Float.toString(30.0F) + "\n"
				+ "Linea " + Integer.toString(3) + "\n"
				+ "Cantidad: " + "1"
				+ "\n" + "Fecha de inicio=" + fecha.toString()
				+ "\n" + "Fecha de fin=" + fecha.toString()
				+ "\n" + "Servicio=" + "idServicio1"
				+ "\n" + "Promocion=" + ""
				+ "\n" + "Precio=" + Float.toString(10.0F) + "\n"
;
		String result = instance.toString();
		assertEquals(expResult, result);
	}

}
