@etsy
Feature:Etsy title verification
  Agile Story: User should be able to type any keyword and see relevant information

  Background: User navigates to URL
      Given user is on the Etsy home page

  Scenario: Etsy home page title verification
    #Given user is on the Etsy home page
    Then  User sees title is as expected
    # Etsy - Shop for handmade, vintage, custom, and unique gifts for
    #everyone


  Scenario: Etsy Search Functionality Title Verification (without parameterization)
   # Given user is on the Etsy home page
    When User types Wooden Spoon in the search box
    And User clicks search button
    Then User sees Wooden Spoon is in the title

  Scenario: Etsy Search Functionality Title Verification (with parameterization)
  #  Given user is on the Etsy home page
    When User types "Wooden Spoon" in the search box
    And User clicks search button
    Then User sees Wooden Spoon is in the title