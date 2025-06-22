package com.batiaev.java1.lesson7;

/**
 * Homework
 *
 * @author anton
 * @since 15/02/18
 */
public class Homework {
    public static void main(String[] args) {
        Cat[] cats = new Cat[5];
        //init
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("cat"+i, 5);
        }
        Plate plateFullOfFood = new Plate(100);
        for (Cat cat : cats) {
            boolean eat = cat.eat(plateFullOfFood);
            if (!eat) {
                System.out.println("Мяю!");
                plateFullOfFood.addSomeFood(10);
            }
        }
    }
}
