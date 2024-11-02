package org.example;

import org.example.discounts.BulkDiscount;
import org.example.discounts.PercentageDiscount;
import org.example.updaters.ItemUpdater;
import org.example.updaters.ItemUpdaterFactory;

import java.util.ArrayList;
import java.util.List;

class Cart {
    private List<Item> items = new ArrayList<>();
    private PercentageDiscount percentageDiscount;
    private BulkDiscount bulkDiscount;

    public void setPercentageDiscount(PercentageDiscount discount) {
        this.percentageDiscount = discount;
    }

    public void setBulkDiscount(BulkDiscount bulkDiscount) {
        this.bulkDiscount = bulkDiscount;
    }

    public void addItem(String name, int sellIn, int quality, int price, CurrencyType currency) {
        Item item = new Item(name, sellIn, quality, price, currency);
        items.add(item);
    }

    public void simulateDays(int days) {
        for (int day = 0; day < days; day++) {
            System.out.println("Day " + day + ":");
            updateAndDisplayItems();
            printTotals();
            System.out.println();
        }
    }

    private void updateAndDisplayItems() {
        for (Item item : items) {
            ItemUpdater updater = ItemUpdaterFactory.getUpdater(item.name);
            updater.update(item);
            item.display();
        }
    }


    private void printTotals() {
        int totalBeforeDiscount = calculateTotalBeforeDiscount();
        int discountAmount = calculateDiscountAmount(totalBeforeDiscount);
        int totalAfterDiscount = totalBeforeDiscount - discountAmount;

        System.out.println("Total Before Discount: " + totalBeforeDiscount);
        System.out.println("Discount Amount: " + discountAmount);
        System.out.println("Total After Discount: " + totalAfterDiscount);
    }

    private int calculateTotalBeforeDiscount() {
        int total = 0;
        for (Item item : items) {
            total += item.price; // Assumes price is the total price for each item
        }
        return total;
    }

    private int calculateDiscountAmount(int totalBeforeDiscount) {
        int discountAmount = 0;
        int totalItems = items.size();

        // Apply Percentage Discount if available
        if (percentageDiscount != null) {
            discountAmount += percentageDiscount.calculateDiscountAmount(totalBeforeDiscount);
        }

        // Apply Bulk Discount if available and total items exceed threshold
        if (bulkDiscount != null && totalItems >= bulkDiscount.threshold) {
            discountAmount += bulkDiscount.discountAmount;
        }

        return discountAmount;
    }
}


