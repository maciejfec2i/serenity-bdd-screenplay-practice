package com.saucedemo.utilities.ui.components.items;

import net.serenitybdd.screenplay.targets.Target;

public class ItemCard {

    public static final Target FOR_ITEM_WITH_NAME = Target.the("item card for '{0}'").locatedBy(
            "//div[@class='inventory_item_description'][contains(., '{0}')]"
    );

    public static final Target BUTTON_FOR_ITEM_WITH_TEXT = Target.the("'{0}' button on the '{1}' item card")
            .locatedBy(
                    "//div[@class='inventory_item_description'][contains(., '{1}')]//descendant::button[.='{0}'] | //div[@class='cart_item_label'][contains(., '{1}')]//descendant::button[.='{0}']"
            );

    public static final Target INVENTORY_ITEM_NAME = Target.the("inventory item name on item card")
            .locatedBy(".inventory_item_name");
}
