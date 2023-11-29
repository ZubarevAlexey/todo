package kg.java.todo.controllers.v1;


import kg.java.todo.core.contracts.facades.PriorityFacade;
import kg.java.todo.core.exceptions.EntityDuplicateException;
import kg.java.todo.core.exceptions.EntityNotFoundException;
import kg.java.todo.core.models.dtos.priority.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/priority")
public class PriorityController {
    private final PriorityFacade priorityFacade;

    public PriorityController(PriorityFacade priorityFacade) {
        this.priorityFacade = priorityFacade;
    }

    @PostMapping("/add")
    public ResponseEntity<PriorityDto> add(@RequestBody CreatePriorityDto model){
        try {
            return ResponseEntity.ok(priorityFacade.add(model));
        }catch (EntityDuplicateException e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping("/update")
    public ResponseEntity<PriorityDto> update(@RequestBody UpdatePriorityDto model){
        try {
            return ResponseEntity.ok(priorityFacade.update(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody DeletePriorityDto model){
        try {
            return ResponseEntity.ok(priorityFacade.delete(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/id")
    public ResponseEntity<PriorityDto> findById(@RequestBody FindByIdPriorityDto model){
        try {
            return ResponseEntity.ok(priorityFacade.findById(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}
