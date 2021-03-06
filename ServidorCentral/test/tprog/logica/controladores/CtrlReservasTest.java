package tprog.logica.controladores;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tprog.logica.clases.Ciudad;
import tprog.logica.clases.Cliente;
import tprog.logica.clases.Pais;
import tprog.logica.clases.Proveedor;
import tprog.logica.dt.DTCliente;
import tprog.logica.dt.DTFacturaF;
import tprog.logica.dt.DTLineaReserva;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinReserva;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTProveedor;
import tprog.logica.dt.DTReserva;
import tprog.logica.dt.DTServicio;
import tprog.logica.dt.DTUbicacion;
import tprog.logica.dt.EstadoReserva;
import tprog.logica.manejadores.ManejadorProductos;
import tprog.logica.manejadores.ManejadorReservas;
import tprog.logica.manejadores.ManejadorUsuarios;

public class CtrlReservasTest {

    CtrlReservas instance;
    String nickname;
    String nicknameP;
    DTProveedor dtP;
    DTMinServicio dtMinS;
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
        try {
            Calendar calendar = Calendar.getInstance();
            String directorioImagenes = (new File(".")).getCanonicalPath();
            System.out.println("Dir imagenes: " + directorioImagenes);
            ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
            calendar.set(1988, 12 - 1, 28);
            DTCliente dtC = new DTCliente("oWood", "123", "Oliver", "Wood", "quidditch28@gmail.com",
                    directorioImagenes + "/imagenes/clientes/oWood.jpg", calendar.getTime(), new HashSet<>());
            mu.altaCliente(dtC);
            calendar.set(1990, 4 - 1, 15);
            dtC = new DTCliente("eWatson", "123", "Emma", "Watson", "e.watson@gmail.com",
                    directorioImagenes + "/imagenes/clientes/eWatson.jpg", calendar.getTime(), new HashSet<>());
            mu.altaCliente(dtC);
            calendar.set(1978, 12 - 1, 3);
            dtC = new DTCliente("BruceS", "123", "Bruce", "Sewell", "bruce.sewell@gmail.com",
                    null, calendar.getTime(), new HashSet<>());
            mu.altaCliente(dtC);
            calendar.set(1984, 11 - 1, 27);
            dtC = new DTCliente("JeffW", "123", "Jeff", "Williams", "jeff.williams@gmail.com",
                    null, calendar.getTime(), new HashSet<>());
            mu.altaCliente(dtC);
            calendar.set(1960, 11 - 1, 1);
            DTProveedor dtP = new DTProveedor("tCook", "123", "Tim", "Cook", "air.f@gmail.com",
                    directorioImagenes + "/imagenes/proveedores/tCook.jpg",
                    calendar.getTime(), "AirFrance", "http://www.airfrance.com/");
            mu.altaProveedor(dtP);
            calendar.set(1965, 9 - 1, 2);
            dtP = new DTProveedor("moody", "123", "Alastor", "Moody", "eu.car@eucar.com",
                    directorioImagenes + "/imagenes/proveedores/moody.jpg",
                    calendar.getTime(), "EuropCar", "http://www.europcar.com.uy/");
            mu.altaProveedor(dtP);
            calendar.set(1970, 5 - 1, 4);
            dtP = new DTProveedor("remus", "123", "Remus", "Lupin", "iberia@gmail.com",
                    directorioImagenes + "/imagenes/proveedores/remus.jpg",
                    calendar.getTime(), "Iberia", "http://www.iberia.com/uy/");
            mu.altaProveedor(dtP);
            calendar.set(1967, 2 - 1, 12);
            dtP = new DTProveedor("adippet", "123", "Armando", "Dippet", "tam@outlook.com",
                    directorioImagenes + "/imagenes/proveedores/adippet.jpg",
                    calendar.getTime(), "Tam", "http://www.tam.com.br/");
            mu.altaProveedor(dtP);
            calendar.set(1963, 8 - 1, 5);
            dtP = new DTProveedor("mHooch", "123", "Madam", "Hooch", "segHogar@gmail.com",
                    directorioImagenes + "/imagenes/proveedores/mHooch.jpg",
                    calendar.getTime(), "Segundo Hogar", "http://www.segundohogar.com/");
            mu.altaProveedor(dtP);
            ManejadorProductos mp = ManejadorProductos.getInstance();
            mp.altaCategoria("Vuelos", null);
            mp.altaCategoria("Empresas", "Vuelos");
            mp.altaCategoria("Iberia", "Empresas");
            mp.altaCategoria("American Airlines", "Empresas");
            mp.altaCategoria("Air France", "Empresas");
            mp.altaCategoria("TAM", "Empresas");
            mp.altaCategoria("Tipo vuelo", "Vuelos");
            mp.altaCategoria("LowCost", "Tipo vuelo");
            mp.altaCategoria("Standard", "Tipo vuelo");
            mp.altaCategoria("First Class", "Tipo vuelo");
            mp.altaCategoria("Alojamientos", null);
            mp.altaCategoria("Tipo alojamiento", "Alojamientos");
            mp.altaCategoria("Hotel", "Tipo alojamiento");
            mp.altaCategoria("Hostal", "Tipo alojamiento");
            mp.altaCategoria("Apartamento", "Tipo alojamiento");
            mp.altaCategoria("Casa", "Tipo alojamiento");
            mp.altaCategoria("Ubicación", "Alojamientos");
            mp.altaCategoria("Playa", "Ubicación");
            mp.altaCategoria("Rural", "Ubicación");
            mp.altaCategoria("Montaña", "Ubicación");
            mp.altaCategoria("Habitaciones", "Alojamientos");
            mp.altaCategoria("1 ambiente", "Habitaciones");
            mp.altaCategoria("1 dormitorio", "Habitaciones");
            mp.altaCategoria("2 dormitorios", "Habitaciones");
            mp.altaCategoria("Automóviles", null);
            mp.altaCategoria("Tarifa", "Automóviles");
            mp.altaCategoria("Mini", "Tarifa");
            mp.altaCategoria("Económico", "Tarifa");
            mp.altaCategoria("Standard", "Tarifa");
            mp.altaCategoria("Full", "Tarifa");
            mp.altaCategoria("Tipo vehículo", "Automóviles");
            mp.altaCategoria("Auto", "Tipo vehículo");
            mp.altaCategoria("Camioneta", "Tipo vehículo");
            mp.altaCategoria("Camión", "Tipo vehículo");
            mp.altaCategoria("Moto", "Tipo vehículo");
            mp.altaCategoria("Marca", "Automóviles");
            mp.altaCategoria("Chevrolet", "Marca");
            mp.altaCategoria("Peugeot", "Marca");
            mp.altaCategoria("Daihatsu", "Marca");
            mp.altaCategoria("Fiat", "Marca");
            mp.altaCategoria("Ford", "Marca");
            mp.altaCategoria("Cruceros", null);
            mp.altaCategoria("Mediterráneo", "Cruceros");
            mp.altaCategoria("Mar Negro", "Cruceros");
            mp.altaCategoria("Caribe", "Cruceros");
            mp.altaCategoria("Nilo", "Cruceros");
            mp.altaCategoria("Alaska", "Cruceros");
            Pais p = new Pais("Uruguay");
            p.agregarCiudad(new Ciudad("Montevideo"));
            mp.agregarPais(p);
            p = new Pais("Argentina");
            p.agregarCiudad(new Ciudad("Buenos Aires"));
            p.agregarCiudad(new Ciudad("Bariloche"));
            mp.agregarPais(p);
            p = new Pais("Colombia");
            p.agregarCiudad(new Ciudad("Bogotá"));
            mp.agregarPais(p);
            p = new Pais("EEUU");
            p.agregarCiudad(new Ciudad("Miami"));
            mp.agregarPais(p);
            p = new Pais("España");
            p.agregarCiudad(new Ciudad("Valencia"));
            p.agregarCiudad(new Ciudad("Madrid"));
            mp.agregarPais(p);
            p = new Pais("Francia");
            p.agregarCiudad(new Ciudad("París"));
            mp.agregarPais(p);
            p = new Pais("Alemania");
            p.agregarCiudad(new Ciudad("Berlín"));
            mp.agregarPais(p);
            p = new Pais("Suiza");
            p.agregarCiudad(new Ciudad("Ginebra"));
            mp.agregarPais(p);
            p = new Pais("Australia");
            p.agregarCiudad(new Ciudad("Sidney"));
            mp.agregarPais(p);
            p = new Pais("Brasil");
            p.agregarCiudad(new Ciudad("Florianópolis"));
            mp.agregarPais(p);
            p = new Pais("China");
            p.agregarCiudad(new Ciudad("Pekín"));
            p.agregarCiudad(new Ciudad("Cantón"));
            mp.agregarPais(p);
            Set<String> imgs = new HashSet<>();
            imgs.add(directorioImagenes + "/imagenes/IMG7.jpg");
            DTServicio dtS = new DTServicio("Euro-Vuelo-S", "remus", "Vuelo con excelente atención y comodidad",
                    1100, imgs, new DTUbicacion("Montevideo", "Uruguay"),
                    new DTUbicacion("Valencia", "España"));
            Set<String> cats = new HashSet<>();
            cats.add("Iberia");
            cats.add("Standard");
            mp.altaServicio(dtS, "remus", cats);
            imgs = new HashSet<>();
            imgs.add(directorioImagenes + "/imagenes/IMG7.jpg");
            dtS = new DTServicio("Euro-Vuelo-LC", "remus", "Vuelo con excelente "
                    + "atención y comodidad a un precio accesible.", 850, imgs,
                    new DTUbicacion("Montevideo", "Uruguay"),
                    new DTUbicacion("Valencia", "España"));
            cats = new HashSet<>();
            cats.add("Iberia");
            cats.add("LowCost");
            mp.altaServicio(dtS, "remus", cats);
            imgs = new HashSet<>();
            imgs.add(directorioImagenes + "/imagenes/IMG7.jpg");
            dtS = new DTServicio("Euro-Vuelo-FC", "remus", "Vuelo de primera clase. "
                    + "Excelente atención, comodidad y servicio.", 1300, imgs,
                    new DTUbicacion("Montevideo", "Uruguay"),
                    new DTUbicacion("Valencia", "España"));
            cats = new HashSet<>();
            cats.add("Iberia");
            cats.add("First Class");
            mp.altaServicio(dtS, "remus", cats);
            imgs = new HashSet<>();
            imgs.add(directorioImagenes + "/imagenes/IMG8.jpg");
            dtS = new DTServicio("Euro-Car-1", "moody", "Euro-Car. Autos de buena calidad "
                    + "y comodidad. Versión Económica", 300, imgs,
                    new DTUbicacion("Madrid", "España"),
                    new DTUbicacion("Valencia", "España"));
            cats = new HashSet<>();
            cats.add("Económico");
            cats.add("Auto");
            cats.add("Chevrolet");
            mp.altaServicio(dtS, "moody", cats);
            imgs = new HashSet<>();
            imgs.add(directorioImagenes + "/imagenes/IMG9.jpg");
            dtS = new DTServicio("Euro-Car-2", "moody", "Euro-Car. Autos de buena calidad"
                    + " y comodidad. Versión Standard.", 300, imgs,
                    new DTUbicacion("Madrid", "España"),
                    new DTUbicacion("Valencia", "España"));
            cats = new HashSet<>();
            cats.add("Común");
            cats.add("Auto");
            cats.add("Chevrolet");
            mp.altaServicio(dtS, "moody", cats);
            imgs = new HashSet<>();
            imgs.add(directorioImagenes + "/imagenes/IMG10.jpg");
            dtS = new DTServicio("Euro-Car-3", "moody", "Euro-Car. Autos de buena calidad "
                    + "y comodidad. Una camioneta para toda la familia.", 300, imgs,
                    new DTUbicacion("Valencia", "España"), null);
            cats = new HashSet<>();
            cats.add("Full");
            cats.add("Camioneta");
            cats.add("Chevrolet");
            mp.altaServicio(dtS, "moody", cats);
            imgs = new HashSet<>();
            imgs.add(directorioImagenes + "/imagenes/IMG1.jpg");
            imgs.add(directorioImagenes + "/imagenes/IMG2.jpg");
            dtS = new DTServicio("Casa para p4 BsAs", "mHooch", "Esta hermosa casa, se "
                    + "encuentra ubicada en el corazón de Buenos Aires y ofrece una "
                    + "capacidad para cuatro personas. La propiedad cuenta con un "
                    + "dormitorio con dos camas simples, que pueden transformarse en "
                    + "una matrimonial y dos baños completos, que incluyen toallas.",
                    80, imgs, new DTUbicacion("Buenos Aires", "Argentina"), null);
            cats = new HashSet<>();
            cats.add("Casa");
            cats.add("2 dormitorios");
            mp.altaServicio(dtS, "mHooch", cats);
            imgs = new HashSet<>();
            imgs.add(directorioImagenes + "/imagenes/IMG3.jpg");
            imgs.add(directorioImagenes + "/imagenes/IMG4.jpg");
            imgs.add(directorioImagenes + "/imagenes/IMG5.jpg");
            dtS = new DTServicio("Floripa G. House", "mHooch", "Estamos a sólo unos pasos "
                    + "de un supermercado, restaurantes, cajero automático, "
                    + "gasolinera, farmacia, gimnasio, etc. Lagoa da Conceição es 7"
                    + " km de nuestra casa de huéspedes y tarda sólo 10-15 minutos "
                    + "en el transporte público. Allí se encuentra una buena vida "
                    + "nocturna con bares y música en vivo.", 190, imgs,
                    new DTUbicacion("Florianópolis", "Brasil"), null);
            cats = new HashSet<>();
            cats.add("Casa");
            cats.add("2 dormitorios");
            mp.altaServicio(dtS, "mHooch", cats);
            imgs = new HashSet<>();
            imgs.add(directorioImagenes + "/imagenes/IMG6.jpg");
            dtS = new DTServicio("Air-France-FC", "tCook", "¡Un vuelo de primera! "
                    + "Excelencia y experiencia en mejorar sus viajes.", 100, imgs,
                    new DTUbicacion("París", "Francia"),
                    new DTUbicacion("Berlín", "Alemania"));
            cats = new HashSet<>();
            cats.add("Air France");
            cats.add("First Class");
            mp.altaServicio(dtS, "tCook", cats);
            imgs = new HashSet<>();
            imgs.add(directorioImagenes + "/imagenes/IMG11.jpg");
            dtS = new DTServicio("TAM-FC", "adippet", "¡Un vuelo de primera! Excelencia y "
                    + "experiencia.", 150, imgs, new DTUbicacion("Florianópolis",
                            "Brasil"), new DTUbicacion("Pekín", "China"));
            cats = new HashSet<>();
            cats.add("TAM");
            cats.add("First Class");
            mp.altaServicio(dtS, "adippet", cats);
            imgs = new HashSet<>();
            imgs.add(directorioImagenes + "/imagenes/IMG12.jpg");
            dtS = new DTServicio("Luxury south beach corner apartament", "mHooch",
                    "Beautiful large 2 bedrooms 2 bathrooms apartment CORNER UNIT. "
                    + "Marble floor throughout, beautiful open kitchen, granite "
                    + "counter top, spacious dining room area and living room area."
                    + "Spectacular views of Miami from all windows and balcony.",
                    300, imgs, new DTUbicacion("Miami", "EEUU"), null);
            cats = new HashSet<>();
            cats.add("Hotel");
            cats.add("Playa");
            cats.add("2 dormitorios");
            mp.altaServicio(dtS, "mHooch", cats);
            imgs = new HashSet<>();
            imgs.add(directorioImagenes + "/imagenes/IMG8.jpg");
            dtS = new DTServicio("Coche-Miami", "mHooch",
                    "A useful car to travel around Miami", 360, imgs,
                    new DTUbicacion("Miami", "EEUU"), null);
            cats = new HashSet<>();
            cats.add("Económico");
            cats.add("Auto");
            cats.add("Chevrolet");
            mp.altaServicio(dtS, "mHooch", cats);
            List<String> servs = new ArrayList<>();
            servs.add("Euro-Car-1");
            servs.add("Euro-Car-1");
            mp.altaPromocion("Euro-Cars-E-S", 30, "moody", servs);
            servs = new ArrayList<>();
            servs.add("Euro-Car-1");
            servs.add("Euro-Car-3");
            mp.altaPromocion("Euro-Cars-E-F", 30, "moody", servs);
            servs = new ArrayList<>();
            servs.add("Euro-Car-2");
            servs.add("Euro-Car-3");
            mp.altaPromocion("Euro-Cars-ES-F", 30, "moody", servs);
            servs = new ArrayList<>();
            servs.add("Euro-Vuelo-S");
            servs.add("Euro-Vuelo-LC");
            mp.altaPromocion("Euro-Vuelos-S-LC", 40, "remus", servs);
            servs = new ArrayList<>();
            servs.add("Euro-Vuelo-S");
            servs.add("Euro-Vuelo-FC");
            mp.altaPromocion("Euro-Vuelos-S-FC", 40, "remus", servs);
            servs = new ArrayList<>();
            servs.add("Euro-Vuelo-LC");
            servs.add("Euro-Vuelo-FC");
            mp.altaPromocion("Euro-Vuelos-LC-FC", 40, "remus", servs);
            servs = new ArrayList<>();
            servs.add("Casa para p4 BsAs");
            servs.add("Floripa G. House");
            mp.altaPromocion("Sudamerica-Casas", 50, "mHooch", servs);
            servs = new ArrayList<>();
            servs.add("Luxury south beach corner apartament");
            servs.add("Coche-Miami");
            mp.altaPromocion("Miami-Viaje", 30, "mHooch", servs);
            ManejadorReservas mr = ManejadorReservas.getInstance();
            try {
                //R1 S1

                calendar.set(2015, 1 - 1, 1);

                Set<DTLineaReserva> lineas = new HashSet<>();
                lineas.add(new DTLineaReserva(1, calendar.getTime(),
                        calendar.getTime(), "Euro-Vuelo-S", null, "remus", 1100));
                DTReserva dtR = new DTReserva(0, calendar.getTime(),
                        EstadoReserva.Facturada, 1100, lineas);
                mr.agregarReserva(mu.getCliente("oWood"), dtR);

                instance = new CtrlReservas();
                instance.seleccionarCliente("oWood");
                instance.confirmarFactura(1);
                DTFacturaF dt = instance.verFactura(1);
                instance.sendEmail(1);

                //R2    S1 S2 --> S1 S4
                lineas = new HashSet<>();
                lineas.add(new DTLineaReserva(2, calendar.getTime(),
                        calendar.getTime(), "Euro-Vuelo-S", null, "remus", 1100));
                lineas.add(new DTLineaReserva(1, calendar.getTime(),
                        calendar.getTime(), "Euro-Car-1", null, "moody", 300));
                dtR = new DTReserva(0, calendar.getTime(),
                        EstadoReserva.Pagada, 2500, lineas);
                mr.agregarReserva(mu.getCliente("eWatson"), dtR);

                //R3    P7
                lineas = new HashSet<>();

                calendar.set(2015, 3 - 1, 5);
                Date inicio = calendar.getTime();
                calendar.set(2015, 4 - 1, 2);
                Date fin = calendar.getTime();

                lineas.add(new DTLineaReserva(1, inicio,
                        fin, null, "Sudamerica-Casas", "mHooch", 135));

                calendar.set(2015, 3 - 1, 5);

                dtR = new DTReserva(0, calendar.getTime(),
                        EstadoReserva.Cancelada, 135, lineas);
                mr.agregarReserva(mu.getCliente("BruceS"), dtR);
                instance.seleccionarCliente("BruceS");
                instance.confirmarFactura(3);
                //R4    S5 S6
                lineas = new HashSet<>();

                calendar.set(2015, 5 - 1, 8);
                inicio = calendar.getTime();
                calendar.set(2015, 5 - 1, 12);
                fin = calendar.getTime();

                lineas.add(new DTLineaReserva(1, inicio,
                        fin, "Euro-Car-2", null, "moody", 300));

                calendar.set(2015, 5 - 1, 8);
                inicio = calendar.getTime();
                calendar.set(2015, 5 - 1, 12);
                fin = calendar.getTime();

                lineas.add(new DTLineaReserva(1, inicio,
                        fin, "Euro-Car-3", null, "moody", 300));

                calendar.set(2015, 5 - 1, 8);

                dtR = new DTReserva(0, calendar.getTime(),
                        EstadoReserva.Pagada, 600, lineas);
                mr.agregarReserva(mu.getCliente("JeffW"), dtR);
                //R5    S9
                lineas = new HashSet<>();

                calendar.set(2015, 8 - 1, 7);
                inicio = calendar.getTime();
                calendar.set(2015, 8 - 1, 10);
                fin = calendar.getTime();

                lineas.add(new DTLineaReserva(2, inicio,
                        fin, "Air-France-FC", null, "tCook", 100));

                calendar.set(2015, 8 - 1, 7);

                dtR = new DTReserva(0, calendar.getTime(),
                        EstadoReserva.Registrada, 200, lineas);
                mr.agregarReserva(mu.getCliente("oWood"), dtR);

                //R6    P8 S7 --> P8 S9
                lineas = new HashSet<>();

                calendar.set(2015, 8 - 1, 7);
                inicio = calendar.getTime();
                calendar.set(2015, 8 - 1, 14);
                fin = calendar.getTime();

                lineas.add(new DTLineaReserva(1, inicio,
                        fin, null, "Miami-Viaje", "mHooch", 330));

                calendar.set(2015, 8 - 1, 14);
                inicio = calendar.getTime();
                calendar.set(2015, 8 - 1, 21);
                fin = calendar.getTime();

                lineas.add(new DTLineaReserva(1, inicio,
                        fin, "Air-France-FC", null, "tCook", 100));

                calendar.set(2015, 8 - 1, 7);

                dtR = new DTReserva(0, calendar.getTime(),
                        EstadoReserva.Registrada, 430, lineas);
                mr.agregarReserva(mu.getCliente("eWatson"), dtR);
                //R7    S2
                lineas = new HashSet<>();

                calendar.set(2015, 8 - 1, 7);

                lineas.add(new DTLineaReserva(2, calendar.getTime(),
                        calendar.getTime(), "Euro-Vuelo-LC", null, "remus", 850));
                dtR = new DTReserva(0, calendar.getTime(),
                        EstadoReserva.Registrada, 1700, lineas);
                mr.agregarReserva(mu.getCliente("BruceS"), dtR);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            instance = new CtrlReservas();
            fecha = new Date();
            DTProveedor dtP1 = new DTProveedor("nick", "pass", "nom", "ap", "email", "imagen", fecha, "empresa", "webEmpresa");
            prov = new Proveedor(dtP1);
            nicknameP = prov.getNickname();
            DTLineaReserva l1 = new DTLineaReserva(1, fecha, fecha, "idServicio1", "", null, 10);
            Set<DTLineaReserva> set = new HashSet();
            set.add(l1);
            DTCliente dtC1 = new DTCliente("alguien", "pass", "alg", "apellido", "email", "imagen", fecha, null);
            Cliente jorge = new Cliente(dtC1);
			//Servicio ser = new Servicio("idServicio", "descripcion", 50, null, null, null, prov);
            //Promocion promo = new Promocion("idPromocion", 20, prov);
            vacio = null;
            mu.altaProveedor(prov.crearDT());
            //mp.altaPromocion("idPromocion", 20, "nick", vacio);
            mu.altaCliente(jorge.crearDT());

            instance.seleccionarProveedor("nick");
            //mp.altaServicio(ser.crearDT(),"nick",vacio);
            instance.limpiarBD();

        } catch (IOException ex) {
            Logger.getLogger(CtrlReservasTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of seleccionarCliente method, of class CtrlReservas.
     */
    @Test
    public void testSeleccionarCliente() {
        System.out.println("seleccionarCliente");
        nickname = "";
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
        nicknameP = "nick";
        instance.seleccionarProveedor(nicknameP);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(nicknameP, instance.getNicknameP());

    }

    /**
     * Test of listarPromociones method, of class CtrlReservas.
     */
    @Test
    public void testListarPromociones() throws Exception {
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
    public void testListarServicios() throws Exception {
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
        DTMinPromocion dtPromo = new DTMinPromocion(this.nicknameP, "promo");

        instance.seleccionarPromocion(dtPromo);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(dtPromo.equals(instance.getDtP()));

    }

    /**
     * Test of seleccionarServicio method, of class CtrlReservas.
     */
    @Test
    public void testSeleccionarServicio() {
        System.out.println("seleccionarServicio");
        dtMinS = new DTMinServicio(this.nicknameP, "bueno");

        instance.seleccionarServicio(dtMinS);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(dtMinS.equals(instance.getDtS()));

    }

    /**
     * Test of seleccionarDTReserva method, of class CtrlReservas.
     */
    @Test
    public void testSeleccionarDTReserva() {
        System.out.println("seleccionarDTReserva");
        dtR = null;
		//instance.seleccionarDTReserva(dtR);
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
                    new Date(2015, 1 - 1, 1), "Euro-Vuelo-S", null, "remus", 1100));
            dtR = new DTReserva(0, new Date(2015, 1 - 1, 1),
                    EstadoReserva.Facturada, 1100, lineas);
            mr.agregarReserva(mu.getCliente("oWood"), dtR);
            //R2    S1 S2
            lineas = new HashSet();
            lineas.add(new DTLineaReserva(2, new Date(2015, 1 - 1, 1),
                    new Date(2015, 1 - 1, 1), "Euro-Vuelo-S", null, "remus", 1100));
            lineas.add(new DTLineaReserva(1, new Date(2015, 1 - 1, 1),
                    new Date(2015, 1 - 1, 1), "Euro-Vuelo-LC", null, "remus", 850));
            dtR = new DTReserva(0, new Date(2015, 1 - 1, 1),
                    EstadoReserva.Cancelada, 3050, lineas);
            mr.agregarReserva(mu.getCliente("eWatson"), dtR);

            //R3    P7
            lineas = new HashSet();
            DTLineaReserva aux = new DTLineaReserva(1, new Date(2015, 3 - 1, 5),
                    new Date(2015, 4 - 1, 2), null, "Sudamerica-Casas", "mHooch", 135);
            lineas.add(aux);
            dtR = new DTReserva(0, new Date(2015, 3 - 1, 5),
                    EstadoReserva.Pagada, 135, lineas);
            mr.agregarReserva(mu.getCliente("BruceS"), dtR);
            //R4    S5 S6
            lineas = new HashSet();
            lineas.add(new DTLineaReserva(1, new Date(2015, 5 - 1, 8),
                    new Date(2015, 5 - 1, 12), "Euro-Car-2", null, "moody", 300));
            lineas.add(new DTLineaReserva(1, new Date(2015, 5 - 1, 8),
                    new Date(2015, 5 - 1, 12), "Euro-Car-3", null, "moody", 300));
            dtR = new DTReserva(0, new Date(2015, 5 - 1, 8),
                    EstadoReserva.Pagada, 600, lineas);
            mr.agregarReserva(mu.getCliente("JeffW"), dtR);
            //R5    S9
            lineas = new HashSet();
            lineas.add(new DTLineaReserva(2, new Date(2015, 8 - 1, 7),
                    new Date(2015, 8 - 1, 10), "Air-France-FC", null, "tCook", 100));
            dtR = new DTReserva(0, new Date(2015, 8 - 1, 7),
                    EstadoReserva.Registrada, 200, lineas);
            mr.agregarReserva(mu.getCliente("oWood"), dtR);
            instance.quitarLineaReserva(1);
            //R6    P8 S7
            lineas = new HashSet();
            lineas.add(new DTLineaReserva(1, new Date(2015, 8 - 1, 7),
                    new Date(2015, 8 - 1, 14), null, "Miami-Viaje", "mHooch", 462));
            lineas.add(new DTLineaReserva(1, new Date(2015, 8 - 1, 14),
                    new Date(2015, 8 - 1, 21), "Casa para p4 BsAs", null, "mHooch", 80));
            dtR = new DTReserva(0, new Date(2015, 8 - 1, 7),
                    EstadoReserva.Registrada, 542, lineas);
            instance.seleccionarServicio(new DTMinServicio("remus", "Euro-Vuelo-LC"));
            instance.ingresarLineaReserva(2, fecha, fecha);
            mr.agregarReserva(mu.getCliente("eWatson"), dtR);
            instance.seleccionarServicio(null);
            //R7    S2
            lineas = new HashSet();
            lineas.add(new DTLineaReserva(2, new Date(2015, 8 - 1, 7),
                    new Date(2015, 8 - 1, 7), "Euro-Vuelo-LC", null, "remus", 850));
            dtR = new DTReserva(0, new Date(2015, 8 - 1, 7),
                    EstadoReserva.Registrada, 1700, lineas);
            instance.seleccionarPromocion(new DTMinPromocion("moody", "Euro-Cars-E-S"));
            instance.ingresarLineaReserva(2, fecha, fecha);
            mr.agregarReserva(mu.getCliente("BruceS"), dtR);
            Set<DTReserva> ssset = instance.listarReservasProveedor();
            Set<String> list = instance.listarNotificacionesProveedor();
            instance.listarNotificacionesProveedor();
            instance.limpiarNotificacionesProveedor();
            instance.quitarLineaReserva(1);
            DTCliente habra = instance.getClienteAsociado();
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
        DTCliente dtC1 = new DTCliente("alguien", "pass", "alg", "apellido", "email", "imagen", fecha, null);
        Cliente jorge = new Cliente(dtC1);
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
        DTReserva expResult = new DTReserva(-1, null, EstadoReserva.Registrada, 0, new HashSet<>());
        instance.altaReserva(expResult);
        instance.seleccionarServicio(null);
        instance.seleccionarPromocion(new DTMinPromocion("remus", "Euro-Vuelos-LC-FC"));
        instance.altaReserva(expResult);
    }

    /**
     * Test of listarReservas method, of class CtrlReservas.
     */
    @Test
    public void testListarReservas() throws Exception {
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
        //assertEquals(expResult.size(),result.size());
        //assertTrue(foundAll);
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
		//DTCliente dtC1 = new DTCliente("alguien", "pass", "alg", "apellido", "email", "imagen", fecha, null);
        //Cliente jorge = new Cliente(dtC1);

        //Servicio ser = new Servicio("idServicio", "descripcion", 50, null, null, null, prov);
        this.dtMinS = new DTMinServicio("nick", "idServicio");
        instance.eliminarReserva();
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testGetEstadoReserva() {
        System.out.println("getEstadoReserva");
        instance.getEstadoReserva();
    }

    @Test
    public void testLiberarMemoriaControlador() {
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

    @Test
    public void testFacturarReserva() throws Exception {
        System.out.println("facturarReserva");
        Set<DTLineaReserva> lineas = new HashSet();
        lineas.add(new DTLineaReserva(1, new Date(2015, 5 - 1, 8),
                new Date(2015, 5 - 1, 12), "Euro-Car-2", null, "moody", 300));
        lineas.add(new DTLineaReserva(1, new Date(2015, 5 - 1, 8),
                new Date(2015, 5 - 1, 12), "Euro-Car-3", null, "moody", 300));
        dtR = new DTReserva(0, new Date(2015, 5 - 1, 8),
                EstadoReserva.Pagada, 600, lineas);
        instance.seleccionarCliente("JeffW");
        instance.altaReserva(dtR);

        assertTrue(instance.facturarReserva("moody", "JeffW", 1));
    }

}
