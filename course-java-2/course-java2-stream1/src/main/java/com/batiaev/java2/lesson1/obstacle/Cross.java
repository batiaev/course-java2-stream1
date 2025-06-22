package com.batiaev.java2.lesson1.obstacle;

import com.batiaev.java2.lesson1.animal.Animal;

/**
 * Cross
 *
 * @author anton
 * @since 16/10/17
 */
public class Cross extends Obstacle {
    public Cross(float size) {
        this.size = size;
    }

    @Override
    public void doIt(Animal a) {
        a.cross(size);
    }
}
