
@smoke
Feature: Wikipedia Search Functionality Scenario Outline

  @wiki_2
  Scenario Outline:
    Given User is on Wikipedia home page
    When User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<expectedTitle>" is in the wiki title
    Then User sees "<expectedMainHeader>" is in the main header
    Then User sees "<expectedImageHeader>" is in the image header

    @ceos
    Examples: Search values we're gonna search in the search box
      | searchValue           | expectedTitle         | expectedMainHeader    | expectedImageHeader   |
      | Steve Jobs            | Steve Jobs            | Steve Jobs            | Steve Jobs            |
      | Mustafa Kemal Atatürk | Mustafa Kemal Atatürk | Mustafa Kemal Atatürk | Mustafa Kemal Atatürk |
      | Albert Einstein       | Albert Einstein       | Albert Einstein       | Albert Einstein       |
      | Sundar Pichai         | Sundar Pichai         | Sundar Pichai         | Sundar Pichai         |

    @scientists
    Examples:
      | searchValue | expectedTitle | expectedMainHeader | expectedImageHeader |
      | Maria Curia | Maria Curia   | Maria Curia        | Maria Curia         |
      | Marry Barra | Marry Barra   | Marry Barra        | Marry Barra         |