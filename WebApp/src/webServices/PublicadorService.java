/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webServices;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

/**
 *
 * @author ignacio.prandi
 */
@WebServiceClient(name = "PublicadorService", targetNamespace = "http://ui.estaciondetrabajo.tprog/", wsdlLocation = "http://localhost:9128/publicador?wsdl")
public class PublicadorService extends Service {
    private final static URL PUBLICADORSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(PublicadorService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = PublicadorService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:9128/publicador?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:9128/publicador?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        PUBLICADORSERVICE_WSDL_LOCATION = url;
    }

    public PublicadorService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PublicadorService() {
        super(PUBLICADORSERVICE_WSDL_LOCATION, new QName("http://ui.estaciondetrabajo.tprog/", "PublicadorService"));
    }

    /**
     * 
     * @return
     *     returns Publicador
     */
    @WebEndpoint(name = "PublicadorPort")
    public Publicador getPublicadorPort() {
        return super.getPort(new QName("http://ui.estaciondetrabajo.tprog/", "PublicadorPort"), Publicador.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Publicador
     */
    @WebEndpoint(name = "PublicadorPort")
    public Publicador getPublicadorPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ui.estaciondetrabajo.tprog/", "PublicadorPort"), Publicador.class, features);
    }
}
