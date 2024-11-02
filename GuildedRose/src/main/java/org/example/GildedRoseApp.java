package org.example;
import org.example.discounts.BulkDiscount;
import org.example.discounts.PercentageDiscount;


public class GildedRoseApp {
    public static void main(String[] args) {
        Cart cart = new Cart();

        cart.setPercentageDiscount(new PercentageDiscount(10)); // 10% discount on total
        cart.setBulkDiscount(new BulkDiscount(5, 50)); // 50 discount if 5 or more items

        // Add items to the cart
        cart.addItem("Aged Brie", 10, 20, 100, CurrencyType.EUR);
        cart.addItem("Standard", 5, 10, 50, CurrencyType.EUR);
        cart.addItem("Conjured", 3, 6, 30, CurrencyType.EUR);
        cart.addItem("Sulfuras", 0, 80, 400, CurrencyType.EUR);
        cart.addItem("Standard", 7, 12, 60, CurrencyType.EUR);

        int daysToSimulate = 5;

        cart.simulateDays(daysToSimulate);
    }
}



