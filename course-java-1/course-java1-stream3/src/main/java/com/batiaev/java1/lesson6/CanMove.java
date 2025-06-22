package com.batiaev.java1.lesson6;

import java.io.Serializable;

/**
 * CanMove
 *
 * @author anton
 * @since 22/03/18
 */
public interface CanMove extends Serializable, Runnable {
    long getDistance();

    void move();
}
