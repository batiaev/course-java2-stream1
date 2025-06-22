package com.batiaev.java3.lesson6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Slf4j
public class LogExample {
    private static final Logger log = LoggerFactory.getLogger(LogExample.class);

    public static void main(String[] args) {
        log.info("Simple info log message");
        int value = 42;
        log.warn("Warning message with argument {}", value);
        int[] array = new int[5];
        int invalidIndex = 30;
        try {
            System.out.println(array[invalidIndex]);//IndexOutOfBoundsException
        } catch (Exception e) {
            log.error("Detailed error message with some args {} and exception: ", invalidIndex, e);
        }
    }
}
