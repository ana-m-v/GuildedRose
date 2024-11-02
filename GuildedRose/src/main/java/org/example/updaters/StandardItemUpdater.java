package org.example.updaters;

import org.example.Item;

public class StandardItemUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        item.sellIn--;
        if(item.quality < 0) {
            item.quality = 0;
            item.price = 0;
        }
        if (item.quality > 0) {
            item.quality--;
            item.price--;
        }
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--;
            item.price--;
        }
    }
}
