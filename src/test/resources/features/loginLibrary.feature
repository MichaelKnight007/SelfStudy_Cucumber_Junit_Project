@smoke
Feature: Library login feature
  User Story:
  As a user, I should be able to login with correct credentials to different accounts. And dashboard should be displayed.
  Accounts are: librarian, student, admin

  Background: For all scenarios user is on the login page of the library application
    Given user is on the login page of the library application
    #Background is running for all the scenarios in the same feature file


  Scenario: Login as a librarian

    When  user enters librarian username
    And  user enters librarian password
    Then user should see the dashboard


  Scenario: Login as a librarian
   # Given user is on the login page of the library application
    When  user enters student username
    And  user enters student password
    Then user should see the dashboard


  Scenario: Login as a librarian
  #  Given user is on the login page of the library application
    When  user enters admin username
    And  user enters admin password
    Then user should see the dashboard



