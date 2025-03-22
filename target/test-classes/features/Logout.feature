Feature: Logout Functionality

  Scenario: User successfully logs out
    Given the user is logged into their account
    When the user clicks on the logout button
    Then the user should be logged out and see the logout confirmation message
