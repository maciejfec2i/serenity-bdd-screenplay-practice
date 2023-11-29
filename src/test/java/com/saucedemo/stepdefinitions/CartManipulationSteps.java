package com.saucedemo.stepdefinitions;

import com.saucedemo.utilities.user.actions.cart.Cart;
import com.saucedemo.utilities.user.actions.Authenticate;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

import java.util.Map;

public class CartManipulationSteps {

    @And("{user} {} the following item(s) to/from the cart: {items}")
    public void userAddsOrRemovesTheFollowingItems(Actor user, String desiredAction, String[] itemNames) {

        Map<String, Performable> performCartManipulationAction = Map.of(
                "add", Cart.usingTheUI().addItemsCalled(itemNames),
                "remove", Cart.usingTheUI().removeActionsCalled(itemNames)
        );

        desiredAction = desiredAction.toLowerCase();

        if(!performCartManipulationAction.containsKey(desiredAction)) {
            throw new IllegalArgumentException(desiredAction + " is not a valid action. Please pass in add or remove");
        }

        user.attemptsTo(
                performCartManipulationAction.get(desiredAction)
        );
    }

    /**
     * This is an Arrange step. It logs the user in and adds the specified items to cart using JavaScript to avoid
     * unnecessary UI interactions.
     * <br><br>
     * The step definition used 2 custom parameter types:
     * <br>
     * - user {@link com.saucedemo.stepdefinitions.parameters.definitions.Common#user(String)}
     * <br>
     * - items {@link  com.saucedemo.stepdefinitions.parameters.definitions.Common#items(String)}
     *
     * @param user Actor performing the actions
     * @param itemNames List of item names to be added to the cart
     * @author Maciej Fec
     * @version 16/11/2023
     */
    @Given("A {user} has the following item(s) in the cart: {items}")
    public void userIsLoggedInAndHasTheExpectedItemsInCart(Actor user, String[] itemNames) {
        user.attemptsTo(
                Authenticate.viaTheUI(),
                Cart.usingJavaScript().addItemsCalled(itemNames)
        );
    }
}
