Feature: Tile verification for students
  @studentTitle
  Scenario: Student Title Averification
    When user hits list of  students API with "http://cybertekchicago.com/student/all"
    Then user verifies each student's title to be at least two letters

    @studentEmail

    Scenario: Student email verification
      When user hits list of  students API with "http://cybertekchicago.com/student/all"
      Then user verifies each students email to be valid
