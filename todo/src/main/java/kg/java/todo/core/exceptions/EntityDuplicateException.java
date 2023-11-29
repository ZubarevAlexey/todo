package kg.java.todo.core.exceptions;

public class EntityDuplicateException extends Exception{
    public EntityDuplicateException(){
        super("entity exist");
    }
}
