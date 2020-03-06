@API
Feature: Validating Syntax /getOneEmployee.php HRMS API
Background:
Given user generates token

#This is the only homework Assignment
@APITEST @getOneEmp
Scenario: Retrieving created Employee using /getOneEmployee.php API
Given user calls getOneEmployee API
When User retrieves response for getOneEmployee
Then status code is 200 for get OneEmployee
Then user validates created employee exists