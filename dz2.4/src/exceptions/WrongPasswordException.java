package exceptions;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(String message) {
        super(message);
    }

    public String confirmPasswordValidation() {
        return "parols don't the same";
    }
}
