package com.batiaev.java2.lesson3;

import java.util.*;

public class Homework {
    public static void main(String[] args) {
//        task1();
        task2();
    }

    private static void task2() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("anton", "12345");
        phoneBook.add("anton", "54321");
        phoneBook.add("ivan", "55555");
        Set<String> numbers = phoneBook.get("anton");
        System.out.println(numbers);

    }

    private static void task1() {
        List<String> words = Arrays.asList(
                "one", "two", "three", "four", "five", "one");
        System.out.println(words);
        Set<String> uniqueWords = new HashSet<>(words);
        System.out.println(uniqueWords);
        Map<String, Integer> duplicates = new HashMap<>();
        for (String s : words) {
//            duplicates.containsKey(s)
            duplicates.put(s, duplicates.getOrDefault(s, 0) + 1);
        }
        System.out.println(duplicates);
    }

}
