Feature: Multi-Currency Functionality

  Scenario Outline: Change currency on the website
    Given theee user is on the homepage
    When the user selects "<currency>" currency
    Then the currency should change to "<symbol>"

    Examples:
      | currency  | symbol |
      | Euro      | €     |
      | Pound     | £     |
      | Dollar    | $     |
