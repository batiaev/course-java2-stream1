package com.batiaev.java3.lesson1;

import java.util.*;

/**
 * LongDoubleConverter
 *
 * @author anton
 * @since 19/08/19
 */
public class LongDoubleConverter extends NumberDoubleConverter<Long> {
    @Override
    public Double convert(Long value) {
        return null;
    }

    public static void main(String[] args) {

        //PECS - producer extend, consumer super
        Converter<String, String> stringConverter = value -> value;
        NumberDoubleConverter<Integer> integerConverter =
                new NumberDoubleConverter<Integer>() {
            @Override
            public Double convert(Integer value) {
                return Double.parseDouble(value.toString());
            }
        };
        LongDoubleConverter longDoubleConverter = new LongDoubleConverter();

        List<Converter<?,?>> converters = new ArrayList<>();
        converters.addAll(Arrays.asList(
                stringConverter, integerConverter, longDoubleConverter));


        getMap();
    }

    private static <T extends Number>
    Map<Class<T>, NumberDoubleConverter<T>> getMap() {
        Map<T, NumberDoubleConverter<T>> hashMap = new HashMap<>();
//        hashMap.put(Long.class, new LongDoubleConverter());
//        return hashMap;
        return null;
    }
}
