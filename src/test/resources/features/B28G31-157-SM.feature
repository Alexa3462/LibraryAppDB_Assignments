
Feature: As a data consumer, I want UI and DB book information are (to) match.

  @B28G31-183 @ui @db
  Scenario: Verify book information with DB - SM
    Given the "librarian" on the home page - SM
    And the user navigates to "Books" page -SM
    When the user searches for "SM Book of Life, how to procrastinate" book - SM
    And  the user clicks edit book button -SM
    Then book information must match the Database -SM