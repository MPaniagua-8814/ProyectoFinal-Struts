/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import dao.usuarioDAO;
import dao.usuarioDAOImpl;
import java.util.List;
import model.usuario;

/**
 *
 * @author Anderson
 */
public class CRUD extends ActionSupport {

    List<usuario> list;
    usuario usuario;
    int id_usuario;
    String nombre;
    String login;
    String correo;

    public List<usuario> getList() {
        return list;
    }

    public void setList(List<usuario> list) {
        this.list = list;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
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

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }

    public String gotoCrud() {
        usuarioDAO userDAO = new usuarioDAOImpl();
        list = userDAO.getAllusuario();
        usuario = new usuario();
        return "success";
    }
    
    public String SaveOrUpdate(){
        usuario = new usuario(id_usuario,nombre,login,correo);
        usuarioDAO userDAO = new usuarioDAOImpl();
        
        if(id_usuario != 0){
            userDAO.update(usuario);
        }else{
            userDAO.insert(usuario);
        }
        list = userDAO.getAllusuario();
        usuario = new usuario();
        return "success";
    }
    
    public String editusuario(){
        usuarioDAO userDAO = new usuarioDAOImpl();
        usuario = userDAO.getusuarioById(id_usuario);
        list = userDAO.getAllusuario();
        return "success";
    }
    
    public String deleteUsuario(){
        usuarioDAO userDAO = new usuarioDAOImpl();
        userDAO.delete(id_usuario);
        list = userDAO.getAllusuario();
        usuario = new usuario();
        return "success";
    }
}
