package com.apt.testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.genericLib.ConfigAPI;

import io.restassured.response.Response;

public class CheckAllCountriesTest extends ConfigAPI{

	@Test
	public void checkCountriesWithBaseURI() throws IOException
	{
		String apiData = getApiData("fetchAllCountriesByBaseURI");
		Response resp = executeRequest(apiData);
		
		resp.then().assertThat().statusCode(200)
		.and().log().all();
	}
}
