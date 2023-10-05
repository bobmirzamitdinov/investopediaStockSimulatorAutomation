Feature: Test login functionality

  Scenario: Check login is successful using valid credentials
    Given user is on login page
    When user enters username and password
    And clicks on login button
    Then user is navigated to the home page

