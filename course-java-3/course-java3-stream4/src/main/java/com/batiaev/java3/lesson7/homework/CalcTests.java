package com.batiaev.java3.lesson7.homework;

import sun.jvm.hotspot.StackTrace;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Vector;

public class CalcTests {

    @BeforeSuite()
    @SuppressWarnings("unused")
    public void beforeTests() {
        System.out.println("Start testing...");
    }

    @Test(priority = 4)
    @SuppressWarnings("unused")
    public void addTest() {
        final String methodName = Thread.currentThread()
                .getStackTrace()[1].getMethodName();
//        final String methodName = new Exception()
//                .getStackTrace()[0].getMethodName();
        final Method[] declaredMethods = this.getClass().getDeclaredMethods();

        Method method = null;
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().equals(methodName)) {
                method = declaredMethod;
                break;
            }
        }
        final Annotation[] addTestsAnnotations = method.getAnnotations();
        System.out.println(Arrays.toString(addTestsAnnotations));

        System.out.println("Тестируем сложение...");
    }

    @Test(priority = 8)
    @SuppressWarnings("unused")
    public void mulTest() {
        System.out.println("Тестируем умножение...");
    }

    @Test(priority = 8)
    @SuppressWarnings("unused")
    public void divTest() {
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
