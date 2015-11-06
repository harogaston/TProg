package tprog.web;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tprog.logica.dt.DTCliente;
import tprog.logica.dt.DTMinReserva;
import tprog.logica.dt.DTProveedor;
import tprog.logica.dt.DTReserva;
import tprog.logica.interfaces.Fabrica;
import tprog.logica.interfaces.ICtrlUsuarios;

public class VerPerfil extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Fabrica f = Fabrica.getInstance();
                HttpSession session = request.getSession();
		ICtrlUsuarios ctrlU = f.getICtrlUsuarios();
		if (request.getSession().getAttribute("usuario_logueado") != null) {
                        if (session.getAttribute("tipo_usuario") == TipoUsuario.CLIENTE){
                            ctrlU.seleccionarCliente((String) request.getSession().getAttribute("usuario_logueado"));
                            DTCliente dtC;
                            try {
				dtC = ctrlU.infoCliente();
				request.setAttribute("nick", dtC.getNickname());
				String nombreCompleto = dtC.getNombre() + " " + dtC.getApellido();
				request.setAttribute("nombre", nombreCompleto);
				Date fechaNacimiento = dtC.getFechaNacimiento();
				String fNac = Integer.toString(fechaNacimiento.getDate()) + "-"
						+ Integer.toString(fechaNacimiento.getMonth() + 1) + "-"
						+ Integer.toString(fechaNacimiento.getYear() + 1900) + "\n";
				request.setAttribute("fNac", fNac);
				request.setAttribute("email", dtC.getEmail());
				request.setAttribute("imagen", dtC.getImagen());

				Set<DTMinReserva> reservasMin = dtC.getReservas();
				// Voy a crear un Set<DTReserva> para pasarle a la jsp
				Collection<DTReserva> reservas = new TreeSet<>();
				for (DTMinReserva dtMinR : reservasMin) {
					ctrlU.seleccionarReserva(dtMinR.getIdReserva());
					reservas.add(ctrlU.infoReserva());
				}
				request.setAttribute("reservas", reservas);

				request.getRequestDispatcher("/pages/perfil.jsp").forward(request, response);
			} catch (Exception ex) {
				Logger.getLogger(VerPerfil.class.getName()).log(Level.SEVERE, null, ex);
			}
                        }else{
                            ctrlU.seleccionarProveedor((String) request.getSession().getAttribute("usuario_logueado"));
                            DTProveedor dtP;
                            try {
				dtP = ctrlU.infoProveedor();
				request.setAttribute("nick", dtP.getNickname());
				String nombreCompleto = dtP.getNombre() + " " + dtP.getApellido();
				request.setAttribute("nombre", nombreCompleto);
				Date fechaNacimiento = dtP.getFechaNacimiento();
				String fNac = Integer.toString(fechaNacimiento.getDate()) + "-"
						+ Integer.toString(fechaNacimiento.getMonth() + 1) + "-"
						+ Integer.toString(fechaNacimiento.getYear() + 1900) + "\n";
                                request.setAttribute("fNac", fNac);
				request.setAttribute("email", dtP.getEmail());
				request.setAttribute("imagen", dtP.getImagen());
                                request.setAttribute("linkEmpresa", dtP.getWebEmpresa());
                                request.setAttribute("nombreEmpresa", dtP.getEmpresa());
                                request.setAttribute("", f);
				/*Set<DTMinReserva> reservasMin = dtC.getReservas();
				// Voy a crear un Set<DTReserva> para pasarle a la jsp
				/*Collection<DTReserva> reservas = new TreeSet<>();
				for (DTMinReserva dtMinR : reservasMin) {
					ctrlU.seleccionarReserva(dtMinR.getIdReserva());
					reservas.add(ctrlU.infoReserva());
				}
				request.setAttribute("reservas", reservas);*/

				request.getRequestDispatcher("/pages/perfil.jsp").forward(request, response);
			} catch (Exception ex) {
				Logger.getLogger(VerPerfil.class.getName()).log(Level.SEVERE, null, ex);
			}
                        }    
		} else {
			// Si por algún motivo el atributo ya no exite (ej: expiró la sesión) lo mando al inicio
			request.getRequestDispatcher("/pages/inicio.jsp").forward(request, response);
		}
	}
}
