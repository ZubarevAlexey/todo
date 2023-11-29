package kg.java.todo.core.mappers;

import kg.java.todo.core.models.dtos.CreateUserDto;
import kg.java.todo.core.models.dtos.UpdateUserDto;
import kg.java.todo.core.models.dtos.UserDto;
import kg.java.todo.core.models.entities.UserEntity;

public class UserMapper {
    public UserDto toDomain(UserEntity model){
        return UserDto.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .phoneNumber(model.getPhoneNumber())
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
