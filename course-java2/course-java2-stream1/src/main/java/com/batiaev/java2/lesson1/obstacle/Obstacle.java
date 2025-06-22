package com.batiaev.java2.lesson1.obstacle;

import com.batiaev.java2.lesson1.animal.Animal;

/**
 * Obstacle
 *
 * @author anton
 * @since 16/10/17
 */
public abstract class Obstacle {
    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    float size;

    public abstract void doIt(Animal a);
}
