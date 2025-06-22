package com.batiaev.java3.lesson7.homework;

public class CalcTests extends AnnotationProcessor {

    @BeforeSuite
    @SuppressWarnings("unused")
    public void beforeTests() {
        System.out.println("Start testing...");
    }

    @Test(priority = 4)
    @SuppressWarnings("unused")
    public void addTest() {
        System.out.println("Тестируем сложение...");
    }

    @Test(priority = 8)
    @SuppressWarnings("unused")
    public void mulTest() {
        System.out.println("Тестируем умножение...");
    }

    @Test(priority = 8)
    @SuppressWarnings("unused")
    private void divTest() {
        System.out.println("Тестируем деление...");
    }

    @Test
    @SuppressWarnings("unused")
    public void subTest() {
        System.out.println("Тестируем вычитание...");
    }

    @AfterSuite
    @SuppressWarnings("unused")
    public void afterTests() {
        System.out.println("Testing finished");
    }
}
