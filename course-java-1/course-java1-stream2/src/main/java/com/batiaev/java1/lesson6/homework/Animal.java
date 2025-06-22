package com.batiaev.java1.lesson6.homework;

import java.util.Objects;

/**
 * Animal
 *
 * @author anton
 * @since 12/02/18
 */
public abstract class Animal {
    protected double maxDistance;
    protected double maxSwim;
    protected double maxJump;

    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Dog(150);
        animals[0] = new Cat(5,20);
        for (Animal animal : animals) {
            animal.jump(10);
            animal.swim(5);
            animal.run(15);
        }
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(double maxDistance) {
        this.maxDistance = maxDistance;
    }

    public double getMaxSwim() {
        return maxSwim;
    }

    public void setMaxSwim(double maxSwim) {
        this.maxSwim = maxSwim;
    }

    public double getMaxJump() {
        return maxJump;
    }

    public void setMaxJump(double maxJump) {
        this.maxJump = maxJump;
    }

    public Animal(double swim, double jump, double run) {
        this.maxDistance = run;
        this.maxJump = jump;
        this.maxSwim = swim;
    }

    protected abstract boolean swim(double value);

    protected abstract boolean run(double value);

    protected abstract boolean jump(double value);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (Double.compare(animal.maxDistance, maxDistance) != 0) return false;
        if (Double.compare(animal.maxSwim, maxSwim) != 0) return false;
        return Double.compare(animal.maxJump, maxJump) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(maxDistance);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(maxSwim);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(maxJump);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
//    @Override
//    public String toString() {
//        return "Animal{" +
//                "maxDistance=" + maxDistance +
//                ", maxSwim=" + maxSwim +
//                ", maxJump=" + maxJump +
//                '}';
//    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Animal{");
        sb.append("maxDistance=").append(maxDistance);
        sb.append(", maxSwim=").append(maxSwim);
        sb.append(", maxJump=").append(maxJump);
        sb.append('}');
        return sb.toString();
    }
}
