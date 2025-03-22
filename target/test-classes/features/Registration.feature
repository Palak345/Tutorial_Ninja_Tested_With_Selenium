Feature: Registration Functionality

  Scenario: User registers successfully
    Given the user is on the registration page
    When the user enters valid registration details
    Then the user should be registered successfully

  Scenario: User enters mismatched passwords
    Given the user is on the registration page
    When the user enters mismatched passwords
    Then registration error message should be displayed

  Scenario: User does not agree to terms
    Given the user is on the registration page
    When the user does not agree to terms
    Then a terms agreement error message should be displayed
