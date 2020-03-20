
Feature: Title of your feature


  @token
  Scenario: Generating Token
    Given I provide the header for Generating Token
    And I provide the body for Generating Token
    And I make Generating Token call
    Then I validate the the Generating Token Status Code
    And I get the token from the response