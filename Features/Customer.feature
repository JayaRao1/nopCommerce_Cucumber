Feature: Customer Feature

  Background: Below are commeon steps for every Scenario
    Given User launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And user enters Email as "admin@yourstore.com" and Password as "admin"
    And clicks on login
    Then user can view Dashboard
    When user clicks on Customer Menu
    And clicks on Customer Menu Item

@sanity
  Scenario Outline: Add a New Customer
    And click on Add New Button
    Then user can view add new customer page
    When user enters customer Info
    And clicks on save button
    Then uer can view confirmation message "The new customer has been added sucessfully."
    And close Browser

    Examples: 
      | username            | password |
      | admin@yourstore.com | admin    |

@regression
  Scenario: Search Custtomer by using Email ID 
    And Entes customer EmailId
    When Clicks on search button
    Then user should found particular email id details in the search table
    And close Browser

@regression
  Scenario: Search Customer by using Firstname and Lastname
    And Enter customer FirstName
    And Enter customer LastName
    When Clicks on search button
    Then user should found Name in the search table
    And close Browser
