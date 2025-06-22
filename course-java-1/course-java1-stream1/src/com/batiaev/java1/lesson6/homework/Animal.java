package com.batiaev.java1.lesson6.homework;

import java.util.Random;

public abstract class Animal {
    protected static Random random = new Random();
    protected String name;
    protected int age;

    protected int runLimit;
    protected float jumpLimit;
    protected int swimLimit;

    public Animal(String name) {
        this.name = name;
    }

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public abstract void run(int distance);

    public abstract void jump(float distance);

    public abstract void swim(int distance);

    public static void main(String[] args) {
        Cat barsik = new Cat(5, "Barsik");
        Dog murzik = new Dog(7, "Murzik");

        barsik.run(250);
        murzik.run(320);

        barsik.jump(1.5f);
        murzik.jump(2.5f);

        barsik.swim(100);
        murzik.swim(20);
    }
}
