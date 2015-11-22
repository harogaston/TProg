package tprog.logica.clases;

import java.util.ArrayList;

public class RegistroAccesos {
    private static RegistroAccesos instance = null;
    private ArrayList<Acceso> accesos;
    
    public RegistroAccesos(){
        accesos = new ArrayList<Acceso>();
    }
    
    public static RegistroAccesos getInstance(){
        if (instance == null){
            instance = new RegistroAccesos();
        }
        return instance;
    }
    
    public ArrayList<Acceso> getAccesos(){
        return accesos;
    }

    public void agregarAcceso(String ipAddress, String urlAddress, String browser, 
            String sistemaOperativo){
        if (accesos.size()== 10000){
            accesos.remove(0);
        }
        accesos.add(new Acceso(ipAddress, urlAddress, browser, sistemaOperativo));
    }
}
