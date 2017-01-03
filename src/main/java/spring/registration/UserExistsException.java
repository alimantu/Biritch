package spring.registration;

public class UserExistsException extends Exception {

    private String message;

    public UserExistsException() {}

    public UserExistsException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
