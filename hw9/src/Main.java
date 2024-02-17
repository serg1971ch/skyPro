import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача №1\n");
/*
Задача 1
Бухгалтеры попросили посчитать сумму всех выплат за месяц.
Напишите программу, которая решит эту задачу, и выведите в консоль результат в формате:
«Сумма трат за месяц составила … рублей».
 */
        task1();
        System.out.println();
        System.out.println("Задача №2\n");
/*
Задача 2
Также бухгалтерия попросила найти минимальную и максимальную трату за день.
Напишите программу, которая решит эту задачу, и выведите в консоль результат в формате:
«Минимальная сумма трат за день составила … рублей. Максимальная сумма трат за день составила … рублей».
*/
        task2();
        System.out.println(" ");
/*
Задача № 3
Теперь бухгалтерия хочет понять, какую в среднем сумму компания тратила в течение 30 дней.
Напишите программу, которая посчитает среднее значение трат за месяц (то есть сумму всех трат за месяц поделить
на количество дней), и выведите в консоль результат в формате: «Средняя сумма трат за месяц составила … рублей».
Важно помнить: подсчет среднего значения может иметь остаток, то есть быть не целым, а дробным числом.
*/
        System.out.println("Задача №3\n");
        task3();
        System.out.println();
/*
Задача № 4
В бухгалтерской книге появился баг. Что-то пошло не так: фамилии и имена сотрудников начали отображаться в обратную сторону.
Т. е. вместо «Иванов Иван» мы имеем «навИ вонавИ». Данные с именами сотрудников хранятся в виде массива символов char[]
Напишите код, который в случае такого бага будет выводить фамилии и имена сотрудников в корректном виде.
В качестве данных для массива используйте: char[] reverseFullName = { 'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
В результате в консоль должно быть выведено: Ivanov Ivan.
Важно: не используйте дополнительные массивы для решения этой задачи. Необходимо корректно пройти по массиву циклом и распечатать его элементы в правильном порядке.
*/
        System.out.println("Задача №4\n");
        task4();
    }

    public static int[] generateRandomArray() {
        Random random = new Random();
        int[] arr = new int[30];
        for (
                int i = 0;
                i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    public static void task1() {
        int[] arr = generateRandomArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Сумма трат за месяц составила %d рублей\n", arr[i]);
        }
    }

    public static void task2() {
        int[] arr = generateRandomArray();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Обмен элементов
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.printf("Минимальная сумма трат за день составила %d рублей\n", arr[0]);
        System.out.printf("Максимальная сумма трат за день составила %d рублей\n", arr[29]);
    }

    public static void task3() {
        int[] arr = generateRandomArray();
        int sum = 0;
        int total = 30;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double avg = (double) sum / total;
        System.out.printf("Средняя сумма трат за месяц составила %.2f рублей\n", avg);
    }

    private static void task4() {
        char[] reverseFullName = { 'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};

        // Создаем новый массив для хранения исправленного имени и фамилии
        char[] fullName = new char[reverseFullName.length];

        // Используем цикл для переворачивания имени и фамилии
        for (int i = 0; i < reverseFullName.length; i++) {
            fullName[i] = reverseFullName[reverseFullName.length - 1 - i];
        }

        // Преобразуем массив символов в строку
        String fullNameString = new String(fullName);

        // Разделяем имя и фамилию по пробелу
        String[] nameParts = fullNameString.split(" ");

        // Выводим имя и фамилию в правильном порядке
        System.out.println(nameParts[1] + " " + nameParts[0]);
    }
}