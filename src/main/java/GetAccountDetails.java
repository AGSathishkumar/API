import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class GetAccountDetails extends Login {

	public void getDetail()
	{
		RestAssured.baseURI = "https://uibank-api.azurewebsites.net/";
		RestAssured.authentication = RestAssured.oauth2(tokenId);

			Response  response  =  RestAssured.given()
					.headers("Content-Type", "application/json")
					.log().all()
					.queryParam("?filter[where][userId]=",Login.userId)
					.get("api/accounts");

			response.prettyPrint();

			JsonPath jsonPath = response.jsonPath();
			System.out.println(" Account Number : " +  jsonPath.getString("accountNumber"));
			System.out.println(" Account Holder Name : " +  jsonPath.getString("friendlyName"));
			System.out.println(" Account Type : " +  jsonPath.getString("type"));
			System.out.println(" Account Balance :  " +  jsonPath.getString("balance"));

	}
}
