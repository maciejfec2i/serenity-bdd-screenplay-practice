package com.saucedemo.stepdefinitions.parameters.definitions;

import com.saucedemo.utilities.ui.components.common.Button;
import com.saucedemo.utilities.ui.components.common.PrimaryHeader;
import com.saucedemo.utilities.ui.components.items.ItemCard;
import com.saucedemo.utilities.ui.pages.checkout.CheckoutCompletePage;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.targets.Target;
import org.apache.commons.text.WordUtils;

public class Actions {

    @ParameterType(".*")
    public Target navigationAction(String action) {

        switch(action.toLowerCase()) {
            case "view shopping cart":
                return PrimaryHeader.CART_ICON;
            case "continue shopping":
            case "checkout":
            case "cancel":
            case "continue":
            case "finish":
                return Button.WITH_TEXT.of(action);
            case "return back home":
                return CheckoutCompletePage.BACK_HOME_BUTTON;
            default: throw new IllegalArgumentException(action + " is not a valid action. Please specify a valid action");
        }
    }
}
