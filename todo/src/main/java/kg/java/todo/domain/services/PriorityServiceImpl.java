package kg.java.todo.domain.services;

import jakarta.transaction.Transactional;
import kg.java.todo.core.contracts.services.PriorityService;
import kg.java.todo.core.exceptions.EntityDuplicateException;
import kg.java.todo.core.exceptions.EntityNotFoundException;
import kg.java.todo.core.mappers.PriorityMapper;
import kg.java.todo.core.models.dtos.priority.*;
import kg.java.todo.data.PriorityRepository;
import kg.java.todo.data.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PriorityServiceImpl implements PriorityService {
    private final PriorityRepository priorityRepository;
    private final PriorityMapper priorityMapper;
    private final UserRepository userRepository;

    public PriorityServiceImpl(PriorityRepository priorityRepository,
                               PriorityMapper priorityMapper, UserRepository userRepository) {
        this.priorityRepository = priorityRepository;
        this.priorityMapper = priorityMapper;
        this.userRepository = userRepository;
    }

    @Override
    public PriorityDto add(CreatePriorityDto model) throws EntityDuplicateException, EntityNotFoundException {
        var user = userRepository.findById(model.getUserId()).orElseThrow(EntityNotFoundException::new);
        var priority = priorityRepository.findPriorityEntityByName(model.getName());
        if (priority.isPresent()) throw new EntityDuplicateException();
        var entity = priorityMapper.fromDomain(model);
        entity.setUser(user);
        priorityRepository.save(entity);
        return priorityMapper.toDomain(entity);
    }

    @Override
    public PriorityDto update(UpdatePriorityDto model) throws EntityNotFoundException {
        var user = userRepository.findById(model.getUserId()).orElseThrow(EntityNotFoundException::new);
        var priority = priorityRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = priority.builder()
                .id(model.getId())
                .name(model.getName())
                .color(model.getColor())
                .user(user)
                .build();
        priorityRepository.save(entity);
        return priorityMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeletePriorityDto model) throws EntityNotFoundException {
        var priority = priorityRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        priorityRepository.delete(priority);
        return HttpStatus.OK;
    }

    @Override
    public PriorityDto findById(FindByIdPriorityDto model) throws EntityNotFoundException {
        var priority = priorityRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return priorityMapper.toDomain(priority);
    }

    @Override
    public List<PriorityDto> findByUserName(FindPriorityByUserNameDto model) {
        var entities = priorityRepository.findPriorityEntitiesByUserName(model.getUserName());
        return entities.stream().map(priorityMapper::toDomain).toList();
    }
}
