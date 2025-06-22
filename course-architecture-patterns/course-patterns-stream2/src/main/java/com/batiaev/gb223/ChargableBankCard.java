package com.batiaev.gb223;

/**
 * ChargableBankCard
 *
 * @author anton
 * @since 23/07/19
 */

public class ChargableBankCard extends BankCard implements Chargable {
    public ChargableBankCard(String id, double i) {
        super(id, i);
    }

    @Override
    public void charge(double value) {
        setAmount(getAmount() - value);
    }
}
