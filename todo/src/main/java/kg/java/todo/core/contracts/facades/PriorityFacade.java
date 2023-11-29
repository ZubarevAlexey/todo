package kg.java.todo.core.contracts.facades;

import kg.java.todo.core.exceptions.EntityDuplicateException;
import kg.java.todo.core.exceptions.EntityNotFoundException;
import kg.java.todo.core.models.dtos.priority.*;
import org.springframework.http.HttpStatus;

public interface PriorityFacade {
    PriorityDto add(CreatePriorityDto model) throws EntityDuplicateException, EntityNotFoundException;
    PriorityDto update(UpdatePriorityDto model) throws EntityNotFoundException;
    HttpStatus delete(DeletePriorityDto model) throws EntityNotFoundException;
    PriorityDto findById(FindByIdPriorityDto model) throws EntityNotFoundException;
}
