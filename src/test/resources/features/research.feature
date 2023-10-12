Feature: Test research page functionalities
  Scenario: Search for APPL company and verify results
    Given I am on the Investopedia Simulator website
    When I log in with valid credentials
    Then I navigate to the Research page
    And I search for the company "APPL"
    And I verify that the results contain the keyword "More"