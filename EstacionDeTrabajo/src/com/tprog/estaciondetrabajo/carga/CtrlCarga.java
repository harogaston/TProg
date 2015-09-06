/*
 * Header Test
 */
package com.tprog.estaciondetrabajo.carga;

import com.tprog.logica.clases.Ciudad;
import com.tprog.logica.clases.Pais;
import com.tprog.logica.dt.DTCliente;
import com.tprog.logica.dt.DTLineaReserva;
import com.tprog.logica.dt.DTProveedor;
import com.tprog.logica.dt.DTReserva;
import com.tprog.logica.dt.DTServicio;
import com.tprog.logica.dt.DTUbicacion;
import com.tprog.logica.dt.EstadoReserva;
import com.tprog.logica.manejadores.ManejadorProductos;
import com.tprog.logica.manejadores.ManejadorReservas;
import com.tprog.logica.manejadores.ManejadorUsuarios;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlCarga{

    public void cargarDatos() {
        //Alta de Clientes
        File dir = new File(".");
        try {
            String directorioImagenes = dir.getCanonicalPath();
            ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
            DTCliente dtC = new DTCliente("oWood", "Oliver", "Wood", "quidditch28@gmail.com",
                    directorioImagenes + "/imagenes/clientes/oWood.jpg", new Date(1988, 12 - 1, 28), new HashSet());
            mu.altaCliente(dtC);
            dtC = new DTCliente("eWatson", "Emma", "Watson", "e.watson@gmail.com",
                    directorioImagenes + "/imagenes/clientes/eWatson.jpg", new Date(1990, 4 - 1, 15), new HashSet());
            mu.altaCliente(dtC);
            dtC = new DTCliente("BruceS", "Bruce", "Sewell", "bruce.sewell@gmail.com",
                    null, new Date(1978, 12 - 1, 3), new HashSet());
            mu.altaCliente(dtC);
            dtC = new DTCliente("JeffW", "Jeff", "Williams", "jeff.williams@gmail.com",
                    null, new Date(1984, 11 - 1, 27), new HashSet());
            mu.altaCliente(dtC);
            //AltaProveedores
            DTProveedor dtP = new DTProveedor("tCook", "Tim", "Cook", "air.f@gmail.com",
                    directorioImagenes + "/imagenes/proveedores/tCook.jpg",
                    new Date(1960, 11 - 1, 1), "AirFrance", "http://www.airfrance.com/");
            mu.altaProveedor(dtP);
            dtP = new DTProveedor("moody", "Alastor", "Moody", "eu.car@eucar.com",
                    directorioImagenes + "/imagenes/proveedores/moody.jpg",
                    new Date(1965, 9 - 1, 2), "EuropCar", "http://www.europcar.com.uy/");
            mu.altaProveedor(dtP);
            dtP = new DTProveedor("remus", "Remus", "Lupin", "iberia@gmail.com",
                    directorioImagenes + "/imagenes/proveedores/remus.jpg",
                    new Date(1970, 5 - 1, 4), "Iberia", "http://www.iberia.com/uy/");
            mu.altaProveedor(dtP);
            dtP = new DTProveedor("adippet", "Armando", "Dippet", "tam@outlook.com",
                    directorioImagenes + "/imagenes/proveedores/adippet.jpg",
                    new Date(1967, 2 - 1, 12), "Tam", "http://www.tam.com.br/");
            mu.altaProveedor(dtP);
            dtP = new DTProveedor("mHooch", "Madam", "Hooch", "segHogar@gmail.com",
                    directorioImagenes + "/imagenes/proveedores/mHooch.jpg",
                    new Date(1963, 8 - 1, 5), "Segundo Hogar", "http://www.segundohogar.com/");
            mu.altaProveedor(dtP);
            //Alta Categorias
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
            mp.altaCategoria("Común", "Tarifa");
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
            //Ciudades y Países
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

            //Alta Servicios
            //S1
            Set<String> imgs = new HashSet();
            imgs.add(directorioImagenes + "/imagenes/IMG7.jpg");
            DTServicio dtS = new DTServicio("Euro-Vuelo-S", "Vuelo con excelente atención y comodidad",
                    1100, imgs, new DTUbicacion("Montevideo", "Uruguay"),
                    new DTUbicacion("Valencia", "España"));
            Set<String> cats = new HashSet() {
            };
            cats.add("Iberia");
            cats.add("Standard");
            mp.altaServicio(dtS, "remus", cats);
            //S2
            imgs = new HashSet();
            imgs.add(directorioImagenes + "/imagenes/IMG7.jpg");
            dtS = new DTServicio("Euro-Vuelo-LC", "Vuelo con excelente "
                    + "atención y comodidad a un precio accesible.", 850, imgs,
                    new DTUbicacion("Montevideo", "Uruguay"),
                    new DTUbicacion("Valencia", "España"));
            cats = new HashSet() {
            };
            cats.add("Iberia");
            cats.add("LowCost");
            mp.altaServicio(dtS, "remus", cats);
            //S3
            imgs = new HashSet();
            imgs.add(directorioImagenes + "/imagenes/IMG7.jpg");
            dtS = new DTServicio("Euro-Vuelo-FC", "Vuelo de primera clase. "
                    + "Excelente atención, comodidad y servicio.", 1300, imgs,
                    new DTUbicacion("Montevideo", "Uruguay"),
                    new DTUbicacion("Valencia", "España"));
            cats = new HashSet() {
            };
            cats.add("Iberia");
            cats.add("First Class");
            mp.altaServicio(dtS, "remus", cats);
            //S4
            imgs = new HashSet();
            imgs.add(directorioImagenes + "/imagenes/IMG8.jpg");
            dtS = new DTServicio("Euro-Car-1", "Euro-Car. Autos de buena calidad "
                    + "y comodidad. Versión Económica", 300, imgs,
                    new DTUbicacion("Madrid", "España"),
                    new DTUbicacion("Valencia", "España"));
            cats = new HashSet() {
            };
            cats.add("Económico");
            cats.add("Auto");
            cats.add("Chevrolet");
            mp.altaServicio(dtS, "moody", cats);
            //S5
            imgs = new HashSet();
            imgs.add(directorioImagenes + "/imagenes/IMG9.jpg");
            dtS = new DTServicio("Euro-Car-2", "Euro-Car. Autos de buena calidad"
                    + " y comodidad. Versión Standard.", 300, imgs,
                    new DTUbicacion("Madrid", "España"),
                    new DTUbicacion("Valencia", "España"));
            cats = new HashSet() {
            };
            cats.add("Común");
            cats.add("Auto");
            cats.add("Chevrolet");
            mp.altaServicio(dtS, "moody", cats);
            //S6
            imgs = new HashSet();
            imgs.add(directorioImagenes + "/imagenes/IMG10.jpg");
            dtS = new DTServicio("Euro-Car-3", "Euro-Car. Autos de buena calidad "
                    + "y comodidad. Una camioneta para toda la familia.", 300, imgs,
                    new DTUbicacion("Valencia", "España"), null);
            cats = new HashSet() {
            };
            cats.add("Full");
            cats.add("Camioneta");
            cats.add("Chevrolet");
            mp.altaServicio(dtS, "moody", cats);
            //S7
            imgs = new HashSet();
            imgs.add(directorioImagenes + "/imagenes/IMG1.jpg");
            imgs.add(directorioImagenes + "/imagenes/IMG2.jpg");
            dtS = new DTServicio("Casa para p4 BsAs", "Esta hermosa casa, se "
                    + "encuentra ubicada en el corazón de Buenos Aires y ofrece una "
                    + "capacidad para cuatro personas. La propiedad cuenta con un "
                    + "dormitorio con dos camas simples, que pueden transformarse en "
                    + "una matrimonial y dos baños completos, que incluyen toallas.",
                    80, imgs, new DTUbicacion("Buenos Aires", "Argentina"), null);
            cats = new HashSet() {
            };
            cats.add("Casa");
            cats.add("2 dormitorios");
            mp.altaServicio(dtS, "mHooch", cats);
            //S8
            imgs = new HashSet();
            imgs.add(directorioImagenes + "/imagenes/IMG3.jpg");
            imgs.add(directorioImagenes + "/imagenes/IMG4.jpg");
            imgs.add(directorioImagenes + "/imagenes/IMG5.jpg");
            dtS = new DTServicio("Floripa G. House", "Estamos a sólo unos pasos "
                    + "de un supermercado, restaurantes, cajero automático, "
                    + "gasolinera, farmacia, gimnasio, etc. Lagoa da Conceição es 7"
                    + " km de nuestra casa de huéspedes y tarda sólo 10-15 minutos "
                    + "en el transporte público. Allí se encuentra una buena vida "
                    + "nocturna con bares y música en vivo.", 190, imgs,
                    new DTUbicacion("Florianópolis", "Brasil"), null);
            cats = new HashSet() {
            };
            cats.add("Casa");
            cats.add("2 dormitorios");
            mp.altaServicio(dtS, "mHooch", cats);
            //S9
            imgs = new HashSet();
            imgs.add(directorioImagenes + "/imagenes/IMG6.jpg");
            dtS = new DTServicio("Air-France-FC", "¡Un vuelo de primera! "
                    + "Excelencia y experiencia en mejorar sus viajes.", 100, imgs,
                    new DTUbicacion("París", "Francia"),
                    new DTUbicacion("Berlín", "Alemania"));
            cats = new HashSet() {
            };
            cats.add("Air France");
            cats.add("First Class");
            mp.altaServicio(dtS, "tCook", cats);
            //S10
            imgs = new HashSet();
            imgs.add(directorioImagenes + "/imagenes/IMG11.jpg");
            dtS = new DTServicio("TAM-FC", "¡Un vuelo de primera! Excelencia y "
                    + "experiencia.", 150, imgs, new DTUbicacion("Florianópolis",
                            "Brasil"), new DTUbicacion("Pekín", "China"));
            cats = new HashSet() {
            };
            cats.add("TAM");
            cats.add("First Class");
            mp.altaServicio(dtS, "adippet", cats);
            //S11
            imgs = new HashSet();
            imgs.add(directorioImagenes + "/imagenes/IMG12.jpg");
            dtS = new DTServicio("Luxury south beach corner apartament",
                    "Beautiful large 2 bedrooms 2 bathrooms apartment CORNER UNIT. "
                    + "Marble floor throughout, beautiful open kitchen, granite "
                    + "counter top, spacious dining room area and living room area."
                    + "Spectacular views of Miami from all windows and balcony.",
                    300, imgs, new DTUbicacion("Miami", "EEUU"), null);
            cats = new HashSet() {
            };
            cats.add("Hotel");
            cats.add("Playa");
            cats.add("2 dormitorios");
            mp.altaServicio(dtS, "mHooch", cats);
            //S12
            imgs = new HashSet();
            imgs.add(directorioImagenes + "/imagenes/IMG8.jpg");
            dtS = new DTServicio("Coche-Miami",
                    "A useful car to travel around Miami", 360, imgs,
                    new DTUbicacion("Miami", "EEUU"), null);
            cats = new HashSet() {
            };
            cats.add("Económico");
            cats.add("Auto");
            cats.add("Chevrolet");
            mp.altaServicio(dtS, "mHooch", cats);
            //Alta de Promociones
            //P1 4 5
            Set<String> servs = new HashSet();
            servs.add("Euro-Car-1");
            servs.add("Euro-Car-1");
            mp.altaPromocion("Euro-Cars-E-S", 30, "moody", servs);
            //P2 4 6
            servs = new HashSet();
            servs.add("Euro-Car-1");
            servs.add("Euro-Car-3");
            mp.altaPromocion("Euro-Cars-E-F", 30, "moody", servs);
            //P3 5 6
            servs = new HashSet();
            servs.add("Euro-Car-2");
            servs.add("Euro-Car-3");
            mp.altaPromocion("Euro-Cars-ES-F", 30, "moody", servs);
            //P4 1 2
            servs = new HashSet();
            servs.add("Euro-Vuelo-S");
            servs.add("Euro-Vuelo-LC");
            mp.altaPromocion("Euro-Vuelos-S-LC", 40, "remus", servs);
            //P5 1 3
            servs = new HashSet();
            servs.add("Euro-Vuelo-S");
            servs.add("Euro-Vuelo-FC");
            mp.altaPromocion("Euro-Vuelos-S-FC", 40, "remus", servs);
            //P6 2 3
            servs = new HashSet();
            servs.add("Euro-Vuelo-LC");
            servs.add("Euro-Vuelo-FC");
            mp.altaPromocion("Euro-Vuelos-LC-FC", 40, "remus", servs);
            //P7 7 8
            servs = new HashSet();
            servs.add("Casa para p4 BsAs");
            servs.add("Floripa G. House");
            mp.altaPromocion("Sudamerica-Casas", 50, "mHooch", servs);
            //P8 11 12
            servs = new HashSet();
            servs.add("Luxury south beach corner apartament");
            servs.add("Coche-Miami");
            mp.altaPromocion("Miami-Viaje", 30, "mHooch", servs);

            //Alta Reservas
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
        } catch (IOException ex) {
            Logger.getLogger(CtrlCarga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}