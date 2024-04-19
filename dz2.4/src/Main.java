import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.Objects;

public class Main {
    static boolean loginValidation = true;
    static boolean passwordValidation = true;
    static boolean confirmValidation = true;

    public static void main(String[] args) {
        String login = "serge_1971_ch";
        String password = "3j_georg12_33";
        String confirmPassword = "3j_georg12_33";
        try {
            getAuthorization(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        } finally {
            if (loginValidation && passwordValidation && confirmValidation) {
                System.out.println("Валидация прошла успешно");
            } else if (!loginValidation) {
                System.out.println("Валидация не пройдена, устраните ошибки в логине");
            } else if (!passwordValidation) {
                System.out.println("Валидация не пройдена, устраните ошибки в пароле");
            } else {
                System.out.println("Валидация не пройдена, устраните ошибки в идентичности паролей");
            }
        }
    }

    private static void getAuthorization(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        boolean testLogin = login.matches("^[\\w+]+$");
        boolean testPassword = password.matches("^[\\w+]+$");

        if (!testLogin || login.length() >= 20) {
            loginValidation = false;
        } else {
            loginValidation = true;
        }

        if (!testPassword || password.length() >= 20) {
            passwordValidation = false;
        } else {
            passwordValidation = true;
        }

        if (!Objects.equals(password, confirmPassword)) {
            confirmValidation = false;
        } else {
            confirmValidation = true;
        }

        if (!loginValidation && passwordValidation && confirmValidation) {
            throw new WrongLoginException("Логин должен содержать только латинские буквы, " +
                    "цифры и знак подчеркивания и длина символов должен равен или меньше 20 символов");
        } else if (loginValidation && !passwordValidation && confirmValidation) {
            throw new WrongPasswordException("Пароль должен содержать только латинские буквы, " +
                    "цифры и знак подчеркивания и длина символов должен равен или меньше 20 символов");
        } else if (loginValidation && passwordValidation && !confirmValidation) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}