package com.batiaev.java1.lesson6;

/**
 * Animal
 *
 * @author anton
 * @since 22/03/18
 */
public abstract class Animal {
    private final String name;
    private String color;
    private int age;

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        System.out.println("call Animal(String, String, int)");
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract String getSound();

    public final void test() {
        System.out.println("test");
    }
}
