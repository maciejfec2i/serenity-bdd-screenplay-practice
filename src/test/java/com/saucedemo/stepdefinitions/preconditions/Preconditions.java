package com.saucedemo.stepdefinitions.preconditions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Preconditions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
}
