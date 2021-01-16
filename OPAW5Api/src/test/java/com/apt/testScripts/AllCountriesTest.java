package com.apt.testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.genericLib.ConfigAPI;

import io.restassured.response.Response;

public class AllCountriesTest extends ConfigAPI{
	
	@Test
	public void getAllCountries() throws IOException
	{
		String apiData = getApiData("fetchAllCountries");
		Response resp = executeRequest(apiData);
		
		resp.then().assertThat().statusCode(200)
		.and().log().all();
	}
}
