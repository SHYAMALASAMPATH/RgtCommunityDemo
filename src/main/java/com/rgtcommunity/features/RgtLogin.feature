Feature: Rgt R&D Login
@loginAll
Scenario Outline: Login scenario with valid credentials
	    Given user on R&D login page
        When user clicks on homepage login
		And user login with <username> and <password>
		When user clicks on login
		Then user should verify the user email
        And user should sign out
        Then user should view login button
		
		Examples:
		 |username    | password |
		 |globaladmin@ratnaglobaltech.com|Letmecall@143|
         |admin@ratnaglobaltech.com|Letmecall@143|
         |user@ratnaglobaltech.com|Letmecall@143|