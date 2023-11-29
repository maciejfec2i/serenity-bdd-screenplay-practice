package com.saucedemo.utilities.user;

public enum Credentials {

    STANDARD_USER("standard_user", "secret_sauce"),
    LOCKED_OUT_USER("locked_out_user", "secret_sauce"),
    INVALID_USERNAME_USER("invalid_username", "secret_sauce"),
    INVALID_PASSWORD_USER("standard_user", "invalid_password");

    private String username;
    private String password;

    Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
