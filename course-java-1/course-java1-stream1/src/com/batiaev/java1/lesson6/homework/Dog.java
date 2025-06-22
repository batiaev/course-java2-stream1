package com.batiaev.java1.lesson6.homework;

public class Dog extends Animal {

    public Dog(int age, String name) {
        super(age, name);
        super.runLimit = 500 + random.nextInt(200);
//        super.jumpLimit = 0.5f;
        super.jumpLimit = 2;
        super.swimLimit = 10;
    }

    @Override
    public void run(int distance) {
        if (runLimit > distance) {
            System.out.println(name + " run: "
                    + (distance < runLimit) + " (дистанция: "
                    + distance + ", умение: "
                    + runLimit + ")");
        } else {
            System.out.println(name + " не пробежит данную дистанцию!");
        }
    }

    @Override
    public void jump(float distance) {
        if (jumpLimit > 0) {
            System.out.println(name + " jump: "
                    + (distance < jumpLimit) + " (высота: " + distance + ", умение: "
                    + jumpLimit + ")");
        } else {
            System.out.println(name + " не умеет прыгать!");
        }
    }

    @Override
    public void swim(int distance) {
        if (swimLimit > 0) {
            System.out.println(name + " swim: "
                    + (distance < swimLimit) + " (дистанция: "
                    + distance + ", умение: "
                    + swimLimit + ")");
        } else {
            System.out.println(name + " не умеет плавать!");
        }
    }
}
