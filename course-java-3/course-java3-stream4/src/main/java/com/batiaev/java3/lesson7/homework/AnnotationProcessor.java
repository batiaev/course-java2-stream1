package com.batiaev.java3.lesson7.homework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import static com.batiaev.java3.lesson7.homework.Test.MAX_PRIORITY;
import static com.batiaev.java3.lesson7.homework.Test.MIN_PRIORITY;

/**
 * Test executor
 *
 * @author batiaev
 */
public class AnnotationProcessor {

    public static void main(String[] args) {
        start(CalcTests.class);
    }

    {
    /*
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */
    }

    public static void start(String className) throws ClassNotFoundException {
        start(Class.forName(className));
    }

    public static void start(Class<?> classObj) {
        runTests(classObj);
    }

    private static <T> void runTests(Class<T> clazz) {
        final T testClass;
        Method beforeTestsMethod = null;
        Method afterTestsMethod = null;
        Set<Method> testMethods = new TreeSet<>(new TestComparator());

        try {
            testClass = clazz.newInstance();

            Method[] declaredMethods = clazz.getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (method.isAnnotationPresent(BeforeSuite.class)) {
                    if (beforeTestsMethod == null) beforeTestsMethod = method;
                    else throw new CustomTestException("BeforeTestsMethod already exist");
                } else if (method.isAnnotationPresent(AfterSuite.class)) {
                    if (afterTestsMethod == null) afterTestsMethod = method;
                    else throw new CustomTestException("AfterTestsMethod already exist");
                } else {
                    final Test annotation = method.getAnnotation(Test.class);
                    if (annotation != null) {
                        final int priority = annotation.priority();
                        if (priority < MIN_PRIORITY || priority > MAX_PRIORITY)
                            throw new CustomTestException("invalid priority value: " + priority
                                    + ", should be in range [" + MIN_PRIORITY + "," + MAX_PRIORITY + "]");
                        else
                            testMethods.add(method);
                    }
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
        CustomTestException(String value) {
            super(value);
        }
    }
}
