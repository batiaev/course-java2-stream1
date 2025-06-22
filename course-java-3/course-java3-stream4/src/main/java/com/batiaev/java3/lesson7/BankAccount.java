package com.batiaev.java3.lesson7;

/**
 * BankAccount
 *
 * @author anton
 * @since 09/09/19
 */
@Table(name = "bank_account")
public final class BankAccount extends Account {
    private String cardId;

    public BankAccount(String id) {
        super(id);
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
