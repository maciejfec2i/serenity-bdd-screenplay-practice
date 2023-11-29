package com.saucedemo.stepdefinitions;

import com.saucedemo.utilities.ui.interactions.ClickOn;
import com.saucedemo.utilities.ui.interactions.OpenBrowser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

public class NavigationSteps {

    @When("{user} decide to {navigationAction}")
    public void userDecidesToPerformAnAction(Actor user, Target target) {
        user.attemptsTo(
                ClickOn.the(target)
        );
    }

    @And("{user} are on the {page} page")
    public void userIsOnTheDesiredPage(Actor user, PageObject page) {
        user.attemptsTo(
                OpenBrowser.on(page)
        );
    }
}
