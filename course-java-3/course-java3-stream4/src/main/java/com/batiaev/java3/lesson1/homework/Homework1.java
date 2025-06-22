package com.batiaev.java3.lesson1.homework;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Homework1
 *
 * @author anton
 * @since 22/08/19
 */
public class Homework1 {
    public static void main(String[] args) {
        Object[] data = new Object[] {123123,43,123,123};
        Integer[] data2 = new Integer[] {123123,43,123,123};
        swap(data, 0, 3);

        List<Object> objects = convertToList(data);
        objects.add("123");
        List<Integer> objects2 = convertToList(data2);
        Integer integer = objects2.get(0);
    }

    private static <T> List<T> convertToList(T[] data) {
        return Arrays.asList(data);
    }

    private static <T> void swap(T[] data, int v1, int v2) {
        if (v1 == v2)
            return;
        if (v1 < 0 || v2 < 0 || v1 > data.length-1 || v2 > data.length-1)
            return;
        T temp = data[v1];
        data[v1] = data[v2];
        data[v2] = temp;
    }
}
