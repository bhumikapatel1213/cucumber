Feature: Techfios other login functonality validation

 @OtherScenario1
Scenario: User should able to login wth credentials(other)
    Given User on techfios login page
    When User enters password as "abc123"
    When User enters username as "demo@techfios.com"
    And User clicks on signin button
    Then User should land on Dashboard page
 
  @OtherScenario2    
     Scenario: User should able to login with invalid credentials(other)
    Given User on techfios login page
    When User enters password as "abc123"
    When User enters username as "demo2@techfios.com"
    And User clicks on signin button
    Then User should land on Dashboard page
 
  @OtherScenario3    
    Scenario: User should able to login with invalid credentials(other)
    Given User on techfios login page
    When User enters password as "abc12345"
    When User enters username as "demo@techfios.com"
    And User clicks on signin button
    Then User should land on Dashboard page
    
