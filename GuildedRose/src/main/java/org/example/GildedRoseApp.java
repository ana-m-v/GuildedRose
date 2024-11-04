package org.example;

import org.example.services.CurrencyConverterService;
import org.example.discounts.Discount;
import org.example.domain.Cart;
import org.example.domain.Item;
import org.example.domain.Money;
import org.example.domain.CurrencyType;
import org.example.discounts.BulkDiscount;
import org.example.discounts.PercentageDiscount;
import org.example.services.DiscountService;
import org.example.updaters.ItemUpdater;
import org.example.updaters.ItemUpdaterFactory;

import java.util.ArrayList;
import java.util.List;

public class GildedRoseApp {
    public static void main(String[] args) {
        DiscountService discountService = new DiscountService();
        Cart cart = new Cart(discountService);

        List<Discount> discounts = new ArrayList<>();
        discounts.add(new PercentageDiscount(10)); // 10% discount on total
        discounts.add(new BulkDiscount(5, 50)); // 50 currency units discount if 5 or more items

        // Add items to the cart
        cart.addItem(new Item("Aged Brie", 10, 20, new Money(100, CurrencyType.EUR)));
        cart.addItem(new Item("Standard", 5, 10, new Money(50, CurrencyType.EUR)));
        cart.addItem(new Item("Conjured", 3, 6, new Money(30, CurrencyType.EUR)));
        cart.addItem(new Item("Sulfuras", 0, 80, new Money(400, CurrencyType.EUR)));
        cart.addItem(new Item("Standard", 7, 12, new Money(60, CurrencyType.EUR)));

        // Apply updates and discounts
        int daysToSimulate = 5;
        simulateDays(cart, daysToSimulate);

        // Display individual prices in selected currency
        displayIndividualPrices(cart, CurrencyType.USD);

        // Calculate total price after discounts in selected currency
        double totalAfterDiscount = cart.applyDiscounts(discounts);
        Money totalInUSD = cart.calculateTotalPrice(CurrencyType.USD);
        System.out.println("Total After Discounts in USD: " + totalInUSD);
    }

    private static void simulateDays(Cart cart, int days) {
        for (int day = 0; day < days; day++) {
            System.out.println("Day " + day + ":");
            updateAndDisplayItems(cart.getItems());
            System.out.println();
        }
    }

    private static void updateAndDisplayItems(List<Item> items) {
        for (Item item : items) {
            ItemUpdater updater = ItemUpdaterFactory.getUpdater(item.getName());
            updater.update(item);
            displayItem(item);
        }
    }

    private static void displayIndividualPrices(Cart cart, CurrencyType currency) {
        System.out.println("Individual Prices in " + currency + ":");
        for (Item item : cart.getItems()) {
            Money convertedPrice = CurrencyConverterService.convert(item.getPrice(), currency);
            System.out.println(item.getName() + " - " + convertedPrice);
        }
    }

    private static void displayItem(Item item) {
        System.out.println(item.getName() + " - Sell In: " + item.getSellIn() +
                ", Quality: " + item.getQuality() + ", Price: " + item.getPrice());
    }
}