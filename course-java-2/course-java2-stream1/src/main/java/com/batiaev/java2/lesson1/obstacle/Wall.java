package com.batiaev.java2.lesson1.obstacle;

import com.batiaev.java2.lesson1.animal.Animal;
import com.batiaev.java2.lesson1.animal.Jumpable;
import com.batiaev.java2.lesson1.obstacle.Obstacle;

/**
 * Wall
 *
 * @author anton
 * @since 16/10/17
 */
public class Wall extends Obstacle {
    public Wall(float size) {
        this.size = size;
    }

    @Override
    public void doIt(Animal a) {
        if(a instanceof Jumpable) {
            ((Jumpable) a).jump(size);
        } else {
            a.getOutFromDistance("jump");
        }
    }
}
