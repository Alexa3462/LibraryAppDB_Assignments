@B28G31-158-AM
Feature: As a librarian, I want to know which genre of books is being borrowed the most
@ui @db
  Scenario: verify the common book genre that’s being borrowed
    Given Establish the database connection
    When I execute query to find most popular book genre - AM
    Then verify "Fantasy" is the most popular book genre. - AM
