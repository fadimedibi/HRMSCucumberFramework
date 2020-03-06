package com.hrms.API.steps.practice;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleAPITests {

	/**
	 * Below are hard coded examples using REST assured
	 * 
	 */

//	@Test
	public void getAllJobTitles() {

		Response response = RestAssured.given().contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzEyOTQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4NjQ5NCwidXNlcklkIjoiMjU0In0.1xf1AsKAoc-dBoFB0G7pxJxqzvcQClgt_F8Nj78T8Oo")
				.when().get("http://54.167.125.15/syntaxapi/api/jobTitle.php");

		response.prettyPrint();

		int actualResponseCode = response.getStatusCode();
		System.out.println(actualResponseCode);

	}

//	@Test
	public void getOneEmployee() {

		Response response = RestAssured.given().param("employee_id", "3624").contentType("application/json").header(
				"Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzEyOTQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4NjQ5NCwidXNlcklkIjoiMjU0In0.1xf1AsKAoc-dBoFB0G7pxJxqzvcQClgt_F8Nj78T8Oo")
				.when().get("http://54.167.125.15/syntaxapi/api/getOneEmployee.php");

		response.prettyPrint();

		int actualResponseCode = response.getStatusCode();
		System.out.println(actualResponseCode);

	}

//	@Test
	public void getAllEmployeeStatuses() {
		Response response = RestAssured.given().contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzEyOTQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4NjQ5NCwidXNlcklkIjoiMjU0In0.1xf1AsKAoc-dBoFB0G7pxJxqzvcQClgt_F8Nj78T8Oo")
				.when().get("http://54.167.125.15/syntaxapi/api/employeeStatus.php");

		response.prettyPrint();
		int actualResponseCode = response.getStatusCode();
		System.out.println(actualResponseCode);

	}

	@Test
	public void createEmployee() {

		Response response = RestAssured.given().urlEncodingEnabled(true).header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzEyOTQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4NjQ5NCwidXNlcklkIjoiMjU0In0.1xf1AsKAoc-dBoFB0G7pxJxqzvcQClgt_F8Nj78T8Oo")

				.param("emp_firstname", "newName").param("emp_lastname", "employee").param("emp_middle_name", "syntax")
				.param("emp_gender", "2").param("emp_birthday", "1991-04-22").param("emp_status", "Employee")
				.param("emp_job_title", "Developer").contentType("application/json").when()
				.post("http://18.232.148.34/syntaxapi/api/createEmployee.php");

		response.prettyPrint();
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(200, actualStatusCode);

	}

//	@Test
	public void getAllEmployees() {

		Response response = RestAssured.given().contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzEyOTQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4NjQ5NCwidXNlcklkIjoiMjU0In0.1xf1AsKAoc-dBoFB0G7pxJxqzvcQClgt_F8Nj78T8Oo")
				.when().get("http://54.167.125.15/syntaxapi/api/getAllEmployees.php");

		response.prettyPrint();
		int actualStatusCode = response.getStatusCode();

		Assert.assertEquals(200, actualStatusCode);
		System.out.println(actualStatusCode);
	}

}
