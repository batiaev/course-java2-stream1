package com.batiaev.java3.lesson7.homework;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PriorityValidator implements ConstraintValidator<Test, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value >= Test.MIN_PRIORITY && value <= Test.MAX_PRIORITY;
    }
}
