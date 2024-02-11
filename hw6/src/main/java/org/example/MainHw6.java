package org.example;

public class MainHw6 {
    public static void main(String[] args) {
 /*
 Задача 1
С помощью цикла for выведите в консоль все числа от 1 до 10.
 */
        for (int i = 1; i < 11; i++) {
            System.out.printf(" %d", i);
        }
        System.out.println(" ");
 /*
 Задача 2
С помощью цикла for выведите в консоль все числа от 10 до 1.
 */
        for (int i = 10; i > 0; i--) {
            System.out.printf(" %d", i);
        }
        System.out.println();
 /*
 Задача 3
Выведите в консоль все четные числа от 0 до 17.
 */
        for (int i = 0; i < 17; i++) {
            if (i % 2 == 0) {
                System.out.printf(" %d", i);
            }
        }
        System.out.println();
 /*
 Задача 4
Выведите в консоль все числа от 10 до −10 от бо́льшего числа к меньшему.
 */
        for (int i = 10; i >= -10; i--) {
            System.out.printf(" %d", i);
        }
        System.out.println();
 /*
 Задача 5
Напишите программу, которая выводит в консоль все високосные года, начиная с 1904 года до 2096.
В консоль результат должен выводиться в формате: «… год является високосным».
 */
        for (int i = 1904; i <= 2096; i++) {
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                System.out.println(i + " год является високосным");
            }
        }
 /*
 Задача 6
Напишите программу, которая выводит в консоль последовательность чисел:
7 14 21 28 35 42 49 56 63 70 77 84 91 98
 */
        for (int i = 7; i < 99; i++) {
            if (i % 7 == 0)
                System.out.printf(" " + "%d", i);
        }
 /*
 Задача 7
Напишите программу, которая выводит в консоль последовательность чисел:
1 2 4 8 16 32 64 128 256 512
 */
        System.out.println();
        for (int i = 1; i <= 512; i *= 2) {
            System.out.printf(" " + "%d", i);
        }
        System.out.println();
 /*
 Задача 8
Посчитайте с помощью цикла for сумму годовых накоплений, если каждый месяц вы будете откладывать по 29 000 рублей «в банку».
Выведите сумму накоплений за каждый месяц в консоль в формате: «Месяц …, сумма накоплений равна … рублей».
 */
        int monthlySavings = 29000;
        int totalSavings = 0;
        System.out.println("Накопление в 'банку'");
        for (int month = 1; month <= 12; month++) {
            totalSavings += monthlySavings;
            System.out.println("Месяц " + month + ", сумма накоплений равна " + totalSavings + " рублей");
        }
 /*
 Задача 9
Перепишите решение задачи выше при условии, что деньги вы откладывать будете не «в банку», а в банк под проценты — 12% годовых.
 Выведите сумму накоплений за каждый месяц в консоль в формате: «Месяц …, сумма накоплений равна … рублей».
 */
        System.out.println("Накопление с процентами");
        monthlySavings = 29000;
        totalSavings = 0;
        double monthlyPersent = 0.01;
        for (int month = 1; month <= 12; month++) {
            totalSavings += monthlySavings + monthlySavings*monthlyPersent;
            System.out.println("Месяц " + month + ", сумма накоплений равна " + totalSavings + " рублей");
        }
  /*
 Задача 10
Напишите программу, которая выводит в консоль таблицу умножения на 2:
 */
        int number = 2;
        int limit = 10;
        System.out.println("Таблица умножения");
        for (int i = 1; i <= limit; i++) {
            int result = number * i;
            System.out.println(number + " * " + i + " = " + result);
        }
    }
}
