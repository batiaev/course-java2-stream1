package com.batiaev.java1.lesson5;

import com.batiaev.java1.lesson5.animals.Cat;

/**
 * Lesson5
 *
 * @author anton
 * @since 05/02/18
 */
public class Lesson5 {
    public static void main(String[] args) {
        Cat barsik = new Cat();
        Cat murzik = new Cat("murzik", "black");
        String name = murzik.getName();
        int age = murzik.getAge();

        Cat[] cats = new Cat[5];
        cats.getClass();
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Cat#" + i, "black");
            cats[i].makeSound();
        }
        System.out.println("cat created");
        System.out.println(barsik);
    }
}
