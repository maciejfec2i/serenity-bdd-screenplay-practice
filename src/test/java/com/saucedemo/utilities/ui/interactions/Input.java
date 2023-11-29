package com.saucedemo.utilities.ui.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.SilentTask;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Input {

    private String value;

    public Input() {}

    public Input(String value) {
        this.value = value;
    }

    public static Input theValue(String value) {
        return new Input(value);
    }

    public Performable into(String cssOrXpathForElement) {
        return Task.where(
                "{0} enters the value '" + this.value + "' into element located by" + cssOrXpathForElement,
                SilentTask.where(
                        WaitUntil.the(cssOrXpathForElement, isVisible()),
                        WaitUntil.the(cssOrXpathForElement, isClickable()),
                        Enter.theValue(this.value).into(cssOrXpathForElement)
                )
        );
    }

    public Performable into(By locator) {
        return Task.where(
                "{0} enters the value '" + this.value + "' into element located " + locator,
                SilentTask.where(
                        WaitUntil.the(locator, isVisible()),
                        WaitUntil.the(locator, isClickable()),
                        Enter.theValue(this.value).into(locator)
                )
        );
    }

    public Performable into(Target target) {
        return Task.where(
                "{0} enters the value '" + this.value + "' into the " + target,
                SilentTask.where(
                        WaitUntil.the(target, isVisible()),
                        WaitUntil.the(target, isClickable()),
                        Enter.theValue(this.value).into(target)
                )
        );
    }

    public Performable into(WebElementFacade element) {
        return Task.where(
                "{0} enters the value '"+ this.value + "' into " + element,
                SilentTask.where(
                        WaitUntil.the(ExpectedConditions.visibilityOf(element)),
                        WaitUntil.the(ExpectedConditions.elementToBeClickable(element)),
                        Enter.theValue(this.value).into(element)
                )
        );
    }
}
