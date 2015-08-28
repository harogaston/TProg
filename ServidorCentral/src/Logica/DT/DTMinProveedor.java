/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.DT;

/**
 *
 * @author sofia
 */
public class DTMinProveedor {
    private final String nickname;
    private final String email;
    private final String empresa;
    
    public DTMinProveedor(String nick, String email, String emp){
        this.nickname = nick;
        this.email = email;
        this.empresa = emp;
    }
    
    public String getNickname(){
        return this.nickname;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getEmpresa(){
        return this.empresa;
    }
    
}
