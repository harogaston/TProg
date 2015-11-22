
package tprog.logica.clases;

import java.util.Date;

public class Acceso {
    private int idAcceso;
    private final String ipAddress;
    private final String urlAddress;
    private final String browser;
    private final String sistemaOperativo;
    private final Date fechaAcceso;
    private static int numeracion = 0;    
    
    public int getIdAcceso(){
        return idAcceso;
    }
    
    public String getIPAddress(){
        return ipAddress;
    }
    
    public String getURLAddress(){
        return urlAddress;
    }
    
    public String getBrowser(){
        return browser;
    }
    
    public String getSistemaOperativo(){
        return sistemaOperativo;
    }
    
    public Date getFechaAcceso(){
        return fechaAcceso;
    }
    
    public Acceso(String ipAddress, String urlAddress, String browser, 
            String sistemaOperativo) {
        numeracion++;
        this.idAcceso = numeracion;
        this.ipAddress = ipAddress;
        this.urlAddress = urlAddress;
        this.browser = browser;
        this.sistemaOperativo = sistemaOperativo;
        this.fechaAcceso = new Date();
    }
}
