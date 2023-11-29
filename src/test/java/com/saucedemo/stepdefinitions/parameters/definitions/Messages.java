package com.saucedemo.stepdefinitions.parameters.definitions;

import com.saucedemo.utilities.data.messages.Errors;
import io.cucumber.java.ParameterType;

public class Messages {

    @ParameterType(".*")
    public Errors error(String errorName) {
        return Errors.valueOf(errorName.replace(" ", "_").toUpperCase());
    }
}
