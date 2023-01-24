package logic.exceptions;

public class NotExistentUserException extends Exception{
    public NotExistentUserException(String message){
        super(message);
    }
}
