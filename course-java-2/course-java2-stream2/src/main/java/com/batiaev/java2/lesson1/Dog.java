package com.batiaev.java2.lesson1;

import java.io.Serializable;

public class Dog extends Animal implements CanSwim, Serializable, Cloneable {

    void makeSound() {
        System.out.println("gav");
    }

    public void swim() {
        this.doSwim();
    }

    public void doSwim() {
        System.out.println("");
    }
}
