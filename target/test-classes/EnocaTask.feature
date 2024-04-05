@run
Feature: Enoca Task

  Scenario: Enoca Task
    Given User navigates to the lee.com.tr website.
    And Rejects cookies.
    And Login with valid email and password values.
    When Navigates to the cart and checks is there any product and clears it if there is.
    And Randomly selects one of the Jeans, Women, Men categories.
    And On the product page, selects the order as ascending by price.
    And Selects first product.
    And Randomly selects one of the size options on the product detail page that opens, adds the product to the cart and goes to the cart.
    And Selects the I want gift wrapping option.
    Then Enters a random code to the promotion code field and verifies that the error message appears.
    When Clicks on the buy button.
    And Adds new address on delivery information page and proceeds.
    Then Enters invalid credit card information and clicks complete order button. Verifies that the error message appears.
    When Navigates to the cart again.
    Then Increases the quantity of product by one and verifies that the quantity increased.
    And Logout successfully and closes browser.