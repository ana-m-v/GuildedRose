package org.example.updaters;

import java.util.HashMap;
import java.util.Map;

public class ItemUpdaterFactory {
    private static final Map<String, ItemUpdater> updaterMap = new HashMap<>();

    static {
        updaterMap.put("Aged Brie", new AgedBrieUpdater());
        updaterMap.put("Conjured", new ConjouredItemUpdater());
        updaterMap.put("Sulfuras", new SulfurasUpdater());
        updaterMap.put("Standard", new StandardItemUpdater());
    }

    public static ItemUpdater getUpdater(String itemName) {
        return updaterMap.getOrDefault(itemName, new StandardItemUpdater());
    }
}

