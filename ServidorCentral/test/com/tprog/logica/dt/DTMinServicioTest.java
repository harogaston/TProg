/*
 * Header Test
 */
package com.tprog.logica.dt;

import org.junit.Test;
import static org.junit.Assert.*;

public class DTMinServicioTest {
	
	public DTMinServicioTest() {
	}

	@Test
	public void testGetNicknameP() {
		System.out.println("getNicknameP");
		DTMinServicio instance = new DTMinServicio("nickP", "id");
		String expResult = "nickP";
		String result = instance.getNicknameP();
		assertEquals(expResult, result);
	}

	@Test
	public void testGetIdServicio() {
		System.out.println("getIdServicio");
		DTMinServicio instance = new DTMinServicio("nickP", "id");
		String expResult = "id";
		String result = instance.getIdServicio();
		assertEquals(expResult, result);
	}

	@Test
	public void testToString() {
		System.out.println("toString");
		DTMinServicio instance = new DTMinServicio("nickP", "id");
		String expResult = "Nickname del proveedor: " + "nickP"
				+ "\n" + "ID de servicio: " + "id" + "\n";
		String result = instance.toString();
		assertEquals(expResult, result);
	}
	
}
