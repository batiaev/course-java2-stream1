package com.batiaev.gb223.lesson5;

import com.batiaev.gb223.BankCard;

/**
 * Transaction
 *
 * @author anton
 * @since 30/07/19
 */
public class Transaction {
    private double amount;
    private BankCard from;
    private BankCard to;

    public Transaction(double amount,
                       BankCard from,
                       BankCard to) {
        this.amount = amount;
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        return to != null ? to.equals(that.to) : that.to == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        return result;
    }

    public double getAmount() {
        return amount;
    }

    public BankCard getFrom() {
        return from;
    }

    public BankCard getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "Transaction{" + "amount=" + amount +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
