package kg.java.todo.core.contracts.facades;

import kg.java.todo.core.exceptions.EntityDuplicateException;
import kg.java.todo.core.exceptions.EntityNotFoundException;
import kg.java.todo.core.models.dtos.*;
import org.springframework.http.HttpStatus;

public interface UserFacade {
    UserDto register(CreateUserDto model) throws EntityDuplicateException;
    UserDto update(UpdateUserDto model) throws EntityNotFoundException;
    HttpStatus delete(DeleteUserDto model) throws EntityNotFoundException;
    UserDto findById(FindByIdUserDto model) throws EntityNotFoundException;
}
