package kg.java.todo.core.mappers;

import kg.java.todo.core.models.dtos.category.CategoryDto;
import kg.java.todo.core.models.dtos.priority.PriorityDto;
import kg.java.todo.core.models.dtos.task.CreateTaskDto;
import kg.java.todo.core.models.dtos.task.TaskDto;
import kg.java.todo.core.models.dtos.task.UpdateTaskDto;
import kg.java.todo.core.models.dtos.user.UserDto;
import kg.java.todo.core.models.entities.TaskEntity;
import kg.java.todo.core.models.entities.UserEntity;

public class TaskMapper {
    public TaskDto toDomain(TaskEntity model){
        var category = model.getCategory();
        var priority = model.getPriority();
        var user = model.getUser();
        return TaskDto.builder()
                .id(model.getId())
                .name(model.getName())
                .status(model.getStatus())
                .category(CategoryDto.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .build())
                .priority(PriorityDto.builder()
                        .id(priority.getId())
                        .name(priority.getName())
                        .color(priority.getColor())
                        .build())
                .user(UserDto.builder()
                        .id(user.getId())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .phoneNumber(user.getPhoneNumber())
                        .build())
                .build();
    }
    public TaskEntity fromDomain(CreateTaskDto model) {
        return TaskEntity.builder()
                .name(model.getName())
                .status(model.getStatus())
                .build();
    }
    public TaskEntity fromDomain(UpdateTaskDto model) {
        return TaskEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .status(model.getStatus())
                .build();
    }
}
