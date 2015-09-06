 /* Header Test
 */
package com.tprog.logica.controladores;

import com.tprog.estaciondetrabajo.carga.CtrlCarga;
import com.tprog.logica.clases.Cliente;
import com.tprog.logica.clases.Promocion;
import com.tprog.logica.clases.Proveedor;
import com.tprog.logica.clases.Servicio;
import com.tprog.logica.dt.DTLineaReserva;
import com.tprog.logica.dt.DTMinPromocion;
import com.tprog.logica.dt.DTMinReserva;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTReserva;
import com.tprog.logica.dt.EstadoReserva;
import com.tprog.logica.manejadores.ManejadorProductos;
import com.tprog.logica.manejadores.ManejadorReservas;
import com.tprog.logica.manejadores.ManejadorUsuarios;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author MarG
 */
public class CtrlReservasTest {

    CtrlReservas instance;
    CtrlCarga ctrlUniversal;
    String nickname;
    String nicknameP;
    DTMinPromocion dtP;
    DTMinServicio dtS;
    DTReserva dtR;
    int idReserva;

    float precioTotal;
    Date fecha;
    Proveedor prov;
    Set<String> vacio;

    public CtrlReservasTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ctrlUniversal = new CtrlCarga();
        ctrlUniversal.cargarDatos();

        instance = new CtrlReservas();
        fecha = new Date();
        Proveedor prov = new Proveedor("nick", "nom", "ap", "email", "imagen", fecha, "empresa", "webEmpresa");
        nicknameP = prov.getNickname();
        DTLineaReserva l1 = new DTLineaReserva(1, fecha, fecha, "idServicio1", "", 10);
        Set<DTLineaReserva> set = new HashSet();
        set.add(l1);
        Cliente jorge = new Cliente("alguien", "alg", "apellido", "email", "imagen", fecha);
        Servicio ser = new Servicio("idServicio", "descripcion", 50, null, null, null, prov);
        Promocion promo = new Promocion("idPromocion", 20, prov);
        ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
        ManejadorProductos mp = ManejadorProductos.getInstance();
        vacio = null;
        mu.altaProveedor(prov.crearDT());
        //mp.altaPromocion("idPromocion", 20, "nick", vacio);
        mu.altaCliente(jorge.crearDT());

        instance.seleccionarProveedor("nick");
        //mp.altaServicio(ser.crearDT(),"nick",vacio);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of seleccionarCliente method, of class CtrlReservas.
     */
    @Test
    public void testSeleccionarCliente() {
        System.out.println("seleccionarCliente");
        String nickname = "";
        instance.seleccionarCliente(nickname);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(nickname, instance.getNickname());

    }

    /**
     * Test of seleccionarProveedor method, of class CtrlReservas.
     */
    @Test
    public void testSeleccionarProveedor() {
        System.out.println("seleccionarProveedor");
        String nicknameP = "nick";
        instance.seleccionarProveedor(nicknameP);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(nicknameP, instance.getNicknameP());

    }

    /**
     * Test of listarPromociones method, of class CtrlReservas.
     */
    @Test
    public void testListarPromociones() {
        System.out.println("listarPromociones");
        Set<DTMinPromocion> expResult = new HashSet();
        expResult.add(new DTMinPromocion("remus", "Euro-Vuelos-S-LC"));
        expResult.add(new DTMinPromocion("mHooch", "Sudamerica-Casas"));
        expResult.add(new DTMinPromocion("moody", "Euro-Cars-E-F"));
        expResult.add(new DTMinPromocion("remus", "Euro-Vuelos-S-FC"));
        expResult.add(new DTMinPromocion("moody", "Euro-Cars-E-S"));
        expResult.add(new DTMinPromocion("remus", "Euro-Vuelos-LC-FC"));
        expResult.add(new DTMinPromocion("moody", "Euro-Cars-ES-F"));
        expResult.add(new DTMinPromocion("mHooch", "Miami-Viaje"));
        Set<DTMinPromocion> result = instance.listarPromociones();
        boolean foundAll = true;
        for (DTMinPromocion dtResult : result) {
            boolean found = false;
            for (DTMinPromocion dtExpResult : expResult) {
                if (dtExpResult.getIdPromocion().equals(dtResult.getIdPromocion())
                        && dtExpResult.getNicknameP().equals(dtResult.getNicknameP())) {
                    found = true;
                }
            }
            foundAll = foundAll && found;
        }
        assertTrue(result.size() == expResult.size() && foundAll);

//        assertTrue(expResult.containsAll(result));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of listarServicios method, of class CtrlReservas.
     */
    @Test
    public void testListarServicios() {
        System.out.println("listarServicios");
        Set<DTMinServicio> expResult = new HashSet<>();
        expResult.add(new DTMinServicio("remus", "Euro-Vuelo-S"));
        expResult.add(new DTMinServicio("mHooch", "Floripa G. House"));
        expResult.add(new DTMinServicio("remus", "Euro-Vuelo-LC"));
        expResult.add(new DTMinServicio("moody", "Euro-Car-1"));
        expResult.add(new DTMinServicio("adippet", "TAM-FC"));
        expResult.add(new DTMinServicio("moody", "Euro-Car-2"));
        expResult.add(new DTMinServicio("mHooch", "Casa para p4 BsAs"));
        expResult.add(new DTMinServicio("moody", "Euro-Car-3"));
        expResult.add(new DTMinServicio("tCook", "Air-France-FC"));
        expResult.add(new DTMinServicio("mHooch", "Luxury south beach corner apartament"));
        expResult.add(new DTMinServicio("mHooch", "Coche-Miami"));
        expResult.add(new DTMinServicio("remus", "Euro-Vuelo-FC"));
        Set<DTMinServicio> result = instance.listarServicios();
        boolean foundAll = true;
        for (DTMinServicio dtResult : result) {
            boolean found = false;
            for (DTMinServicio dtExpResult : expResult) {
                if (dtExpResult.getIdServicio().equals(dtResult.getIdServicio())
                        && dtExpResult.getNicknameP().equals(dtResult.getNicknameP())) {
                    found = true;
                }
            }
            foundAll = foundAll && found;
        }
        assertTrue(result.size() == expResult.size() && foundAll);
    }

    /**
     * Test of seleccionarPromocion method, of class CtrlReservas.
     */
    @Test
    public void testSeleccionarPromocion() {
        System.out.println("seleccionarPromocion");
        DTMinPromocion dtP = new DTMinPromocion(this.nicknameP, "promo");

        instance.seleccionarPromocion(dtP);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(dtP.equals(instance.getDtP()));

    }

    /**
     * Test of seleccionarServicio method, of class CtrlReservas.
     */
    @Test
    public void testSeleccionarServicio() {
        System.out.println("seleccionarServicio");
        DTMinServicio dtS = new DTMinServicio(this.nicknameP, "bueno");

        instance.seleccionarServicio(dtS);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(dtS.equals(instance.getDtS()));

    }

    /**
     * Test of seleccionarDTReserva method, of class CtrlReservas.
     */
    @Test
    public void testSeleccionarDTReserva() {
        System.out.println("seleccionarDTReserva");
        DTReserva dtR = null;

        instance.seleccionarDTReserva(dtR);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(dtR, instance.getDtR());

    }

    /**
     * Test of ingresarLineaReserva method, of class CtrlReservas.
     */
    @Test
    public void testIngresarLineaReserva() {
        System.out.println("ingresarLineaReserva");
        ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
        ManejadorReservas mr = ManejadorReservas.getInstance();
        try {
            //R1 S1
            Set<DTLineaReserva> lineas = new HashSet();
            lineas.add(new DTLineaReserva(1, new Date(2015, 1 - 1, 1),
                    new Date(2015, 1 - 1, 1), "Euro-Vuelo-S", null, 1100));
            DTReserva dtR = new DTReserva(0, new Date(2015, 1 - 1, 1),
                    EstadoReserva.Facturada, 1100, lineas);
            mr.agregarReserva(mu.getCliente("oWood"), dtR, "remus");
            //R2    S1 S2
            lineas = new HashSet();
            lineas.add(new DTLineaReserva(2, new Date(2015, 1 - 1, 1),
                    new Date(2015, 1 - 1, 1), "Euro-Vuelo-S", null, 1100));
            lineas.add(new DTLineaReserva(1, new Date(2015, 1 - 1, 1),
                    new Date(2015, 1 - 1, 1), "Euro-Vuelo-LC", null, 850));
            dtR = new DTReserva(0, new Date(2015, 1 - 1, 1),
                    EstadoReserva.Cancelada, 3050, lineas);
            mr.agregarReserva(mu.getCliente("eWatson"), dtR, "remus");

            //R3    P7
            lineas = new HashSet();
            lineas.add(new DTLineaReserva(1, new Date(2015, 3 - 1, 5),
                    new Date(2015, 4 - 1, 2), null, "Sudamerica-Casas", 135));
            dtR = new DTReserva(0, new Date(2015, 3 - 1, 5),
                    EstadoReserva.Pagada, 135, lineas);
            mr.agregarReserva(mu.getCliente("BruceS"), dtR, "mHooch");
            //R4    S5 S6
            lineas = new HashSet();
            lineas.add(new DTLineaReserva(1, new Date(2015, 5 - 1, 8),
                    new Date(2015, 5 - 1, 12), "Euro-Car-2", null, 300));
            lineas.add(new DTLineaReserva(1, new Date(2015, 5 - 1, 8),
                    new Date(2015, 5 - 1, 12), "Euro-Car-3", null, 300));
            dtR = new DTReserva(0, new Date(2015, 5 - 1, 8),
                    EstadoReserva.Pagada, 600, lineas);
            mr.agregarReserva(mu.getCliente("JeffW"), dtR, "moody");
            //R5    S9
            lineas = new HashSet();
            lineas.add(new DTLineaReserva(2, new Date(2015, 8 - 1, 7),
                    new Date(2015, 8 - 1, 10), "Air-France-FC", null, 100));
            dtR = new DTReserva(0, new Date(2015, 8 - 1, 7),
                    EstadoReserva.Registrada, 200, lineas);
            mr.agregarReserva(mu.getCliente("oWood"), dtR, "tCook");

            //R6    P8 S7
            lineas = new HashSet();
            lineas.add(new DTLineaReserva(1, new Date(2015, 8 - 1, 7),
                    new Date(2015, 8 - 1, 14), null, "Miami-Viaje", 462));
            lineas.add(new DTLineaReserva(1, new Date(2015, 8 - 1, 14),
                    new Date(2015, 8 - 1, 21), "Casa para p4 BsAs", null, 80));
            dtR = new DTReserva(0, new Date(2015, 8 - 1, 7),
                    EstadoReserva.Registrada, 542, lineas);
            mr.agregarReserva(mu.getCliente("eWatson"), dtR, "mHooch");
            //R7    S2
            lineas = new HashSet();
            lineas.add(new DTLineaReserva(2, new Date(2015, 8 - 1, 7),
                    new Date(2015, 8 - 1, 7), "Euro-Vuelo-LC", null, 850));
            dtR = new DTReserva(0, new Date(2015, 8 - 1, 7),
                    EstadoReserva.Registrada, 1700, lineas);
            mr.agregarReserva(mu.getCliente("BruceS"), dtR, "remus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test of listarServiciosProveedor method, of class CtrlReservas.
     */
    @Test
    public void testListarServiciosProveedor() {
        System.out.println("listarServiciosProveedor");
        ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
        ManejadorProductos mp = ManejadorProductos.getInstance();
        Cliente jorge = new Cliente("alguien", "alg", "apellido", "email", "imagen", fecha);
        mu.altaCliente(jorge.crearDT());

        Set<DTMinServicio> expResult = new HashSet();
        Set<DTMinServicio> result = instance.listarServiciosProveedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of listarPromocionesProveedor method, of class CtrlReservas.
     */
    @Test
    public void testListarPromocionesProveedor() {
        System.out.println("listarPromocionesProveedor");

        Set<DTMinPromocion> expResult = new HashSet();
        Set<DTMinPromocion> result = instance.listarPromocionesProveedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of mostrarReservaTemporal method, of class CtrlReservas.
     */
    @Test
    public void testMostrarReservaTemporal() {
        System.out.println("mostrarReservaTemporal");
        DTReserva expResult = new DTReserva(-1, null, EstadoReserva.Registrada, 0, new HashSet<>());
        DTReserva result = instance.mostrarReservaTemporal();
        assertTrue(result.getEstadoReserva().equals(expResult.getEstadoReserva())
                && result.getIdReserva() == expResult.getIdReserva()
                && result.getLineasReserva().toString().equals(expResult.getLineasReserva().toString())
                && result.getPrecioTotal() == expResult.getPrecioTotal());
        //la fecha nunca va a hacer igual porque se crearían en momentos distintos
    }

    /**
     * Test of altaReserva method, of class CtrlReservas.
     */
    @Test
    public void testAltaReserva() throws Exception {
        instance.seleccionarServicio(new DTMinServicio("remus", "Euro-Vuelo-LC"));
        instance.altaReserva();
    }

    /**
     * Test of listarReservas method, of class CtrlReservas.
     */
    @Test
    public void testListarReservas() {
        System.out.println("listarReservas");
        Set<DTMinReserva> expResult = new HashSet();
        expResult.add(new DTMinReserva(1, new Date(2015, 1 - 1, 1)));
        expResult.add(new DTMinReserva(2, new Date(2015, 1 - 1, 1)));
        expResult.add(new DTMinReserva(3, new Date(2015, 3 - 1, 5)));
        expResult.add(new DTMinReserva(4, new Date(2015, 5 - 1, 8)));
        expResult.add(new DTMinReserva(5, new Date(2015, 8 - 1, 7)));
        expResult.add(new DTMinReserva(6, new Date(2015, 8 - 1, 7)));
        expResult.add(new DTMinReserva(7, new Date(2015, 8 - 1, 7)));
        Set<DTMinReserva> result = instance.listarReservas();
        boolean foundAll = true;
        for (DTMinReserva dtResult : result) {
            boolean found = false;
            for (DTMinReserva dtExpResult : expResult) {
                if (dtExpResult.getIdReserva() == dtResult.getIdReserva()
                        && dtExpResult.getFechaCreacion().compareTo(dtResult.getFechaCreacion()) == 0) {
                    found = true;
                }
            }
            foundAll = foundAll && found;
        }
        assertTrue(result.size() == expResult.size() && foundAll);
    }

    /**
     * Test of seleccionarReserva method, of class CtrlReservas.
     */
    @Test
    public void testSeleccionarReserva() {
        System.out.println("seleccionarReserva");

        instance.seleccionarReserva(80);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(80, instance.getIdReserva());

    }

    /**
     * Test of infoReserva method, of class CtrlReservas.
     */
    @Test
    public void testInfoReserva() {
        System.out.println("infoReserva");

        DTReserva expResult = null;
        DTReserva result = instance.infoReserva();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of cambiarEstadoReserva method, of class CtrlReservas.
     */
    @Test
    public void testCambiarEstadoReserva() {
        System.out.println("cambiarEstadoReserva");
        EstadoReserva nuevoEstado = EstadoReserva.Pagada;

        boolean expResult = false;
        boolean result = instance.cambiarEstadoReserva(nuevoEstado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of eliminarReserva method, of class CtrlReservas.
     */
    @Test
    public void testEliminarReserva() {
        System.out.println("eliminarReserva");
        Cliente jorge = new Cliente("alguien", "alg", "apellido", "email", "imagen", fecha);

        Servicio ser = new Servicio("idServicio", "descripcion", 50, null, null, null, prov);
        this.dtS = new DTMinServicio("nick", "idServicio");
        instance.eliminarReserva();
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void getEstadoReserva() {
        System.out.println("getEstadoReserva");
        instance.getEstadoReserva();
    }

    @Test
    public void liberarMemoriaControlador() {
        System.out.println("liberarMemoriaControlador");
        instance.liberarMemoriaControlador();
        assertEquals(instance.getNickname(), null);
        assertEquals(instance.getNicknameP(), null);
        assertEquals(instance.getDtS(), null);
        assertEquals(instance.getDtR(), null);
        assertEquals(instance.getDtS(), null);
        assertEquals(instance.getIdReserva(), -1);
        assertEquals(instance.getPrecioTotal(), 0, 0);
        Set<DTLineaReserva> set = new HashSet();
        assertEquals(instance.getLineasReserva(), set);

    }

}
