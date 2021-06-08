@A
Feature: Verify RGT Login functionality


@GlobalAdmin
 Scenario: Verify Login with Global Admin 
                Given user on R&D login page
#                When user clicks on homepage login
                And user login with "globaladmin@ratnaglobaltech.com" and "Letmecall@143"
                When user clicks on login
                Then user should verify the user email
                And user should sign out
                Then user should view login button
@CommunityAdmin        
Scenario: Verify Login with Community Admin 
                Given user on R&D login page
#                When user clicks on homepage login
                And user login with "admin@ratnaglobaltech.com" and "Letmecall@143"
                When user clicks on login
                Then user should verify the user email
                And user should sign out
                Then user should view login button
@CommunityUser            
Scenario: Verify Login with Community User
                Given user on R&D login page
#                When user clicks on homepage login
                And user login with "user@ratnaglobaltech.com" and "Letmecall@143"
                When user clicks on login
                Then user should verify the user email
                And user should sign out
                Then user should view login button    



