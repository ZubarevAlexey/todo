package kg.java.todo.domain.facades;

import kg.java.todo.core.contracts.facades.TaskFacade;
import kg.java.todo.core.contracts.services.TaskService;
import kg.java.todo.core.exceptions.EntityDuplicateException;
import kg.java.todo.core.exceptions.EntityNotFoundException;
import kg.java.todo.core.models.dtos.task.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskFacadeImpl implements TaskFacade {
    private final TaskService taskService;

    public TaskFacadeImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public TaskDto add(CreateTaskDto model) throws EntityDuplicateException, EntityNotFoundException {
        return taskService.add(model);
    }

    @Override
    public TaskDto update(UpdateTaskDto model) throws EntityNotFoundException {
        return taskService.update(model);
    }

    @Override
    public HttpStatus delete(DeleteTaskDto model) throws EntityNotFoundException {
        return taskService.delete(model);
    }

    @Override
    public TaskDto findById(FindByIdTaskDto model) throws EntityNotFoundException {
        return taskService.findById(model);
    }

    @Override
    public List<TaskDto> findTasksByUSerName(FindTaskByUserNameDto model) throws EntityNotFoundException {
        return taskService.findTasksByUSerName(model);
    }
}
