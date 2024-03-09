import model.Employee;
import serviceBook.EmployeeBook;

public class Main {
    public static void main(String[] args) {

        Employee employee1 = new Employee("Vasya Petrov", "Accounting office", 35000);
        Employee employee2 = new Employee("Svetlana Pugateva", "Accounting office", 32000);
        Employee employee3 = new Employee("Denis Pomidorov", "Purchasing department", 44000);
        Employee employee4 = new Employee("Olga Frolova", "Purchasing department", 38000);
        Employee employee5 = new Employee("Konstantin Kozlov", "Sales and distribution department", 55000);
        Employee employee6 = new Employee("Anna Cemernya", "Sales and distribution department", 42000);
        Employee employee7 = new Employee("Dmitrij Gelumghinov", "Assembly shop", 24000);
        Employee employee8 = new Employee("Andrey Boroda", "Assembly shop", 23000);
        Employee employee9 = new Employee("Artem Vorobey", "Warehouse", 18000);

        EmployeeBook book = new EmployeeBook(10);
        book.addEmployee(employee1);
        book.addEmployee(employee2);
        book.addEmployee(employee3);
        book.addEmployee(employee4);
        book.addEmployee(employee5);
        book.addEmployee(employee6);
        book.addEmployee(employee7);
        book.addEmployee(employee8);
        book.addEmployee(employee9);

        System.out.println("**********_ФИО_**************");
        book.getAllNames();
        System.out.println("**********_Все сотрудники_**************");
        book.getAllEmployees();
        System.out.println("**********_Макс зарплата_**************");
        System.out.println(book.getMaxSalary());
        System.out.println("**********_Мин зарплата_**************");
        System.out.println(book.getMinSalary());
        System.out.println("**********_Сумма всех зарплат_**************");
        System.out.println(book.getSumSalary());
        System.out.println("**********_Средняя зарплата_**************");
        System.out.println(book.getAverageSalary());
        System.out.println("**********_Добавить сотрудника_**************");
        System.out.println(book.addEmployee(new Employee("Semen Limonov", "Warehouse", 20000)));
        System.out.println("**********_Удалить сотрудника_**************");
        book.deleteEmployee(2);
    }
}