package com.batiaev.java2.lesson3;

import java.util.*;

/**
 * Main
 *
 * @author anton
 * @since 26/10/17
 */
public class Main {
    public static void main(String[] args) {

        String[] words = {
                "мыло", "машина", "самолёт", "рама",
                "стол", "стул", "корыто", "щётка",
                "машина", "ванна", "дверь", "стол",
                "люстра", "машина"};
        List<String> data = Arrays.asList(words);
        Set<String> set = new TreeSet<>(data);
        System.out.println(data);
        System.out.println(set);

        Map<String, Integer> map = new HashMap<>();
        for (String word : data) {
//            map.put(word, map.getOrDefault(word, 0) + 1); //java8 example
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        map.forEach((word, count) -> {
            System.out.println(word + " = " + count);
        });
    }
}
