package kg.java.todo.controllers.v1;

import kg.java.todo.core.contracts.facades.TaskFacade;
import kg.java.todo.core.exceptions.EntityDuplicateException;
import kg.java.todo.core.exceptions.EntityNotFoundException;
import kg.java.todo.core.models.dtos.task.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/task")
@RestController
public class TaskController {
    private final TaskFacade taskFacade;

    public TaskController(TaskFacade taskFacade) {
        this.taskFacade = taskFacade;
    }
    @PostMapping("/add")
    public ResponseEntity<TaskDto> add(@RequestBody CreateTaskDto model) {
        try {
            return ResponseEntity.ok(taskFacade.add(model));
        }
        catch (EntityDuplicateException | EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/update")
    public ResponseEntity<TaskDto> add(@RequestBody UpdateTaskDto model) {
        try {
            return ResponseEntity.ok(taskFacade.update(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> add(@RequestBody DeleteTaskDto model) {
        try {
            return ResponseEntity.ok(taskFacade.delete(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/id")
    public ResponseEntity<TaskDto> add(@RequestBody FindByIdTaskDto model) {
        try {
            return ResponseEntity.ok(taskFacade.findById(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
