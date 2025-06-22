package com.batiaev.gb223;

import com.batiaev.gb223.lesson5.Transaction;
import com.batiaev.gb223.lesson5.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Bank
 *
 * @author anton
 * @since 16/07/19
 */
public class Bank {
    private static final Bank BANK = new Bank();

    private List<BankCard> cards = new ArrayList<>();

    public static Bank instance() {
        return BANK;
    }

    public void accept(Visitor visitor) {
        for (BankCard card : cards) {
            visitor.visit(card);
        }
    }

    public void execute(Transaction transaction) {
        transaction.getFrom().charge(transaction.getAmount());
        transaction.getTo().charge(-transaction.getAmount());
        System.out.println(transaction);
    }

    public BankCard.Builder createNewBankCard() {
        return new BankCard.Builder();
    }
}
