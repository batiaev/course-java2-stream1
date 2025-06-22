package com.batiaev.java2.lesson3;

import com.batiaev.java2.lesson1.Animal;
import com.batiaev.java2.lesson1.Cat;

import java.util.*;

public class Lesson3 {
    public static void main(String[] args) {
//        example1();
//        example2();
//        example3();
//        example4();
//        example5();
//        example6();
//        example7();
        example8();
        example9();
    }

    private static void example9() {
        boolean equals = new Card().equals(new Card());
        boolean equals2 = new Card().hashCode() == new Card().hashCode();
        System.out.println(equals);
    }

    private static void example8() {
        Table<Card> cardTable = new ArrayTable();
        Card card = cardTable.get(1, 2);
        cardTable.put(1,1, new Card());
    }

    private static void example7() {
        Map<String, Card> cardMap = new HashMap<>();

        Card value = new Card();
        value.setCardName("1234 5678 1235 4567");

        cardMap.put(value.getCardName(), value);
        Card card = cardMap.get(value.getCardName());

        int size = cardMap.size();


        Map<String, Animal> animalMap = new HashMap<>();
        animalMap.put("barsik", new Cat());

        Animal barsik = animalMap.get("barsik");
    }

    private static void example6() {
        Set<String> uniqueNames = new HashSet<>();
//        Set<String> uniqueNames = new TreeSet<>();
//        Set<String> uniqueNames = new LinkedHashSet<>();
        uniqueNames.add("Igor");
        System.out.println(uniqueNames.size());
        uniqueNames.add("Anton");
        System.out.println(uniqueNames.size());
        uniqueNames.add("Anton");
        System.out.println(uniqueNames.size());
        uniqueNames.add("Anton");
        System.out.println(uniqueNames.size());
        uniqueNames.add("Max");
        System.out.println(uniqueNames.size());

        uniqueNames.forEach(s -> {
            System.out.println(s);
        });
    }

    private static void example5() {
        List<List<String>> grid = new ArrayList<>(1000);

        grid.add(new ArrayList<>());

        grid.get(0).add("Example");
    }

    private static void example4() {
        String[] namesArray = new String[10];
        String[] newNamesArray = new String[20];
        for (int i = 0; i < namesArray.length; i++) {
            newNamesArray[i] = namesArray[i];
        }
        namesArray = newNamesArray;

        List<String> names = new ArrayList<>();

        List<String> linkedList = new LinkedList<>();
        names.add("Anton");
        names.add("Igor");
        names.get(5);
        names.indexOf("Anton");

        innerExample4((ArrayList<String>) names);

        names.add(1, "Max");
    }

    private static void innerExample4(ArrayList<String> names) {
        ArrayList<String> arrayList = names;
        arrayList.trimToSize();
    }

    private static void example3() {
        Collection<Long> data2 = new ArrayList<>();
        data2.add(5L);
        data2.add(new Long(5));

        //example2
        data2.clear();
        data2.size();
        boolean contains = data2.contains(5L);
        for (Long value : data2) {

        }
    }

    private static void example2() {
        Iterable<Long> data2 = new ArrayList<>();
        //example2
        for (Long value : data2) {

        }

        //example3
        data2.forEach(value -> {

        });
    }

    private static void example1() {
        //FIXME
        long[] data = new long[10];

        //example1
        for (long value : data) {

        }
    }
}
