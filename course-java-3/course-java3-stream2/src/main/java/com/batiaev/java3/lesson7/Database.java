package com.batiaev.java3.lesson7;

import java.util.List;

public interface Database<T> {
    void createTable(Class<Account> accountClass);

    List<T> getAll();
}
