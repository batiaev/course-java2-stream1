package com.batiaev.java3.lesson6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Math.exp;
import static java.lang.Math.sin;

/**
 * Lesson6
 *
 * @author anton
 * @since 05/09/19
 */
@MyCustomAnnotation(name = "Real lesson 6")
public class Lesson6 {
    private static final Logger log = LoggerFactory.getLogger(Lesson6.class);

    private static int summa(int value1, int value2) {
        log.error("error");
        log.warn("warn");
        log.info("info");
        log.debug("debug");
        log.trace("trace");
        final int result = value1 + value2;
        log.debug("{} + {} = {}", value1, value2, result);
        return result;
    }



    private String name;
    private double amount;

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public static void main(String[] args) {

//        final MyCustomAnnotation annotation =
//                Lesson6.class.getAnnotation(MyCustomAnnotation.class);
//        System.out.println(annotation.name() + " " + annotation.value());

//        int result = summa(3, 6);
        example();
    }

    private static void example() {

        log.info("exec main method");
        int value = 42;
        log.warn("Unexpected value = " + 42);
        log.warn(String.format("Unexpected value = %s", 42));
        log.warn("Unexpected value = {}, but expected value is {}", 42, 13);

        int a = 3;
        int b = 9;
        double result = sin(a) * exp(9);
        if (log.isDebugEnabled())
            log.debug("sin={}, exp={}, result={}", sin(a), exp(9), result);

        Lesson6 lesson6 = new Lesson6();
        long sum = lesson6.sum(5, 6);
        System.out.println(sum);
        double amount = lesson6.getAmount();

        log.error("error");

        log.warn("something happend!");
        log.info("test");
        try {
            int valu = 15 / 0;
        } catch (Exception e) {
            log.error("Got exception during calculation {}:", 15, e);
        }
    }

    public long sum(int val1, int val2) {
        return val1 + val2;
    }

    public double divide(int val1, int val2) {
        return val1 / val2;
    }
}

