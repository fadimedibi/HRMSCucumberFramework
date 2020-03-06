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
//import com.hrms.utils.CommonMethods;
//
//public class UpdateEmployeeAPI {
//
//	public static RequestSpecification request;
//	private static Response response;
//	public String UpdateEmpURI = "http://54.167.125.15/syntaxapi/api/updateEmployee.php";
//
//	@Given("user calls updateEmployee API")
//	public void user_calls_updateEmployee_API() {
//
//		request = given().header("Content-Type", "application/json").header("Authorization",
//				SyntaxAPIAuthenticationSteps.Token);
//
//		request.body(CommonMethods.readJson(
//				"C:\\Users\\murat\\eclipse-workspace\\HRMSCucumberFramework\\src\\test\\resources\\JSONFiles\\updateEmployee.json"));
//
//	}
//
//	@When("User retrieves updated response")
//	public void user_retrieves_updated_response() {
//
//		response = request.put(UpdateEmpURI);
//		System.out.println(response.prettyPrint());
//
//	}
//
//	@Then("validate status code of updateEmployee is {int}")
//	public void validate_status_code_of_updateEmployee_is(int expectedStatusCode) {
//		int ActualStatusCode = response.getStatusCode();
//		System.out.println("Actual Status Code is: " + ActualStatusCode);
//		Assert.assertEquals(expectedStatusCode, ActualStatusCode);
//		
//		
//	
//
//	}
//
//	@Then("user validates employee is updated")
//	public void user_validates_employee_is_updated() {
//
//		boolean isUpdated = response.getBody().asString().contains("Entry updated");
//		Assert.assertTrue("Employee is not updated", isUpdated);
//
//	}
//
//}
