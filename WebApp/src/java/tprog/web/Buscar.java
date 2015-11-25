package tprog.web;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webservice.DtPromocion;
import webservice.DtServicio;

public class Buscar extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//establezco proxy con el web service
			URL wsdlLocation = new URL(getServletContext().getInitParameter("wsdl"));
			webservice.PublicadorService service = new webservice.PublicadorService(wsdlLocation);
			webservice.Publicador proxy = service.getPublicadorPort();
			//preparo los parametros para pasar al web service
			//porque no se pueden pasar nulls
			String busquedaPrevia = (request.getParameter("busquedaPrevia") == null) ? "null" : request.getParameter("busquedaPrevia");
			String seleccionPrevia = (request.getParameter("seleccionPrevia") == null) ? "null" : request.getParameter("seleccionPrevia");
			String tipoOrden = (request.getParameter("tipo_orden") == null) ? "null" : request.getParameter("tipo_orden");
			String busqueda = (request.getParameter("busqueda") == null) ? "null" : request.getParameter("busqueda");
			String categoriaSeleccionada = (request.getParameter("categoriaSeleccionada") == null) ? "null" : request.getParameter("categoriaSeleccionada");
			//recibo respuesta
			webservice.WrapperBuscar result = proxy.buscar(
					busquedaPrevia,
					seleccionPrevia,
					tipoOrden,
					busqueda,
					categoriaSeleccionada);
			//paso el arbol de categorias de nuevo a un jsonarray
			JsonParser jsonParser = new JsonParser();
			JsonArray list = (JsonArray) jsonParser.parse(result.getArbolCategorias());
			request.setAttribute("arbolJson", list);
			//paso los terminos del typeahead a un jsonarray
			JsonArray termsArray = (JsonArray) jsonParser.parse(result.getTerminosTypeAhead());
			request.setAttribute("terminos", termsArray);
			//rearmo el map de servicios
			List<webservice.WrapperBuscar.Servicios.Entry> listServicios
					= result.getServicios().getEntry();
			Map<DtServicio, String> servicios = new HashMap<>();
			for (webservice.WrapperBuscar.Servicios.Entry entry : listServicios) {
				servicios.put(entry.getKey(), entry.getValue());
			}
			//rearmo el map de promociones
			List<webservice.WrapperBuscar.Promociones.Entry> listPromociones
					= result.getPromociones().getEntry();
			Map<DtPromocion, String> promociones = new HashMap<>();
			for (webservice.WrapperBuscar.Promociones.Entry entry : listPromociones) {
				promociones.put(entry.getKey(), entry.getValue());
			}
			//asigno atributos de la request
			request.setAttribute("servicios", servicios);
			request.setAttribute("promociones", promociones);
			request.setAttribute("categoriaPrevia", result.getCategoriaPrevia());
			request.setAttribute("busquedaPrevia", result.getBusquedaPrevia());
			tipoOrden = result.getTipoOrden();
			if (!tipoOrden.equals("")) {
				request.setAttribute("tipo_orden", result.getTipoOrden());
			}
			//reseteo los atributos para que en el próximo llamado no
			//tengan valores inválidos
			request.setAttribute("categoriaSeleccionada", null);
			request.setAttribute("busqueda", null);
			//redirijo request
			request.getRequestDispatcher("/pages/busqueda.jsp").forward(request, response);
		} catch (ServletException | IOException ex) {
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
