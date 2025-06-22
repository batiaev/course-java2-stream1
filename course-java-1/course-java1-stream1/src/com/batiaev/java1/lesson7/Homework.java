package com.batiaev.java1.lesson7;

/**
 * Homework
 *
 * @author anton
 * @since 28/12/17
 */
public class Homework {
    public static void main(String[] args) {
        Cat[] cats = new Cat[5];
        for (int i = 0; i < cats.length; ++i) {
            cats[i] = new Cat((int) (Math.random() * 10), "Cat #" + (i + 1));
        }

        Plate plate = new Plate(50);
        for (Cat cat : cats) {
//            if (cat instanceof Cat) {
//                ((Cat) cat).eat(plate);
//            }
            cat.eat(plate);
            cat.printInfo();
        }
    }
}
