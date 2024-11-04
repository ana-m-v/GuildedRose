package org.example.discounts;

import org.example.domain.Item;

import java.util.List;

public class BulkDiscount implements Discount {
    public double threshold;
    public double discountAmount;

    public BulkDiscount(double threshold, double discountAmount) {
        this.threshold = threshold;
        this.discountAmount = discountAmount;
    }


    @Override
    public double apply(double total, List<Item> items) {
        // Calculate the total quantity of items in the cart
        long itemCount = items.stream().mapToInt(Item::getQuantity).sum();

        // If the total quantity meets or exceeds the threshold, apply the discount
        if (itemCount >= threshold) {
            return total - discountAmount;
        }
        // Otherwise, return the original total without any bulk discount
        return total;    }
}


