package Dataamatorene.Exceptions;

public class InvalidPasswordException extends IllegalArgumentException {
    public InvalidPasswordException(String msg){
        super(msg);
    }
}
