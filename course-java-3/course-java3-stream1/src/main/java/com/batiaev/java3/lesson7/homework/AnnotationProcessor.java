package com.batiaev.java3.lesson7.homework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class AnnotationProcessor {

    public static void main(String[] args) {
        start(CalcTests.class);
    }

    public static void start(String className) throws ClassNotFoundException {
        start(Class.forName(className));
    }

    public static void start(Class classObj) {
        runTests(classObj);
    }

    private static void runTests(Class classObj) {
        Object tester;
        Method beforeTests = null;
        Method afterTests = null;
        Comparator<Method> comp = (m1, m2) -> {
            Integer i1 = m1.getAnnotation(Test.class).priority();
            Integer i2 = m2.getAnnotation(Test.class).priority();
            return i1.compareTo(i2);
        };
        Set<Method> testMethods = new TreeSet<>(comp);
        try {
            tester = classObj.newInstance();
            for (Method method : classObj.getDeclaredMethods()) {
                method.setAccessible(true);
                if (method.isAnnotationPresent(BeforeSuite.class)) {
                    if (beforeTests == null)
                        beforeTests = method;
                    else throw new RuntimeException();
                } else if (method.getAnnotation(AfterSuite.class) != null) {
                    if (afterTests == null)
                        afterTests = method;
                    else throw new RuntimeException();
                } else if (method.getAnnotation(Test.class) != null) {
                    testMethods.add(method);
                }
            }
            if (beforeTests != null) beforeTests.invoke(tester);
            for (Method method : testMethods) {
                method.invoke(tester);
            }
            if (afterTests != null) afterTests.invoke(tester);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
