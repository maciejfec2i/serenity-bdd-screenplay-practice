package com.saucedemo.utilities.ui.pages.checkout;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("/checkout-complete.html")
public class CheckoutCompletePage extends PageObject  {

    public static final Target BACK_HOME_BUTTON = Target.the("back to home button").located(By.cssSelector("button[id='back-to-products']"));
}
