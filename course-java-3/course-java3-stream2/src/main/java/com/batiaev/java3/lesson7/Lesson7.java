package com.batiaev.java3.lesson7;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

@Slf4j
@Lesson7Annotation(expected = RuntimeException.class)
public class Lesson7 {

    @Validate(minValue = 1, maxValue = 9)
    @Lesson7Annotation
    private static long value;

    @Lesson7SecondAnnotation
    @Lesson7Annotation
    public Lesson7(long value) {
        //FIXME
        Lesson7.value = value;
    }

    @Lesson7Annotation
    public static void main(@Lesson7Annotation String[] args) {
//
//        @Lesson7Annotation
//        String name = "Anton";
//
        Class<Lesson7> lesson7Class = Lesson7.class;
//
//        Lesson7Annotation annotation = lesson7Class.getAnnotation(Lesson7Annotation.class);
//        Class<? extends Throwable> expected = annotation.expected();
//        Class<? extends Annotation> aClass = annotation.annotationType();
//        System.out.println(annotation);


        //------------
        value = 123;
        try {
            Field valueField = lesson7Class.getDeclaredField("value");
            Validate validator = valueField.getAnnotation(Validate.class);
            int max = validator.maxValue();
            int min = validator.minValue();
            if (value < min) log.warn("value less then limit = {}", min);
            if (value > max) log.warn("value greater then limit = {}", max);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

























