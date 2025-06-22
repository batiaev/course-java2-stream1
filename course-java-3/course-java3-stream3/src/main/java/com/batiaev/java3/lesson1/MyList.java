package com.batiaev.java3.lesson1;

public class MyList {
    private Object[] values = new Object[10];
    private int lastIndex = 0;

    void add(Object value) {
        values[lastIndex] = value;
        ++lastIndex;
    }

    Object get(int index) {
        return values[index];
    }
}
