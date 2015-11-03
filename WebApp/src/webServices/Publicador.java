/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webServices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author ignacio.prandi
 */
@WebService(name = "Publicador", targetNamespace = "http://ui.estaciondetrabajo.tprog/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Publicador {
    
    //muchas weas
    /*
      *@param arg1
      *@param arg0
      *@return
    */
     
    @WebMethod
    @WebResult(partName = "return")
    public int nuevoCliente(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);
    
    @WebMethod
    @WebResult(partName = "return")
    public String[] verServicio(@WebParam(name = "arg0", partName = "arg0")
        String arg0, @WebParam(name = "arg1", partName = "arg1")
        String arg1);
}
