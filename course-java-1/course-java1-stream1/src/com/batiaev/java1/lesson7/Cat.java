package com.batiaev.java1.lesson7;

import com.batiaev.java1.lesson6.homework.Animal;

import java.io.Serializable;

public class Cat extends Animal implements CanFly, Serializable {

    private boolean isHungry = true;
    private int appetite;

    public Cat(int age, String name) {
        super(age, name);
        appetite = 2;
        this.runLimit = 200;
        super.jumpLimit = 2;
        swimLimit = 0;
    }

    public void eat(Plate plate) {
        isHungry = plate.decreaseFood(appetite);
    }

    public boolean isHungry() {
        return isHungry;
    }

    @Override
    public void run(int distance) {

        if (runLimit > 0) {
            System.out.println(
                    name + " run: " + (distance < runLimit)
                            + " (дистанция: " + distance
                            + ", умение: " + runLimit + ")");
        } else {
            System.out.println(name + " не умеет бегать!");
        }
    }

    @Override
    public void jump(float distance) {
        if (jumpLimit > 0) {
            System.out.println(name +
                    " jump: " + (distance < jumpLimit)
                    + " (высота: " + distance
                    + ", умение: " + jumpLimit + ")");
        } else {
            System.out.println(name + " не умеет прыгать!");
        }
    }

    @Override
    public void swim(int distance) {
        if (swimLimit != 0) {
            System.out.println(name +
                    " swim: " + (distance < swimLimit)
                    + " (дистанция: " + distance + ", умение: "
                    + swimLimit + ")");
        } else {
            System.out.println(name + " не умеет плавать!");
        }
    }

    public void printInfo() {
        System.out.println(name + (isHungry ? " is hungry" : " is not hungry"));
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", runLimit=" + runLimit +
                ", jumpLimit=" + jumpLimit +
                ", swimLimit=" + swimLimit +
                '}';
    }

    @Override
    public void fly() {
        System.out.println("I belive I can flyy!");
    }
}