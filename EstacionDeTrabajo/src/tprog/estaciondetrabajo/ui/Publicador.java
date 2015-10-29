/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tprog.estaciondetrabajo.ui;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

/**
 *
 * @author ignacio.prandi
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class Publicador {
    
    //private Logica logica = new Logica();
    private Endpoint endpoint = null;
    
    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9128/publicador", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    @WebMethod
    public int nuevoCliente(int i){
        return i;
        
    }
    
    
}
