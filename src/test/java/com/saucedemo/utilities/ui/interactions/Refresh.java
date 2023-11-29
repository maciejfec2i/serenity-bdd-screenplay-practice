package com.saucedemo.utilities.ui.interactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class Refresh {

    public static Performable thePage() {
        return Task.where(
                "{0} refreshes the page",
                user -> BrowseTheWeb.as(user).getDriver().navigate().refresh()
        );
    }
}
