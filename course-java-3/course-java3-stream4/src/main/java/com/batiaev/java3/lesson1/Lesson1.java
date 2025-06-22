package com.batiaev.java3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Lesson1 {

    public static void main(String[] args) {
        example1();
        example2();

        example3();

        example4();
        example5();
    }

    private static void example5() {
        Iterable<Number> iterable = new ArrayList<>();
        Consumer<Number> action1 = new Consumer<Number>() {
            @Override
            public void accept(Number number) {

                System.out.println(number.intValue());
            }
        };
        iterable.forEach(action1);
        Consumer<Object> action2 = new Consumer<Object>() {
            @Override
            public void accept(Object number) {
                System.out.println(number.toString());
            }
        };
        iterable.forEach(action2);
//        iterable.forEach((Double action1) -> {
//
//        });
    }

    private static void example4() {
        int v1 = 5;
        int v2 = 37;
    }

    private static void example1() {

        Storage stringStorage = new Storage();
        stringStorage.add("42");
        stringStorage.add("apple");
        String o = (String) stringStorage.get(0);
        System.out.println(o);

        //fail
//        long o1 = (long) stringStorage.get(1);
//        System.out.println(o1);

        Storage longStorage = new Storage();
        longStorage.add(42L);
        long firstLong = (long) longStorage.get(0);
        System.out.println(firstLong);

    }

    private static void example2() {
        List<String> stringStorage = Arrays.asList("42", "apple");
        String s1 = stringStorage.get(0);
//        long s2 = stringStorage.get(1);
    }

    private static void example3() {
        MyList<String> stringList = new MyList<>();
        stringList.add("42");
//        stringList.add(42L);//type check
        String s1 = stringList.get(0);

        MyList<Long> longList = new MyList<>();
        longList.add(42L);
        longList.add(Long.valueOf(34));
//        long aLong = longList.get(0);
    }
}
