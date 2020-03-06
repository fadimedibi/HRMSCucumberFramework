package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import com.hrms.utils.APIConstants;
import com.sun.xml.xsom.impl.scd.Iterators.Map;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllEmployeesAPI {
	
	public static RequestSpecification request;
	private static Response response;


	@Given("user calls getAllEmployees API")
	public void user_calls_getAllEmployees_API() {
	   
	request=	given().header("Content-Type", "application/json").header("Authorization",
				SyntaxAPIAuthenticationSteps.Token);
	}

	@When("User retrieves getAllEmployees response")
	public void user_retrieves_getAllEmployees_response() {
		System.out.println(request.log().all());
	  response=  request.get(APIConstants.GET_ALL_EMPLOYEES_URI);
		// System.out.println(response.prettyPrint());
		
	}

	@Then("status code is {int} correct for get AllEmployees")
	public void status_code_is_correct_for_get_AllEmployees(int int1) {


		int statusCode = response.getStatusCode();
		response.then().assertThat().statusCode(int1);
		System.out.println(statusCode);
		
	}

	@Then("user validates all employees are listed")
	public void user_validates_all_employees_are_listed() {
		
		JSONObject json=new JSONObject(response.prettyPrint());
		JSONArray array=json.getJSONArray("Employee");
		System.out.println("Size of list for returned Employee is: "+array.length());
		
		
	   
//		JsonPath jsonPathEvaluator = response.jsonPath();
//		List<Map<String, String>> result = jsonPathEvaluator.get("Employee");
//
//		jsonPathEvaluator.get("Employee");
//		Assert.assertFalse("The list is Empty!!",result.isEmpty());	
		
		
	
		
		
//		boolean isDisplayed = response.prettyPrint().contains("Employee");
//
//		Assert.assertTrue("All Employees are not displayed", isDisplayed);

		
		
	}
	
	
}
