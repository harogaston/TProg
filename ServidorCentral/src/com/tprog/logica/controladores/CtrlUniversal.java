/*
 * Header Test
 */
package com.tprog.logica.controladores;
import com.tprog.logica.interfaces.ICtrlUniversal;
import com.tprog.logica.manejadores.*;
import com.tprog.logica.dt.DTCliente;
import com.tprog.logica.dt.DTProveedor;
import com.tprog.logica.dt.DTUbicacion;
import com.tprog.logica.dt.DTServicio;
import java.util.HashSet;
import java.util.Date;
import com.tprog.logica.clases.Pais;
import com.tprog.logica.clases.Ciudad;
import com.tprog.logica.clases.Proveedor;
import java.util.Set;


/**
 *
 * @author sofia
 */
public class CtrlUniversal implements ICtrlUniversal {
    
    @Override
    public void cargarDatos(){
    //alta de Clientes
        ManejadorUsuarios mu = ManejadorUsuarios.getInstance();
        DTCliente dtC = new DTCliente("oWood", "Oliver", "Wood", "quidditch28@gmail.com",
		"Oli", new Date(1988, 12, 28), new HashSet());
        mu.altaCliente(dtC);
        dtC = new DTCliente("eWatson", "Emma", "Watson", "e.watson@gmail.com",
                "Emma", new Date(1990, 4, 15), new HashSet());
        mu.altaCliente(dtC);
        dtC = new DTCliente("BruceS", "Bruce", "Sewell", "bruce.sewell@gmail.com",
                "Bruce", new Date(1978, 12, 3), new HashSet());
        mu.altaCliente(dtC);
        dtC = new DTCliente("JeffW", "Jeff", "Williams", "jeff.williams@gmail.com",
                "Jeff", new Date(1984, 11, 27), new HashSet());
        mu.altaCliente(dtC);
    //AltaProveedores   
        DTProveedor dtP = new DTProveedor("tCook", "Tim", "Cook", "air.f@gmail.com",
			"Air France", new Date(1960, 11, 1), "AirFrance", "http://www.airfrance.com/");
        mu.altaProveedor(dtP);
        dtP = new DTProveedor("moody", "Alastor", "Moody", "eu.car@eucar.com",
			"Cars", new Date(1965, 9, 2), "EuropCar", "http://www.europcar.com.uy/");
        mu.altaProveedor(dtP);
        dtP = new DTProveedor("remus", "Remus", "Lupin", "iberia@gmail.com",
			"Werewolf", new Date(1970, 5, 4), "Iberia", "http://www.iberia.com/uy/");
        mu.altaProveedor(dtP);
        dtP = new DTProveedor("adippet", "Armando", "Dippet", "tam@outlook.com",
			"Dip", new Date(1967, 2, 12), "Tam", "http://www.tam.com.br/");
        mu.altaProveedor(dtP);
        dtP = new DTProveedor("mHooch", "Madam", "Hooch", "segHogar@gmail.com",
			"Broom", new Date(1963, 8, 5), "Segundo Hogar", "http://www.segundohogar.com/");
        mu.altaProveedor(dtP);
    //Alta Categorias
        ManejadorProductos mp = ManejadorProductos.getInstance();
        mp.altaCategoria("Vuelos", "");
        mp.altaCategoria("Empresas", "Vuelos");
        mp.altaCategoria("Iberia", "Empresas");
        mp.altaCategoria("American Airlines", "Empresas");
        mp.altaCategoria("Air France", "Empresas");
        mp.altaCategoria("TAM", "Empresas");
        mp.altaCategoria("Tipo vuelo", "Vuelos");
        mp.altaCategoria("LowCost", "Tipo vuelo");
        mp.altaCategoria("Standard", "Tipo vuelo");
        mp.altaCategoria("First Class", "Tipo vuelo");
        mp.altaCategoria("Alojamientos", "");
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
        mp.altaCategoria("Automóviles","");
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
        mp.altaCategoria("Marca","Automóviles");
        mp.altaCategoria("Chevrolet", "Marca");
        mp.altaCategoria("Peugeot", "Marca");
        mp.altaCategoria("Daihatsu", "Marca");
        mp.altaCategoria("Fiat", "Marca");
        mp.altaCategoria("Ford", "Marca");
        mp.altaCategoria("Cruceros", "");
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
    }
}
