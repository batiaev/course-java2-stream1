package com.batiaev.java3.lesson1;

/**
 * DoubleConverter
 *
 * @author anton
 * @since 19/08/19
 */
public class DoubleConverter implements Converter<String, Double> {
    @Override
    public Double convert(String value) {
        return Double.parseDouble(value);
    }
}
