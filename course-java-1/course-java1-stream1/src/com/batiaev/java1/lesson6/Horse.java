package com.batiaev.java1.lesson6;

/**
 * Cat
 *
 * @author anton
 * @since 21/12/17
 */
public class Horse extends Animal {

    public Horse(String name) {
        this.name = name;
    }

    @Override
    public String makeSound() {
        return "hrrr";
    }
}
