Feature: Main Page Navigation and Footer Links

  Scenario: Verify main navigation links are visible and clickable
    Given the user is on the home page
    Then all main navigation links should be visible and clickable

  Scenario: Verify footer links are visible and clickable
    Given the user is on the home page
    Then all footer links should be visible and clickable
    Then the site logo should be visible and clickable
    Then close the browser