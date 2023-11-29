package kg.java.todo.controllers.v1;

import kg.java.todo.core.contracts.facades.UserFacade;
import kg.java.todo.core.exceptions.EntityDuplicateException;
import kg.java.todo.core.exceptions.EntityNotFoundException;
import kg.java.todo.core.models.dtos.user.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }
    @PostMapping("/signup")
    public ResponseEntity<UserDto> register(@RequestBody CreateUserDto model){
        try {
            return ResponseEntity.ok(userFacade.register(model));
        }catch (EntityDuplicateException e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping("/update")
    public ResponseEntity<UserDto> update(@RequestBody UpdateUserDto model){
        try {
            return ResponseEntity.ok(userFacade.update(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody DeleteUserDto model){
        try {
            return ResponseEntity.ok(userFacade.delete(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/id")
    public ResponseEntity<UserDto> findById(@RequestBody FindByIdUserDto model){
        try {
            return ResponseEntity.ok(userFacade.findById(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
