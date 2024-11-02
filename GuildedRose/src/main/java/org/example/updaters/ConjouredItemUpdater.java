package org.example.updaters;

import org.example.Item;

public class ConjouredItemUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        item.sellIn--;

        item.quality -= 2;
        item.price -= 2;

        if (item.sellIn < 0) {
            item.quality -= 2;
            item.price -= 2;
        }

        if (item.quality < 0) {
            item.quality = 0;
        }
    }
}
