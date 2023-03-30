Feature: Default

	#As a librarian, I want to know borrowed books number 
	@B28G31-160
	Scenario: As a librarian, I want to know borrowed books number - EL
		Given the "librarian" is on the home page 
		When the librarian gets borrowed books number 
		Then borrowed books number information must match with DB