@B28G31-159_MG
Feature: Books module
  As a librarian, I should be able to add new book into library

  @B28G31-159_MG @db@ui
  Scenario Outline: Verify added book is matching with DB
    Given the "librarian" on the home page - MG
    And the user navigates to "Books" page - MG
    When the librarian click to add book - MG
    And the librarian enter book name "<Book Name>" - MG
    When the librarian enter ISBN "<ISBN>" - MG
    And the librarian enter year "<Year>" - MG
    When the librarian enter author "<Author>"
    And the librarian choose the book category "<Book Category>" - MG
    And the librarian click to save changes - MG
    Then verify "The book has been created." message is displayed - MG
    And verify "<Book Name>" information must match with DB - MG

    Examples:
      | Book Name                | ISBN     | Year | Author       | Book Category        |
      | Clean Code MG            | 12112021 | 2021 | Kathy Sierra | Fantasy              |
      | Head First Java MG       | 10112021 | 2021 | Kathy Sierra | Action and Adventure |
      | The Scrum Field Guide MG | 11112021 | 2006 | Mitch Lacey  | Short Story          |