package com.saucedemo.stepdefinitions;

import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import java.util.Map;

public class FormCompletionSteps {

    @When("{user} complete the form with the following details:")
    public void userCompletesAFormUsingTheDataTableDetails(Actor user, Map<String, String> customerDetails) {

    }
}
