package com.batiaev.patterns.lesson7;

public class Lesson7 {
    public static void main(String[] args) {
        //FIXME
        transactionScript();
        tableModule();
        domainModel();
    }

    private static void domainModel() {
        Human sales = new Sales();
        save(sales);
    }

    private static void save(Human sales) {
        //FIXME
    }

    private static void tableModule() {
        SalesTable sales = new SalesTable();
    }

    private static void transactionScript() {
        Atm atm = new Atm();
        atm.getCash();
    }
}
