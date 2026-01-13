
@smoke
Feature: Web table orders functionality

  Background: User is already Logged in
    Given User is already logged in entering username "Test" and password "Tester"

# TC #: Order place scenario
#1- Given user is already logged in to The Web table app
#2- When user is on the “Order” page
#3- Then user sees below options under “product” dropdown
#a. MoneyCog
#b. FamilyBea
#c. Screenable
#Note: Follow POM and BDD

  Scenario: Order place scenario
    Given user clicks Order option
    Then user sees below options under product dropdown
      | MoneyCog   |
      | Familybea  |
      | Screenable |



    #TC #: Order place scenario
    #1- Given user is already logged in to The Web table app
    #2- When user is on the “Order” page
    #3- Then user sees below radio buttons enabled for
    #a. Visa
    #b. Mastercard
    #c. American Express

  Scenario: Order place scenario
    When user clicks Order option
    Then Then user sees below radio buttons enabled
      | Visa             |
      | MasterCard       |
      | American Express |


    #1- Given user is already logged in to web table app
    #2- When user is on the “Order” page
    #3- Then user enters appropriate test data
        #a. Product
        #b. Quantity
        #c. Customer name
        #d. Street
        #e. City
        #f. State
        #g. Zip
        #h. Payment info:
            #i. Card type: Visa/MasterCard/American Express
            #ii. Card No
            #iii. Expire date
    #4- And user clicks to “Process Order”
    #5- Then user should see new order in the table on “View all orders”
    #page
    #TASK 9 : CREATE PARAMETERIZED VERSION OF THE SCENARIO


  Scenario: Order place scenario creating an order
    Given user clicks Order option
    When  user enters "2" into qauntity field
    And user enters "John Doe" into name field
    And user enters "Mareşal Fevzi Çakmak" into street field
    And user enters "Afyon" into city field
    And user enters "None" into state field
    And user enters "03330" into zip field
    And user selects "American Express" card
    And user enters "1111222233334444" into card number field
    And user enters "11/28" into expiration date field
    And user clicks on calculate button
    And user clicks Process Order button
    Then user sees "John Doe" in the orders table on View all orders page

  @wip_1
  Scenario Outline: Order place scenario creating an order
    Given user clicks Order option
    When  user enters "<quantity>" into qauntity field
    And user enters "<name>" into name field
    And user enters "<street>" into street field
    And user enters "<city>" into city field
    And user enters "<state>" into state field
    And user enters "<zip>" into zip field
    And user selects "<cardType>" card
    And user enters "<cardNumber>" into card number field
    And user enters "<expirationDate>" into expiration date field
    And user clicks on calculate button
    And user clicks Process Order button
    Then user sees "<actualName>" in the orders table on View all orders page

    Examples:
      | quantity | name     | street  | city  | state | zip   | cardType         | cardNumber       | expirationDate | actualName |
      | 2        | John Doe | Maresal | Afyon | Ege   | 03320 | Visa             | 1111222233334444 | 18/28          | John Doe   |
      | 3        | Jane Doe | Aydin   | Mugla |       | 46030 | American Express | 1212212134344343 | 22/30          | Jane Doe   |
      | 5        | Maya     | Kadir   | İzmir | Ege   | 35210 | MasterCard       | 2211332244114433 | 01/29          | Maya       |