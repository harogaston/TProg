/*
 * Header Test
 */
package com.tprog.logica.dt;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gaston
 */
public class DTPromocionTest {
	
	public DTPromocionTest() {
	}

	@Test
	public void testGetIdPromocion() {
		System.out.println("getIdPromocion");
		DTMiniItem s1 = new DTMiniItem("Pepe", 1);
		DTMiniItem s2 = new DTMiniItem("Pipi", 2);
		DTMiniItem s3 = new DTMiniItem("Popo", 1);
		Set<DTMiniItem> set = new HashSet();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		DTPromocion instance = new DTPromocion("id", 0.25F, 550.0F, set);
		String expResult = "id";
		String result = instance.getIdPromocion();
		assertEquals(expResult, result);
	}

	@Test
	public void testGetDescuento() {
		System.out.println("getDescuento");
		DTMiniItem s1 = new DTMiniItem("Pepe", 1);
		DTMiniItem s2 = new DTMiniItem("Pipi", 2);
		DTMiniItem s3 = new DTMiniItem("Popo", 1);
		Set<DTMiniItem> set = new HashSet();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		DTPromocion instance = new DTPromocion("id", 0.25F, 550.0F, set);
		float expResult = 0.25F;
		float result = instance.getDescuento();
		assertEquals(expResult, result, 0.001);
	}

	@Test
	public void testGetTotal() {
		System.out.println("getTotal");
		DTMiniItem s1 = new DTMiniItem("Pepe", 1);
		DTMiniItem s2 = new DTMiniItem("Pipi", 2);
		DTMiniItem s3 = new DTMiniItem("Popo", 1);
		Set<DTMiniItem> set = new HashSet();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		DTPromocion instance = new DTPromocion("id", 0.25F, 550.0F, set);
		float expResult = 550.0F;
		float result = instance.getTotal();
		assertEquals(expResult, result, 0.001);
	}

	@Test
	public void testGetServicios() {
		System.out.println("getServicios");
		DTMinServicio s1 = new DTMinServicio("Pepe", "550");
		DTMinServicio s2 = new DTMinServicio("Pepe", "123");
		DTMinServicio s3 = new DTMinServicio("Pepe", "89");
		Set<DTMinServicio> set = new HashSet();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		DTPromocion instance = new DTPromocion("id", 0.25F, 550.0F, set);
		Set<DTMinServicio> expResult = set;
		Set<DTMinServicio> result = instance.getServicios();
		assertEquals(expResult, result);
	}

	@Test
	public void testToString() {
		System.out.println("toString");
		DTMinServicio s1 = new DTMinServicio("Pepe", "550");
		DTMinServicio s2 = new DTMinServicio("Pepe", "123");
		DTMinServicio s3 = new DTMinServicio("Pepe", "89");
		Set<DTMinServicio> set = new HashSet();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		DTPromocion instance = new DTPromocion("id", 0.25F, 550.0F, set);
		String expResult = "ID de promocion: " + "id"
				+ "\n" + "Descuento: " + Float.toString(0.25F)
				+ "\n" + "Total: " + Float.toString(550.0F)
				+ "\n" + "Servicios: " + "\n"
				+ "Servicio " + Integer.toString(1) + ": "
				+ "Nickname del proveedor: " + "Pepe"
				+ "\n" + "ID de servicio: " + "550" + "\n"
				+ "Servicio " + Integer.toString(2) + ": "
				+ "Nickname del proveedor: " + "Pepe"
				+ "\n" + "ID de servicio: " + "123" + "\n"
				+ "Servicio " + Integer.toString(3) + ": "
				+ "Nickname del proveedor: " + "Pepe"
				+ "\n" + "ID de servicio: " + "89" + "\n";
		String result = instance.toString();
		assertEquals(expResult, result);
	}
	
}
