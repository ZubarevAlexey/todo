package kg.java.todo.core.models.dtos;

import kg.java.todo.core.models.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserDto extends BaseDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;

}
