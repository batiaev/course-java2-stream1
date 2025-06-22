package com.batiaev.java1.lesson6;

/**
 * Cat
 *
 * @author anton
 * @since 22/03/18
 */
public class Cat extends Animal {
    private String sound;

    public Cat() {
        this("name", "color", 0);
        System.out.println("call Cat");
    }

    public Cat(String name, String color, int age) {
        super(name, color, age);
        System.out.println("call Cat(String, String, int)");
    }

    public String makeSomeNoize() {
        return sound;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
