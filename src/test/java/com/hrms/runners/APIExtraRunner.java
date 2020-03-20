package com.hrms.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/api", 
			glue = {"com.hrms.API.ExtraSteps" }, 
			dryRun = false,
			plugin= {"pretty"},
			monochrome=true,
			tags = "@token")
public class APIExtraRunner {

}
