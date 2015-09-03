/*
 * Header Test
 */
package com.tprog.logica.clases;

import com.tprog.logica.dt.DTLineaReserva;
import com.tprog.logica.dt.DTMinReserva;
import com.tprog.logica.dt.DTReserva;
import com.tprog.logica.dt.EstadoReserva;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReservaTest {

	Reserva instance;
	Date fecha;
	Set<LineaReserva> lineasReserva;
	Servicio servicio;
	Promocion promocion;
	Set<DTLineaReserva> set;
	String nicknameProv;
	float precioTotal;
	EstadoReserva estado;

	public ReservaTest() {
	}

	@Before
	public void setUp() throws Exception {
		fecha = new Date();
		DTLineaReserva l1 = new DTLineaReserva(1, fecha, fecha, "idServicio1", null, 10);
		DTLineaReserva l2 = new DTLineaReserva(2, fecha, fecha, null, "idPromocion2", 20);
		DTLineaReserva l3 = new DTLineaReserva(3, fecha, fecha, "idServicio3", null, 30);
		set = new HashSet();
		set.add(l1);
		set.add(l2);
		set.add(l3);
		precioTotal = l1.getPrecio() + l2.getPrecio() * 2 + l3.getPrecio() * 3;
		this.nicknameProv = "Pedro";
		estado = EstadoReserva.Registrada;

		instance = new Reserva(fecha, estado, precioTotal, set, nicknameProv);

	}

	/**
	 * Test of getIdReserva method, of class Reserva.
	 */
	@Test
	public void testGetIdReserva() {
		System.out.println("getIdReserva");
		// La primer reserva tiene id 1
		// Para que el test pase debe realizarse un Clean Build antes
		int expResult = 1; // valor autogenerado gg
		int result = instance.getIdReserva();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getFCreacion method, of class Reserva.
	 */
	@Test
	public void testGetFCreacion() {
		System.out.println("getFCreacion");

		Date expResult = fecha;
		Date result = instance.getFCreacion();
		assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of getEstadoReserva method, of class Reserva.
	 */
	@Test
	public void testGetEstadoReserva() {
		System.out.println("getEstadoReserva");

		EstadoReserva expResult = estado;
		EstadoReserva result = EstadoReserva.Registrada;
		if (instance != null) {
			result = instance.getEstadoReserva();
		}
		assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of getPrecioTotal method, of class Reserva.
	 */
	@Test
	public void testGetPrecioTotal() {
		System.out.println("getPrecioTotal");
		float expResult = this.precioTotal;
		float result = 0;
		if (instance != null) {
			result = instance.getPrecioTotal();
		}
		assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of agregarLineaReserva method, of class Reserva.
	 */
	@Test
	public void testAgregarLineaReserva() {
		System.out.println("agregarLineaReserva");
		LineaReserva linea = null;

		if ((linea != null) && (instance != null)) {
			instance.agregarLineaReserva(linea);
		}
        // TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of setEstadoReserva method, of class Reserva.
	 */
	@Test
	public void testSetEstadoReserva() {
		System.out.println("setEstadoReserva");
		EstadoReserva expResult = EstadoReserva.Cancelada;
		instance.setEstadoReserva(EstadoReserva.Cancelada);
		EstadoReserva result = instance.getEstadoReserva();
		// TODO review the generated test code and remove the default call to fail.
		assertEquals(expResult, result);
	}

	/**
	 * Test of setPrecioTotal method, of class Reserva.
	 */
	@Test
	public void testSetPrecioTotal() {
		System.out.println("setPrecioTotal");

		float p = 20;

		instance.setPrecioTotal(p);
		float result = instance.getPrecioTotal();
		// TODO review the generated test code and remove the default call to fail.
		assertEquals(p, result, 0);
	}

	/**
	 * Test of crearDTReserva method, of class Reserva.
	 */
	@Test
	public void testCrearDTReserva() {
		System.out.println("crearDTReserva");
		DTReserva result = instance.crearDTReserva();
		DTReserva esperado = new DTReserva(instance.getIdReserva(), fecha, instance.getEstadoReserva(), instance.getPrecioTotal(), set);

		assertEquals(esperado.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of crearDTMinReserva method, of class Reserva.
	 */
	@Test
	public void testCrearDTMinReserva() {
		System.out.println("crearDTMinReserva");

		DTMinReserva expected = new DTMinReserva(instance.getIdReserva(), this.fecha);

		DTMinReserva result = instance.crearDTMinReserva();

		assertEquals(expected.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of cambiarEstadoReserva method, of class Reserva.
	 */
	@Test
	public void testCambiarEstadoReserva() {
		System.out.println("cambiarEstadoReserva");
		EstadoReserva nuevoEstado = null;

		boolean expResult = false;
		boolean result = instance.cambiarEstadoReserva(nuevoEstado);
		assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of eliminar method, of class Reserva.
	 */
	@Test
	public void testEliminar() {
		System.out.println("eliminar");

		if (instance != null) {
			instance.eliminar();
		}

        // TODO review the generated test code and remove the default call to fail.
	}

}
