#1. Go to https://www.bing.com/
#2. Search for “orange”
#3. Verify title is:
#a. Expected = “orange – Search”
#Note:
#1. Follow POM Design Pattern
#2. BDD implementation

  @bing
  Feature: Search functionality of Bing web site
    Background: User is on the bing search page
      Given User navigates to Bing search page

    Scenario: User searches for orange
      When user enters orange into Bing search box
      Then user should see orange in the title


      # -------------------- Parameterization --------------------------------

    Scenario: User searches for orange
      When user enters "orange" into Bing search box
      Then user should see "orange12" in the title
      # And user sees 3 oranges ==> 3 is accepted as int automatically.