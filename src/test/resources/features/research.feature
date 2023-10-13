Feature: Test Research Page functionalities
  Scenario: Verify Symbol Search in Research Page
    Given user is on the investopedia simulator website
    And user logs in with valid credentials
    When user navigates to the Research page
    And user searches for the company
    Then user verifies that the results contain company