package kg.java.todo.core.mappers;

import kg.java.todo.core.models.dtos.user.CreateUserDto;
import kg.java.todo.core.models.dtos.user.UpdateUserDto;
import kg.java.todo.core.models.dtos.user.UserDto;
import kg.java.todo.core.models.entities.UserEntity;

import java.util.stream.Collectors;

public class UserMapper {
    private CategoryMapper categoryMapper;
    private PriorityMapper priorityMapper;

    public UserMapper(CategoryMapper categoryMapper, PriorityMapper priorityMapper) {
        this.categoryMapper = categoryMapper;
        this.priorityMapper = priorityMapper;
    }

    public UserMapper() {
    }

    public UserDto toDomain(UserEntity model){
        return UserDto.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .phoneNumber(model.getPhoneNumber())
                .build();
    }
    public UserDto toDomainCat(UserEntity model){
        var categories = model.getCategories().stream()
                .map(categoryMapper::toDomain)
                .toList();
        var priorities = model.getPriorities().stream()
                .map(priorityMapper::toDomain)
                .toList();
        return UserDto.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .phoneNumber(model.getPhoneNumber())
                .categories(categories)
                .priorities(priorities)
                .build();
    }
    public UserEntity fromDomain(CreateUserDto model){
        return UserEntity.builder()
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .phoneNumber(model.getPhoneNumber())
                .build();
    }
    public UserEntity fromDomain(UpdateUserDto model){
        return UserEntity.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .phoneNumber(model.getPhoneNumber())
                .build();
    }
}
