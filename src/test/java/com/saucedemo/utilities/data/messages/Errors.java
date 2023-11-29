package com.saucedemo.utilities.data.messages;

public enum Errors {

    LOCKED_OUT_USER("Sorry, this user has been locked out"),
    INVALID_CREDENTIALS("Username and password do not match any user in this service"),
    FIRST_NAME_REQUIRED("First Name is required");

    private String errorMessage;

    Errors(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String message() {
        return this.errorMessage;
    }
}
