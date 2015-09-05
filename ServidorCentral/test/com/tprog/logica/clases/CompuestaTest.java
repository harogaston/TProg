/*
 * Header Test
 */
package com.tprog.logica.clases;

import com.tprog.logica.dt.DTMinServicio;
import java.util.HashSet;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MarG
 */
public class CompuestaTest {
    
    Compuesta instance;
    
    public CompuestaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Compuesta("idCategoria");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setPadre method, of class Compuesta.
     */
    @Test
    public void testSetPadre() {
        System.out.println("setPadre");
        Compuesta padre = new Compuesta("padre");
        instance.setPadre(padre);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getPadre method, of class Compuesta.
     */
    @Test
    public void testGetPadre() {
        System.out.println("getPadre");
        Compuesta padre = new Compuesta("padre");
        instance.setPadre(padre);
        Compuesta expResult = padre;
        Compuesta result = instance.getPadre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getIdCategoria method, of class Compuesta.
     */
    @Test
    public void testGetIdCategoria() {
        System.out.println("getIdCategoria");
        String expResult = "idCategoria";
        String result = instance.getIdCategoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of listarServicios method, of class Compuesta.
     */
    @Test
    public void testListarServicios() {
        System.out.println("listarServicios");
        Categoria cat = new Simple("idCategoria");;
        instance.add(cat);
        Set<DTMinServicio> expResult = new HashSet();
        Set<DTMinServicio> result = instance.listarServicios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of esCategoriaSimple method, of class Compuesta.
     */
    @Test
    public void testEsCategoriaSimple() {
        System.out.println("esCategoriaSimple");
        boolean expResult = false;
        boolean result = instance.esCategoriaSimple();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of add method, of class Compuesta.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Categoria cat = new Simple("idCategoria");;
        instance.add(cat);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of remove method, of class Compuesta.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Categoria cat = new Simple("idCategoria");
        instance.add(cat);
        instance.remove(cat);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of esCategoriaPadre method, of class Compuesta.
     */
    @Test
    public void testEsCategoriaPadre() {
        System.out.println("esCategoriaPadre");
        boolean expResult = true;
        boolean result = instance.esCategoriaPadre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of listarCategorias method, of class Compuesta.
     */
    @Test
    public void testListarCategorias() {
        System.out.println("listarCategorias");
        DefaultMutableTreeNode expResult = new DefaultMutableTreeNode("idCategoria");
        Categoria cat = new Simple("idCategoria");
        instance.add(cat);
        DefaultMutableTreeNode result = instance.listarCategorias();
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
