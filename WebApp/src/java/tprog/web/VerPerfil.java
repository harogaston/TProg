package tprog.web;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webservice.DtCliente;
import webservice.DtProveedor;
import webservice.DtReserva;
import webservice.WrapperVerPerfilCliente;
import webservice.WrapperVerPerfilProveedor;

public class VerPerfil extends HttpServlet {

	/*
	 Se tiene que manejar igual el doPost y el doGet, por eso ambos hacen
	 el mismo processRequest
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		webservice.PublicadorService service = new webservice.PublicadorService();
		webservice.Publicador proxy = service.getPublicadorPort();

		if (request.getSession().getAttribute("usuario_logueado") != null) {
			if (session.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE) {
				WrapperVerPerfilCliente result = proxy.verPerfilCliente((String) request.getSession().getAttribute("usuario_logueado"));
				DtCliente dtC = result.getCliente();
				request.setAttribute("nick", dtC.getNickname());
				String nombreCompleto = dtC.getNombre() + " " + dtC.getApellido();
				request.setAttribute("nombre", nombreCompleto);
				String fNac = Integer.toString(dtC.getFechaNacimiento().getDay()) + "-"
						+ Integer.toString(dtC.getFechaNacimiento().getMonth() + 1) + "-"
						+ Integer.toString(dtC.getFechaNacimiento().getYear()) + "\n";
				request.setAttribute("fNac", fNac);
				request.setAttribute("email", dtC.getEmail());

				byte[] bytesImagen = result.getImagen();
				if (bytesImagen != null) {
					BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytesImagen));
					String rutaRelativaImagen = "imagenes/clientes/" + dtC.getNickname() + ".jpg";
					String rutaCompletaImagen = getServletContext().getRealPath("/") + "/" + rutaRelativaImagen;
					ImageIO.write(img, "jpg", new File(rutaCompletaImagen));
					System.out.println("Ruta imagen original = " + dtC.getImagen());
					System.out.println("Ruta relativa = " + rutaCompletaImagen);
					request.setAttribute("imagen", rutaRelativaImagen);
				}
				// Voy a crear un Set<DTReserva> para pasarle a la jsp
				Set<DtReserva> reservas = new HashSet(result.getReservas());
				request.setAttribute("reservas", reservas);
				request.getRequestDispatcher("/pages/perfil.jsp").forward(request, response);
			} else {
				try {
					WrapperVerPerfilProveedor result = proxy.verPerfilProveedor((String) request.getSession().getAttribute("usuario_logueado"));
					DtProveedor dtP = result.getProveedor();
					request.setAttribute("nick", dtP.getNickname());
					String nombreCompleto = dtP.getNombre() + " " + dtP.getApellido();
					request.setAttribute("nombre", nombreCompleto);
					String fNac = Integer.toString(dtP.getFechaNacimiento().getDay()) + "-"
							+ Integer.toString(dtP.getFechaNacimiento().getMonth() + 1) + "-"
							+ Integer.toString(dtP.getFechaNacimiento().getYear()) + "\n";
					request.setAttribute("fNac", fNac);
					request.setAttribute("email", dtP.getEmail());

					byte[] bytesImagen = result.getImagen();
					if (bytesImagen != null) {
						BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytesImagen));
						String rutaRelativaImagen = "imagenes/proveedores/" + dtP.getNickname() + ".jpg";
						String rutaCompletaImagen = getServletContext().getRealPath("/") + "/" + rutaRelativaImagen;
						ImageIO.write(img, "jpg", new File(rutaCompletaImagen));
						System.out.println("Ruta imagen original = " + dtP.getImagen());
						System.out.println("Ruta relativa = " + rutaCompletaImagen);
						//si la imagen es nula, directamente no se asigna el atributo
						request.setAttribute("imagen", rutaRelativaImagen);
					}
					request.setAttribute("linkEmpresa", dtP.getWebEmpresa());
					request.setAttribute("nombreEmpresa", dtP.getEmpresa());
					request.getRequestDispatcher("/pages/perfil.jsp").forward(request, response);
				} catch (ServletException | IOException ex) {
					Logger.getLogger(VerPerfil.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		} else {
			// Si por algún motivo el atributo ya no existe (ej: expiró la sesión) lo mando al inicio
			request.getRequestDispatcher("/pages/inicio.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
