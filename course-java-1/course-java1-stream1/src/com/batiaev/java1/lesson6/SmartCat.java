package com.batiaev.java1.lesson6;

/**
 * SmartCat
 *
 * @author anton
 * @since 21/12/17
 */
public class SmartCat extends Cat {
    public SmartCat(String name) {
        super(name);
    }

    public SmartCat(String name, int age) {
        super(name, age);
    }

    @Override
    public String makeSound() {
        return "Hello world!";
    }
}
