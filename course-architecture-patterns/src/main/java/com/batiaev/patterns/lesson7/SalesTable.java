package com.batiaev.patterns.lesson7;

import lombok.Data;

import java.util.UUID;

@Data
public class SalesTable {
    private String department;
//    private Human human;
    private UUID humanId;
}
