package kg.java.todo.core.models.dtos.priority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindPriorityByUserNameDto {
    private String userName;
}
