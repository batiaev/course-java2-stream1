package com.batiaev.java1.lesson5;

/**
 * Employee
 *
 * @author anton
 * @since 22/03/18
 */
public class Employee {

    private final String name;
    private final String position;
    private final String email;
    private final String phone;
    private final float salary;
    private final int age;

    public Employee(String name, String position, String email, String phone,
                    float salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", position='").append(position).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    //    @Override
//    public String toString() {
//        return String.format("ФИО: %s%nДолжность: %s%nemail: %s%n" +
//                        "Телефон: %s%nЗарплата: %.2f%nВозраст: %d%n",
//                name, position, email, phone, salary, age
//        );
//    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иван Иванов", "Инженер",
                "ivanov.ivan@example.com",
                "01", 30000F, 30);
        employees[1] = new Employee("Петр Петров", "Водитель",
                "petr.petrov@example.com", "02", 30000F, 26);
        employees[2] = new Employee("Иван Петров", "Слесарь",
                "ivan.petrov@example.com", "03", 30000F, 42);
        employees[3] = new Employee("Петр Иванов", "Токарь",
                "petr.ivanov@example.com", "04", 30000F, 47);
        employees[4] = new Employee("Степан Сидоров", "Столяр",
                "stepan.sidorov@example.com", "09", 30000F, 36);

        System.out.println("Сотрудники, старше 40 лет:");
        for (Employee currentEmployee : employees) {
            if (currentEmployee.getAge() >= 40) {
                currentEmployee.printInfo();
            }
        }
    }
}
