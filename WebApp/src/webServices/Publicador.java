/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webServices;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author ignacio.prandi
 */
@WebService(name = "Publicador", targetNamespace = "http://servidor/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Publicador {
    
    //muchas weas
}
