package org.example;

public class Main {
    public static void main(String[] args) {
//   Задача 1.
        var dog = 8.0;
        var cat = 3.6;
        var paper = 763789;

        System.out.println(dog);
        System.out.println(cat);
        System.out.println(paper);
/*   Задача 2. Увеличьте значение каждой
перечисленной в прошлой задаче переменной на 4.
Для решения этой задачи используйте тип переменной var.
 */
        dog += 4;
        cat += 4;
        paper += 4;
        System.out.println();
//ыведите в консоль новые значения переменных.
        System.out.println(dog);
        System.out.println(cat);
        System.out.println(paper);
        System.out.println();
//   Задача 3. Теперь нужно уменьшить значение каждой переменной:
        dog -= 3.5;
        cat -= 1.6;
        paper -= 7639;
        System.out.println();
/*   Задача 4.
Инициализируйте (присвойте значение) переменную friend значением 19.
Увеличьте значение переменной на 2, после чего поделите значение на 7.
После каждой операции выводите значение переменной в консоль. В итоге у вас должно быть выведено 3 значения одной переменной.
Для решения этой задачи используйте тип переменной var.
 */
        var friend = 19;
        System.out.println(friend);
        friend += 2;
        System.out.println(friend);
        friend -= 7;
        System.out.println(friend);
        System.out.println();
/*   Задача 5.
Инициализируйте переменную frog значением 3.5.
Увеличьте переменную в 10 раз и поделите на 3.5. Добавьте к последнему значению переменной 4.
После каждой операции выводите значение переменной в консоль. В итоге у вас должно быть выведено 4 значения одной переменной.
Для решения этой задачи используйте тип переменной var.
 */
        var frog = 3.5;
        System.out.println(frog);
        frog *= 10;
        System.out.println(frog);
        frog /= 3.5;
        System.out.println(frog);
        frog += 4;
        System.out.println(frog);
        System.out.println();
/*   Задача 6.
В боксе перед каждым боем спортсменов взвешивают. Это делают для того, чтобы убедиться, что боксеры соответствуют
своей весовой категории и бой будет честным.
Масса одного боксера — 78.2 кг.
Масса второго боксера — 82.7 кг.
Подсчитайте и выведите в консоль общую массу двух бойцов.
Подсчитайте и выведите в консоль разницу между массами бойцов.
Для решения этой задачи используйте тип переменной var.
 */
        var firstBoxer = 78.2;
        var secondBoxer = 82.7;
        System.out.println("Oбщая масса двух бойцов: " + (firstBoxer + secondBoxer) + " кг");
        System.out.println("Разница мужду массами двух бойцов: "  + (secondBoxer - firstBoxer) + " кг");
        System.out.println();
/*   Задача 7.
Вычислите разницу масс спортсменов, используйте 2 способа:
 Вычитание из большей массы меньшей.
 С помощью функции остаток от деления.
Для решения этой задачи используйте тип переменной var.
 */
        System.out.println("Первый способ решения задачи №7.");
        System.out.println("Разница мужду массами двух бойцов: "  + (secondBoxer - firstBoxer) + " кг");
        System.out.println("Второй способ решения задачи №7.");
        System.out.println("Разница мужду массами двух бойцов: "  + (secondBoxer%firstBoxer) + " кг");
        System.out.println();
        /*   Задача 8.
    Решите задачу с помощью функций сложения, вычитания, умножения и деления.

            640 часов работы поделено между сотрудниками.
            Если каждый сотрудник посвящает работе 8 часов, то сколько всего работников в компании?
            Выведите результат задачи в консоль в формате: «Всего работников в компании — … человек».
    Посчитайте, сколько часов работы должно быть поделено между сотрудниками, если в компании работает на 94 человека больше.
    Выведите результат задачи в консоль в формате: «Если в компании работает … человек,
    то всего … часов работы может быть поделено между сотрудниками».
 */
        var totalHours = 640;
        var hours = 8;
        System.out.println("Всего работников в компании - " + totalHours/hours + " человек");
        var emploeers = totalHours/hours + 94;
        System.out.println("Если в компании работает - " + emploeers + "  человек, то всего - " + emploeers*8 + " часов работы может быть поделено между сотрудниками.");
    }
}