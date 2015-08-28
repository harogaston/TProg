/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.DT;

import java.util.Date;

/**
 *
 * @author Martins
 */
public class DTCliente extends DTUsuario {
    
    public DTCliente(String nick, String nom, String ap, String email,String imagen, Date fecha){
            super(nick,nom,ap,email,imagen,fecha);
    }
    
}
