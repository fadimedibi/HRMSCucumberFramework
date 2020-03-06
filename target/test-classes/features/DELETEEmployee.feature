@API
Feature: Validating Syntax HRMS API's Delete
Background:
Given user generates token
@APITEST, @delete
Scenario: This test will check to see if an Employee is deleted
Given user calls deleteEmployee API
When User retrieves delete response
Then validate status code of deleteEmployee is 200
Then user validates employee is deleted