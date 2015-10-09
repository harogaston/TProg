package tprog.logica.clases;

import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import tprog.logica.dt.DTCliente;
import tprog.logica.dt.DTMinCliente;
import tprog.logica.dt.DTReserva;
import tprog.logica.dt.EstadoReserva;

public class ClienteTest {

	Cliente instance;
	Date fecha;

	public ClienteTest() {
	}

	@Before
	public void setUp() {
		fecha = new Date();
		DTCliente dtC = new DTCliente("nick", "pass", "nombre", "ap", "email", "imagen", fecha, new HashSet<>());
		instance = new Cliente(dtC);
	}

	@Test
	public void testCrearDT() {
		System.out.println("crearDT");
		DTCliente expResult = new DTCliente("nick", "pass", "nombre", "ap", "email", "imagen", fecha, new HashSet<>());
		instance = new Cliente(expResult);
		DTCliente result = instance.crearDT();
		assertEquals(expResult, result);
	}

	@Test
	public void testCrearDTMin() {
		System.out.println("crearDTMin");
		DTMinCliente expResult = new DTMinCliente("nick", "email");
		DTMinCliente result = instance.crearDTMin();
		assertEquals(expResult, result);
	}

	@Test
	public void testAgregarReserva() {
		System.out.println("agregarReserva");
		DTReserva r = new DTReserva(123, fecha, EstadoReserva.Pagada, 180.53F, new HashSet<>());
		Reserva reserva;
		try {
			reserva = new Reserva(instance, r);
			instance.agregarReserva(reserva);
		} catch (Exception ex) {
			Logger.getLogger(ClienteTest.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
