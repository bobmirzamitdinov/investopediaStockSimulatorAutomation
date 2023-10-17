@regression
Feature: Test functionalities in Research Page

  Scenario: Verify Navigation to Research Page
    Given user is on the investopedia simulator website
    When user logs in with valid credentials
    And user clicks Research screen name
    Then user is navigated to the research page