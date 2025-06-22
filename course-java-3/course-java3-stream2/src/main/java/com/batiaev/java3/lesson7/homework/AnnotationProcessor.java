package com.batiaev.java3.lesson7.homework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

public class AnnotationProcessor {

    private final static Comparator<Method> methodComparator = (m1, m2) -> {
        Integer i1 = m1.getAnnotation(Test.class).priority();
        Integer i2 = m2.getAnnotation(Test.class).priority();
        if (i1.compareTo(i2) == 0) {
            return m1.getName().compareTo(m2.getName());
        }
        return i1.compareTo(i2);
    };

    public static void main(String[] args) {
        start(CalcTests.class);
    }

    public static void start(String className) throws ClassNotFoundException {
        start(Class.forName(className));
    }

    public static void start(Class classObj) {
        runTests(classObj);
    }

    private static <T> void runTests(Class<T> clazz) {
        final T testClass;
        Method beforeTestsMethod = null;
        Method afterTestsMethod = null;
        Set<Method> testMethods = new TreeSet<>(methodComparator);
        try {
            testClass = clazz.newInstance();

            Method[] declaredMethods = clazz.getDeclaredMethods();
            for (Method method : declaredMethods) {
                method.setAccessible(true);
                declaredMethods[2].equals(declaredMethods[3]);
                if (method.isAnnotationPresent(BeforeSuite.class)) {
                    if (beforeTestsMethod == null) beforeTestsMethod = method;
                    else throw new CustomTestException("BeforeTestsMethod already exist");
                } else if (method.isAnnotationPresent(AfterSuite.class)) {
                    if (afterTestsMethod == null) afterTestsMethod = method;
                    else throw new CustomTestException();
                } else if (method.getAnnotation(Test.class) != null) {
                    testMethods.add(method);
                }
            }
            if (beforeTestsMethod != null) beforeTestsMethod.invoke(testClass);
            for (Method method : testMethods) {
                method.invoke(testClass);
            }
            if (afterTestsMethod != null) afterTestsMethod.invoke(testClass);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static class CustomTestException extends RuntimeException {
        public CustomTestException(String value) {
            super(value);
        }

        public CustomTestException() {
        }
    }
}
