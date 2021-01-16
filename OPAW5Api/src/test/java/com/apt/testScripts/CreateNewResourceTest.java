package com.apt.testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.genericLib.ConfigAPI;

import io.restassured.response.Response;

public class CreateNewResourceTest extends ConfigAPI{

	@Test
	public void checkNewData() throws IOException
	{
		String apiData = getApiData("createNewData");
		Response resp = executeRequest(apiData);
		
		resp.then().assertThat().statusCode(201)
		.and().log().all();
	}
}














