/*
 * Header Test
 */
package com.tprog.logica.dt;

import org.junit.Test;
import static org.junit.Assert.*;

public class DTMinPromocionTest {
	
	public DTMinPromocionTest() {
	}

	@Test
	public void testGetNicknameP() {
		System.out.println("getNicknameP");
		DTMinPromocion instance = new DTMinPromocion("nick", "idPromo");
		String expResult = "nick";
		String result = instance.getNicknameP();
		assertEquals(expResult, result);
	}

	@Test
	public void testGetIdPromocion() {
		System.out.println("getIdPromocion");
		DTMinPromocion instance = new DTMinPromocion("nick", "idPromo");
		String expResult = "idPromo";
		String result = instance.getIdPromocion();
		assertEquals(expResult, result);
	}

	@Test
	public void testToString() {
		System.out.println("toString");
		DTMinPromocion instance = new DTMinPromocion("nick", "idPromo");
		String expResult = "Nickname del proveedor: " + "nick"
				+ "\n" + "ID de servicio: " + "idPromo" + "\n";
		String result = instance.toString();
		assertEquals(expResult, result);
	}
	
}
