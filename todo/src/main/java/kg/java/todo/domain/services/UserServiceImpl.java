package kg.java.todo.domain.services;

import jakarta.transaction.Transactional;
import kg.java.todo.core.contracts.services.UserService;
import kg.java.todo.core.exceptions.EntityDuplicateException;
import kg.java.todo.core.exceptions.EntityNotFoundException;
import kg.java.todo.core.mappers.UserMapper;
import kg.java.todo.core.models.dtos.*;
import kg.java.todo.data.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto register(CreateUserDto model) throws EntityDuplicateException {
        var user = userRepository.findUserEntityByFirstName(model.getFirstName());
        if (user.isPresent()) throw new EntityDuplicateException();
        var entity = userMapper.fromDomain(model);
        userRepository.save(entity);
        return userMapper.toDomain(entity);
    }

    @Override
    public UserDto update(UpdateUserDto model) throws EntityNotFoundException {
        var user = userRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = user.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .phoneNumber(model.getPhoneNumber())
                .build();
        userRepository.save(entity);
        return userMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteUserDto model) throws EntityNotFoundException {
        var user = userRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        userRepository.delete(user);
        return HttpStatus.OK;
    }

    @Override
    public UserDto findById(FindByIdUserDto model) throws EntityNotFoundException {
        var user = userRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return userMapper.toDomain(user);
    }
}
