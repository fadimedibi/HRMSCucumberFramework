//package com.hrms.API.steps.practice;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//
//import static io.restassured.RestAssured.*;
//
//import org.junit.Assert;
//
//public class DeleteEmployeeAPI {
//
//	private static RequestSpecification request;
//	private Response response;
//	public String deleteEmpURI="http://54.167.125.15/syntaxapi/api/deleteEmployee.php";
//
//	@Given("user calls deleteEmployee API")
//	public void user_calls_deleteEmployee_API() {
//		request = given()
//				.header("Content-Type", "application/json")
//				.header("Authorization", SyntaxAPIAuthenticationSteps.Token)
//				.param("employee_id", "06163A");
//	}
//
//	@When("User retrieves delete response")
//	public void user_retrieves_delete_response() {
//		response = request.delete(deleteEmpURI);
//		System.out.println(response.prettyPrint());
//	}
//
//	@Then("validate status code of deleteEmployee is {int}")
//	public void validate_status_code_of_deleteEmployee_is(int expectedStatusCode) {
//
//		int actualStatusCode = response.statusCode();
//		System.out.println("Actual Status Code is: " + actualStatusCode);
//
//		Assert.assertEquals(expectedStatusCode, actualStatusCode);
//	}
//
//	@Then("user validates employee is deleted")
//	public void user_validates_employee_is_deleted() {
//
//		boolean isDeleted = response.body().asString().contains("Entry deleted");
//
//		Assert.assertTrue("Employee does not exist or you have provided invalid employee_id", isDeleted);
//
//	}
//}
