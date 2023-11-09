
package com.academia.actividadm4.Dao;

import com.academia.actividadm4.Entidades.Task;
import com.academia.actividadm4.Interfaces.TaskDAO;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Gimenez Carlos Martin
 */
public class TaskDAOJPAImplements implements TaskDAO {

    private static final String PERSISTENCE_UNIT_NAME = "actividadM4Persistencia";
    private static final EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    //agregar tarea
    @Override
    public void addTask(Task task) {
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(task);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            JOptionPane.showMessageDialog(null, e.toString()); 
        } finally {
            em.close();
        }
    }

    //actualizar tarea
    @Override
    public void updateTask(Task task) {
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(task);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
            em.close();
        }
    }

    //eliminar tarea
    @Override
    public void deleteTask(int taskId) {
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Task task = em.find(Task.class, taskId);
            if (task != null) {
                em.remove(task);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
            em.close();
        }
    }

    //obtener tarea por id
    @Override
    public Task getTaskById(int taskId) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.find(Task.class, taskId);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        } finally {
            em.close();
        }
    }

    //obtener la lista completa de tareas
    @Override
    public List<Task> getAllTasks() {
        EntityManager em = factory.createEntityManager();
        try {
            Query query = em.createQuery("SELECT t FROM Task t");
            return query.getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return Collections.emptyList();
        } finally {
            em.close();
        }
    }

}
