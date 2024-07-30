/*
Theory Questions :
Explain how arrays are represented in memory and their advantages.

Answer :
Arrays are stored in continuous memory locations and each element is accessed by index.
Advantages - Direct Accessing, Cache Friendly
 */

import java.util.*;
class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId +
                "\nName: " + name +
                "\nPosition: " + position +
                "\nSalary: " + salary;
    }
}

class EmployeeManagement {
    private Employee[] employees;
    private int size;

    public EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                employees[i] = employees[size - 1];
                employees[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeManagement ems = new EmployeeManagement(10);

        ems.addEmployee(new Employee(1, "Alice", "Manager", 75000));
        ems.addEmployee(new Employee(2, "Bob", "Developer", 60000));
        ems.addEmployee(new Employee(3, "Charlie", "Designer", 50000));

        System.out.println("All Employees:");
        ems.traverseEmployees();

        System.out.println("\nSearching for Employee with ID 2");
        Employee emp = ems.searchEmployee(2);
        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting Employee with ID 2");
        ems.deleteEmployee(2);

        System.out.println("\nAll Employees after deletion:");
        ems.traverseEmployees();
    }
}
