/*
 * Header Test
 */
package tprog.logica.dt;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class EstadoReservaTest {
	EstadoReserva instance;
	public EstadoReservaTest() {
	}

	@Before
	public void setUp() {
		instance = EstadoReserva.Cancelada;
	}

	@Test
	public void testValues() {
		System.out.println("values");
		EstadoReserva[] test = new EstadoReserva[4];
		test[1] = EstadoReserva.Cancelada;
		test[0] = EstadoReserva.Registrada;
		test[3] = EstadoReserva.Facturada;
		test[2] = EstadoReserva.Pagada;
		EstadoReserva[] expResult = test;
		EstadoReserva[] result = EstadoReserva.values();
		assertArrayEquals(expResult, result);
	}

	@Test
	public void testValueOf() {
		System.out.println("valueOf");
		String name = "Facturada";
		EstadoReserva expResult = EstadoReserva.Facturada;
		EstadoReserva result = EstadoReserva.valueOf(name);
		assertEquals(expResult, result);
	}

	@Test
	public void testToString() {
		System.out.println("toString");
		String expResult = "Cancelada";
		String result = instance.toString();
		assertEquals(expResult, result);
	}
}
