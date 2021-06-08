Feature: Rgt R&D Login

Scenario Outline: Login scenario with valid credentials
	    Given user on R&D login page
	    When user clicks on homepage login
		And user login with "rgtlogincredentials" and <rownumber>
		When user clicks on login
		Then user should verify the user email
		And  user should sign out
		Then user should view login button
		
		Examples:
	     | rownumber |
		 |1|
#		 |2|
#		 |3|