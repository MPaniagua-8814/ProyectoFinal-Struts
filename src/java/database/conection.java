/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Anderson
 */
public class conection {
    Connection con;
    String url="jdbc:mysql://localhost:3306/organizador_tareas";
    String user="root";
    String pass="";
    
    
    public Connection Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        } catch (Exception u){
                }
    
    return con;
    }
}
