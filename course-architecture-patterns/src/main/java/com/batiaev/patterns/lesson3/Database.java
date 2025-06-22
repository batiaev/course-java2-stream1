package com.batiaev.patterns.lesson3;

import lombok.Data;

@Data
public class Database {

    private final String dbName;

    private Database(String dbName) {
        this.dbName = dbName;
    }

//    public static List<Database> databaseList;
//    public static long COUNT = 5;
    private static Database db = null;

    public static Database getInstance() {
        if (db == null) {
            synchronized (db) {
                if (db == null)
                    db = new Database("test1.db");
            }
        }
        return db;
    }

    public void saveAccount(Account account) {
        //FIXME
    }

    public void saveAsset(Asset asset) {
        //FIXME
    }
}
