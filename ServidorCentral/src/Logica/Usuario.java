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
import java.util.Date;
public class Usuario {
    
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private String imagen;
    private Date fechaNacimiento;
    
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
     public String getFechaNacimiento(){
        return "";
    }
     
    // Setters
    
    public void setNombre(String nom){
        nombre = nom;
    }
    public void setApellido(String ap){
        apellido = ap;
    }
    public void setNickname(String nick){
        nickname = nick;
    }
    public void setEmail(String em){
        email = em;
    }
     public void setImagen(String imag){
        imagen = imag;
    }
     public void setFechaNacimiento(Date fecha){
        fechaNacimiento = fecha;
    }
    
}
