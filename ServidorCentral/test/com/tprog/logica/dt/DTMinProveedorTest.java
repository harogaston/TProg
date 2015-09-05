/*
 * Header Test
 */
package com.tprog.logica.dt;

import org.junit.Test;
import static org.junit.Assert.*;

public class DTMinProveedorTest {
	
	public DTMinProveedorTest() {
	}

	@Test
	public void testGetNickname() {
		System.out.println("getNickname");
		DTMinProveedor instance = new DTMinProveedor("nick", "nick@email.com", "empresa");
		String expResult = "nick";
		String result = instance.getNickname();
		assertEquals(expResult, result);
	}

	@Test
	public void testGetEmail() {
		System.out.println("getEmail");
		DTMinProveedor instance = new DTMinProveedor("nick", "nick@email.com", "empresa");
		String expResult = "nick@email.com";
		String result = instance.getEmail();
		assertEquals(expResult, result);
	}

	@Test
	public void testGetEmpresa() {
		System.out.println("getEmpresa");
		DTMinProveedor instance = new DTMinProveedor("nick", "nick@email.com", "empresa");
		String expResult = "empresa";
		String result = instance.getEmpresa();
		assertEquals(expResult, result);
	}

	@Test
	public void testToString() {
		System.out.println("toString");
		DTMinProveedor instance = new DTMinProveedor("nick", "nick@email.com", "empresa");
		String expResult = "Nickname: " + "nick"
				+ "\n" + "Email: " + "nick@email.com" + "\n"
				+ "\n" + "Empresa: " + "empresa" + "\n";
		String result = instance.toString();
		assertEquals(expResult, result);
	}
	
}
