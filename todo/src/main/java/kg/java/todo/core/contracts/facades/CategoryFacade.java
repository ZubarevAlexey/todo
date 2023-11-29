package kg.java.todo.core.contracts.facades;

import kg.java.todo.core.exceptions.EntityDuplicateException;
import kg.java.todo.core.exceptions.EntityNotFoundException;
import kg.java.todo.core.models.dtos.category.*;
import org.springframework.http.HttpStatus;

public interface CategoryFacade {
    CategoryDto register(CreateCategoryDto model) throws EntityDuplicateException, EntityNotFoundException;
    CategoryDto update(UpdateCategoryDto model) throws EntityNotFoundException;
    HttpStatus delete(DeleteCategoryDto model) throws EntityNotFoundException;
    CategoryDto findById(FindByIdCategoryDto model) throws EntityNotFoundException;
}
