Feature: Verify AddCommunity By GlobalAdmin

Scenario: Verify AddCommunity functionality
        Given user on R&D login page
        When user clicks on homepage login
        And user login with <username> and <password>
        When user clicks on communities
        Then user should view addcommunity button
        When user clicks addcommunity 
        Then user should view addcommunity popup
        When user add community with following details and click save
        |gatedcommunity|GatedCommunity|Active|ConatactName|Maneger|Primarycontactno|secondarycontactno|pemail|secemail|add1|add2|India|Andhra Pradesh|hyderabad|near by |500072|goood community|
        Then verify community name in communities view