package kg.java.todo.core.models.dtos.user;

import kg.java.todo.core.models.dtos.category.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;


}
