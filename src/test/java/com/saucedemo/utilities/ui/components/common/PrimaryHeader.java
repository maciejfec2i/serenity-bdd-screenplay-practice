package com.saucedemo.utilities.ui.components.common;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PrimaryHeader {

    public static final Target CART_ICON = Target.the("Cart Icon").locatedBy("#shopping_cart_container");
    public static final Target CART_ITEM_COUNT_BADGE = Target.the("Cart Item Count Badge").locatedBy(".shopping_cart_badge");
}
