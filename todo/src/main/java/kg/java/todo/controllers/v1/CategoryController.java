package kg.java.todo.controllers.v1;

import kg.java.todo.core.contracts.facades.CategoryFacade;
import kg.java.todo.core.contracts.facades.UserFacade;
import kg.java.todo.core.exceptions.EntityDuplicateException;
import kg.java.todo.core.exceptions.EntityNotFoundException;
import kg.java.todo.core.models.dtos.category.*;
import kg.java.todo.core.models.dtos.user.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryFacade categoryFacade;

    public CategoryController(CategoryFacade categoryFacade) {
        this.categoryFacade = categoryFacade;
    }

    @PostMapping("/add")
    public ResponseEntity<CategoryDto> add(@RequestBody CreateCategoryDto model){
        try {
            return ResponseEntity.ok(categoryFacade.register(model));
        }catch (EntityDuplicateException e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping("/update")
    public ResponseEntity<CategoryDto> update(@RequestBody UpdateCategoryDto model){
        try {
            return ResponseEntity.ok(categoryFacade.update(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody DeleteCategoryDto model){
        try {
            return ResponseEntity.ok(categoryFacade.delete(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/id")
    public ResponseEntity<CategoryDto> findById(@RequestBody FindByIdCategoryDto model){
        try {
            return ResponseEntity.ok(categoryFacade.findById(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
