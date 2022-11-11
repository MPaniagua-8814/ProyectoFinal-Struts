/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Anderson
 */
public class usuario {
    private int id_usuario;
    private String nombre;
    private String login;
    private String correo;

     public usuario() {
         super();
    }
     
    public usuario(int id_usuario, String nombre, String login, String correo) {
        super();
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.login = login;
        this.correo = correo;
    }
    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}
