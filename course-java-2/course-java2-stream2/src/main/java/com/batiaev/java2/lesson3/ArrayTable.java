package com.batiaev.java2.lesson3;

public class ArrayTable implements Table<Card> {
    private final int DEFAULT_SIZE = 10;
    private Card[][] data = new Card[DEFAULT_SIZE][DEFAULT_SIZE];

    @Override
    public Card get(int row, int column) {
        if (data.length<row) return null;
        if (data[row].length<column) return null;
        return data[row][column];
    }

    @Override
    public Card put(int row, int column, Card value) {
        if (data.length<row)  {
            Card[][] tempData = new Card[row][];
            //FIXME
        }
        return null;//FIXME
    }
}
