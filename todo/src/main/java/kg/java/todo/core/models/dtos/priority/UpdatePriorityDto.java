package kg.java.todo.core.models.dtos.priority;

import kg.java.todo.core.models.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatePriorityDto extends BaseDto {
    private String name;
    private String color;
    private Long userId;
}
