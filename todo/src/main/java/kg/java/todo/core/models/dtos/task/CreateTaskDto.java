package kg.java.todo.core.models.dtos.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTaskDto {
    private String name;
    private String status;
    private Long categoryId;
    private Long priorityId;
    private Long userId;
}
