package com.batiaev.java1.lesson6;

/**
 * Dog
 *
 * @author anton
 * @since 21/12/17
 */
public class Dog extends Animal {
    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String makeSound() {
        return "gav";
    }

    public void run() {
        System.out.println("running...");
    }
}
