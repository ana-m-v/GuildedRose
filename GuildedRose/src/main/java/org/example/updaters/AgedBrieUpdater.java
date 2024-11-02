package org.example.updaters;

import org.example.Item;

public class AgedBrieUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        item.sellIn--;
        if (item.quality < 50) {
            item.quality++;
            item.price++;
        }
    }
}
