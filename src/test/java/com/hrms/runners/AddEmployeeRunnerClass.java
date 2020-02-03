package com.hrms.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)
	@CucumberOptions(
			features="src/test/resources/features/AddEmployee.feature"
			, glue="com/hrms/steps"
			, dryRun=false
			,plugin="pretty"
			,monochrome=true
			,name="AddEmployee and Login Credentials"
			)

public class AddEmployeeRunnerClass {

	
	

	
}
