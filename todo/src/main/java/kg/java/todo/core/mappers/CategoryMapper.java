package kg.java.todo.core.mappers;

import kg.java.todo.core.models.dtos.category.CategoryDto;
import kg.java.todo.core.models.dtos.category.CreateCategoryDto;
import kg.java.todo.core.models.dtos.category.UpdateCategoryDto;
import kg.java.todo.core.models.dtos.user.UserDto;
import kg.java.todo.core.models.entities.CategoryEntity;
import kg.java.todo.core.models.entities.UserEntity;

public class CategoryMapper {
    public CategoryDto toDomain(CategoryEntity model){
        var user = model.getUser();
        return CategoryDto.builder()
                .id(model.getId())
                .name(model.getName())
                .user(UserDto.builder()
                        .id(user.getId())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .phoneNumber(user.getPhoneNumber())
                        .build())
                .build();
    }
    public CategoryEntity fromDomain(CreateCategoryDto model){
        return CategoryEntity.builder()
                .name(model.getName())
                .build();
    }
    public CategoryEntity fromDomain(UpdateCategoryDto model){
        return CategoryEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }
}
