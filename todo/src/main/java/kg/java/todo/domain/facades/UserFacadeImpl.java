package kg.java.todo.domain.facades;

import jakarta.transaction.Transactional;
import kg.java.todo.core.contracts.facades.UserFacade;
import kg.java.todo.core.contracts.services.UserService;
import kg.java.todo.core.exceptions.EntityDuplicateException;
import kg.java.todo.core.exceptions.EntityNotFoundException;
import kg.java.todo.core.models.dtos.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserFacadeImpl implements UserFacade {
    private final UserService userService;

    public UserFacadeImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDto register(CreateUserDto model) throws EntityDuplicateException {
        return userService.register(model);
    }

    @Override
    public UserDto update(UpdateUserDto model) throws EntityNotFoundException {
        return userService.update(model);
    }
    @Override
    public HttpStatus delete(DeleteUserDto model) throws EntityNotFoundException {
        return userService.delete(model);
    }

    @Override
    public UserDto findById(FindByIdUserDto model) throws EntityNotFoundException {
        return userService.findById(model);
    }
}
