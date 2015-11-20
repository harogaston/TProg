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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        webservice.PublicadorService service = new webservice.PublicadorService();
        webservice.Publicador proxy = service.getPublicadorPort();
        System.out.println("Llego hasta el servlet");
        response.setContentType("application/pdf");
        try {
            String idReservaString = request.getParameter("idReserva");
            Integer idReserva = Integer.parseInt(idReservaString);
            WrapperVerFactura wrapper = proxy.verFactura(idReserva);
            DtFacturaF dtf = wrapper.getFactura();
            Set<DtServicioF> servicios = new HashSet(dtf.getServicios());
            Set<DtPromocionF> promociones = new HashSet(dtf.getPromociones());
            String fecha = Integer.toString(dtf.getFecha().getDay()) + "-"
                    + Integer.toString(dtf.getFecha().getMonth()) + "-"
                    + Integer.toString(dtf.getFecha().getYear()) + "\n";
            // step 1
            Document document = new Document();
            // step 2
            PdfWriter.getInstance(document, response.getOutputStream());
            // step 3
            document.open();
            // step 4
            document.add(new Paragraph("Detalles de la Factura", FontFactory.getFont("arial", 22, Font.ITALIC, BaseColor.BLACK)));
            document.add(new Paragraph(" "));

            document.add(new Paragraph("Id de la Reserva: " + idReservaString));
            document.add(new Paragraph("Fecha: " + fecha));
            document.add(new Paragraph("Cliente: " + dtf.getNicknameCliente()));
            document.add(new Paragraph("Monto: $" + dtf.getMonto()));
            document.add(new Paragraph(" "));
            
            
            if (!servicios.isEmpty()) {
                document.add( new Paragraph("Servicios"));
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
                for(DtServicioF servicio: servicios){
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
             if (!promociones.isEmpty()) {
                document.add( new Paragraph("Promociones"));
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
                for(DtPromocionF promocion: promociones){
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
            //request.getRequestDispatcher("/pages/perfil.jsp").forward(request, response); 
/*
             ="panel-heading">Servicios</div>
             <br>
             <% if (!servicios.isEmpty()) { %>
             <table

             class  

             ="table">
             <thead>
             <tr>
             <th>Item</th>
             <th>Nombre</th>
             <th>Cantidad</th>
             <th>Precio</th>
             <th>Proveedor</th>

             </tr>
             </thead>
             <tbody>
             <%	int j = 0;
             for (DtServicioF servicio : servicios

                                    
             ) {
             j++;
             %
             > <tr>
             < th scope = "row" > <  %= j % > <  / th
             > <td> < %= servicio.getNombre() % > <  / td
             > <td> < %= servicio.getCantidad() % > <  / td
             > <td>$<  %= servicio.getPrecio() % > <  / td
             > <td> < %= servicio.getNicknameProveedor() % > <  / td
             > <  / tr
             > <  %
             }
             %>
             </table
                                    
                                
             >
             <%}%>
             </div
             >
             <div

             class  

             ="panel panel-default">    
             <div class  

             ="panel-heading">Promociones</div>
             <br>
             <% if (!promociones.isEmpty()) { %>
             <table

             class  

             ="table">
             <thead>
             <tr>
             <th>Item</th>
             <th>Nombre</th>
             <th>Cantidad</th>
             <th>Precio</th>
             <th>Proveedor</th>

             </tr>
             </thead>
             <tbody>
             <%	int i = 0;
             for (DtPromocionF promocion : promociones

                                            
             ) {
             i++;
             %
             > <tr>
             < th scope = "row" > <  %= i % > <  / th
             > <td> < %= promocion.getNombre() % > <  / td
             > <td> < %= promocion.getCantidad() % > <  / td
             > <td>
             $<  %= promocion.getPrecio() % > <  / td
             > <td> < %= promocion.getNicknameProveedor() % > <  / td
             */

        } catch (DocumentException de) {
            throw new IOException(de.getMessage());
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
