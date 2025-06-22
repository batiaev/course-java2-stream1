package com.batiaev.java3.lesson1;

public class MultiGenericManager<T extends Number, V extends Number> extends GenericManager<T> {
    private V value2;

    public MultiGenericManager(T i, V aDouble) {
        super(i);
        value2 = aDouble;
    }

    public static void main(String[] args) {
        MultiGenericManager<Integer,Double> multiGenericManager =
                new MultiGenericManager<>(1,new Double(123.5));
    }

    public double totalValue() {
        return value.doubleValue() + value2.doubleValue();
    }
}
