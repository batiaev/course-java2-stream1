package com.batiaev.gb223;

import java.util.List;
import java.util.stream.Collector;

/**
 * BankCard
 *
 * @author anton
 * @since 16/07/19
 */
public class MultiBankCard implements Acccount {
    private final String id;
    private List<BankAccount> accountList;

    @Override
    public double getAmount() {
        return accountList.stream().mapToDouble(BankAccount::getAmount).sum();
    }

    @Override
    public void setAmount(double value) {
        accountList.get(0).setAmount(value);
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

        public MultiBankCard build() {

            return new MultiBankCard(id, amount);
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
        MultiBankCard card = bank.createNewBankCard()
//                                .id("123")
                                .amount(140)
                                .paymentType("Visa")
                                .ccy("USD")
                                .build();
    }

    public MultiBankCard(String id, double i) {
        this.id = id;
        this.amount = i;
    }
}
