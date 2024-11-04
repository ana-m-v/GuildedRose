package org.example.discounts;

import org.example.domain.Item;

import java.util.List;

public interface Discount {
    double apply(double total, List<Item> items);
}

