package com.saucedemo.utilities.ui.components.common;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ErrorMessageContainer {

    public static final Target ERROR_MESSAGE = Target.the("the error message").located(By.cssSelector("h3[data-test='error']"));
}
