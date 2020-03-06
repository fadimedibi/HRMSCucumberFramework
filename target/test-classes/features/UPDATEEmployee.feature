@API
Feature: Validating Syntax HRMS API's Update
Background:
Given user generates token
@update
Scenario: This test will check to see if an Employee is updated
Given user calls updateEmployee API
When User retrieves updated response
Then validate status code of updateEmployee is 200
Then user validates employee is updated