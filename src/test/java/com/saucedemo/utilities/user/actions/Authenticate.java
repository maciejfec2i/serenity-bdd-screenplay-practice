package com.saucedemo.utilities.user.actions;

import com.saucedemo.utilities.ui.interactions.OpenBrowser;
import com.saucedemo.utilities.ui.pages.LoginPage;
import com.saucedemo.utilities.ui.interactions.ClickOn;
import com.saucedemo.utilities.ui.interactions.Input;
import com.saucedemo.utilities.user.Credentials;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class Authenticate {

    public static Performable viaTheUI() {
        return Task.where(
                "{0} authenticates via the UI",
                actor -> {
                    Credentials credentials = actor.recall("credentials");
                    actor.attemptsTo(
                            OpenBrowser.on(new LoginPage()),
                            Input.theValue(credentials.getUsername()).into(LoginPage.USERNAME_FIELD),
                            Input.theValue(credentials.getPassword()).into(LoginPage.PASSWORD_FIELD),
                            ClickOn.the(LoginPage.LOGIN_BUTTON)
                    );
                }
        );
    }
}
