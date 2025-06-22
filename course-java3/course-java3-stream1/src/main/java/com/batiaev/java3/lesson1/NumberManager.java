package com.batiaev.java3.lesson1;

public class NumberManager<Type extends Number> extends GenericManager<Type> {
    public NumberManager(Type value) {
        super(value);
    }

    public static void main(String[] args) {
        NumberManager<Double> doubleNumberManager = new NumberManager<>(123.0);
        NumberManager<Integer> integerNumberManager =
                new NumberManager<Integer>(123);

        double sum = doubleNumberManager.calculateSum(integerNumberManager);


    }

    public <MethodType extends Number> double calculateSum(NumberManager<MethodType> second) {

        Type value = getValue();
        return value.doubleValue() + second.getValue().doubleValue();
    }


}
