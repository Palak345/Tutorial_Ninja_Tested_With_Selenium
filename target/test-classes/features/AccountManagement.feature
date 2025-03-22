Feature: Account Management

  Scenario Outline: Verify Account Management Functionality
    Given the user is logged in and on the profile page
    When the user clicks on the profile dropdown
    And selects My Account
    And edits the account information
    And modifies the first name to "<newName>"
    Then clicks the continue button

    Examples:
      | newName       |
      | Pall          |
      | Palakkk         |
      | TestUser      |
