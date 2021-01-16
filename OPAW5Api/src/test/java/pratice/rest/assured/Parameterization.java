package pratice.rest.assured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Parameterization {

	@Test
	public void checkAllPosts()
	{
		Response resp = given().param("userId" , "3")
						.when().get("https://jsonplaceholder.typicode.com/posts");
		
		resp.then().log().all();
	}
}
