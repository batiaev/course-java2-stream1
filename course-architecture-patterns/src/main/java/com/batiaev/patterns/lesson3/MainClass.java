package com.batiaev.patterns.lesson3;

import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) {
        String dbName = "test1.db";
//        Database oldDatabase1 = new Database(dbName);
//        Database oldDatabase2 = new Database(dbName);

        Database database1 = Database.getInstance();
        Database database2 = Database.getInstance();
        Database database3 = Database.getInstance();


        Person me = new Person("Anton");
        Asset rub = new Asset("RUB", 1000);
        Asset usd = new Asset("USD", 500);

        new Account("mainBank", me, Arrays.asList(rub, usd));

        Account.builder()
                .name("mainBank")
                .owner(me)
                .addAsset(rub)
                .addAsset(usd)
                .build();
    }


//    public static Builder prepareBuilder(Class clazz) {
//        switch (clazz.getSimpleName()) {
//            "asset": return new AssetBuilder();
//        }
//    }

}
