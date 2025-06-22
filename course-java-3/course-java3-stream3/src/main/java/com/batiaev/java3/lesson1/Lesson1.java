package com.batiaev.java3.lesson1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lesson1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("anton", "vasia", "ivan");
        System.out.println(names);
        names.add(String.valueOf(3.14));
        String name = names.get(0);

        Object[] objects1 = names.toArray(new Object[3]);

        MyList myList = new MyList();
        myList.add("anton");
        myList.add(3.14);
        myList.add(new Object());
        String value = (String) myList.get(0);

        example4();
        example5();
        example6();
    }

    private static void example6() {
        Map<String, Account> accountMap = new HashMap<>();
    }

    private static void example5() {
        Integer[] integers = new Integer[3];
        integers[0] = 1;
        integers[1] = 2;
        integers[2] = 3;
        Stats<Integer> values = new Stats<>(integers);
        values.avg();

        Stats<Double> doubleValues = new Stats<>(new Double[]{1.0, 2.0, 3.0});

        boolean result = values.sameAvg(doubleValues);
    }

    private static void example4() {
//        MyCustomList<String, Object, Object, Object> customList = new MyCustomList<>();
//        MyCustomList<String> customList = new MyCustomList<>();
        MyCustomList<Account> accounts = new MyCustomList<>();
        accounts.add(0, new Account("anton"));
        Account account = accounts.get(0);
    }


}
