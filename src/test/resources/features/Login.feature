@sprint1 @login
Feature: Login

  @smoke
  Scenario: Valid login
    When I enter valid username and valid password
    And I click on login button
    Then I succesfully logged in

  @regression
  Scenario: Invalid Login
    Given I open browser and navigated to the HRMS
    When I enter valid username and invalid password
    And I click on login button
    Then I see error message
    And I close browser

  @regression
  Scenario Outline: Invalid Login and message validation
    When I enter "<Username>" and "<Password>"
    And I click on login button
    Then I see "<ErrorMessage>"

    Examples: 
      | Username | Password    | ErrorMessage             |
      | Admin    | Admin123    | Invalid credentials      |
      | Admin    |             | Password cannot be empty |
      |          | Hum@nhrm123 | Username cannot be empty |
      |          |             | Username cannot be empty |
