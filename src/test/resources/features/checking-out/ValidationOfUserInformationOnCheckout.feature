@checkout_form_validation
Feature: When attempting to 'Continue' with the Checkout process from the 'Checkout: Your Information' page

  @checkout_form_validation_01
  Scenario: A Standard User who has not filled in any form fields should see the correct error message
    Given A Standard User is logged in and on the Checkout: Your Information page
    When they decide to Continue
    Then they should see the first name required error message

  @checkout_form_validation_02 @smoke
  Scenario Outline: A Standard User who has not completed some form fields should see the correct error message
    Given A Standard User is logged in and on the Checkout: Your Information page
    When they complete the form with the following details:
      | First Name | <first-name> |
      | Last Name  | <last-name>  |
      | Post Code  | <post-code>  |
    And they decide to Continue
    Then they should see the <expected-error> error message

    Examples:
      | first-name | last-name | post-code | expected-error      |
      | [blank]    | Carrol    | SE14 6DU  | first name required |
      | Robert     | [blank]   | SE14 6DU  | last name required  |
      | Robert     | Carrol    | [blank]   | post code required  |
