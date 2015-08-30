/*
 * Header Test
 */
package com.tprog.logica.dt;

import java.util.Set;
import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;

public class DTCategoriaTest{

	public DTCategoriaTest() {
	}

	@Test
	public void testGetIdCategoria() {
		System.out.println("getIdCategoria");
		DTCategoria instance = new DTCategoria("testID", null);
		String expResult = "testID";
		String result = instance.getIdCategoria();
		assertEquals(expResult, result);
		fail("fallo en DTCategoria::getIdCategoria.");
	}

	@Test
	public void testGetSubCategorias() {
		System.out.println("getSubCategorias");
		DTCategoria sub1 = new DTCategoria("subCategoria1", null);
		DTCategoria sub2 = new DTCategoria("subCategoria2", null);
		DTCategoria sub3 = new DTCategoria("subCategoria3", null);
		Set<DTCategoria> subCategorias = new HashSet();
		subCategorias.add(sub1);
		subCategorias.add(sub2);
		subCategorias.add(sub3);
		DTCategoria instance = new DTCategoria("categoriaPadre", subCategorias);
		Set<DTCategoria> expResult = subCategorias;
		Set<DTCategoria> result = instance.getSubCategorias();
		assertEquals(expResult, result);
		fail("fallo en DTCategoria::getSubCategorias.");
	}

}
