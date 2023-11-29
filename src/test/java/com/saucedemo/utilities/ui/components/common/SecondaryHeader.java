package com.saucedemo.utilities.ui.components.common;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SecondaryHeader {
    public static final Target TITLE = Target.the("the page title").located(By.cssSelector("span[class='title']"));
}
