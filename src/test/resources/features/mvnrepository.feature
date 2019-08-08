Feature: Mvn result verification
  @mvnresult
  Scenario: Mvn result verification
    When User is on Mvnrepository main page
    Then User searches for word "cucumber java"
