package com.batiaev.java3.lesson1;

public class Stats<T extends Number> {
    private T[] nums;

    public Stats(T[] о) {
        nums = о;
    }

    public double avg() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue(); // Ошибка
        }
        return sum / nums.length;
    }

    public <E extends Number> boolean sameAvg(Stats<? extends Number> another) {
        E value;
        return Math.abs(this.avg() - another.avg()) < 0.0001;
    }

    public <E extends Number> E sameAvg2(Stats<? super Number> another) {
//        return E value;

        return null;
    }
}