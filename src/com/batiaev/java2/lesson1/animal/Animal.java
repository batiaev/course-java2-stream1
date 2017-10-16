package com.batiaev.java2.lesson1.animal;

/**
 * Animal
 *
 * @author anton
 * @since 16/10/17
 */
public abstract class Animal {
    protected String name;
    protected String animType;
    protected boolean onDistance;
    protected float maxRunDistance;

    public boolean isOnDistance() {
        return onDistance;
    }

    public void getOutFromDistance(String reason) {
        System.out.println(animType + " " + name + " " + reason + " fail");
        onDistance = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void info() {
        System.out.println(animType + " " + name);
    }

    public void cross(float dist) {
        if(dist < maxRunDistance) {
            System.out.println(animType + " cross ok");
        } else {
            getOutFromDistance("cross");
        }
    }
}