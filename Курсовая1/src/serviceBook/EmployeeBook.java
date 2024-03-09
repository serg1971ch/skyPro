package serviceBook;

import model.Employee;

public class EmployeeBook {
    private Employee[] employeeList;

    public EmployeeBook(int n) {
        employeeList = new Employee[n];
    }


    public void getAllEmployees() {
        String[] list = new String[employeeList.length];
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] == null) {
                continue;
            }
            list[i] = employeeList[i].toString();
        }
        printListNames(list);
    }

    public void getAllNames() {
        String[] names = new String[employeeList.length];
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] == null) {
                continue;
            }
            names[i] = employeeList[i].getName();
        }
        printListNames(names);
    }

    public int getSumSalary() {
        int sum = 0;
        for (Employee employee : employeeList) {
            if (employee == null) {
                continue;
            }
            sum += employee.getSalary();
        }
        return sum;
    }

    public int getMaxSalary() {
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] == null) {
                continue;
            } else if (min < employeeList[i].getSalary()) {
                min = employeeList[i].getSalary();
            }
        }
        return min;
    }

    public int getMinSalary() {
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] == null) {
                continue;
            } else  if (max > employeeList[i].getSalary()) {
                max = employeeList[i].getSalary();
            }
        }
        return max;
    }

    public int getAverageSalary() {
        return getSumSalary() / employeeList.length;
    }

    private void printListNames(String[] simpleList) {
        for (String string : simpleList) {
            System.out.println(string);
        }
    }

    public boolean addEmployee(Employee employee) {
        boolean isEmptyList = true;
        for (int i = 0; i < this.employeeList.length; i++) {
            if (employeeList[i] == null) {
                employeeList[i] = employee;
                isEmptyList = true;
                break;
            } else {
                isEmptyList = false;
            }
        }
        return isEmptyList;
    }

    private Employee getIdEmployeeById(int id) {
        Employee employeeId = null;
        for (int i = 0; i < employeeList.length; i++) {
            if (i == id && employeeList[i] != null) {
                employeeId = employeeList[i];
            }
        }
        return employeeId;
    }

    public void deleteEmployee(int id) {
        Employee employeeDeletedById = getIdEmployeeById(id);
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeDeletedById.equals(employeeList[i])) {
                employeeList[i] = null;
            }
        }
        getAllEmployees();
    }
}
