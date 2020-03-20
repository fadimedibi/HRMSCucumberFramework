@APITESTDIEGO
Feature: Validating Syntax HRMS API's JobTitles
Background:
Given user generates token
@SyntaxHRMSAPIEndToEnd22JobTitle
Scenario: This test will check all Job Titles
Given user calls getAllJobTitles API
When User retrieves getJobTitles response
Then validate status code of getAllJobTitles is 200
Then user validates allJobTitles displayed