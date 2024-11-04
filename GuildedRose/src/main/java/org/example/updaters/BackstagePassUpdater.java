package org.example.updaters;

import org.example.domain.Item;

public class BackstagePassUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
            item.price.setAmount(0);
            return;
        }

        if (item.quality < 50) {
            item.quality++;

            if (item.sellIn < 5 && item.quality < 50) {
                item.quality++;
                item.price.increaseAmount(1);
            }

            if (item.sellIn < 10 && item.quality < 50) {
                item.quality++;
                item.price.increaseAmount(1);
            }
        }
    }
}
