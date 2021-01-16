package pratice.rest.assured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class DemoBasicAuth {

	@Test
	public void checkBasicAuth()
	{
		Response resp = given().auth().basic("admin", "admin")
						.when().get("https://the-internet.herokuapp.com/basic_auth");
		
		resp.then().log().all();
	}
	
	// status code is 200 OK
}













