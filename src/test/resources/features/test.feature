
@smoke
Feature: Amazon verification
#Comments goes using this sign
  @amazon
Scenario: Amazon title verification
  When User is on Amazon application
  Then User should see Amazon in title
    And User searches for something

    @amazon2
    Scenario: Amazon search verification
      When User is on Amazon application

