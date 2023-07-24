@smoke
Feature: Apo Search Functionality
  User Story:
  As a user, I should be able to search on the Apo home page


  Scenario: User should be able to search the Apo home page
    When user enters the home page
    And user clicks search box
    And user enters vitamin in search box
    And user scroll down and up
    And user goes back to home page
    Then user should see the home page









