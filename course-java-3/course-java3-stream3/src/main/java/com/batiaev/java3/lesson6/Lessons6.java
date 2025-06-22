package com.batiaev.java3.lesson6;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Lessons6 {

    private String name;
    private double amount;

    public static void main(String[] args) {
        //FIXME

        Lessons6 lessons6 = new Lessons6();
        long sum = lessons6.sum(5, 6);
        System.out.println(sum);
        double amount = lessons6.getAmount();

        log.error("error");

        log.warn("something happend!");
        log.info("test");
        try {
            int valu = 15 / 0;
        } catch (Exception e) {
            log.error("Got exception during calculation {}:", 15, e);
        }
    }

    public long sum(int val1, int val2) {
        return val1 + val2;
    }
}
