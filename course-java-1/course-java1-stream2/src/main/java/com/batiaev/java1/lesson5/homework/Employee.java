package com.batiaev.java1.lesson5.homework;

/**
 * Employee
 *
 * @author anton
 * @since 08/02/18
 */
public class Employee {
    private final String name;
    private final String position;
    private final String email;
    private final String pnohe;
    private final int salary;
    private final int age;

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivanov", "Engineer", "ivivan@mailbox.com", "89543535345", 45000, 27);
        employees[1] = new Employee("Ivan", "Engineer", "ivivan@maierlbox.com", "8954345445", 40000, 74);
        employees[2] = new Employee("Dmitry", "Engineer", "iverivan@mailbox.com", "89543536575", 50000, 25);
        employees[3] = new Employee("Vladimir", "Engineer", "ivivaern@mailbox.com", "82353535345", 70000, 90);
        employees[4] = new Employee("Anton", "Engineer", "iviwetvan@mailbox.com", "892384312", 80000, 45);


        employees[0].getMe();
        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                System.out.println(employee);
            }
        }
    }

    public Employee(String name, String position,
                    String email, String pnohe,
                    int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.pnohe = pnohe;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", pnohe='" + pnohe + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public Employee getMe() {
        return this;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPnohe() {
        return pnohe;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }
}
