Feature: Search Functionality

  Scenario: Search for an existing product
    Given is on the homepage
    When the user searches for a product with keyword "iPhone"
    Then relevant products should be displayed

  Scenario: Search for a non-existing product
    Given the user is on the homepage
    When the user searches for a product with keyword "NonExistentProduct123"
    Then a no results message should be displayed
