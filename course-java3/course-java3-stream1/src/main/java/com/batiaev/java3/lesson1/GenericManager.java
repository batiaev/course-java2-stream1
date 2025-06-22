package com.batiaev.java3.lesson1;

import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenericManager<VeryLongDifficultType> {
    protected VeryLongDifficultType value;

    public GenericManager(VeryLongDifficultType value) {
        this.value = value;
    }

    public VeryLongDifficultType getValue() {
        return value;
    }

    public static void main(String[] args) {
        GenericManager<String> commonManagerString = new GenericManager<>("15");
        String value2 = commonManagerString.getValue();

        GenericManager<?> commonManagerInteger = new GenericManager<>(145);
        Object value3 = commonManagerInteger.getValue();


        GenericManager<? super Long> longManager = new GenericManager<Number>(new Long(15));
//        Number value4 = longManager.getValue();

        GenericManager<? extends Number> doubleManager = new GenericManager<>(new Double(15));
        Number value = doubleManager.getValue();

        GenericManager<String> manager2 = new GenericManager<>("Hello world");
        String value1 = manager2.getValue();
        value = Integer.valueOf(value1);

        List<Integer> values = new ArrayList<>();


        ArrayList<?> numbers = new ArrayList<Integer>();
        numbers = new ArrayList<GenericManager>();
        numbers = new ArrayList<String>();
        numbers = new ArrayList<FileReader>();

        System.out.println();


        //-------
    }
}
