//package com.hrms.API.steps.practice;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
//
//import org.junit.Assert;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//
//public class GetOneEmployeeAPI {
//
//	private static Response response;
//	public static RequestSpecification request;
//
//	@Given("user calls getOneEmployee API")
//	public void user_calls_getOneEmployee_API() {
//
//		request = given().header("Content-Type", "application/json")
//				.header("Authorization", SyntaxAPIAuthenticationSteps.Token).param("employee_id", "07001A");
//
//	}
//
//	@When("User retrieves response for getOneEmployee")
//	public void user_retrieves_response_for_getOneEmployee() {
//
//		response = request.get("http://54.167.125.15/syntaxapi/api/getOneEmployee.php");
//		System.out.println(response.prettyPrint());
//
//	}
//
//	@Then("status code is {int} for get OneEmployee")
//	public void status_code_is_for_get_OneEmployee(int expectedStatusCode) {
//		int actualStatusCode = response.getStatusCode();
//		System.out.println("Actual Status Code= " + actualStatusCode);
//
//		response.then().assertThat().statusCode(expectedStatusCode);
//
//		// Assert.assertEquals(expectedStatusCode, actualStatusCode ); junit
//	}
//
//	@Then("user validates created employee exists")
//	public void user_validates_created_employee_exists() {
//
//		boolean isDisplayed = response.prettyPrint().contains("07001A");
//
//		Assert.assertTrue("Employee is not displayed", isDisplayed);
//
//	}
//
//}
