@regression
Feature: Test login functionality

  Scenario: Check login is successful using valid credentials
    Given browser is open
    And user is on login page
    When user enters email address and password
    And clicks on sign in button
    Then user is navigated to the portfolio page
