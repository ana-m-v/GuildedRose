package org.example.discounts;

public class PercentageDiscount implements Discount {
    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double calculateDiscountAmount(double totalPrice) {
        return (totalPrice * percentage) / 100;
    }
}


