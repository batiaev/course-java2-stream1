package com.batiaev.java2.lesson1.animal;

import java.util.Random;

public class Cat extends Animal implements Jumpable {

    public Cat(String name) {
        this.name = name;
        onDistance = true;
        animType = "Cat";
        maxRunDistance = 500;
    }

    @Override
    public void jump(float height) {
        if (height < 1.5f) {
            System.out.println(animType + " jump ok");
        } else {
            float doubleJump = (new Random()).nextFloat();
            if (height < 1.5f + doubleJump) {
                System.out.println(animType + " double jump ok");
            } else
                getOutFromDistance("jump");
        }
    }
}
