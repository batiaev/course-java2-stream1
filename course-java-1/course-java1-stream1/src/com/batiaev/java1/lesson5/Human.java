package com.batiaev.java1.lesson5;

/**
 * Human
 *
 * @author anton
 * @since 18/12/17
 */
public class Human extends Animal {
    private int index;

    public Human(int i) {
        index = i;
    }

    public void play(Cat barsik) {
        barsik.meow();
    }
}
