package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateEmployeeAPI {

	private static Response response;
	public static RequestSpecification request;

	@Given("user calls createEmployee API")
	public void user_calls_createEmployee_API() {

		request = given().header("Content-Type", "application/json").header("Authorization",
				SyntaxAPIAuthenticationSteps.Token);

		request.body(CommonMethods.readJson(
				"C:\\Users\\murat\\eclipse-workspace\\HRMSCucumberFramework\\src\\test\\resources\\JSONFiles\\createEmployee.json"));

	}

	@When("User retrieves response")
	public void user_retrieves_response() {

		response = request.post("http://54.167.125.15/syntaxapi/api/createEmployee.php");
		// response.prettyPrint();

	}

	@Then("status code is {int}")
	public void status_code_is(Integer expectedStatusCode) {

		Integer ActualStatusCode = response.getStatusCode();
		System.out.println("Actual Status Code is: " + ActualStatusCode);

		Assert.assertEquals(expectedStatusCode, ActualStatusCode);

	}

	@Then("user validates employee is created")
	public void user_validates_employee_is_created() {

		boolean isCreated = response.prettyPrint().contains("Entry Created");
		Assert.assertTrue("employee is not created", isCreated);
	}
}
