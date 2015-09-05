/*
 * Header Test
 */
package com.tprog.logica.dt;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gaston
 */
public class DTProveedorTest {
	
	public DTProveedorTest() {
	}

	@Test
	public void testGetEmpresa() {
		System.out.println("getEmpresa");
		Date fecha = new Date();
		DTProveedor instance = new DTProveedor("juanpe", "Juan", "Pérez", "juanpe@gmail.com", "imagen", fecha, "empresa", "empresa.com");
		String expResult = "empresa";
		String result = instance.getEmpresa();
		assertEquals(expResult, result);
	}

	@Test
	public void testGetWebEmpresa() {
		System.out.println("getWebEmpresa");
		Date fecha = new Date();
		DTProveedor instance = new DTProveedor("juanpe", "Juan", "Pérez", "juanpe@gmail.com", "imagen", fecha, "empresa", "empresa.com");
		String expResult = "empresa.com";
		String result = instance.getWebEmpresa();
		assertEquals(expResult, result);
	}

	@Test
	public void testToString() {
		System.out.println("toString");
		Date fecha = new Date();
		DTProveedor instance = new DTProveedor("juanpe", "Juan", "Pérez", "juanpe@gmail.com", "imagen", fecha, "empresa", "empresa.com");
		String expResult = "Nickname: " + "juanpe"
				+ "\n" + "Nombre: " + "Juan"
				+ "\n" + "Apellido: " + "Pérez"
				+ "\n" + "Email: " + "juanpe@gmail.com"
				+ "\n" + "Fecha de nacimiento: " + fecha.toString() + "\n"
				+ "Empresa: " + "empresa" + "\n"
				+ "Web Empresa: " + "empresa.com" + "\n";
		String result = instance.toString();
		assertEquals(expResult, result);
	}
	
}
