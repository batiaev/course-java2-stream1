package com.batiaev.java2.lesson1.obstacle;

import com.batiaev.java2.lesson1.animal.Animal;
import com.batiaev.java2.lesson1.animal.Swimable;

/**
 * Water
 *
 * @author anton
 * @since 16/10/17
 */
public class Water extends Obstacle {
    public Water(float size) {
        this.size = size;
    }

    @Override
    public void doIt(Animal a) {
        if (a instanceof Swimable) {
            ((Swimable) a).swim(size);
        } else {
            a.getOutFromDistance("water");
        }
    }
}