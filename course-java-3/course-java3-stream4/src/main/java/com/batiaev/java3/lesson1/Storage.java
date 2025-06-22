package com.batiaev.java3.lesson1;

/**
 * Storage
 *
 * @author anton
 * @since 19/08/19
 */
public class Storage {
    private Object[] value = new Object[10];
    private int index = 0;

    public void add(Object v) {
        value[index] = v;
        index++;
    }

    public Object get(int idx) {
        return value[idx];
    }
}
