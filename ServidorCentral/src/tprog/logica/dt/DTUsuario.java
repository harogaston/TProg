/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.logica.dt;

import java.util.Date;

public class DTUsuario {

    protected String nickname;
    protected String nombre;
    protected String apellido;
    protected String password;
    protected String email;
    protected String imagen;
    protected Date fechaNacimiento;

    public DTUsuario(String nickname, String nombre, String apellido, String email,
            String imagen, Date fechaNacimiento) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.imagen = imagen;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "Nickname: " + nickname
                + "\n" + "Nombre: " + nombre
                + "\n" + "Apellido: " + apellido
                + "\n" + "Email: " + email
                + "\n" + "Fecha de nacimiento: "
                + Integer.toString(fechaNacimiento.getDate()) + "-"
                + Integer.toString(fechaNacimiento.getMonth() + 1) + "-"
                + Integer.toString(fechaNacimiento.getYear()) + "\n";

    }

}
