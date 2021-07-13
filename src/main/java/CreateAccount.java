import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateAccount extends Login {
	public static void CreateAccount() {
		RestAssured.baseURI = "https://uibank-api.azurewebsites.net/";
		RestAssured.authentication = RestAssured.oauth2(tokenId);
		Response response = RestAssured.given().headers("Content-Type", "application/json")
				.contentType(ContentType.JSON).log().all()
				.body("{\"friendlyName\":\"RunTime1\",\"type\":\"checking\",\"userId\":\"" + Login.userId
						+ "\",\"balance\":200,\"accountNumber\":27710347}")
				.post("api/accounts");
		System.out.println("Userid" + Login.userId);
		response.prettyPrint();
		System.out.println(response.getStatusCode());
		JsonPath jsonPath = response.jsonPath();
		System.out.println("Created Accounts");
	}

}
