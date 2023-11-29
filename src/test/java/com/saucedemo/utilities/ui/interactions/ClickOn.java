package com.saucedemo.utilities.ui.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ClickOn {

    public ClickOn() {}

    public static Performable the(String cssOrXpathForElement) {
        return Task.where(
                "{0} clicks on element located by" + cssOrXpathForElement,
                SilentTask.where(
                        WaitUntil.the(cssOrXpathForElement, isVisible()),
                        WaitUntil.the(cssOrXpathForElement, isClickable()),
                        Click.on(cssOrXpathForElement)
                )
        );
    }

    public static Performable the(By locator) {
        return Task.where(
                "{0} clicks on element located " + locator,
                SilentTask.where(
                        WaitUntil.the(locator, isVisible()),
                        WaitUntil.the(locator, isClickable()),
                        Click.on(locator)
                )
        );
    }

    public static Performable the(Target target) {
        return Task.where(
                "{0} clicks on the " + target,
                SilentTask.where(
                        WaitUntil.the(target, isVisible()),
                        WaitUntil.the(target, isClickable()),
                        Click.on(target)
                )
        );
    }

    public static Performable the(WebElementFacade element) {
        return Task.where(
                "{0} clicks on " + element,
                SilentTask.where(
                        WaitUntil.the(ExpectedConditions.visibilityOf(element)),
                        WaitUntil.the(ExpectedConditions.elementToBeClickable(element)),
                        Click.on(element)
                )
        );
    }
}
