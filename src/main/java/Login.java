import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Login extends CreateUser {
	File token = new File("Json/Token.json");
	static String tokenId = "";
	static String userId = "";

	public static void generateAccessToken() {
		System.out.println(CreateUser.username);
		RestAssured.baseURI = "https://uibank-api.azurewebsites.net";
		Response generatedtoken = RestAssured.given().header("Content-Type", "application/json")
				.body("{\"username\":\"" + CreateUser.username + "\",\"password\":\"" + CreateUser.password + "\"}")
				.post("api/users/login");
		JsonPath tokenResponse = generatedtoken.jsonPath();
		tokenResponse.prettyPrint();
		if (generatedtoken.getStatusCode() == 200) {
			tokenId = tokenResponse.getString("id");
			userId = tokenResponse.get("userId");
			System.out.println("Login Successful!");
		} else
			System.out.println("Login Failed!");
	}
}
