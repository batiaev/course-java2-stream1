package com.batiaev.java1.lesson6;

import com.batiaev.java1.lesson5.animals.Animal;

/**
 * Dog
 *
 * @author anton
 * @since 08/02/18
 */
public class Dog extends Animal implements CanRun {
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(long maxDistance) {
        this.maxDistance = maxDistance;
    }

    private long maxDistance;

    @Override
    public void printName() {
        System.out.println("Dog's name is " + name);
    }

    @Override
    public void makeSound() {
        System.out.println("Gav");
    }

    public void runDistance() {
        System.out.println("Dog running " + maxDistance);
    }
}
