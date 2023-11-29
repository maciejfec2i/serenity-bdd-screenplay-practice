@navigation @full_suite
Feature: When navigating to a specific page

  @navigation_01 @smoke
  Scenario Outline: A Standard User should be successfully redirected to the expected page
    Given A Standard User is logged in and on the <initial> page
    When they decide to <do-action>
    Then they should be successfully redirected to the <expected> page

    Examples:
      | initial                    | do-action                | expected                   |
      | Products                   | View Shopping Cart       | Your Cart                  |
      | Your Cart                  | Continue Shopping        | Products                   |
      | Your Cart                  | Checkout                 | Checkout: Your Information |
      | Checkout: Your Information | Cancel                   | Your Cart                  |
      | Checkout: Overview         | Cancel                   | Products                   |
      | Checkout: Overview         | Finish                   | Checkout: Complete!        |
      | Checkout: Complete!        | Return Back Home         | Products                   |