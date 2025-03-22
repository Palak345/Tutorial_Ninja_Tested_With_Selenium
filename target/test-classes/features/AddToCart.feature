Feature: Add to Cart Functionality

  Scenario: User adds a product to the cart
    Given the user is on the homepage
    When the user searches for "MacBook"
    And the user selects the product from search results
    And clicks on the add to cart button
    Then the product should be added to the cart successfully

  Scenario: User searches for a non-existing product
    Given the user is on the homepage
    When the user searches for a non-existing product "InvalidProduct123"
    Then no product should be displayed

  Scenario: User tries to open cart without adding any product
    Given the user is on the homepage
    When the user opens the cart without adding any product
    Then the cart should be empty
