@B28G31-164 @namid
Feature: verify the common book genre that’s being borrowed- ZU

	@B28G31-163

		
		  Scenario: verify the the common book genre that’s being borrowed  - ZU
		    Given Establish the database connection - ZU
		    When I execute query to find most popular book genre - ZU
		    Then verify "Fantasy" is the most popular book genre. - ZU