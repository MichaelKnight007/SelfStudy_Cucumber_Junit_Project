@wip
Feature: Web Table Login Functionality

  Scenario: Web Table Login scenario Hard coded implementation
    Given user goes to URL
    When  user enters correct username into username field
    And user enters correct password into password field
    Then user should see that URL ends with orders

  Scenario: Web Table Login scenario parameterized implementation
    Given user goes to URL
    When  user enters valid "Test" into username field
    And user enters valid "Tester" into password field
    Then user should see that URL ends with orders

  Scenario: Web Table Login data table implementation
    Given user goes to URL
    When  user enters valid credentials
      | username | Test   |
      | password | Tester |
    Then user should see that URL ends with orders