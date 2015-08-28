/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica.dt;

/**
 *
 * @author Martins
 */
public class DTMinCliente {
    private String nickname;
    private String email;
    
    public DTMinCliente(String nick, String em){
        this.nickname = nick;
        this.email = em;
    }
    
    public String getNickname(){
        return this.nickname;
    }
    
    public String getEmail(){
        return this.email;
    }
    
}
