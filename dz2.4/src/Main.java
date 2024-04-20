import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        try {
            getAuthorization("serg_1971_ch?+++", "3j_georg12_33", "3j_georg12_33");
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        }catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("validation is done!");
        }
    }

    private static void getAuthorization(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        boolean test = login.matches("^[\\w]+$");
        if (test && login.length() >= 20) {
            throw new WrongLoginException("Логин должен содержать только латинские буквы, " +
                    "цифры и знак подчеркивания и длина символов должен равен или меньше 20 символов");

        }
        if (test && password.length() >= 20) {
            throw new WrongPasswordException("Пароль должен содержать только латинские буквы, " +
                    "цифры и знак подчеркивания и длина символов должен равен или меньше 20 символов");
        }

        if (password.length() != confirmPassword.length()) {
            throw new WrongLoginException("Пароли не совпадают");
        }
    }
}