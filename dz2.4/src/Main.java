import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        String login = "serg_1971_ch";
        String password = "3j_georg12_33";
        String confirmPassword = "3j_georg12_33";

        try {
            AuthService.getAuthorization(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}