package org.example.services;

import org.example.discounts.Discount;
import org.example.domain.Item;

import java.util.List;

public class DiscountService {
    public double applyDiscounts(List<Item> items, List<Discount> discounts) {
        double total = items.stream().mapToDouble(item -> item.getPrice().getAmount()).sum();

        // Apply each discount to the total price
        for (Discount discount : discounts) {
            total = discount.apply(total, items);
        }

        return total;
    }
}
