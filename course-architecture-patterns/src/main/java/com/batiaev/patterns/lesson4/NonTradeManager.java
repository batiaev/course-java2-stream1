package com.batiaev.patterns.lesson4;

import com.batiaev.patterns.lesson4.decorator.TransactionDecorator;

public class NonTradeManager {
    private final TransactionDecorator transactionDecorator;

    public NonTradeManager(TransactionDecorator transactionDecorator) {
        this.transactionDecorator = transactionDecorator;
    }

    public void transfer(String accountId) {
        transactionDecorator.process(accountId);
        doTransfer(accountId);
    }

    private void doTransfer(String accountId) {
        //FIXME
    }
}
