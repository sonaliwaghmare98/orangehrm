Feature: This feature tests Add Employee page


  Scenario: Check if first name field is mandatory
    Given user is logged in with valid credentials
    When user leaves first name field empty
    And click on save button
    Then user should get an error