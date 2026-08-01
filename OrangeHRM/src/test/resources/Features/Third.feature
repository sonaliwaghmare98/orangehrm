Feature: This is Third Feature File

  Scenario: First Parameterization Scenario
    Given I have "A" and "B"
    When I add them
    Then print the result

  Scenario: Passing list as a parameter
    Given I have following fruits:
      | Apple  |
      | Banana |
      | Kiwi   |
      | Litchi |
      | Grapes |
      | Orange |
      | Mango  |
    Then print the entire list

  Scenario: Passing list as a parameter
    Given I have following fruits with quantity:
      | Apple  | 6  |
      | Banana | 12 |
      | Kiwi   | 2  |
      | Litchi | 40 |
      | Grapes | 70 |
      | Orange | 5  |
      | Mango  | 12 |
    Then print the entire list of fruits

  Scenario: passing table as a parameter
    Given I have following table of fruits:
      | Apple  | 6  | Red    |
      | Banana | 12 | Yellow |
      | Kiwi   | 2  | Green  |
      | Litchi | 40 | Red    |
      | Grapes | 70 | Green  |
      | Orange | 5  | Orange |
      | Mango  | 12 | Yellow |
    Then print the entire table of fruits

  Scenario Outline: This is Data Driven scenario
    Given I have a "<fruit>"
    Then print its name
    Examples:
      | fruit  |
      | Apple  |
      | Banana |
      | Kiwi   |
      | Litchi |
      | Grapes |
      | Orange |
      | Mango  |

  Scenario Outline: This is Data Driven scenario using File
    Given I have a <row>
    Then print its name
    Examples:
      | row |
      | 1   |
      | 2   |
      | 3   |
      | 4   |
      | 5   |
      | 6   |
      | 7   |
      | 8   |
      | 9   |