package com.batiaev.java3.lesson7;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Lesson7Test {
    private Map<String, Object> record;
    private double value = 3.1415;

    @Before
    public void init() {
        record = new HashMap<>();
        record.put("name", "apple");
        record.put("id", "123/13");
        record.put("price", value);
    }

    @Test
    public void testProcessPrice() {
        Lesson7 lesson7 = new Lesson7();
        Good good = lesson7.process(record);
        assertEquals(value, good.getPrice(), 0.00001);
    }

    @Test
    public void testProcessName() {
        Lesson7 lesson7 = new Lesson7();
        Good good = lesson7.process(record);
        assertEquals(record.get("name"), good.getName());
    }

    @Test
    public void testProcessBarcode() {
        Lesson7 lesson7 = new Lesson7();
        Good good = lesson7.process(record);
        assertEquals(record.get("id"), good.getBarcode());
    }

    @Test
    public void testProcessIsNotNull() {
        Lesson7 lesson7 = new Lesson7();
        Good good = lesson7.process(record);
        assertNotNull(good);
    }
}