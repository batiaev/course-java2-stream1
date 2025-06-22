package com.batiaev.java1.lesson5.homework;

/**
 * Homework
 *
 * @author anton
 * @since 21/12/17
 */
public class Homework {
//    fio
//    position
//    email
//    phoneNumber
//    salary
//    age
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivanov Ivan", "Developer",
                "ivanov@gmail.com", "89991234567", 10000, 25);
        employees[1] = new Employee("Petrov Max", "PM",
                "petrov@gmail.com", "89991234568", 20000, 26);
        employees[2] = new Employee("Sidorov Petr", "QA",
                "sedorov@gmail.com", "89991234569", 30000, 70);
        employees[3] = new Employee("Gusev Dima", "Head of department",
                "gusev@gmail.com", "89991234560", 40000, 45);
        employees[4] = new Employee("Maslov Alex", "HR",
                "maslov@gmail.com", "89991234561", 50000, 29);

        for (Employee employee : employees) {
            if (employee.getAge() > 40)
                System.out.println(employee);
        }
    }
}
