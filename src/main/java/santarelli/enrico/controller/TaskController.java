package santarelli.enrico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import santarelli.enrico.domain.models.Task;
import santarelli.enrico.service.TaskService;

import javax.naming.directory.InvalidAttributesException;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) throws InvalidAttributesException {
        Task taskCreated = taskService.createTask(task);
        return ResponseEntity.ok(taskCreated);
    }

    @PutMapping
    public ResponseEntity<Task> updateTask(@RequestBody Task task){
        Task taskUpdated = taskService.updateTask(task);
        return ResponseEntity.ok(taskUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
