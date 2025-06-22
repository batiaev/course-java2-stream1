package com.batiaev.java1.lesson5.animals;

import java.util.Objects;

/**
 * Cat
 *
 * @author anton
 * @since 06/02/18
 */
public class Cat extends Animal {

    private String color;
    private long maxJump;

    @Override
    public void printName() {
        System.out.println("Cat's name is " + name);
    }

    public long getMaxJump() {
        return maxJump;
    }

    public void setMaxJump(long maxJump) {
        this.maxJump = maxJump;
    }

    public Cat(String name, String color, int age) {
        System.out.println("Cat(name,color,age)");
        super.name = name;
        this.color = color;
        this.age = age;
    }

    public Cat(String name, String color) {
        this(name, color, 1);
        System.out.println("Cat(name,color)");
    }

    public Cat() {
        this("noname", "white", 0);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public long maxJump() {
        return maxJump;
    }
}
