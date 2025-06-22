package com.batiaev.java3.lesson7;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TableValidator implements ConstraintValidator<Table, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.startsWith("gb_");
    }
}
