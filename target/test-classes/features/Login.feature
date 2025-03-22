Feature: Login Functionality

  Scenario Outline: Login with different credentials
    Given the user is on the login page
    When the user logs in with "<email>" and "<password>"
    And clicks on the login button
    Then the user should be redirected to the account dashboard if credentials are valid

    Examples:
    | email                  | password       |
    | validuser@example.com  | validpassword |
    | invalid@example.com    | wrongpassword |
    |                        | password123   |
    | testuser@example.com   |               |