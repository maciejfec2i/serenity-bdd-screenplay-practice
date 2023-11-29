package com.saucedemo.utilities.ui.interactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ExecuteJavaScript {

    public static Performable script(String script) {
        return Task.where(
                "{0} executes the following JavaScript script:\n " + script,
                user -> BrowseTheWeb.as(user).evaluateJavascript(script)
        );
    }
}
