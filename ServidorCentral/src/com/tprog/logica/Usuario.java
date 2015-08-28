/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.logica;

/**
 *
 * @author Martins
 */
import java.util.Date;
public class Usuario {
    
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private String imagen;
    private Date fechaNacimiento; // pasar a Date en caso de poderse
    
    public Usuario(String nick, String nom, String ap, String email,
            String imag, Date fN){
        this.nickname = nick;
        this.nombre = nom;
        this.apellido = ap;
        this.email = email;
        this.imagen = imag;
        this.fechaNacimiento  = fN;
    }
    
    //Getters
    
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getNickname(){
        return nickname;
    }
     public String getEmail(){
        return email;
    }
     public String getImagen(){
        return imagen;
    }
     public Date getFechaNacimiento(){
        return fechaNacimiento;
    }
     
    // Setters
    
    public void setNombre(String nom){
        this.nombre = nom;
    }
    public void setApellido(String ap){
        this.apellido = ap;
    }
    public void setNickname(String nick){
        this.nickname = nick;
    }
    public void setEmail(String em){
        this.email = em;
    }
     public void setImagen(String imag){
        this.imagen = imag;
    }
     public void setFechaNacimiento(Date fecha){
        this.fechaNacimiento = fecha;
    }
    
}
