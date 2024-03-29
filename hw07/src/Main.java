import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        /*
 Задача 1
Продолжите работать с кодом, который вы написали в предыдущем уроке — в задачах с накоплениями.
С помощью цикла while посчитайте, сколько месяцев потребуется, чтобы накопить 2 459 000 рублей при условии,
 что первоначально мы имеем 0 рублей и готовы откладывать по 15 тысяч рублей.

Результат программы должен быть выведен в консоль с тем количеством месяцев, которое необходимо для накопления данной суммы.
Формат сообщения: «Месяц …, сумма накоплений равна … рублей».
 */
        int savingTotalMoney = 2459000;
        int savingCurrentMoney = 0;
        int monthCount = 0;
        while (savingCurrentMoney < savingTotalMoney) {
            savingCurrentMoney += 15000;
            monthCount++;
        }

        System.out.println("Месяц " + monthCount + ", сумма накоплений равна " + savingCurrentMoney + " рублей");

/*
 Задача 2
Выведите в одну строку через пробел числа от 1 до 10 с помощью цикла while.
На следующей строке выведите числа в обратном порядке от 10 до 1 с помощью цикла for.
Для обоих циклов можно использовать как одну общую переменную, так и свою в каждом цикле.
Не забудьте выполнить переход на новую строку между двумя циклами.
В результате программы вывод должен получиться следующим:

1 2 3 4 5 6 7 8 9 10
10 9 8 7 6 5 4 3 2 1
*/
        int i = 1;
        while (i < 11) {
            System.out.printf("%d ", i);
            i++;
        }

        System.out.println();

        for (int j = 10; j >= 1; j--) {
            System.out.printf("%d ", j);
        }

/*
 Задача 3
В стране Y население — 12 миллионов человек.
Рождаемость составляет 17 человек на 1000, смертность — 8 человек.
Рассчитайте, какая численность населения будет через 10 лет, если показатели рождаемости и смертности постоянны.
В консоль выведите результат операции на каждый год в формате: «Год …, численность населения составляет …».
*/
        int population = 12000000;
        double birthRate = 0.017;
        double deathRate = 0.008;

        for (int year = 1; year <= 10; year++) {
            population += (birthRate - deathRate) * population;
            System.out.println("Год " + year + ", численность населения составляет " + population);
        }

/*
 Задача 4
Василий решил положить деньги на накопительный счет, где каждый месяц к сумме его вклада добавляется еще 7%.
Первоначальная сумма вклада — 15 тысяч рублей.
Вычислите и выведите в консоль, сколько месяцев Василию нужно будет копить,
чтобы собрать сумму в 12 миллионов рублей при условии, что процент банка от накоплений не меняется, а всегда равен 7%.

Выведите в консоль результат программы с указанием суммы накоплений по каждому месяцу.
 */
        double initialDeposit = 15000; // начальный вклад
        double targetAmount = 12000000; // целевая сумма накоплений
        double interestRate = 0.07; // процент банка

        double currentAmount = initialDeposit; // текущая сумма накоплений
        int months = 0; // количество месяцев

        while (currentAmount < targetAmount) {
            currentAmount += currentAmount * interestRate; // добавляем проценты к текущей сумме
            months++; // увеличиваем количество месяцев
            System.out.println("Месяц " + months + ": " + currentAmount);
        }

        System.out.println("Василию понадобится " + months + " месяцев, чтобы накопить " + Math.round(targetAmount) + " рублей.");
        System.out.println("===================== задача №5 =========================\n");
/*
 Задача 5
Видоизмените программу таким образом, чтобы в консоль выводились не все месяцы подряд,
а только каждый шестой. Должны быть видны накопления за 6-й, 12-й, 18-й, 24-й и следующие месяцы.
*/
        currentAmount = 15000;
        months = 0;
        while (currentAmount < targetAmount) {
            currentAmount += currentAmount * interestRate; // добавляем проценты к текущей сумме
            months++; // увеличиваем количество месяцев
            if (months % 6 == 0) {
                System.out.println("Месяц " + months + ": " + currentAmount);
            }
        }

        System.out.println(" ");
        System.out.println("===================== и снова богатенький Вася =========================\n");
/*
 Задача 6
Василий решил, что будет копить деньги ближайшие 9 лет.
Он хочет знать, какой будет сумма его накоплений каждые полгода на протяжении этих 9 лет.
Исходная сумма всё та же — 15 тысяч рублей, проценты банка — 7% ежемесячно.
Напишите программу, которая будет выводить сумму накоплений за каждые полгода в течение 9 лет.
*/
        int targetPeriod = 9; // целевой период накопления в годах
        double rate = 0.07;
        int targetAllNonths = targetPeriod * 12;// целевой период накопления в месяцах
        int currentMonths = 0;// текущее количество месяцев

        while (currentMonths < targetAllNonths) {
            currentAmount += currentAmount * rate; // добавляем проценты к текущей сумме
            currentMonths++;
            if (currentMonths % 6 == 0) {
                System.out.println("Месяц " + months + "Сумма в месяц" + currentAmount);
            }
        }
        System.out.println(" ");
        System.out.println("===================== задача №7 =========================\n");
/*
 Задача 7
В компании пятница — отчетный день.
Нужно написать программу, которая считает дни месяца по датам, определяет, какой день — пятница, и выводит сообщение с напоминанием, что нужно подготовить еженедельный отчет.
Создайте переменную типа int, которая хранит в себе номер первой пятницы месяца (число от 1 до 7).
Выведите на каждую пятницу месяца (включая полученную) сообщение следующего вида: «Сегодня пятница, ...-е число. Необходимо подготовить отчет».
В нашем месяце 31 день. В результате у вас должно получиться от 4 до 5 сообщений с напоминаниями по разным датам.
*/
        int firstFriday = 1; // Номер первой пятницы месяца (от 1 до 7)
        int currentFriday = 0;
        System.out.println("Сегодня пятница, " + firstFriday + " марта. Необходимо подготовить отчет");
        while (currentFriday <= 31) {
            currentFriday += firstFriday;
            if (currentFriday % 7 == 0) {
                System.out.println("Сегодня пятница, " + currentFriday + " марта. Необходимо подготовить отчет");
            }
        }
        System.out.println(" ");
        System.out.println("===============================================================================\n");

//      а ведь можно и по-человечески, используя красоту Java

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM");

        if (currentDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
            System.out.println("Сегодня пятница, " + currentDate.format(formatter) + ". Необходимо подготовить отчет");
        }

        do {
            currentDate = currentDate.plusDays(1);

            if (currentDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
                System.out.println("Сегодня пятница, " + currentDate.format(formatter) + ". Необходимо подготовить отчет");
            }
        } while (currentDate.getMonth() != Month.APRIL);
        System.out.println(" ");
        System.out.println("===================== задача №8 =========================\n");
/*
 Задача 8
Нам нужно написать астрономическое приложение, которое считает, когда над Землей пролетает комета.
Известно, что комета пролетает каждый 79-й год, начиная с нулевого.
В консоль нужно вывести все годы за последние 200 лет, когда появлялась комета, а также следующий год ее появления (ближайшие 100 лет).
Для вычисления периода можно создать две дополнительные переменные, которые содержат год за 200 лет
до текущего (из созданной ранее переменной) в качестве старта и 100 лет после в качестве завершения периода расчета.
В результате решения задачи в консоли должен получиться следующий результат:

1896
1975
2054
*/
    int currentYear = 2024;
    int startYear = currentYear - 200;
    int endYear = currentYear + 100;
    int period = 79;
    int startPeriod = 0;
        for (int year = startPeriod; year <= endYear; year+= period) {
            if(year >= startPeriod) {
                System.out.println(year);
            }
        }
    }
}