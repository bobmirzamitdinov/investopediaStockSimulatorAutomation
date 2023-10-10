Feature: Test research page functionalities

  Scenario: Check symbol search functionality
    Given browser is open
    And user is on login page
    When user enters email address and password
    And clicks on sign in button
    Then user is navigated to the research page