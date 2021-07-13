import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateUser {

	static String username = "";
	static String password = "";
	static String email = "";

	public static void CreateUser() {
		RestAssured.baseURI = "https://uibank-api.azurewebsites.net";
		Map<String, String> HeaderMap = new HashMap<String, String>();
		HeaderMap.put("Content-Type", "application/json");
		HeaderMap.put("Accept", "application/json, text/plain, */*");
		HeaderMap.put("Accept", "application/json, text/plain, */*");

		Response response = RestAssured.given().headers(HeaderMap).log().all().body(new File("Json/CreateUser.json"))
				.post("api/users");
		response.prettyPrint();
		JsonPath jsonPath = response.jsonPath();
		username = jsonPath.getString("username");
		password = jsonPath.getString("password");

	}

}
