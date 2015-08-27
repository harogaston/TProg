/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Martins
 */
import Logica.DT.DTCliente;
import Logica.DT.DTMinCliente;
import java.util.HashMap;
import java.util.Map;
import Logica.*;
import java.util.Date;
public class Cliente extends Usuario {
    Map<String, Reserva> reservas = new HashMap<String, Reserva>(); // habilitar al haber reserva
    
    public Cliente(String nick, String nom, String ap, String email,String imagen, String fecha){
            super(nick,nom,ap,email,imagen,fecha);
    }
            
    public DTCliente crearDTCliente(){
        DTCliente dt = new DTCliente(getNickname(),getNombre(),getApellido(),getEmail(),getImagen(),
        getFechaNacimiento());
        
        return dt;
    }
    
    public DTMinCliente crearDTMin(){
        DTMinCliente dt = new DTMinCliente(getNickname(),getEmail());
        return dt;
    }
}
