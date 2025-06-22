package com.batiaev.java1.lesson6;

/**
 * Animal
 *
 * @author anton
 * @since 21/12/17
 */
public abstract class Animal {
    protected String name;
    protected String color;
    protected int age;

    public Animal() {
//        System.out.println("Animal()");
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
//        System.out.println("Animal(name, age)");
    }

    public abstract String makeSound();

    public boolean canFly() {
        return false;
    }
}
