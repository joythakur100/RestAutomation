package com.apt.testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.genericLib.ConfigAPI;

import io.restassured.response.Response;

public class CreateNewBulkTest extends ConfigAPI{
	@Test
	public void checkNewBulkData() throws IOException
	{
		String apiData = getApiData("createBulkData");
		Response resp = executeBulkPostRequest(apiData);
		
		resp.then().assertThat().statusCode(201)
		.and().log().all();
	}
}
