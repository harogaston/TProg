/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.logica.clases;

import java.util.Date;

public class Usuario {

    private String nickname;
    private String nombre;
    private String apellido;
    private String password;
    private String email;
    private String imagen;
    private Date fechaNacimiento;

    public Usuario(String Nickname, String Password, String Nombre, String Apellido, String Email,
            String Imagen, Date FechaN) {
        this.nickname = Nickname;
        this.password = Password;
        this.nombre = Nombre;
        this.apellido = Apellido;
        this.email = Email;
        this.imagen = Imagen;
        this.fechaNacimiento = FechaN;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getImagen() {
        return imagen;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.apellido = Apellido;
    }

    public void setNickname(String Nickname) {
        this.nickname = Nickname;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public void setImagen(String Imagen) {
        this.imagen = Imagen;
    }

    public void setFechaNacimiento(Date FechaN) {
        this.fechaNacimiento = FechaN;
    }

}
