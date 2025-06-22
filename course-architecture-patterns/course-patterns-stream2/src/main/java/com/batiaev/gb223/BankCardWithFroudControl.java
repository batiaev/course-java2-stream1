package com.batiaev.gb223;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BankCardWithFroudControl
 *
 * @author anton
 * @since 23/07/19
 */
public class BankCardWithFroudControl extends BankCard {
    private final static Logger log = LoggerFactory.getLogger(BankCard.class);
    public BankCardWithFroudControl(String id, double i) {
        super(id, i);
    }

    @Override
    public double getAmount() {
        log.info("call getAmount");
        return super.getAmount();
    }

    @Override
    public void setAmount(double value) {
        log.info("call getAmount");
        super.setAmount(value);
    }
}
