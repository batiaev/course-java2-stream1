package com.batiaev.java1.lesson7;

/**
 * CanFly
 *
 * @author anton
 * @since 25/12/17
 */
public interface CanFly {
    void run(int distance);
    void fly();
    default boolean canFly() {
        return false;
    }
}
