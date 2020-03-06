package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GoRestSteps {
	
	private Response response;
	private static RequestSpecification request;
	
	@When("I provide the request data")
	public void i_provide_the_request_data() {
	    
		request = given().header("Content-Type", "application/json")
				.header("Authorization","Bearer FRPgTeivNoKJ2FjscwiBNYFT9IyoAWH2oAYU" );
		
		
		
		
	}

	@When("I amke a call to albums API")
	public void i_amke_a_call_to_albums_API() {
	   response=request.when().get("https://gorest.co.in/public-api/albums/4");
	}

	@Then("I validate that {int}  is the status code")
	public void i_validate_that_is_the_status_code(int expectedStatus) {
	  // 1st way
	//   response.then().assertThat(expectedStatus);
	   
	   //2nd way 
	   int actualCode=response.statusCode();
	   Assert.assertEquals(expectedStatus, actualCode);
	}

	@Then("I validate the response body")
	public void i_validate_the_response_body() {
	   //1st way
		
		String expectedTitle="  ";
		response.then().body("_meta.message",Matchers.equalTo("OK.Everything worked "));
		response.then().body("result.title", Matchers.equalTo(expectedTitle));
		
		//2nd way
		JsonPath jsonPath=response.jsonPath();
		jsonPath.getString("result.title");
		
		
		
	}
}
