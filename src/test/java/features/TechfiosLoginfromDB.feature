@LoginFromDBFeature @Regression
Feature: Techfios billing login functonality validation with driving data from Mysql DB

@Scenario 
Scenario Outline: User should able to login with valid credentials from DB
    Given User on techfios login page
    When User enters "username" from techfios database
    When User enters "password" from techfios database
    And User clicks on signin button
    Then User should land on Dashboard page

 
    