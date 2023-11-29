package kg.java.todo.core.exceptions;

public class EntityNotFoundException extends Exception{
    public EntityNotFoundException(){
        super("entity not found");
    }
}
