package com.batiaev.java1.lesson7;

/**
 * Company
 *
 * @author anton
 * @since 12/02/18
 */
public class Company {
    private BankCard bankCard;

    public Company() {
        bankCard = new BankCard("bank0", 100);
    }

    public BankCard getBankCard() {
        return bankCard;
    }

    public void setBankCard(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public void paySalary(int amount) {
        bankCard.addAmount(amount);
    }

    public BankCard getBankCardNull() {
        return null;
    }
}
