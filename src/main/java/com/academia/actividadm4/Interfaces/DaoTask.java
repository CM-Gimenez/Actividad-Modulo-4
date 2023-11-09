
package com.academia.actividadm4.Interfaces;

import com.academia.actividadm4.Entidades.Task;
import java.util.List;

/**
 *
 * @author Gimenez Carlos Martin
 */
public interface DaoTask {
    //metodos utilizados para el crud de task
    //crear task
    Task crearTask(Task task);
    
    //obtener tarea por id
    Task getbyIdTask(int id);
    
    //listar todas las tareas
    List<Task> listarTasks();
    
    //actualizar una tarea
    Task actualizarTask(Task task);
    
    //eliminar una tarea
    void eliminarTask(int id);
}
