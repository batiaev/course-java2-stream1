package com.batiaev.java3.lesson7;

@Entity(tableName = "st_good")
public final class Good {
    private String name;
    private double price;
    @Column(field = "id", data = 3.1415)
    private String barcode;

    public Good() {
    }

    @LogParams
    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcode() {
        return barcode;
    }
}
