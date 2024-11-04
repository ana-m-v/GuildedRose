package org.example.repositories;

import org.example.domain.Item;

import java.util.List;

public interface ItemRepository {
    void save(Item item);
    List<Item> findAll();
}
