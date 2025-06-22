package com.batiaev.java3.lesson6.homework;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Logger;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class Task1 {
    private static final Logger log = Logger.getLogger(Task1.class.getName());

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}},
                {new int[]{7, 5, 1, 2, 4, 1, 3, 5}, new int[]{1, 3}},
                {new int[]{4, 2, 9}, new int[]{2, 9}},
        });
    }

    private int[] arrOriginal;
    private int[] arrExpected;

    public Task1(int[] arrOriginal, int[] arrExpected) {
        this.arrOriginal = arrOriginal;
        this.arrExpected = arrExpected;
    }

    @Test
    public void task1() {
        log.info("отправили массив: " + Arrays.toString(arrOriginal)
                + " получили массив: " + Arrays.toString(arrExpected));
        assertArrayEquals("заданный нами массив, должен совпадать с массивом, который возвращает метод",
                arrExpected, Homework6.task1(arrOriginal));
    }

    @Test(expected = RuntimeException.class)
    public void testExceptionTask1() {
        log.info("Тест на появление RuntimeException");
        Homework6.task1(new int[]{1, 2, 3});

    }
}
