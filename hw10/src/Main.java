public class Main {

    public static void main(String[] args) {
        System.out.println("Задача №1");
/*
       Задача 1
Реализуйте метод, который получает в качестве параметра год, проверяет, является ли он високосным, и выводит результат в консоль.
Эту проверку вы уже реализовывали в задании по условным операторам.
 */
        int year = 2024;
        getLeapYear(year);
        System.out.println();
/*
       Задача 2
Вспомните задание 2 из урока «Условные операторы», где вы предлагали пользователю облегченную версию приложения.
*/
        System.out.println("\nЗадача №2\n");
        int clientDeviceYear = 2015;
        int currentClientDeviceYear = 2011;
        int version = 1;
        updateSystemDevice(clientDeviceYear, currentClientDeviceYear, version);

/*
       Задача 3
Возвращаемся к задаче на расчет дней доставки банковской карты.
Ваша задача — доработать код, а именно написать метод,
который на вход принимает дистанцию и возвращает итоговое количество дней доставки.
*/
        System.out.println("\nЗадача №3\n");
        getDeliveryDays(45);
    }


    private static int getLeapYear(int year) {
        int leapYear = 0;
        if (year >= 1584 && year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            leapYear = year;
            System.out.println(year + " год является високосным");
        } else {
            System.out.println(year + " год не является високосным");
        }
        return leapYear;
    }

    private static void updateSystemDevice(int clientDeviceYear, int currentClientDeviceYear, int version) {
        if (clientDeviceYear > currentClientDeviceYear) {
            if (version == 0) {
                System.out.println("Установите облегченную версию приложения для iOS по ссылке");
            } else if (version == 1) {
                System.out.println("Установите облегченную версию приложения для Android по ссылке");
            }
        } else {
            System.out.println("Установите приложение");
        }
    }

    private static int getDeliveryDays(int deliveryDistance) {
        int deliveryDays = 0;
        if (deliveryDistance <= 20) {
            // Доставка в пределах 20 км занимает сутки
            deliveryDays = 1;
        } else if (deliveryDistance <= 60) {
            // Доставка в пределах от 20 км до 60 км добавляет еще один день доставки
            deliveryDays = 2;
        } else if (deliveryDistance <= 100) {
            // Доставка в пределах от 60 км до 100 км добавляет еще одни сутки
            deliveryDays = 3;
        } else {
            // Доставка свыше 100 км невозможна
            System.out.println("Доставка недоступна");
        }
        System.out.println("Потребуется дней: " + deliveryDays);
        return deliveryDays;
    }
}