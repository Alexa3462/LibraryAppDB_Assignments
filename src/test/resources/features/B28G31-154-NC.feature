@B28G31-154
Feature: As a data consumer, I want the user information are stored in mySql DB correctly in users table.

  Background:
    #@B28G31-154
    Given Establish the database connection

  @db
  Scenario: verify users has unique IDs
    When Execute query to get all IDs from users - NC
    Then verify all users has unique ID - NC

 @db
  Scenario: verify users table columns
    When Execute query to get all columns - NC
    Then verify the below columns are listed in result - NC

      | id            |
      | full_name     |
      | email         |
      | password      |
      | user_group_id |
      | image         |
      | extra_data    |
      | status        |
      | is_admin      |
      | start_date    |
      | end_date      |
      | address       |
