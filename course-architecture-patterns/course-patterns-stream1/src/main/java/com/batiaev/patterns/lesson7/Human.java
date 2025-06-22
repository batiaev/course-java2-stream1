package com.batiaev.patterns.lesson7;

import lombok.Data;

import java.util.UUID;

@Data
public class Human {
    private UUID uuid;
    private String name;
    private int age;
}
