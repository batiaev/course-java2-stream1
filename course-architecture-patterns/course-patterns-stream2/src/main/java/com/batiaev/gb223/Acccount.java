package com.batiaev.gb223;

/**
 * Acccount
 *
 * @author anton
 * @since 23/07/19
 */
public interface Acccount {

    double getAmount();

    void charge(double value);

    void setAmount(double value);
}
