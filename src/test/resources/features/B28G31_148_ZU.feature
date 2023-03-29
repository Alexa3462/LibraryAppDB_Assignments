@B28G31-164  @db
Feature: Default

	@B28G31-163  @db
	Scenario: verify the common book genre that’s being borrowed- ZU
		Feature: As a data consumer, I want to know genre of books are being borrowed the most - ZU
		
		  Scenario: verify the the common book genre that’s being borrowed  - ZU
		    Given Establish the database connection - ZU
		    When I execute query to find most popular book genre - ZU
		    Then verify "Fantasy" is the most popular book genre. - ZU