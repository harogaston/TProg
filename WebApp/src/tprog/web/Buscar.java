package tprog.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.tree.DefaultMutableTreeNode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import tprog.logica.dt.DTMinPromocion;
import tprog.logica.dt.DTMinServicio;
import tprog.logica.dt.DTPromocion;
import tprog.logica.dt.DTServicio;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlProductos;

public class Buscar extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Fabrica f = Fabrica.getInstance();
			ICtrlProductos ctrlProductos = f.getICtrlProductos();
			DefaultMutableTreeNode categorias = ctrlProductos.listarCategorias();
			Enumeration listado = categorias.breadthFirstEnumeration();

			// armo objeto de JSON para armar el árbol con jstree
			JSONArray list = new JSONArray();
			while (listado.hasMoreElements()) {
				DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) listado.nextElement();
				String categoria = nodo.toString(); //recupero categoria
				DefaultMutableTreeNode padre = (DefaultMutableTreeNode) nodo.getParent();
				String categoriaPadre = "#";
				if (padre != null) {
					categoriaPadre = padre.toString();
				}
				JSONObject tmp = new JSONObject();
				tmp.put("id", categoria);
				tmp.put("parent", categoriaPadre);
				tmp.put("text", categoria);
				if (!listado.hasMoreElements()) { //agrego nodo Promociones
					tmp.put("id", "Promociones");
					tmp.put("parent", "#");
					tmp.put("text", "Promociones");
				}
				list.add(tmp);
			}

			request.setAttribute("arbolJson", list);

			// El texto buscado o la categoría seleccionada
			CharSequence busqueda = request.getParameter("busqueda");
			if (busqueda == null) {
				busqueda = "";
			}
			String categoriaSeleccionada = request.getParameter("categoriaSeleccionada");

			// Obtengo todos los servicios del sistema
			Set<DTMinServicio> serviciosTodos;
			try {
				serviciosTodos = ctrlProductos.listarServicios();
			} catch (Exception ex) {
				serviciosTodos = new HashSet();
			}

			// Obtengo todas las promociones del sistema
			Set<DTMinPromocion> promocionesTodas;
			try {
				promocionesTodas = ctrlProductos.listarPromociones();
			} catch (Exception ex) {
				promocionesTodas = new HashSet();
			}

			// Defino el orden
			SortedSet<DTServicio> serviciosResultado;
			SortedSet<DTPromocion> promocionesResultado;
			if (request.getParameter("tipo_orden") != null && request.getParameter("tipo_orden").equals("precio")) {
//				 Ordenados por precio
				serviciosResultado = new TreeSet<>(DTServicio::comparePrecio);
				promocionesResultado = new TreeSet<>(DTPromocion::comparePrecio);
				request.setAttribute("precio", "1"); //para que aparezca marcado el precio en la proxima
				request.setAttribute("alfabetico", "0");
			} else {
				// Ordenados por nombre (*** Como no puedo hacer que ande lo dejo siempre por nombre ***)
				serviciosResultado = new TreeSet<>();
				promocionesResultado = new TreeSet<>();
				request.setAttribute("alfabetico", "1"); //para que aparezca marcado el A-Z en la proxima
				request.setAttribute("precio", "0");
			}

			// Si no hay busqueda ni categoría muestro todo
			if (busqueda == null && categoriaSeleccionada == null) {
				// Todos los servicios
				if (!serviciosTodos.isEmpty()) {
					for (DTMinServicio dtMinS : serviciosTodos) {
						ctrlProductos.seleccionarServicio(dtMinS);
						DTServicio infoServicio = ctrlProductos.infoServicio();
						serviciosResultado.add(infoServicio);
					}
				}

				// Todas las promociones
				if (!promocionesTodas.isEmpty()) {
					for (DTMinPromocion dtMinP : promocionesTodas) {
						ctrlProductos.seleccionarPromocion(dtMinP);
						DTPromocion infoPromocion = ctrlProductos.infoPromocion();
						promocionesResultado.add(infoPromocion);
					}
				}
				// Si se realizó una búsqueda
			} else if (busqueda != null) {
				// Busco servicios que contengan el término buscado
				if (!serviciosTodos.isEmpty()) {
					for (DTMinServicio dtMinS : serviciosTodos) {
						ctrlProductos.seleccionarServicio(dtMinS);
						DTServicio infoServicio = ctrlProductos.infoServicio();
						Set<String> listaCategoriasServicio = ctrlProductos.listarCategoriasServicio();

						boolean matcheaServicio = false;
						for (String categoria : listaCategoriasServicio) {
							// Me fijo si el termino buscado conincide con algo del servicio
							if (categoria.contains(busqueda) || infoServicio.getDescripcion().contains(busqueda)
									|| infoServicio.getIdServicio().contains(busqueda)) {
								matcheaServicio = true;
								break;
							}
						}
						if (matcheaServicio) {
							serviciosResultado.add(infoServicio);
						}
					}
				}

				// Busco promociones que contengan el término buscado
				if (!promocionesTodas.isEmpty()) {
					for (DTMinPromocion dtMinP : promocionesTodas) {
						ctrlProductos.seleccionarPromocion(dtMinP);
						DTPromocion infoPromocion = ctrlProductos.infoPromocion();

						// Me fijo si el termino buscado conincide con algo de la promoción
						if (infoPromocion.getIdPromocion().contains(busqueda)) {
							promocionesResultado.add(infoPromocion);
						}
					}
				}
				// Si se seleccionó una categoría del árbol
			} else if (categoriaSeleccionada != null) {
				// Me fijo si debo listar las promociones
				if (categoriaSeleccionada.equals("Promociones")) {
					// Devuelvo todas las promociones
					if (!promocionesTodas.isEmpty()) {
						for (DTMinPromocion dtMinP : promocionesTodas) {
							ctrlProductos.seleccionarPromocion(dtMinP);
							DTPromocion infoPromocion = ctrlProductos.infoPromocion();
							promocionesResultado.add(infoPromocion);
						}
					}
				} else {
					// Agrego todos los servicios de esa categoría
					Set<DTMinServicio> serviciosDeCategoria = ctrlProductos.listarServiciosCategoria(categoriaSeleccionada);
					for (DTMinServicio dtMinS : serviciosDeCategoria) {
						ctrlProductos.seleccionarServicio(dtMinS);
						DTServicio infoServicio = ctrlProductos.infoServicio();
						serviciosResultado.add(infoServicio);
					}
				}
			}

			// Mando los resultados
			request.setAttribute("servicios", serviciosResultado);
			request.setAttribute("promociones", promocionesResultado);
			request.setAttribute("seleccionPrevia", categoriaSeleccionada);
			request.setAttribute("busquedaPrevia", (String) busqueda);

			// Reseteo los atributos para que en el próximo llamado no
			// tengan valores inválidos
			request.setAttribute("categoriaSeleccionada", null);
			request.setAttribute("busqueda", null);

			// Redirijo
			request.getRequestDispatcher("/pages/busqueda.jsp").forward(request, response);
		} catch (Exception ex) {
			Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
