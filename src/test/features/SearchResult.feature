Feature: SearchResult Page
  As a client
  I want to search for specific offer
  In order to reserve it

  Background: User navigates to home page and sees searchBar
    Given navigate to main page phptravels
    Then searchBar is visible

  Scenario Outline: Verify if listing presents chosen departure and return
    When user chooses Flights search type
    And user fill From field with <From>
    And user fill To field with <To>
    And user fill Depart field with <Depart>
    And user fill Adult field with <Adults>
    And user fill Child field with <Child>
    And user clicks search button
    Then heading contains <FromSC> and <ToSC>
    Examples:
      | From     | FromSC | To     | ToSC | Depart          | Adults | Child |
      | New York | EWR    | Munich | MUC  | + 2 weeks | 2      | 2     |