@testgate
Feature: SearchResult Page. As a client I want to search for specific offer in order to reserve it

  Background: User navigates to home page and sees searchBar
    Given navigate to main page phptravels
    Then searchBar is visible

  Scenario: Verify if listing presents chosen departure and return
    When user chooses Flights search type
    And user fill From field with New York
    And user fill To field with Munich
    And user fill Depart date in 5 weeks