package org.example;

public class MainHw3 {
    public static void main(String[] args) {
        /*   Задача 1.
//Обьявите переменные типа int, byte, short, long, float, double
Название переменных может быть любым, но если состоит из двух слов и более, должно соответствовать правилу camelCase.
Выведите в консоль значение каждой переменной в формате «Значение переменной … с типом … равно …».
 */

        int simpleInt = 8;
        byte simpleByte = 3;
        short simpleShort = 76;
        long simpleLong = 2534059;
        float simpleFloat = 23.5F;
        double simpleDouble = 17.8923;


        System.out.println("Значение переменной simpleInt c с типом int равно " + simpleInt);
        System.out.println("Значение переменной simpleByte c с типом byte равно " + simpleByte);
        System.out.println("Значение переменной simpleShort c с типом short равно " + simpleShort);
        System.out.println("Значение переменной simpleLong c с типом long равно " + simpleLong);
        System.out.println("Значение переменной simpleFloat c с типом float равно " + simpleFloat);
        System.out.println("Значение переменной simpleDouble c с типом double равно " + simpleDouble);
        System.out.println();
/*   Задача 2.
Ниже дан список различных значений. Инициализируйте переменные, используйте изученные ранее типы переменных.

Значения:

27.12
987 678 965 549
2,786
569
-159
27897
67
 */
        double first = 27.12;
        long second = 987678965549L;
        double third = 2.786;
        short fourth = 569;
        short fifth = -159;
        short sixth = 27897;
        byte seventh = 67;

        System.out.println();
/*  Задача 3.
    Три школьных учителя, Людмила Павловна, Анна Сергеевна и Екатерина Андреевна, ведут три класса.
    У Людмилы Павловны — 23 ученика, у Анны Сергеевны — 27 учеников, у Екатерины Андреевны — 30 учеников.
    Три учительницы закупили все вместе 480 листов бумаги на все три класса. Посчитайте, сколько достанется листов каждому ученику.
    Результат задачи выведите в консоль в формате: «На каждого ученика рассчитано … листов бумаги».
    Решение:
    Общее количество учеников: 23 + 27 + 30 = 80
    Общее количество листов бумаги: 480
    Количество листов бумаги на каждого ученика: 480 / 80 = 6
    Для объявления переменных не используйте тип var.
 */
        int students1 = 23;
        int student2 = 27;
        int student3 = 30;
        int allStents = students1 + student2 + student3;
        byte allNotes = 80;
        int notesForPerStudent = allNotes/allStents ;

        System.out.println("На каждого ученика рассчитано" + notesForPerStudent + " листов бумаги");
        System.out.println();
/*   Задача 4.
Производительность машины для изготовления бутылок — 16 бутылок за 2 минуты. Какая производительность машины будет:
за 20 минут,
в сутки,
за 3 дня,
за 1 месяц?
Рассчитывайте производительность работы машины в том случае, если она работает без перерыва заданный промежуток времени.
Результаты подсчетов выведите в консоль в формате: «За … машина произвела … штук бутылок».
Для объявления переменных не используйте тип var.
 */
        int performanceForONeMinute = 16 / 2;
        int performanceForTwentyMinutes = performanceForONeMinute * 20;
        int performanceForDay = performanceForONeMinute * 24 * 60;
        int performanceForTheeDays = performanceForDay * 3;
        int performanceForMonth = performanceForDay * 30;

        System.out.println("За 20 минут машина произвела " + performanceForTwentyMinutes + " штук бутылок");
        System.out.println("За сутки машина произвела " + performanceForDay + " штук бутылок");
        System.out.println("За сутки машина произвела " + performanceForTheeDays + " штук бутылок");
        System.out.println("За сутки машина произвела " + performanceForMonth + " штук бутылок");
        System.out.println();
/*   Задача 5.
На ремонт школы нужно 120 банок краски двух цветов: белой и коричневой.
На один класс уходит 2 банки белой и 4 банки коричневой краски. Сколько банок каждой краски было куплено?
Выведите результат задачи в консоль в формате: «В школе, где … классов, нужно … банок белой краски и … банок коричневой краски».
Решение:
Так как на один класс уходит 2 банки белой и 4 банки коричневой краски, то на n классов уйдет 2n банок белой и 4n банок коричневой краски.
Таким образом, чтобы удовлетворить потребности всех классов, нужно купить 2n банок белой и 4n банок коричневой краски.
В данной задаче известно, что всего нужно 120 банок краски двух цветов. Поэтому:

2n + 4n = 120
6n = 120
n = 120 / 6
n = 20

Таким образом, в школе, где 20 классов, нужно 40 банок белой краски и 80 банок коричневой краски.
Для объявления переменных не используйте тип var.
 */
        int allCans = 120;
        int cansOfEachClassForWithePaint = 2;
        int cansOfEachClassForBrownPaint = 4;
        int classes = allCans / (cansOfEachClassForWithePaint + cansOfEachClassForBrownPaint);

        System.out.println("В школе, где  " + classes + "классов, нужно " + classes * cansOfEachClassForWithePaint +
                "банок белой краски и " + classes * cansOfEachClassForBrownPaint + " банок коричневой краски.");

/*   Задача 6.
Спортсмены следят за своим весом и тщательно относятся к тому, что и сколько они съедают.
Вот один из рецептов, по которому спортсмен готовит себе завтрак:
 Бананы — 5 штук (1 банан — 80 грамм).
 Молоко — 200 мл (100 мл = 105 грамм).
 Мороженое-пломбир — 2 брикета по 100 грамм.
 Яйца сырые – 4 яйца (1 яйцо — 70 грамм).
Смешать всё в блендере — и готово.
Подсчитайте вес (количество граммов) такого спортзавтрака, а затем переведите его в килограммы.
Результат в граммах и килограммах напечатайте в консоль.
 */
        int banans = 80 * 5;
        int milk = 105 * 2;
        int iceCream = 100 * 2;
        int eggs = 4 * 78;
        int allProducts = banans + milk + iceCream + eggs;
        double allProductsKg = (double) allProducts / 1000;
        System.out.println("Oбщая масса спортзавтрака: " + allProducts + " грамм");
        System.out.println("Oбщая масса спортзавтрака: " + allProductsKg + " кг");
        System.out.println();
/*   Задача 7.
Правила соревнований обновились, и спортсмену, чтобы оставаться в своей весовой категории, нужно сбросить 7 кг.
Тренер скорректировал рацион так, чтобы спортсмен мог терять в весе от 250 до 500 грамм в день.
Посчитайте, сколько дней уйдет на похудение, если спортсмен будет терять каждый день по 250 грамм,
а сколько — если каждый день будет худеть на 500 грамм.
Посчитайте, сколько может потребоваться дней в среднем, чтобы добиться результата похудения.

Результаты всех подсчетов выведите в консоль.
 */
        int weight = 7000;
        int lostMinWeightInDay = 250;
        int lostMaxWeightInDay = 500;
        int minDays = weight / lostMinWeightInDay;
        int maxDays = weight / lostMaxWeightInDay;
        System.out.println("Количество дней для похудения в минимальном темпе: " + minDays + " дней");
        System.out.println("Количество дней для похудения в максимальном темпе: " + maxDays + " дней");
        System.out.println("Количество дней для похудения, которое потребуется в среднем составляяет: " + (minDays + maxDays) / 2 + " дней");
        System.out.println();
/*   Задача 8.
Представим, что мы работаем в большой компании, штат которой состоит из нескольких сотен сотрудников.
В компании есть правило: чем дольше сотрудник работает в компании, тем ценнее он для бизнеса. Поэтому сотрудники,
которые работают в компании дольше 3 лет, получают повышение зарплаты раз в год.
Каждый год повышение составляет 10% от текущей зарплаты.

К вам пришел руководитель с задачей автоматизировать повышение зарплаты, а также провести расчет для следующих сотрудников:
Маша получает 67 760 рублей в месяц.
Денис получает 83 690 рублей в месяц.
Кристина получает 76 230 рублей в месяц.
Каждому нужно увеличить зарплату на 10% от текущей месячной.
Дополнительно руководитель попросил посчитать разницу между годовым доходом с нынешней зарплатой и после повышения.
Посчитайте, сколько будет получать каждый из сотрудников, а также разницу между годовым доходом до и после повышения.
Выведите в консоль информацию по каждому сотруднику. Например: «Маша теперь получает ... рублей. Годовой доход вырос на ... рублей».
 */
        int mashaMonthIncome = 67760;
        int denMonthIncome = 83690;
        int kristyMonthIncome = 76230;
        int addMonthIncome = 10;

//      посчитаем месячную зарплату сотрудников с учетом повышения
        int mashaAddMonthIncome = mashaMonthIncome + denMonthIncome*addMonthIncome/100;
        int denAddMonthIncome = denMonthIncome + mashaMonthIncome*addMonthIncome/100;
        int kristyAddMonthIncome = kristyMonthIncome + kristyMonthIncome*addMonthIncome/100;

//      посчитаем месячную зарплату сотрудников без учета повышения
        int months = 12;
        int mashaYearIncome = mashaMonthIncome*months;
        int denYearIncome = denMonthIncome*months;
        int kristyYearIncome = kristyMonthIncome*months;

//      посчитаем годовую зарплату сотрудников c учетом повышения
        int mashaAddYearIncome = mashaAddMonthIncome*months;
        int denAddYearIncome  = denAddMonthIncome*months;
        int kristyAddYearIncome = kristyAddMonthIncome*months;

//      посчитаем разницу годовой зарплаты до повышения и после повышения сотрудников
        int mashaYearProfit =  mashaAddYearIncome -  mashaYearIncome;
        int denYearProfit  = denAddYearIncome - denYearIncome;
        int kristyYearProfit = kristyAddYearIncome - kristyYearIncome;

        System.out.println("Маша теперь получает " + mashaAddMonthIncome + " рублей. Годовой доход вырос на " + mashaYearProfit + " рублей");
        System.out.println("Денис теперь получает " + denAddMonthIncome + " рублей. Годовой доход вырос на " + denYearProfit + " рублей");
        System.out.println("Кристина теперь получает " + kristyAddMonthIncome + " рублей. Годовой доход вырос на " + kristyYearProfit + " рублей");
    }
}
