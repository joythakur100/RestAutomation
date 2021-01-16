package com.apt.testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.genericLib.ConfigAPI;

import io.restassured.response.Response;

public class ReuiredPostTest extends ConfigAPI{

	@Test
	public void getReuiredPosts() throws IOException
	{
		String apiData = getApiData("fetchRequiredPosts");
		Response resp = executeRequestWithParam(apiData);
		
		resp.then().assertThat().statusCode(200)
		.and().log().all();
	}
}
















