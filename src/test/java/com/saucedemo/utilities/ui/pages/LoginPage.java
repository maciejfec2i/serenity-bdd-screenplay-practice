package com.saucedemo.utilities.ui.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("/")
public class LoginPage extends PageObject {

    public static final Target USERNAME_FIELD = Target.the("Username Field").located(By.cssSelector("input[data-test='username']"));
    public static final Target PASSWORD_FIELD = Target.the("Password Field").located(By.cssSelector("input[data-test='password']"));
    public static final Target LOGIN_BUTTON = Target.the("Login Button").located(By.cssSelector("input[data-test='login-button']"));
}
