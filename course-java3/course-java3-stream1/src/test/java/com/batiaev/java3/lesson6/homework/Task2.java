package com.batiaev.java3.lesson6.homework;

import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

@Log
public class Task2 {

    @Test
    public void testTask2AnotherDigits() {
        assertTrue("В массиве есть другие цифры",
                Homework6.task2(new int[]{1, 1, 4, 1, 4, 1, 4, 4, 4, 1}));
        log.info("Массив только из 1 и 4");
    }

    @Test(expected = RuntimeException.class)
    public void testTask2Only1And4() {
        Assert.assertFalse("В массиве только 1 и 4",
                Homework6.task2(new int[]{1, 4, 2}));
        log.info("В массиве не только 1 и 4");
    }

    @Test
    public void testTask2Contain1() {
        Assert.assertFalse("В массиве есть 1", Homework6.task2(new int[]{4, 4, 4, 4, 4}));
        log.info("Массив только из 4");
    }

    @Test
    public void testTask2Contain4() {
        Assert.assertFalse("В массиве есть 4", Homework6.task2(new int[]{1, 1, 1}));
        log.info("Массив только из 1");
    }
}