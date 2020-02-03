#Author: syntax team (asel@syntaxtechs.com)
@sprint2 @addEmployee
Feature: Add Employee

  Background: 
    Given I am logged into HRMS
    And I navigated to Add Employee Page

  @smoke @smoke
  Scenario: Add new Employee
    When I add "John", "S" and "Smith"
    And I click Save
    Then I see Employee has been succesfully added

  @regression
  Scenario Outline: Add new Employee
    When I add "<FirstName>", "<MiddleName>" and "<LastName>"
    And I click Save
    Then I see Employee with "<FirstName>", "<MiddleName>" and "<LastName>" is displayed

    Examples: 
      | FirstName | MiddleName | LastName |
      | Morticia  |            | Addams   |
      | Wednesday | W          | Addams   |
      | Gomez     | G          | Addams   |
      | Pugsley   | P          | Addams   |

  @regression
  Scenario: Add Employee without employee id
    When I add "Fred", "F" and "Flintstone"
    And I delete employee id
    And I click Save
    Then I see employee without employee id is being added

  @regression
  Scenario: Add Employee negative scenario
    When I click Save
    Then I see required error message next to the first and last name

  @regression
  Scenario: AddEmployee and Login Credentials
    When I add "Wilma", "W" and "Flintstone"
    And I click on create login checkbox
    And I enter "Wilma", "@5690Wilma@9876" and "@5690Wilma@9876"
    When I click Save
    Then I see Employee has been succesfully added

  @smoke
  Scenario: Add and Modify Employee Details
    When I enter employee details
      | FirstName | MiddleName | LastName |
      | Jessica   | J          | Smith    |
    #| Jane      | S          | Smithy   |
    #| Jack      | M          | Smithes  |
    And I click Save
    And I click on Edit
    Then I am able to modify Employee Details
      | DriverLicense | ExpirationDate | SSN         | SIN   | Gender | MaritalStatus | Nationality | DOB        |
      | N78787567     | 2021-12-08     | 123-45-6789 | 76876 | Male   | Other         | Afghan      | 1980-11-10 |
      | Nhkjkgkhgkg   | 2018-12-08     | 456-45-6789 |  9876 | Female | Married       | Burmese     | 1980-10-19 |
