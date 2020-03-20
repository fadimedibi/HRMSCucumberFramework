@APITESTDIEGO
Feature: Validating Syntax HRMS API's
Background:
Given user generates token
@SyntaxHRMSAPIEndToEnd22AllEmp
Scenario: This test will check to see all employees
Given user calls getAllEmployees API
When User retrieves getAllEmployees response
Then status code is 200 correct for get AllEmployees 
Then user validates all employees are listed
