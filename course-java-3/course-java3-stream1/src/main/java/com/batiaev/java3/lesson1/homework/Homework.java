package com.batiaev.java3.lesson1.homework;

import java.util.ArrayList;
import java.util.List;

public class Homework {
    public static void main(String[] args) {
        //FIXME
        String[] data = {"one", "two", "three", "four"};
        for (String datum : data) {
            System.out.println(datum);
        }
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                task1(data, i, j);
            }
        }
        System.out.println("---");
        for (String datum : data) {
            System.out.println(datum);
        }

        List<String> collection =  task2(data);
        task3();
    }

    private static void task3() {
        Box<Apple> boxOfApples = new Box<>();
        Box<Orange> boxOfOrange = new Box<>();
        boxOfOrange.addFruit(new Orange());
        boxOfApples.addFruit(new Apple());

//        boxOfApples.addll(boxOfOrange);

        boxOfApples.getWeight();
    }

    private static <T> List<T> task2(T[] data) {

        ArrayList<T> ts = new ArrayList<>();
        for (T datum : data) {
            ts.add(datum);
        }
        return ts;
//        return Arrays.asList(data);
    }

    private static <T> void task1(T[] array, int index1, int index2) {
        if (array == null) return;
        if (array.length <= index1 || array.length <= index2) return;

        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}