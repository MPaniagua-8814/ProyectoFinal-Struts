/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.usuario;

/**
 *
 * @author Anderson
 */
public class usuarioDAOImpl implements usuarioDAO {

    conection cn = new conection();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<usuario> getAllusuario() {
        String sql = "select * from usuario";
        List<usuario> list = new ArrayList<usuario>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuario us = new usuario();
                us.setId_usuario(rs.getInt("id_usuario"));
                us.setNombre(rs.getString("nombre"));
                us.setLogin(rs.getString("login"));
                us.setCorreo(rs.getString("correo"));
                list.add(us);
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void insert(usuario usuario) {
        String sql = "insert into usuario(id_rol,login,nombre,correo,contrasena,activo,interno) values(?,?,?,?,?,?,?)";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getCorreo());
            ps.setString(5, usuario.getLogin());
            ps.setBoolean(6, true);
            ps.setBoolean(7, true);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(usuario usuario) {
        String sql = "update usuario set nombre=?, login=?, correo=? where id_usuario=?";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getCorreo());
            ps.setInt(4, usuario.getId_usuario());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id_usuario) {
        String sql = "delete from usuario where id_usuario=?";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_usuario);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     @Override
    public usuario getusuarioById(int id_usuario) {
    String sql = "select * from usuario where id_usuario=?";
    usuario user = new usuario();
     con = cn.Conexion();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
               int id_usuario2 = rs.getInt(1);
               String login = rs.getString(3);
               String nombre = rs.getString(4);
               String correo = rs.getString(5);
               user = new usuario(id_usuario2,nombre,login,correo); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
          return user;  
    }
    
//    @Override
//    public usuario getusuarioById(int id_usuario) {
//    String sql = "select * from usuario where id_usuario=?";
//    usuario user = new usuario();
//     con = cn.Conexion();
//        try {
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while(rs.next()){
//                user.setNombre(rs.getString("nombre"));
//                user.setLogin(rs.getString("login"));
//                user.setCorreo(rs.getString("correo"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(usuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//          return user;  
//    }

}
