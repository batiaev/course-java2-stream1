package com.batiaev.java3.lesson4;

import lombok.*;

@Data
//@EqualsAndHashCode(of = "id")
//@ToString(of = {"name", "amount"}, callSuper = true)
public class Account {
    private long id;
    private double amount;
    private String name;
    private String type;
}
