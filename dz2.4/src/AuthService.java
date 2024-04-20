import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class AuthService {

    public static void getAuthorization(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        boolean testLogin = login.matches("^\\w{1,20}$");
        boolean testParol = password.matches("^\\w{1,20}$");
        if (login.equals(" ")) {
            System.out.println("Login пустой");
        } else if (!testLogin) {
            throw new WrongLoginException("Логин должен содержать только латинские буквы, " +
                    "цифры и знак подчеркивания и длина символов должен равен или меньше 20 символов");

        }

        if (password.equals(" ")) {
            System.out.println("Login пустой");
        } else if (!testParol) {
            throw new WrongPasswordException("Пароль должен содержать только латинские буквы, " +
                    "цифры и знак подчеркивания и длина символов должен равен или меньше 20 символов");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}
