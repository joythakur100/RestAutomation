package pratice.rest.assured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchData {

	@Test
	
	public void getDataFromApi()
	{
		Response resp = RestAssured.get("http://localhost:3000/posts");
		
		int statusCode = resp.getStatusCode();
		System.out.println("status code is : " + statusCode);
		
		String contentType = resp.getContentType();
		System.out.println("content Type is : " + contentType);
		
		String completeResponse = resp.asString();
		System.out.println("Actual Content is : " + completeResponse);
	}
}












