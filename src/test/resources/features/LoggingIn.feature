@login @full_suite
Feature: When Logging in to the Swag Labs site

  @login_01 @smoke
  Scenario: A Standard user should be redirected to the Products page
    Given A Standard User attempts to log in to the site
    Then they should be successfully redirected to the Products page

  @login_02
  Scenario: A Locked Out user should see the locked out error message
    Given A Locked Out User attempts to log in to the site
    Then they should see the locked out user error message

  @login_03 @smoke
  Scenario Outline: A user with invalid credentials should see the error message for invalid credentials
    Given A <user> attempts to log in to the site
    Then they should see the invalid credentials error message

    Examples:
      | user                  |
      | Invalid Username User |
      | Invalid Password User |