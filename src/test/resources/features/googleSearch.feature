Feature: Google Search Functionality
  Agile Story: As a user when I'm on the google search page, I should be able to search anything and see the relevant results

  Scenario: Search page default title verification
    When  user is on the google page
    Then user should see title is Google
