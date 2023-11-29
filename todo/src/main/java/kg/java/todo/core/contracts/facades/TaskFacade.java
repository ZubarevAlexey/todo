package kg.java.todo.core.contracts.facades;

import kg.java.todo.core.exceptions.EntityDuplicateException;
import kg.java.todo.core.exceptions.EntityNotFoundException;
import kg.java.todo.core.models.dtos.task.*;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface TaskFacade {
    TaskDto add(CreateTaskDto model) throws EntityDuplicateException, EntityNotFoundException;
    TaskDto update(UpdateTaskDto model) throws EntityNotFoundException;
    HttpStatus delete(DeleteTaskDto model) throws EntityNotFoundException;
    TaskDto findById(FindByIdTaskDto model) throws EntityNotFoundException;
    List<TaskDto> findTasksByUSerName(FindTaskByUserNameDto model) throws EntityNotFoundException;
}
