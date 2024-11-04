package org.example.domain;

public class Item {
    public String name;
    public int sellIn;
    public int quality;
    public Money price;
    public int quantity;


    public Item(String name, int sellIn, int quality, Money price) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.price = price;
        this.quantity = 0;
    }

    public void display() {
        System.out.println(name + " - Sell In: " + sellIn + ", Quality: " + quality + ", Price: " + price.getAmount() + " " + price.getCurrency());
    }

    public Money getPrice() {
        return price;
    }

    public String getName() {
        return  name;
    }
    public int getQuantity(){
        return quantity;
    }

    public int getQuality() {
        return quality;
    }

    public int getSellIn() {
        return  sellIn;
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }
}

