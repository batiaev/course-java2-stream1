package com.batiaev.java3.lesson1;

public class Calculator {
    private Object value;

    public Calculator(Object v) {
        value = v;
    }

    public Object summa(Object value) {
        if (this.value instanceof Long && value instanceof Long) {
            return (long) this.value + (long) value;
        } else if (this.value instanceof Integer && value instanceof Integer) {
            return (int) this.value + (int) value;
        } else {
            return 0;
        }
    }

    public Object average(Object value) {
        //FIXME
        return 0;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator(13.7);
        calculator.summa(15L);
    }
}
