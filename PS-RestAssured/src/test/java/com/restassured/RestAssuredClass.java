package com.restassured;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class RestAssuredClass {
	static {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
	}
	
	@Test
	public void checkForSold() {
		given().queryParam("status", "sold")
		.when()
		.get("/pet/findByStatus")
		.then().statusCode(200).log().ifValidationFails();
	}
}
