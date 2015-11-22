/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.web;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webservice.DtFacturaF;
import webservice.DtPromocionF;
import webservice.DtServicioF;
import webservice.WrapperVerFactura;

/**
 *
 * @author User
 */
@WebServlet(name = "DescargarPDF", urlPatterns = {"/DescargarPDF"})
public class DescargarPDF extends HttpServlet {

	private String RESULT = "";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		webservice.PublicadorService service = new webservice.PublicadorService();
		webservice.Publicador proxy = service.getPublicadorPort();
		System.out.println("Llego hasta el servlet");
		//response.setContentType("application/pdf");
		try {
			String idReservaString = request.getParameter("idReserva");
            //asigno ruta donde quiero descargar la imagen --hay que cambiarlo
			//el path por defecto esta en glassfish no se que, en tomcat debe ser igual
			RESULT = "C:\\Kun\\tallerino\\TProg\\WebApp\\facturas/factura" + idReservaString + ".pdf";
			Integer idReserva = Integer.parseInt(idReservaString);
			WrapperVerFactura wrapper = proxy.verFactura(idReserva);
			DtFacturaF dtf = wrapper.getFactura();
			Set<DtServicioF> servicios = new HashSet(dtf.getServicios());
			Set<DtPromocionF> promociones = new HashSet(dtf.getPromociones());
			String fecha = Integer.toString(dtf.getFecha().getDay()) + "-"
					+ Integer.toString(dtf.getFecha().getMonth()) + "-"
					+ Integer.toString(dtf.getFecha().getYear()) + "\n";
			//creo el documento pdf
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(RESULT));
			document.open();
			document.add(new Paragraph("Detalles de la Factura", FontFactory.getFont("arial", 22, Font.ITALIC, BaseColor.BLACK)));
			document.add(new Paragraph(" "));
			//ingreso los datos de la factura
			document.add(new Paragraph("Id de la Reserva: " + idReservaString));
			document.add(new Paragraph("Fecha: " + fecha));
			document.add(new Paragraph("Cliente: " + dtf.getNicknameCliente()));
			document.add(new Paragraph("Monto: $" + dtf.getMonto()));
			document.add(new Paragraph(" "));

			//tabla para los servicios
			if (!servicios.isEmpty()) {
				document.add(new Paragraph("Servicios"));
				document.add(new Paragraph(" "));
				PdfPTable table = new PdfPTable(5);
				table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell("Item");
				table.addCell("Nombre");
				table.addCell("Cantidad");
				table.addCell("Precio");
				table.addCell("Proveedor");
				table.getDefaultCell().setBackgroundColor(null);
				int i = 1;
				for (DtServicioF servicio : servicios) {
					table.addCell(Integer.toString(i));
					table.addCell(servicio.getNombre());
					table.addCell(Integer.toString(servicio.getCantidad()));
					table.addCell(Double.toString(servicio.getPrecio()));
					table.addCell(servicio.getNicknameProveedor());
					i++;
				}

				document.add(table);
				document.add(new Paragraph(" "));
			}
			//tabla para las promos
			if (!promociones.isEmpty()) {
				document.add(new Paragraph("Promociones"));
				document.add(new Paragraph(" "));
				PdfPTable table = new PdfPTable(5);
				table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell("Item");
				table.addCell("Nombre");
				table.addCell("Cantidad");
				table.addCell("Precio");
				table.addCell("Proveedor");
				table.getDefaultCell().setBackgroundColor(null);
				int i = 1;
				for (DtPromocionF promocion : promociones) {
					table.addCell(Integer.toString(i));
					table.addCell(promocion.getNombre());
					table.addCell(Integer.toString(promocion.getCantidad()));
					table.addCell(Double.toString(promocion.getPrecio()));
					table.addCell(promocion.getNicknameProveedor());
					i++;
				}

				document.add(table);
				document.add(new Paragraph(" "));
			}

			// step 5
			document.close();
			session.setAttribute("descargaOK", "La descarga se completó correctamente.");
			response.sendRedirect("VerPerfil");
		} catch (DocumentException de) {
			throw new IOException(de.getMessage());
		}

	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
