package com.batiaev.java3.lesson7;

import lombok.Data;

import java.util.Currency;

@Data
@Table("gb_account")
public class Account {
    @PrimaryKey
    private final int id;
    private String name;
    private String amount;
    @Field("curr")
    private Currency currency;
}
