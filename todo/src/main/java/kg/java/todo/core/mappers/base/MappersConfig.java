package kg.java.todo.core.mappers.base;

import kg.java.todo.core.mappers.CategoryMapper;
import kg.java.todo.core.mappers.PriorityMapper;
import kg.java.todo.core.mappers.TaskMapper;
import kg.java.todo.core.mappers.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappersConfig {
    @Bean
    public UserMapper buildUserMapper(CategoryMapper categoryMapper,PriorityMapper priorityMapper,TaskMapper taskMapper) {
        return new UserMapper(categoryMapper,priorityMapper,taskMapper);
    }

    @Bean
    public CategoryMapper buildCategoryMapper() {
        return new CategoryMapper();
    }

    @Bean
    public PriorityMapper buildPriorityMapper() {
        return new PriorityMapper();
    }
    @Bean
    public TaskMapper buildTaskMapper() {
        return new TaskMapper();
    }
}
