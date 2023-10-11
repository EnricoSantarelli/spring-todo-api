package santarelli.enrico.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santarelli.enrico.domain.enums.Status;
import santarelli.enrico.domain.models.Task;
import santarelli.enrico.domain.repositories.TaskRepository;
import santarelli.enrico.service.TaskService;

import javax.naming.directory.InvalidAttributesException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task createTask(Task task) throws InvalidAttributesException{
        if(task.getDifficulty() == null || task.getStatus() == null || task.getIconCodePoint() == null || task.getTitle() == null){
            throw new InvalidAttributesException();
        }
        Task taskCreated = taskRepository.save(task);
        return taskCreated;
    }

    @Override
    public Task updateTask(Task task) {
        Task taskToUpdate = taskRepository.findById(task.getId()).orElseThrow(NoSuchElementException::new);

        if(task.getDifficulty() != null){
            taskToUpdate.setDifficulty(task.getDifficulty());
        }
        if(task.getIconCodePoint() != null){
            taskToUpdate.setIconCodePoint(task.getIconCodePoint());
        }
        if(task.getTitle() != null){
            taskToUpdate.setTitle(task.getTitle());
        }
        if(task.getStatus() != null){
            taskToUpdate.setStatus(task.getStatus());
        }
        if(task.getDescription() != null) {
            taskToUpdate.setDescription(task.getDescription());
        }

        Task taskUpdated = taskRepository.save(taskToUpdate);
        return taskUpdated;
    }

    @Override
    public void deleteTask(Long id) throws NoSuchElementException {
        if(!taskRepository.existsById(id)){
            throw new NoSuchElementException();
        }
        taskRepository.deleteById(id);
    }
}
