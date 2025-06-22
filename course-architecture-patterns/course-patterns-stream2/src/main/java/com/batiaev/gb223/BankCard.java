package com.batiaev.gb223;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Currency;
import java.util.List;

/**
 * BankCard
 *
 * @author anton
 * @since 16/07/19
 */
public class BankCard implements Acccount,TransportCard {
    private final String id;
    private BankAccount defaultAccount;
    private TransportCard transportCard;

    @Override
    public double getAmount() {
        return defaultAccount.getAmount();
    }

    @Override
    public void charge(double value) {
        this.defaultAccount.setAmount(defaultAccount.getAmount()-value);
    }

    @Override
    public void setAmount(double value) {
        this.defaultAccount.setAmount(value);
    }

    @Override
    public void payForTrip() {
        transportCard.payForTrip();
    }

    static class Builder {

        String id;
        double amount;

        Builder id(String id) {
            this.id = id;
            return this;
        }

        Builder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public BankCard build() {

            return new BankCard(id, amount);
        }

        public Builder paymentType(String visa) {
            return this;
        }

        public Builder ccy(String usd) {
            return this;
        }
    }

    public static void main(String[] args) {

        Bank bank = Bank.instance();
        BankCard card = bank.createNewBankCard()
//                                .id("123")
                                .amount(140)
                                .paymentType("Visa")
                                .ccy("USD")
                                .build();
    }

    public BankCard(String id, double i) {
        this.id = id;
        this.amount = i;
    }
}
