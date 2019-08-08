@wikipedia
Feature: Wikipedia search feature


  Scenario: Wikipedia title verification using search feature
  Given User is on Wikipedia Home Page
  When User types "Steve Jobs" in the wiki search box
  Then User clicks wiki search button
  And User sees "Steve Jobs" is in the wiki title

  Scenario: Wikipedia title verification using search feature
    Given User is on Wikipedia Home Page
    When User types "Steve Jobs" in the wiki search box
    Then User clicks wiki search button
    And User sees "Steve Jobs" is in the main header

  Scenario: Wikipedia title verification using search feature
    Given User is on Wikipedia Home Page
    When User types "Steve Jobs" in the wiki search box
    Then User clicks wiki search button
    And User sees "Steve Jobs" is in the image header