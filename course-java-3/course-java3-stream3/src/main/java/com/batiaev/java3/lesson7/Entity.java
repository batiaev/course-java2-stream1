package com.batiaev.java3.lesson7;


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
public @interface Entity {
    String tableName() default "";
}
