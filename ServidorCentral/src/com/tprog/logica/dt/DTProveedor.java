/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.dt;
import java.util.*;
/**
 *
 * @author sofia
 */
public class DTProveedor extends DTUsuario {
    private final String empresa;
    private final String web;
    
    public DTProveedor(String nick, String nom, String ap, String email,String imagen, Date fecha,
            String emp, String web){
            super(nick,nom,ap,email,imagen,fecha);
            this.empresa = emp;
            this.web = web;
    }
    
    String getEmpresa(){
        return this.empresa;
    }
    
    String getWeb(){
        return this.web;
    }
    
}
