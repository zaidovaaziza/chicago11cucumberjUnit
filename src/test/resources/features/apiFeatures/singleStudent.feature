Feature: Single Student API Automation
@singleStudent
  Scenario: Single Student Attribute validation
    When user hits single student API with "http://cybertekchicago.com/student/1512"
    Then user checks for required attributes