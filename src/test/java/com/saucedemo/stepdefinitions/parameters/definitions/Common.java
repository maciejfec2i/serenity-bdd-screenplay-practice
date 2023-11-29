package com.saucedemo.stepdefinitions.parameters.definitions;

import com.saucedemo.utilities.common.factories.PageFactory;
import com.saucedemo.utilities.user.Credentials;
import io.cucumber.java.ParameterType;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.Arrays;
import java.util.List;

public class Common {

    @ParameterType(".*")
    public Actor user(String userName) {
        List<String> pronouns = Arrays.asList("he", "she", "they", "it", "his", "her", "their", "its");

        if(pronouns.contains(userName.toLowerCase())) {
            return OnStage.theActorInTheSpotlight();
        }

        Actor actor = OnStage.theActorCalled(userName);
        actor.remember("credentials", Credentials.valueOf(userName.replace(" ", "_").toUpperCase()));
        return actor;
    }

    @ParameterType(".*")
    public PageObject page(String pageName) {
        return PageFactory.getPage(pageName);
    }

    @ParameterType(".*")
    public String pageTitle(String pageTitle) {
        return pageTitle;
    }

    @ParameterType(".*")
    public String[] items(String items) {
        return items.split(", ");
    }
}
