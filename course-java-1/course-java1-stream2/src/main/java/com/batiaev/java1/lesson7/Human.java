package com.batiaev.java1.lesson7;

/**
 * Human
 *
 * @author anton
 * @since 12/02/18
 */
public class Human {
    private BankCard[] bankCards = new BankCard[3];

    public BankCard getBankCardById(int id) {
        return bankCards[id];
    }

    public void setBankCards(int id, BankCard bankCard) {
        this.bankCards[id] = bankCard;
    }
}
