package kg.java.todo.core.models.dtos.user;

import kg.java.todo.core.models.dtos.category.CategoryDto;
import kg.java.todo.core.models.dtos.priority.PriorityDto;
import kg.java.todo.core.models.dtos.task.TaskDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    List<CategoryDto> categories;
    List<PriorityDto> priorities;
    List<TaskDto> tasks;


}
