Feature: Verify Rgt Global Admin UI Validations

@GlobalAdminUiValidations
Scenario: Verify Global Admin UI Vaalidations
          Given user on R&D login page
                When user clicks on homepage login
                And  user login with "globaladmin@ratnaglobaltech.com" and "Letmecall@143"
                When user clicks on login
                Then verify hometitle "Home"
                Then verify Dashboardtitle "Dashboard"
                When user clicks communites
                Then verify Communitiestitle "Communities"
                Then user verify AddCommunity Button
                Then user verify Settingstitle "Settings"
                And user verify  Servicestitle "Services"
                Then user verify Transactionstitle "Transactions"
                And user verify Complaintstitle "Complaints"
                