package com.batiaev.java2.lesson1;

import com.batiaev.java2.lesson1.homework.Member;

import java.util.List;

public abstract class Animal implements Member {
    protected long age;
    protected String name;

    abstract void makeSound();

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.makeSound();

        CanSwim dog = new Dog();
        doSwim(dog);

        List<CanSwim> data;
    }

    private static void doSwim(CanSwim item) {
        item.swim();
    }

    private boolean result;

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean getResult() {
        return result;
    }

    public long getAbility() {
        return 10;
    }
}

