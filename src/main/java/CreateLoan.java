import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class CreateLoan extends CreateUser{
	
	static String createdQuoteID = "";
	public void CreateLoan()
	{
		RestAssured.baseURI = "https://uibank-api.azurewebsites.net/";

	Response  response  =  RestAssured
			.given()
			.headers("Content-Type", "application/json")
			.log().all()
			.body("{\r\n" + 
					"    \"email\": \""+ CreateUser.email  + "\",\r\n" + 
					"    \"amount\": 10000,\r\n" + 
					"    \"term\": 3,\r\n" + 
						"    \"income\": 5000,\r\n" + 
					"    \"age\": 20\r\n" + 
					"}")
			.post("api/quotes/newquote");

	response.prettyPrint();
	JsonPath jsonPath = response.jsonPath();
	createdQuoteID = jsonPath.get("quoteid");
	System.out.println(" Created Quote ID : " + createdQuoteID);
	}

}

