//package com.hrms.API.steps.practice;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
//
//import org.junit.Assert;
//
//import com.hrms.utils.CommonMethods;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
///**
// * 
// * 
// * @author API Instructor Please manually import --import static org.hamcrest.Matchers.equalTo;
// *
// */
//
//
//
//public class CreateEmployeeAPI {
//	
//	/**
//	 * Declaring RequestSpecification request & Response response as global
//	 * variables
//	 */
//
//	private static Response response;
//	public static RequestSpecification request;
//	
//	public static Object emp_id;
//
//	@Given("user calls createEmployee API")
//	public void user_calls_createEmployee_API() {
//
//		/**
//		 * Preparing request using given() method
//		 **/
//		
//		request = given().header("Content-Type", "application/json").header("Authorization",
//				SyntaxAPIAuthenticationSteps.Token);
//		
//		/**
//		 * Sending body which is stored in createEmployee.json file stored in JSONFiles
//		 * folder(We installed JSON editor) we are sending body using public static
//		 * readJson() method which we stored in CommonMethods class-- (will change
//		 * location next class) which will read your JSON payload and convert to a
//		 * String
//		 * 
//		 **/
//
//		request.body(CommonMethods.readJson(
//				"C:\\Users\\murat\\eclipse-workspace\\HRMSCucumberFramework\\src\\test\\resources\\JSONFiles\\createEmployee.json"));
//
//	}
//
//	@When("User retrieves response")
//	public void user_retrieves_response() {
//		/**
//		 * Calling /createEmployee.php endpoint using when() method and storing in to
//		 * response which we made global
//		 */
//		
//		response = request.post("http://54.167.125.15/syntaxapi/api/createEmployee.php");
//		
//		/**
//		 * At this point, we have sent our body with a POST request to our
//		 * /createEmployee.php REST endpoint and below you can do response.prettyPrint()
//		 * to see the response we get
//		 */
//		response.prettyPrint();
//
//	}
//
//	@Then("status code is {int}")
//	public void status_code_is(int int1) {
//
//		/**
//		 * we are using then() method to perform assertions below are two ways to assert
//		 */
//
//		/**
//		 * Asserting using Assert class from JUnit and using assertEquals() method
//		 */
//		Assert.assertEquals(int1, response.getStatusCode());
//		/**
//		 * Preferred way to assert because we can use then() method
//		 */
//		response.then().assertThat().statusCode(int1);
//		
//		
//		
//		
//		// benim eski code
////		Integer ActualStatusCode = response.getStatusCode();
////		System.out.println("Actual Status Code is: " + ActualStatusCode);
////
////		Assert.assertEquals(expectedStatusCode, ActualStatusCode);
//
//	}
//
//	@Then("user validates employee is created")
//	public void user_validates_employee_is_created() {
//
//		/**
//		 * Here we are asserting to verify that in our response body we see "Message" :
//		 * "Entry Created" We are asserting with equalTo() that comes from --import
//		 * static org.hamcrest.Matchers.equalTo;(You need to manually import)
//		 */
//		response.then().body("Message", equalTo("Entry Created"));
//
//		/**
//		 * Here we are asserting to verify that in our response body we see --
//		 * "emp_firstname" : "SyntaxAPIInstructor" We are asserting with equalTo() that
//		 * comes from --import static org.hamcrest.Matchers.equalTo;(You need to
//		 * manually import) The [0]is because, if you look at the response it is in the
//		 * first object of the Array and first stored object to an array begins with
//		 * index [0]
//		 */
//		response.then().body("Employee[0].emp_firstname", equalTo("Bittim"));
//		
//		emp_id= response.jsonPath().getString("employee_id");
//		System.out.println(" EMPLOYEEE ID: "+ emp_id);
//		
//		
//	//benim eski code	
////		boolean isCreated = response.prettyPrint().contains("Entry Created");
////		Assert.assertTrue("employee is not created", isCreated);
//	}
//}
