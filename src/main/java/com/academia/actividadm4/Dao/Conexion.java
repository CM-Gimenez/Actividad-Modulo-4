/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.academia.actividadm4.Dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author usuario
 */
public class Conexion {
      //Instancia de Connection de Java.Sql
    Connection conectar = null;

    //Atributos de base de datos necesarios para la conexion de la app con la base de datos.
    String usuario = "root";
    String password = "123456";
    String nameDB = "academiasofttek";
    String hostName = "localhost";
    String port = "3306";
    
    //Instancia de ResultSet de Java.sql
    ResultSet rs = null;
    //Instancia de Statement de Java.sql
    Statement st = null;

    //query de conexion a base de datos
    String cadena = "jdbc:mysql://" + hostName + ":" + port + "/" + nameDB;
    
    //metodo para establecer la conexión a base de datos
    public Connection establecerConexion() {
        try {
            conectar = DriverManager.getConnection(cadena, usuario, password);
            System.out.println("Conexión establecida con la base de  datos");
        } catch (HeadlessException | SQLException e) {
            System.out.println(e.toString());
        }

        return conectar;
    }
    
}
