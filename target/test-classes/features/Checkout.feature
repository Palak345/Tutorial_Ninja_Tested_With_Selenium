Feature: Checkout Functionality

    
  Scenario: Attempting to checkout with an empty cart
    Given the user is on the shopping cart page with an empty cart
    When the user attempts to proceed to checkout without adding any product
    Then an error message should be displayed preventing checkout
 
 