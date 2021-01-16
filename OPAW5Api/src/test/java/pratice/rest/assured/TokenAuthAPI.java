package pratice.rest.assured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

@Test
public class TokenAuthAPI {

	public void checkTokenAuth()
	{
		// To capture a new token for API
		Response resp = given()
						.param("client_id", "OAR")
						.param("client_secret", "c024123bfbf47efc2cdfdafae2d3693f")
						.param("grant_type", "client_credentials")
						.when().post("http://coop.apps.symfonycasts.com/token");

		Object token = resp.jsonPath().get("access_token");
		System.out.println("Token to access API is : " + token);
		
		// send request to access token based API
		System.out.println("-------------------------------------------------------------");
		Response actResp = given().auth().oauth2(token.toString())
						   .when().post("http://coop.apps.symfonycasts.com/api/1301/eggs-count");
		
		actResp.then().log().all();
	}
}
















