package com.batiaev.java2.lesson1.animal;

/**
 * Horse
 *
 * @author anton
 * @since 16/10/17
 */
public class Horse extends Animal implements Swimable, Jumpable {
    public Horse(String name) {
        this.name = name;
        animType = "Horse";
        onDistance = true;
        maxRunDistance = 10000;
    }

    public void swim(float dist) {
        if(dist < 10) {
            System.out.println(animType + " water ok");
        } else {
            getOutFromDistance("swim");
        }
    }

    @Override
    public void jump(float height) {
        if(height < 1.0f) {
            System.out.println(animType + " jump ok");
        } else {
            getOutFromDistance("jump");
        }
    }
}

