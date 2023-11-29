package com.saucedemo.stepdefinitions;

import com.saucedemo.utilities.ui.interactions.OpenBrowser;
import com.saucedemo.utilities.user.actions.Authenticate;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;

public class LoginSteps {

    @And("A {user} attempts to log in to the site")
    public void userAttemptsToLoginToTheSite(Actor user) {
        user.attemptsTo(
                Authenticate.viaTheUI()
        );
    }

    @Given("A {user} is logged in and on the {page} page")
    public void userIsLoggedInAndOnTheInitialPage(Actor user, PageObject initialPage) {
        user.attemptsTo(
                Authenticate.viaTheUI(),
                OpenBrowser.on(initialPage)
        );
    }
}
