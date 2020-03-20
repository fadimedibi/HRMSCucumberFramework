package com.hrms.API.ExtraSteps;

import org.json.JSONObject;
import static io.restassured.RestAssured.given;
import org.junit.Assert;
import static com.hrms.utils.APIConstants.*;
import static com.hrms.utils.CommonMethods.readJson;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GenerateTokenSteps {
	private RequestSpecification request;
	private Response response;
	String URI = "http://166.62.36.207/syntaxapi/api/generateToken.php";

	@Given("I provide the header for Generating Token")
	public void i_provide_the_header_for_Generating_Token() {
		request = given().header("Content-Type", "application/json");
	}

	@Given("I provide the body for Generating Token")
	public void i_provide_the_body_for_Generating_Token() {
		// 1st way, just provide the string
//		String bodyText = "{ \"email\": \"Dibi1@gmail.com\",\"password\": \"fadime0789\"}";
//		request.body(bodyText);
		
		// 2nd way, read text from the file
		request.body(readJson(GENERATE_TOKEN_JSON));

	}

	@Given("I make Generating Token call")
	public void i_make_Generating_Token_call() {
		response = request.when().post("URI");
	}

	@Then("I validate the the Generating Token Status Code")
	public void i_validate_the_the_Generating_Token_Status_Code() {
//1st way restAssure Assertion
		response.then().assertThat().statusCode(200);

//2nd way JUnit Assertion
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
		System.out.println("status code " + statusCode);

	}

	@Then("I get the token from the response")
	public void i_get_the_token_from_the_response() {
		System.out.println();
		System.out.println("1st way " + response.asString());
		System.out.println("2nd way " + response.body().asString());
		System.out.println("3rd way " + response.getBody().asString());

		// 1st way, using JSonPath get the response as JsonPath, then get the value of
		// token as jsonPath

		JsonPath jsonPath = response.jsonPath();
		jsonPath.prettyPrint();

		String jSonPathToken = jsonPath.getString("token");
		System.out.println("jSonPathToken: " + jSonPathToken);

		// 2nd way using JSonObject we need a dependency

		JSONObject json = new JSONObject(response.asString());
		String jsonObjectToken = json.getString("token");

		System.out.println("jsonObjectToken: " + jsonObjectToken);

//		ReadWriteFile.writeTextIntoFile(System.getProperty("user.dir")
//			+ "/src/test/resources/JSONFiles/token.txt","Bearer "+jsonPathToken);

	}
}
