package org.example.domain;

import org.example.services.CurrencyConverterService;
import org.example.discounts.Discount;
import org.example.services.DiscountService;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item> items = new ArrayList<>();
    private final DiscountService discountService;

    public Cart(DiscountService discountService) {
        this.discountService = discountService;
    }

    public void addItem(Item item) {
        items.add(item);
        item.setQuantity(item.getQuantity()+1);
    }

    public double applyDiscounts(List<Discount> discounts) {
        return discountService.applyDiscounts(items, discounts);
    }

    public Money calculateTotalPrice(CurrencyType currencyType) {
        double total = 0.0;
        for (Item item : items) {
            Money convertedPrice = CurrencyConverterService.convert(item.getPrice(), currencyType);
            total += convertedPrice.getAmount();
        }
        return new Money(total, currencyType);
    }

    public List<Item> getItems() {
        return items;
    }
}
