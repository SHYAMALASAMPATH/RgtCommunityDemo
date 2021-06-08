@F
Feature: Facebook signup


Scenario Outline: Signup new facebook account
    Given user on facebook landing page
    When user clicked  on create new account
    Then user should view signup popup
    When user created account with following details "<sheetname>" and <rownumber> and clicks signup
    Then user should view user created sucessfully
    
    Examples:
    |sheetname|rownumber|
    |Signupdatasheet|1|

