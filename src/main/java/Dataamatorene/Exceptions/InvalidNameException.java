package Dataamatorene.Exceptions;

public class InvalidNameException extends IllegalArgumentException{
    public InvalidNameException(String msg){
        super(msg);
    }
}
