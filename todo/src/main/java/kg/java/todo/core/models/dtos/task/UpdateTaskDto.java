package kg.java.todo.core.models.dtos.task;

import kg.java.todo.core.models.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateTaskDto extends BaseDto {
    private String name;
    private String status;
    private Long categoryId;
    private Long priorityId;
    private Long userId;
}
