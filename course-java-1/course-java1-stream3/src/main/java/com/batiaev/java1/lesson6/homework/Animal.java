package com.batiaev.java1.lesson6.homework;

/**
 * Animal
 *
 * @author anton
 * @since 26/03/18
 */
public abstract class Animal {
    private String name;
    protected double maxDistance;
    protected double maxSwim;
    protected double maxJump;

    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Dog(150);
        animals[0] = new Cat(5, 20);
        for (Animal animal : animals) {
            animal.jump(10);
            animal.swim(5);
            animal.run(15);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (swim < 0) swim = 0;
        if (jump < 0) jump = 0;
        if (run < 0) run = 0;
        this.maxDistance = run;
        this.maxJump = jump;
        this.maxSwim = swim;
    }

    protected abstract boolean swim(double value);

    protected abstract boolean run(double value);

    protected abstract boolean jump(double value);

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Animal{");
        sb.append("name=").append(name);
        sb.append(", maxDistance=").append(maxDistance);
        sb.append(", maxSwim=").append(maxSwim);
        sb.append(", maxJump=").append(maxJump);
        sb.append('}');
        return sb.toString();
    }
}
