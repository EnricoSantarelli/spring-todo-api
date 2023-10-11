package santarelli.enrico.service;

import santarelli.enrico.domain.models.Task;

import javax.naming.directory.InvalidAttributesException;
import java.util.List;
import java.util.NoSuchElementException;

public interface TaskService {

    List<Task> getAllTasks();
    Task createTask(Task task) throws InvalidAttributesException;
    Task updateTask(Task task);

    void deleteTask(Long id) throws NoSuchElementException;

}
