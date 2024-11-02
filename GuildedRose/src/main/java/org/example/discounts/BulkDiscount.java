package org.example.discounts;

public class BulkDiscount implements Discount {
    public double threshold;
    public double discountAmount;

    public BulkDiscount(double threshold, double discountAmount) {
        this.threshold = threshold;
        this.discountAmount = discountAmount;
    }

    @Override
    public double calculateDiscountAmount(double totalPrice) {
        return totalPrice >= threshold ? discountAmount : 0;
    }
}


