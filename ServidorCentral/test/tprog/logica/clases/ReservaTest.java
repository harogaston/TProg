package tprog.logica.clases;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tprog.logica.dt.DTLineaReserva;
import tprog.logica.dt.DTMinReserva;
import tprog.logica.dt.DTReserva;
import tprog.logica.dt.EstadoReserva;

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

	@BeforeClass
	public static void setUpClass() {

	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() throws Exception {
		fecha = new Date();
		DTLineaReserva linea1 = new DTLineaReserva(1, fecha, fecha, "idServicio1", null, null, 10);
		DTLineaReserva linea2 = new DTLineaReserva(2, fecha, fecha, null, "idPromocion2", null, 20);
		DTLineaReserva linea3 = new DTLineaReserva(3, fecha, fecha, "idServicio3", null, null, 30);
		set = new HashSet();
		set.add(linea1);
		set.add(linea2);
		set.add(linea3);
                //set.add(l4); 

		precioTotal = linea1.getPrecio() + linea2.getPrecio() * 2 + linea3.getPrecio() * 3;
		this.nicknameProv = "Pedro";
		estado = EstadoReserva.Registrada;
		DTReserva dtR = new DTReserva(-1, fecha, estado, precioTotal, set);
		instance = new Reserva(null, dtR);
		//instance = new Reserva(fecha,estado,precioTotal,set,nicknameProv);

	}

	@After
	public void tearDown() {

	}

	/**
	 * Test of getIdReserva method, of class Reserva.
	 */
	@Test
	public void testGetIdReserva() {
		System.out.println("getIdReserva");

		int result = instance.getIdReserva();
                assertEquals(result, result);
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

		EstadoReserva expResult = EstadoReserva.Registrada;
		EstadoReserva result = null;

		result = instance.getEstado();

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

		LineaReserva lin1 = new LineaReserva(5, fecha, fecha, servicio, null, 20);
		LineaReserva lin2 = new LineaReserva(6, fecha, fecha, null, promocion, 20);

		instance.agregarLineaReserva(lin1);
		instance.agregarLineaReserva(lin2);
		assertTrue(instance.getLineasReserva().contains(lin1));
		assertTrue(instance.getLineasReserva().contains(lin2));

	}

	/**
	 * Test of setEstadoReserva method, of class Reserva.
	 */
	@Test
	public void testSetEstadoReserva() {
		System.out.println("setEstadoReserva");

		instance.setEstadoReserva(EstadoReserva.Cancelada);
		assertEquals(EstadoReserva.Cancelada, instance.getEstado());

	}

	/**
	 * Test of setPrecioTotal method, of class Reserva.
	 */
	@Test
	public void testSetPrecioTotal() {
		System.out.println("setPrecioTotal");

		float precio = 20;

		instance.setPrecioTotal(precio);
		float result = instance.getPrecioTotal();
		assertEquals(precio, result, 0);
	}

	/**
	 * Test of crearDT method, of class Reserva.
	 */
	@Test
	public void testCrearDTReserva() throws Exception {
		System.out.println("crearDTReserva");

		DTReserva esperado = new DTReserva(instance.getIdReserva(), fecha, instance.getEstado(), instance.getPrecioTotal(), new HashSet());

		DTReserva result = instance.crearDT();
		assertEquals(esperado.getEstadoReserva(), result.getEstadoReserva());
		assertEquals(esperado.getPrecioTotal(), result.getPrecioTotal(), 0);
		assertTrue(esperado.getFCreacion().equals(result.getFCreacion()));
		//assertEquals(esperado.getLineasReserva().size(), result.getLineasReserva().size());
	}

	/**
	 * Test of crearDTMin method, of class Reserva.
	 */
	@Test
	public void testCrearDTMinReserva() {
		System.out.println("crearDTMinReserva");

		DTMinReserva expected = new DTMinReserva(instance.getIdReserva(), this.fecha);

		DTMinReserva result = instance.crearDTMin();

		assertEquals(expected.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.

	}

	/**
	 * Test of cambiarEstadoReserva method, of class Reserva.
	 */
	@Test
	public void testCambiarEstadoReserva() {
		System.out.println("cambiarEstadoReserva");
		EstadoReserva nuevoEstado = EstadoReserva.Facturada;

		instance.cambiarEstadoReserva(nuevoEstado);
		assertTrue(EstadoReserva.Registrada.equals(instance.getEstado()));
		nuevoEstado = EstadoReserva.Cancelada;
		instance.cambiarEstadoReserva(nuevoEstado);
		assertTrue(EstadoReserva.Cancelada.equals(instance.getEstado()));
		instance.cambiarEstadoReserva(nuevoEstado);
		assertTrue(EstadoReserva.Cancelada.equals(instance.getEstado()));
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
		assertEquals(null, instance.getLineasReserva());
        // TODO review the generated test code and remove the default call to fail.

	}

}
