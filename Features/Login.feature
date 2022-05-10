Feature: Login Feature

@regression
  Scenario: Sucessful login with valid credenials
    Given User launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And user enters Email as "admin@yourstore.com" and Password as "admin"
    And clicks on login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When clicks in logout
    Then Page Title should be "Your store. Login"
    And close Browser

@sanity
  Scenario Outline: Sucessful login with Data Driven
    Given User launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And user enters Email as "<username>" and Password as "<password>"
    And clicks on login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When clicks in logout
    Then Page Title should be "Your store. Login"
    And close Browser

    Examples: 
      | username             | password |
      | admin@yourstore.com  | admin    |
      | admin1@yourstore.com | admin123 |
