package com.batiaev.java3.lesson7;

import java.io.Serializable;
import java.util.UUID;

/**
 * Account
 *
 * @author anton
 * @since 09/09/19
 */
@Deprecated
public abstract class Account implements Serializable {
    protected String id;
    public double value;

    public Account() {
        id = UUID.randomUUID().toString();
        value = 0;
    }

    public Account(String id) {
        this.id = id;
        value = 0;
    }
}
