package Exception;

public class myException extends Exception{
    String message;

    public myException(String errorMessage) {
        this.message = errorMessage;
    }
    public String getMessage() {
        return message;
    }
}
