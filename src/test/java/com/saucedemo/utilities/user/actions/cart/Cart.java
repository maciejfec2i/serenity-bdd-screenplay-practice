package com.saucedemo.utilities.user.actions.cart;

import com.saucedemo.utilities.common.mappers.ItemNameToIDMapper;
import com.saucedemo.utilities.ui.components.items.ItemCard;
import com.saucedemo.utilities.ui.interactions.ClickOn;
import com.saucedemo.utilities.ui.interactions.ExecuteJavaScript;
import com.saucedemo.utilities.ui.interactions.Refresh;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.RememberThat;
import net.serenitybdd.screenplay.Task;

import java.util.Arrays;

public class Cart {

    private String manipulationMethod;

    public Cart() {}

    public Cart(String manipulationMethod) {
        this.manipulationMethod = manipulationMethod;
    }

    public static Cart usingTheUI() {
        return new Cart("ui");
    }

    public static Cart usingJavaScript() {
        return new Cart("js");
    }

    public Performable addItemsCalled(String... itemNames) {
        return Task.where(
                "{0} adds the following items to the cart: " + String.join(", ", itemNames),
                user -> {
                    if(manipulationMethod.equals("ui")) {
                        for(String itemName : itemNames) {
                            user.attemptsTo(
                                    ClickOn.the(ItemCard.BUTTON_FOR_ITEM_WITH_TEXT.of("Add to cart", itemName)),
                                    RememberThat.theValueOf("itemsAddedToCart").is(itemNames)
                            );
                        }
                    }
                    if(manipulationMethod.equals("js")) {
                        String itemNamesAsIDs = Arrays.toString(ItemNameToIDMapper.map(itemNames));
                        String script = String.format("localStorage.setItem('cart-contents', '%s');", itemNamesAsIDs);
                        user.attemptsTo(
                                ExecuteJavaScript.script(script),
                                Refresh.thePage(),
                                RememberThat.theValueOf("itemsAddedToCart").is(itemNames)
                        );
                    }
                }
        );
    }

    public Performable removeActionsCalled(String... itemNames) {
        /*
        localStorage.setItem('cart-contents', JSON.stringify(JSON.parse(localStorage.getItem('cart-contents')).filter(n => !JSON.parse('[1]').includes(n))));
         */
        return Task.where(
                "{0} removes the following items from the cart: " + String.join(", ", itemNames),
                user -> {
                    if(manipulationMethod.equals("ui")) {
                        for(String itemName : itemNames) {
                            user.attemptsTo(
                                    ClickOn.the(ItemCard.BUTTON_FOR_ITEM_WITH_TEXT.of("Remove", itemName)),
                                    RememberThat.theValueOf("itemsRemovedFromCart").is(itemNames)
                            );
                        }
                    }
                    if(manipulationMethod.equals("js")) {
                        String itemNamesAsIDs = Arrays.toString(ItemNameToIDMapper.map(itemNames));
                        String script = String.format("localStorage.setItem('cart-contents', JSON.stringify(JSON.parse(localStorage.getItem('cart-contents')).filter(n => !JSON.parse('%s').includes(n))));", itemNamesAsIDs);
                        user.attemptsTo(
                                ExecuteJavaScript.script(script),
                                Refresh.thePage(),
                                RememberThat.theValueOf("itemsAddedToCart").is(itemNames)
                        );
                    }
                }
        );
    }
}
