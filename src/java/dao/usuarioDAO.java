/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.usuario;

/**
 *
 * @author Anderson
 */
public interface usuarioDAO {
    List<usuario> getAllusuario();
    void insert(usuario usuario);
    void update(usuario usuario);
    void delete(int id_usuario);
    usuario getusuarioById(int id_usuario);
}
