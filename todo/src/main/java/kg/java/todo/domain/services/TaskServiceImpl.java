package kg.java.todo.domain.services;

import jakarta.transaction.Transactional;
import kg.java.todo.core.contracts.services.TaskService;
import kg.java.todo.core.exceptions.EntityDuplicateException;
import kg.java.todo.core.exceptions.EntityNotFoundException;
import kg.java.todo.core.mappers.TaskMapper;
import kg.java.todo.core.models.dtos.task.*;
import kg.java.todo.data.CategoryRepository;
import kg.java.todo.data.PriorityRepository;
import kg.java.todo.data.TaskRepository;
import kg.java.todo.data.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final PriorityRepository priorityRepository;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper, UserRepository userRepository,
                           CategoryRepository categoryRepository, PriorityRepository priorityRepository) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.priorityRepository = priorityRepository;
    }

    @Override
    public TaskDto add(CreateTaskDto model) throws EntityDuplicateException, EntityNotFoundException {
        var user = userRepository.findById(model.getUserId()).orElseThrow(EntityNotFoundException::new);
        var category = categoryRepository.findById(model.getCategoryId()).orElseThrow(EntityNotFoundException::new);
        var priority = priorityRepository.findById(model.getPriorityId()).orElseThrow(EntityNotFoundException::new);
        var task = taskRepository.findTaskEntityByName(model.getName());
        if (task.isPresent()) throw new EntityDuplicateException();
        var entity = taskMapper.fromDomain(model);
        entity.setCategory(category);
        entity.setPriority(priority);
        entity.setUser(user);
        taskRepository.save(entity);
        return taskMapper.toDomain(entity);
    }

    @Override
    public TaskDto update(UpdateTaskDto model) throws EntityNotFoundException {
        var user = userRepository.findById(model.getUserId()).orElseThrow(EntityNotFoundException::new);
        var category = categoryRepository.findById(model.getCategoryId()).orElseThrow(EntityNotFoundException::new);
        var priority = priorityRepository.findById(model.getPriorityId()).orElseThrow(EntityNotFoundException::new);
        var task = taskRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = task.builder()
                .id(model.getId())
                .name(model.getName())
                .status(model.getStatus())
                .category(category)
                .priority(priority)
                .user(user)
                .build();
        taskRepository.save(entity);
        return taskMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteTaskDto model) throws EntityNotFoundException {
        var task = taskRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        taskRepository.delete(task);
        return HttpStatus.OK;
    }

    @Override
    public TaskDto findById(FindByIdTaskDto model) throws EntityNotFoundException {
        var task = taskRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return taskMapper.toDomain(task);
    }
}
