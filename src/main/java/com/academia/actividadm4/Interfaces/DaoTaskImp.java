/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.academia.actividadm4.Interfaces;

import com.academia.actividadm4.Dao.Conexion;
import com.academia.actividadm4.Entidades.Task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class DaoTaskImp implements DaoTask {

    Conexion conn = new Conexion();

    @Override
    public Task crearTask(Task task) {
        try {
            Connection conectar = conn.establecerConexion();
            PreparedStatement pst = conectar.prepareStatement("INSERT INTO tasks (title, description) VALUES (?, ?)");
            pst.setString(1, task.getTitle());
            pst.setString(2, task.getDescription());
            pst.executeUpdate();

            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                task.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex.toString());
        }
        return task;

    }

    @Override
    public Task getbyIdTask(int id) {
        Task task = null;
        try {
            String sql = "SELECT * FROM tasks WHERE id = ?";
            Connection conectar = conn.establecerConexion();
            PreparedStatement pst = conectar.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setTitle(resultSet.getString("title"));
                task.setDescription(resultSet.getString("description"));
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex.toString());
        }
        return task;
    }

    @Override
    public List<Task> listarTasks() {
        List<Task> tasks = null;
        try {
            String sql = "SELECT * FROM tasks";
            Connection conectar = conn.establecerConexion();
            PreparedStatement pst = conectar.prepareStatement(sql);

            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setTitle(resultSet.getString("title"));
                task.setDescription(resultSet.getString("description"));
                tasks.add(task);

            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex.toString());
        }
        return tasks;

    }

    @Override
    public Task actualizarTask(Task task) {
        try {
            String sql = "UPDATE task SET title = ?, description = ?  WHERE id = ?";
            Connection conectar = conn.establecerConexion();
            PreparedStatement pst = conectar.prepareStatement(sql);
             pst.setString(1, task.getTitle());
            pst.setString(2, task.getDescription());
            pst.setInt(3, task.getId());
        } catch (SQLException ex) {
            System.out.println("Error"+ex.toString());
        }
        return task;
    }

    @Override
    public void eliminarTask(int id) {
        
    }

}
