package com.batiaev.java3.lesson7.homework;

import com.batiaev.java3.lesson6.Calculator;

public class CalcTests extends AnnotationProcessor {
    private Calculator calculator;

    public CalcTests() {
        calculator = new Calculator();
    }

    @BeforeSuite
    @SuppressWarnings("unused")
    public void beforeTests() {
        System.out.println("Start testing...");
    }

    @Test(priority = 4)
    @SuppressWarnings("unused")
    public void addTest() {
        System.out.println("Тестируем сложение...");
        int count = 0;
        if (calculator.add(2, 2) != 4) count++;
        if (calculator.add(8, -3) != 5) count++;
        if (calculator.add(0, 0) != 0) count++;
        if (calculator.add(0, 22) != 22) count++;
        if (count != 0) System.out.println("Провалено " + count + " тестов");
        else System.out.println("Тестирование успешно завершено");
    }

    @Test(priority = 8)
    @SuppressWarnings("unused")
    public void mulTest() {
        System.out.println("Тестируем умножение...");
        int count = 0;
        if (calculator.mul(2, 2) != 4) count++;
        if (calculator.mul(8, -3) != -24) count++;
        if (calculator.mul(0, 0) != 0) count++;
        if (calculator.mul(0, 22) != 0) count++;
        if (count != 0) System.out.println("Провалено " + count + " тестов");
        else System.out.println("Тестирование успешно завершено");
    }

    @Test(priority = 8)
    @SuppressWarnings("unused")
    public void divTest() {
        System.out.println("Тестируем деление...");
        int count = 0;
        if (Math.abs(calculator.div(2, 2) - (2f / 2f)) >= 0.01f) count++;
        if (Math.abs(calculator.div(8, -3) - (8f / (-3f))) >= 0.01) count++;
//        if (!Float.isNaN(calculator.div(0, 0))) count++;
        if (Math.abs(calculator.div(0, 22) - (0f / 22f)) >= 0.01) count++;
        if (count != 0) System.out.println("Провалено " + count + " тестов");
        else System.out.println("Тестирование успешно завершено");
    }

    @Test
    @SuppressWarnings("unused")
    public void subTest() {
        System.out.println("Тестируем вычитание...");
        int count = 0;
        if (calculator.sub(2, 2) != 0) count++;
        if (calculator.sub(8, -3) != 11) count++;
        if (calculator.sub(0, 0) != 0) count++;
        if (calculator.sub(0, 22) != -22) count++;
        if (count != 0) System.out.println("Провалено " + count + " тестов");
        else System.out.println("Тестирование успешно завершено");
    }

    @AfterSuite
    @SuppressWarnings("unused")
    public void afterTests() {
        System.out.println("Testing finished");
    }
}
