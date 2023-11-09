/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.academia.actividadm4.Dao;

import com.academia.actividadm4.Entidades.Task;
import com.academia.actividadm4.Interfaces.TaskDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author usuario
 */
public class TaskDAOJPAImplements implements TaskDAO {
    private static final String PERSISTENCE_UNIT_NAME = "actividadM4Persistencia"; 
    private static final EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    @Override
    public void addTask(Task task) {
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(task);
        tx.commit();
        em.close();
    }

    @Override
    public void updateTask(Task task) {
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(task);
        tx.commit();
        em.close();
    }

    @Override
    public void deleteTask(int taskId) {
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Task task = em.find(Task.class, taskId);
        em.remove(task);
        tx.commit();
        em.close();
    }

    @Override
    public Task getTaskById(int taskId) {
        EntityManager em = factory.createEntityManager();
        Task task = em.find(Task.class, taskId);
        em.close();
        return task;
    }

    @Override
    public List<Task> getAllTasks() {
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("SELECT t FROM Task t");
        List<Task> tasks = query.getResultList();
        em.close();
        return tasks;
    }
}
