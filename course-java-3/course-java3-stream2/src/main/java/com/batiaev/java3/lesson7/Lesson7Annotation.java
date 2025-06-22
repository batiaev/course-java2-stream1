package com.batiaev.java3.lesson7;

import org.junit.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Lesson7Annotation {
    Class<? extends Throwable> expected() default Test.None.class;
}
