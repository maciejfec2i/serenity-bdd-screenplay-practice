package com.saucedemo.stepdefinitions;

import com.saucedemo.utilities.data.messages.Errors;
import com.saucedemo.utilities.ui.components.common.ErrorMessageContainer;
import com.saucedemo.utilities.ui.components.common.PrimaryHeader;
import com.saucedemo.utilities.ui.components.common.SecondaryHeader;
import com.saucedemo.utilities.ui.components.items.ItemCard;
import com.saucedemo.utilities.ui.interactions.OpenBrowser;
import com.saucedemo.utilities.ui.pages.YourCartPage;
import com.saucedemo.utilities.user.questions.items.Items;
import com.saucedemo.utilities.user.questions.common.TextOf;
import com.saucedemo.utilities.user.questions.items.NumberOfItems;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

public class VerificationSteps {

    @Then("{user} should be successfully redirected to the {pageTitle} page")
    public void userShouldBeSuccessfullyRedirectedToExpectedPage(Actor user, String expectedPageTitle) {
        user.attemptsTo(
                Ensure.that(TextOf.the(SecondaryHeader.TITLE)).isEqualToIgnoringCase(expectedPageTitle)
        );
    }

    @Then("{user} should see the {error} error message")
    public void userShouldSeeTheCorrectErrorMessage(Actor user, Errors expectedError) {
        user.attemptsTo(
                Ensure.that(TextOf.the(ErrorMessageContainer.ERROR_MESSAGE)).containsIgnoringCase(expectedError.message())
        );
    }

    @Then("the {string} button should be displayed for the following item(s): {items}")
    public void theCorrectButtonShouldBeDisplayedForListedItems(String buttonText, String[] itemNames) {
        for(String itemName : itemNames) {
            OnStage.theActorInTheSpotlight().attemptsTo(
                    Ensure.that(ItemCard.BUTTON_FOR_ITEM_WITH_TEXT.of(buttonText, itemName)).isDisplayed()
            );
        }
    }

    @Then("the cart badge should display that the cart contains {int} items")
    public void theCartBadgeShouldDisplayThatTheCartContainsTheCorrectNumberOfItems(int expectedNumberOfItems) {
        Performable[] performVerifications = expectedNumberOfItems == 0 ?
                new Performable[] {Ensure.that(PrimaryHeader.CART_ITEM_COUNT_BADGE).isNotDisplayed()} :
                new Performable[] {
                        Ensure.that(PrimaryHeader.CART_ITEM_COUNT_BADGE).isDisplayed(),
                        Ensure.that(TextOf.the(PrimaryHeader.CART_ITEM_COUNT_BADGE).asInteger()).isEqualTo(expectedNumberOfItems)
                };

        OnStage.theActorInTheSpotlight().attemptsTo(performVerifications);

    }

    @Then("the items should be displayed on the {page} page")
    public void theItemsShouldBeDisplayedOnTheAppropriatePage(PageObject page) {
        String[] itemsAddedToCart = OnStage.theActorInTheSpotlight().recall("itemsAddedToCart");

        OnStage.theActorInTheSpotlight().attemptsTo(
                OpenBrowser.on(page),
                Ensure.that(Items.inCart()).containsExactlyInAnyOrder(itemsAddedToCart)
        );
    }

    @Then("the cart should contain {int} items")
    public void theCartShouldContainTheCorrectNumberOfItems(int expectedNumberOfItems) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                OpenBrowser.on(new YourCartPage()),
                Ensure.that(NumberOfItems.inCart()).isEqualTo(expectedNumberOfItems)
        );
    }

    @Then("the following items should no longer be displayed on the {page} page: {items}")
    public void removedItemsShouldNoLongerBeInTheCart(PageObject page, String[] removedItems) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                OpenBrowser.on(page),
                Ensure.that(Items.inCart()).doesNotContain(removedItems)
        );
    }
}
