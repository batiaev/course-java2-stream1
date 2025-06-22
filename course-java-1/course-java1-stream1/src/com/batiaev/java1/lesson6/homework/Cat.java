package com.batiaev.java1.lesson6.homework;

public class Cat extends Animal {

    private int appetite;


    public Cat(int age, String name) {
        super(age, name);
        appetite = 2;
        this.runLimit = 200;
        super.jumpLimit = 2;
        swimLimit = 0;
    }

    public void eat() {

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
}
