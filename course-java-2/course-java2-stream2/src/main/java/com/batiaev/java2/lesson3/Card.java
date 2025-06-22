package com.batiaev.java2.lesson3;

import java.util.Objects;

public class Card {
    private int id;
    private String cardName;
    private String name;
    private double amount;

    public void setCardName(String id) {
        this.cardName = cardName;
    }

    public String getCardName() {
        return cardName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id);
    }

    @Override
    public int hashCode() {
        return id;
    }
}
