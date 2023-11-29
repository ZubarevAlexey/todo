package kg.java.todo.core.models.dtos.category;

import kg.java.todo.core.models.dtos.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCategoryDto {
    private String name;
    private Long userId;
}
