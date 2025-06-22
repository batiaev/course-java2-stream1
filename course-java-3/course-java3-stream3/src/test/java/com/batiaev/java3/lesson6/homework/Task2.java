package com.batiaev.java3.lesson6.homework;

import com.batiaev.java3.lesson6.Homework6;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@Slf4j
@RunWith(Parameterized.class)
public class Task2 {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}, "Case 1"},
                {new int[]{7, 5, 1, 2, 4, 1, 3, 5}, new int[]{1, 3}, "Case 2"},
                {new int[]{4, 2, 9}, new int[]{2, 9}, "Case 3"},
        });
    }

    private int[] arrOriginal;
    private int[] arrExpected;
    private String message;

    public Task2(int[] arrOriginal, int[] arrExpected, String message) {
        this.arrOriginal = arrOriginal;
        this.arrExpected = arrExpected;
        this.message = message;
    }

    @Test
    public void task1() {
        log.info(message + ": отправили массив: " + Arrays.toString(arrOriginal)
                + " получили массив: " + Arrays.toString(arrExpected));
        assertArrayEquals("заданный нами массив, должен совпадать с массивом, который возвращает метод",
                arrExpected, Homework6.task2(arrOriginal));
    }

    @Test(expected = RuntimeException.class)
    public void testExceptionTask1() {
        log.info("Тест на появление RuntimeException");
        Homework6.task2(new int[]{1, 2, 3});
    }
}
