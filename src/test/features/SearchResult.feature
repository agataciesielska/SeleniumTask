@testgate
Feature: SearchResult Page
  As a client
  I want to search for specific offer
  In order to reserve it

  Background: User navigates to home page and sees searchBar
    Given navigate to main page phptravels
    And accept cookies
    Then searchBar is visible

  Scenario Outline: Verify if listing presents chosen departure and return
    When I choose Flights search type
    And fill From field with <From>
    And fill To field with <To>
    And fill Depart date in <Depart> weeks
    And fill Adult field with <Adults>
    And fill Child field with <Child>
    And click search button
    Then listing presents offers <FromSC> to <ToSC>
    Examples:
      | From     | FromSC | To     | ToSC | Depart | Adults | Child |
      | New York | EWR    | Munich | MUC  | 2      | 2      | 2     |

  Scenario Outline: Verify if listing presents ascending sorting by price
    When I choose Flights search type
    And fill From field with <From>
    And fill To field with <To>
    And fill Depart date in <Depart> weeks
    And fill Adult field with <Adults>
    And fill Child field with <Child>
    And click search button
    Then listing presents ascending sorting by price
    Examples:
      | From     | To     | Depart | Adults | Child |
      | New York | Munich | 2      | 2      | 2     |
