import io.restassured.response.Response;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetLoanStatus extends CreateLoan {

	public void getLoanDetails() {
		RestAssured.baseURI = "https://uibank-api.azurewebsites.net/";

		Response response = RestAssured.given().headers("Content-Type", "application/json").log().all()
				.get("api/quotes/" + CreateLoan.createdQuoteID);
		response.prettyPrint();
		JsonPath jsonPath = response.jsonPath();
	}

}
