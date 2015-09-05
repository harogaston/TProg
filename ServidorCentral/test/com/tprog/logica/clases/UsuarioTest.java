/*
 * Header Test
 */
package com.tprog.logica.clases;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

    Date fechaN;
    Usuario instance;

    public UsuarioTest() {
    }

    @Before
    public void setUp() {
        fechaN = new Date(1987, 7, 23);
        instance = new Usuario("harogaston", "Gastón", "Haro", "harogason@gmail.com", "perico", fechaN);
    }

    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        String expResult = "Gastón";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetApellido() {
        System.out.println("getApellido");
        String expResult = "Haro";
        String result = instance.getApellido();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        String expResult = "harogaston";
        String result = instance.getNickname();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String expResult = "harogason@gmail.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetImagen() {
        System.out.println("getImagen");
        String expResult = "perico";
        String result = instance.getImagen();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFechaNacimiento() {
        System.out.println("getFechaNacimiento");
        Date expResult = fechaN;
        Date result = instance.getFechaNacimiento();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "GastónAlt";
        instance.setNombre(nombre);
        String result = instance.getNombre();
        assertEquals(nombre, result);
    }

    @Test
    public void testSetApellido() {
        System.out.println("setApellido");
        String apellido = "HaroAlt";
        instance.setApellido(apellido);
        String result = instance.getApellido();
        assertEquals(apellido, result);
    }

    @Test
    public void testSetNickname() {
        System.out.println("setNickname");
        String nickname = "harogastonAlt";
        instance.setNickname(nickname);
        String result = instance.getNickname();
        assertEquals(nickname, result);
    }

    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "alt@gmail.com";
        instance.setEmail(email);
        String result = instance.getEmail();
        assertEquals(email, result);
    }

    @Test
    public void testSetImagen() {
        System.out.println("setImagen");
        String imagen = "imagenAlt";
        instance.setImagen(imagen);
        String result = instance.getImagen();
        assertEquals(imagen, result);
    }

    @Test
    public void testSetFechaNacimiento() {
        System.out.println("setFechaNacimiento");
        Date fechaN = new Date();
        instance.setFechaNacimiento(fechaN);
        Date result = instance.getFechaNacimiento();
        assertEquals(fechaN, result);
    }

}
