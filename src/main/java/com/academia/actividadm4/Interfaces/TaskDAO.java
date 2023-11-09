
package com.academia.actividadm4.Interfaces;

import com.academia.actividadm4.Entidades.Task;
import java.util.List;

/**
 *
 * @author Gimenez Carlos Martin
 */
public interface TaskDAO {
    //metodos utilizados para el crud de task
    void addTask(Task task);
    void updateTask(Task task);
    void deleteTask(int taskId);
    Task getTaskById(int taskId);
    List<Task> getAllTasks();
}
