package com.batiaev.java1.lesson5;

/**
 * Cat
 *
 * @author anton
 * @since 18/12/17
 */
public class Cat extends Animal {
    private int age;
    private String color;

    public Cat(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void meow() {
        System.out.println("Meow");
    }
}
