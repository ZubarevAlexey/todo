package kg.java.todo.core.mappers.base;

import kg.java.todo.core.mappers.CategoryMapper;
import kg.java.todo.core.mappers.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappersConfig {
    @Bean
    public UserMapper buildUserMapper() {
        return new UserMapper();
    }

    @Bean
    public CategoryMapper buildCategoryMapper() {
        return new CategoryMapper();
    }
}
