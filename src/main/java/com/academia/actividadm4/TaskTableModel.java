package com.academia.actividadm4;

import com.academia.actividadm4.Entidades.Task;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Gimenez Carlos Martin
 */


//Clase para crear la tabla
public class TaskTableModel extends AbstractTableModel {
    private final List<Task> tasks;
    private final String[] columnNames = {"ID", "Nombre", "Descripcion"};

    public TaskTableModel(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Task task = tasks.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> task.getId();
            case 1 -> task.getTitle();
            case 2 -> task.getDescription();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
