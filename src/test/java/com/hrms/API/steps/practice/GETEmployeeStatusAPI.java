package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import com.hrms.utils.APIConstants;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GETEmployeeStatusAPI {
	public static RequestSpecification request;
	private static Response response;

	
	@Given("user calls getEmployeeStatuses API")
	public void user_calls_getEmployeeStatuses_API() {
	 
		request=given().header("Content-Type","application/json").header("Authorization",
				SyntaxAPIAuthenticationSteps.Token);
	
	}

	@When("User retrieves getEmployeeStatuses response")
	public void user_retrieves_getEmployeeStatuses_response() {
	  response= request.get(APIConstants.GET_ALL_EMPLOYEE_STATUSES_URI);
	  System.out.println(response.prettyPrint());
	}

	@Then("status code is {int} correct for get employee statuses")
	public void status_code_is_correct_for_get_employee_statuses(int int1) {
	   
		response.then().assertThat().statusCode(int1);
	}

	@Then("user validates employee status")
	public void user_validates_employee_status() {
		
//	 boolean isEmpStatusListDisplayed=  response.prettyPrint().contains("Employee Status List");
//	Assert.assertTrue("Employee Status List is NOT displayed", isEmpStatusListDisplayed);
	

		JSONObject json = new JSONObject(response.prettyPrint());
		JSONArray array = json.getJSONArray("Employee Status List");
		for (int i = 0; i <= array.length() - 1; i++) {
			System.out.println(array.get(i));
			if (i == 0) {
				Assert.assertEquals("Employee", array.get(i));
			} else if (i == 1) {
				Assert.assertEquals("Worker", array.get(i));
			} else if (i == 2) {
				Assert.assertEquals("Self-Employee", array.get(i));
			} else if (i == 3) {
				Assert.assertEquals("Independent contractor", array.get(i));
			} else if (i == 4) {
				Assert.assertEquals("Freelance", array.get(i));
			} else if (i == 5) {
				Assert.assertEquals("Zero hours contract", array.get(i));
			} else if (i == 6) {
				Assert.assertEquals("Gig economy", array.get(i));
			} else if (i == 7) {
				Assert.assertEquals("Self-employe", array.get(i));
			}else if (i == 8) {
				Assert.assertEquals("internee", array.get(i));
			}
		}
		Assert.assertEquals(9, array.length());
		System.out.println(array.length());

		
		
		
		
		
		
	}
}
