package com.batiaev.java1.lesson5.animals;

/**
 * Animal
 *
 * @author anton
 * @since 06/02/18
 */
public abstract class Animal {
    protected String name;
    protected int age;

    public final String getName() {
        return name;
    }

    public void printName() {
        System.out.println(name);
    }

    public final void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public abstract void makeSound();
}
