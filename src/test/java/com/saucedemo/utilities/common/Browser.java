package com.saucedemo.utilities.common;

import net.serenitybdd.core.Serenity;

public class Browser {

    public static String currentUrl() {
        if(Serenity.getDriver() == null) return "";
        return Serenity.getDriver().getCurrentUrl();
    }
}
