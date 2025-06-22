package com.batiaev.java1.lesson6.homework;

/**
 * Cat
 *
 * @author anton
 * @since 26/03/18
 */
public class Cat extends Animal {

    public Cat(int jump, int run) {
        super(0, jump, run);
    }

    @Override
    protected boolean swim(double value) {
        if (value > 0 && value < maxSwim) {
            System.out.println(getName() + " swim " + value);
            return true;
        } else {
            System.out.println(getName() + " cannot swim so much");
            return false;
        }
    }

    @Override
    protected boolean run(double value) {
        if (value > 0 && value < maxDistance) {
            System.out.println(getName() + " run " + value);
            return true;
        } else {
            System.out.println(getName() + " cannot run so much");
            return false;
        }
    }

    @Override
    protected boolean jump(double value) {
        if (value > 0 && value < maxJump) {
            System.out.println(getName() + " jump " + value);
            return true;
        } else {
            System.out.println(getName() + " cannot jump so much");
            return false;
        }
    }
}
