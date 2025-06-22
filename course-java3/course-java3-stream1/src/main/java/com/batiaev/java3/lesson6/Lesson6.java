package com.batiaev.java3.lesson6;

import lombok.Data;
import lombok.extern.java.Log;

@Log
@Data
public class Lesson6 {
    private String name;
    private String description;
    private double amount;

    public static void main(String[] args) {
        log.info("Hello world");
        log.warning("warning");
        Lesson6 lesson6 = new Lesson6();
        double amount = lesson6.getAmount();
        lesson6.setName("Tony");
        log.info(lesson6.toString());
    }
}
