@LoginFeature @Regression
Feature: Techfios billing login functonality validation

 @Scenario1 
Scenario Outline: User should able to login with valid credentials
    Given User on techfios login page
    When User enters password as "abc123"
    When User enters username as "demo@techfios.com"
    And User clicks on signin button
    Then User should land on Dashboard page

	Examples:
	| username          | password       |
	|demo@techfios.com  |abc123          |

 