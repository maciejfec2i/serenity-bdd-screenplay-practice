package com.saucedemo.utilities.ui.components.common;

import net.serenitybdd.screenplay.targets.Target;

public class Button {

    public final static Target WITH_TEXT = Target.the("'{0}' button").locatedBy("//button[. = '{0}'] | //input[@type='submit'][@value = '{0}']");
}
