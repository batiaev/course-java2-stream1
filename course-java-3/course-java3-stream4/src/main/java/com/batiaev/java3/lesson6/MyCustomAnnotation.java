package com.batiaev.java3.lesson6;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * MyCustomAnnotation
 *
 * @author anton
 * @since 05/09/19
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value=TYPE)
public @interface MyCustomAnnotation {
    double value() default 123d;
    String name();
}
