Feature: When viewing the 'Checkout: Overview' page with items in the cart

  Scenario Outline: The 'Item total' amount should add up to the sum of each item multipled by its quantity
    Given A Standard User has the following items in the cart: <items-to-add>
    When they view the Checkout: Overview page
    Then The "Item total" amount should equal to the sum of each item multipled by its quantity

    Examples:
      | items                                                                                   |
      | Sauce Labs Bike Light, Sauce Labs Fleece Jacket, Test.allTheThings() T-Shirt            |
      | Sauce Labs Backpack, Sauce Labs Onesie, Sauce Labs Bike Light, Sauce Labs Fleece Jacket |

  Scenario Outline: The 'Tax' amount should add up to the current taxable percentage of the 'Item total' amount
    Given A Standard User has the following items in the cart: <items-to-add>
    When they view the Checkout: Overview page
    Then The "Tax" amount should equal to the current taxable percentage of the "Item total" amount

    Examples:
      | items                                                                                   |
      | Sauce Labs Bike Light, Sauce Labs Fleece Jacket, Test.allTheThings() T-Shirt            |
      | Sauce Labs Backpack, Sauce Labs Onesie, Sauce Labs Bike Light, Sauce Labs Fleece Jacket |

  Scenario Outline: The 'Total' amount should add up to the 'Item total' and 'Tax' amounts combined
    Given A Standard User has the following items in the cart: <items>
    When they view the Checkout: Overview page
    Then The "Total" amount should equal to the "Item total" and "Tax" amounts combined

    Examples:
      | items                                                                                   |
      | Sauce Labs Bike Light, Sauce Labs Fleece Jacket, Test.allTheThings() T-Shirt            |
      | Sauce Labs Backpack, Sauce Labs Onesie, Sauce Labs Bike Light, Sauce Labs Fleece Jacket |