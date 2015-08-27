/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.DT;

/**
 *
 * @author Martins
 */
import java.util.Date;
public class DTUsuario {
    
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private String imagen;
    private String fechaNacimiento; // hay q pasarlo a Date si se puede
    
    public DTUsuario(String nick, String nom, String ap, String em,
            String imag, String fN){
        this.nickname = nick;
        this.nombre = nom;
        this.apellido = ap;
        this.email = em;
        this.imagen = imag;
        this.fechaNacimiento  = fN;
    }
    public DTUsuario(){
        this.nickname = "";
        this.nombre = "";
        this.apellido = "";
        this.email = "";
        this.imagen = "";
        this.fechaNacimiento  = "";
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
        return  fechaNacimiento;
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
     public void setFechaNacimiento(String fecha){
        fechaNacimiento = fecha;
    }
}
