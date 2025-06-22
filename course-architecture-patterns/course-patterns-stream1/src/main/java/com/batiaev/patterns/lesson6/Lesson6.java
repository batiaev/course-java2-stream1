package com.batiaev.patterns.lesson6;

import java.io.Serializable;
import java.util.Currency;

public class Lesson6 {
    private final static double quote = 63.13;

    public static void main(String[] args) {
        valueObject();
        money();
        registry();
        dataMapper();
        unitOfWork();
        identityMap();
    }

    private static void identityMap() {
        Storage storage = new Storage();
        long personId = 1;
        Person person = storage.getPerson(personId);
    }

    private static void unitOfWork() {
        new UnitOfWork();
    }

    private static void dataMapper() {
        Person person = new Person();
        PersonMapper personMapper = new PersonMapper();
        Person personWithId1 = personMapper.getById(1);
    }

    private static void registry() {
        Registry registry = new Registry();
        Serializable service = registry.getService(String.class);
    }

    private static void money() {
        Account account = new Account(2000);
        Currency currency = Currency.getInstance("USD");

        account.spend(100);
        account.spendOnVacation(100 * quote);
        double amountInUsd = account.getAmount() / quote;
    }

    private static void valueObject() {
        Animal animal = new Animal("name", 1, "black");
    }
}
