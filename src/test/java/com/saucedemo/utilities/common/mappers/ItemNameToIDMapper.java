package com.saucedemo.utilities.common.mappers;

import java.util.Map;

public class ItemNameToIDMapper {

    private static Map<String, String> namesAndIds = Map.of(
            "sauce labs bike light", "0",
            "sauce labs bolt t-shirt", "1",
            "sauce labs onesie", "2",
            "test.allthethings() t-shirt", "3",
            "test.allthethings() t-shirt (red)", "3",
            "sauce labs backpack", "4",
            "sauce labs fleece jacket", "5"
    );

    public static String[] map(String... itemNames) {
        String[] ids = new String[itemNames.length];

        for(int i = 0; i < itemNames.length; i++) {

            String itemName = itemNames[i];

            if(!(namesAndIds.containsKey(itemName.toLowerCase()))) {
                throw new IllegalArgumentException(itemName + " is not recognised as a valid item within this switch statement");
            }

            ids[i] = namesAndIds.get(itemName.toLowerCase());
        }

        return ids;
    }
}
