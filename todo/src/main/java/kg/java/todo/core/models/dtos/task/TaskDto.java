package kg.java.todo.core.models.dtos.task;

import kg.java.todo.core.models.dtos.category.CategoryDto;
import kg.java.todo.core.models.dtos.priority.PriorityDto;
import kg.java.todo.core.models.dtos.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto {
    private Long id;
    private String name;
    private String status;
    private CategoryDto category;
    private PriorityDto priorityDto;
    private UserDto user;
}
