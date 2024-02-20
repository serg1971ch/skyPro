import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Задача № 1\n");
        String firstName = "Ivan";
        String middleName = "Ivanovich";
        String lastName = "Ivanov";
        System.out.printf("Ф. И. О. сотрудника - %s %s %s", lastName, firstName, middleName);

        System.out.println();
        System.out.println("Задача № 2\n");
        String fullName = lastName + " " + firstName + " " + middleName;
        System.out.println("Данные Ф. И. О. сотрудника для заполнения отчета — " + fullName.toUpperCase());
/*
Система, в которой мы работаем, не принимает символ «ё». Напишите программу, которая заменяет символ «ё» на символ «е».
В качестве исходных данных используйте строку fullName и данные в ней — «Иванов Семён Семёнович».
 Результат программы выведите в консоль в формате: «Данные Ф. И. О. сотрудника для заполнения отчета — …».
*/
        System.out.println();
        System.out.println("Задача № 3\n");
        String name = "Иванов Семён Семёнович";

        String replacedName = name.replace('ё', 'e');
        System.out.println("Данные Ф. И. О. сотрудника — "+ replacedName);
    }
}