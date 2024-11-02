package org.example;

public class Item {
    public String name;
    public int sellIn;
    public int quality;
    public int price;
    public CurrencyType currency;

    public Item(String name, int sellIn, int quality, int price, CurrencyType currency) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.price = price;
        this.currency = currency;
    }

    public void display() {
        System.out.println(name + " - Sell In: " + sellIn + ", Quality: " + quality + ", Price: " + price + " " + currency);
    }
}

