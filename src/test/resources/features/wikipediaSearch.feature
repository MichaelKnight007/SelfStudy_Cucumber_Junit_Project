@wiki @smoke
Feature: Wikipedia Search Functionality

  Background: User uses search functionality
    Given User types "Steve Jobs" in the wiki search box and clicks search button



  #TC#: Wikipedia Search Functionality Title Verification
  #1. User is on Wikipedia home page
  #2. User types Steve Jobs in the wiki search box
  #3. User clicks wiki search button
  #4. User sees Steve Jobs is in the wiki title
  #Note: Follow POM

  Scenario:Wikipedia Search Functionality Title Verification
    Then User sees "Steve Jobs" is in the wiki title


  Scenario: Wikipedia Search Functionality Header Verification
    Then User sees "Steve Jobs" is in the main header


  Scenario: Wikipedia Search Functionality Image Header Verification
    Then User sees "Steve Jobs" is in the image header


