package com.batiaev.java3.lesson7;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
    int minValue() default Integer.MIN_VALUE;

    int maxValue() default Integer.MAX_VALUE;
}
