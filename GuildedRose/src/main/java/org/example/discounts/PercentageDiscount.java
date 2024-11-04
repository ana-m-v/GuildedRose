package org.example.discounts;

import org.example.domain.Item;

import java.util.List;

public class PercentageDiscount implements Discount {
    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double apply(double total, List<Item> items) {
        return total - (total * (percentage / 100.0));
    }
}


