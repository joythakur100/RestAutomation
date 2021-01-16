package com.api.genericLib;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeSuite;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ConfigAPI {

	String [] kvData;
	
	@BeforeSuite
	public void configBeforeSuite()
	{
		baseURI = "https://restcountries.eu/";
	}
	
	
	public String getApiData(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/ApiData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		return pobj.getProperty(key);
	}
	
	public Response executeRequestWithParam(String apiData)
	{
		String[] testData = apiData.split(";");
		Response resp = null;
		if(testData[0].equals("get"))
		{
			ArrayList<String> kvData = dataSplitter(testData[2]);
			resp = given()
			.param(kvData.get(0), kvData.get(1))
			.param(kvData.get(2), kvData.get(3))
			.when().get(testData[1]);
			
		}
		else if(testData[0].equals("post"))
		{
			ArrayList<String> kvData = dataSplitter(testData[2]);
			resp = given()
			.param(kvData.get(0), kvData.get(1))
			.param(kvData.get(2), kvData.get(3))
			.when().post(testData[1]);
			
		}
		else if(testData[0].equals("patch"))
		{
			ArrayList<String> kvData = dataSplitter(testData[2]);
			resp = given()
			.param(kvData.get(0), kvData.get(1))
			.param(kvData.get(2), kvData.get(3))
			.when().patch(testData[1]);
			
		}
		else if(testData[0].equals("put"))
		{
			ArrayList<String> kvData = dataSplitter(testData[2]);
			resp = given()
			.param(kvData.get(0), kvData.get(1))
			.param(kvData.get(2), kvData.get(3))
			.when().put(testData[1]);
			
		}
		else if(testData[0].equals("delete"))
		{
			ArrayList<String> kvData = dataSplitter(testData[2]);
			resp = given()
			.param(kvData.get(0), kvData.get(1))
			.param(kvData.get(2), kvData.get(3))
			.when().delete(testData[1]);
			
		}
		return resp;
	}
	
	public Response executeRequest(String apiData)
	{
		String[] testData = apiData.split(";");
		Response resp = null;
		if(testData[0].equals("get"))
		{
			resp = get(testData[1]);
		}
		else if(testData[0].equals("post"))
		{
			resp = given().body(createJsonObject(testData[2])).contentType(ContentType.JSON)
					.when().post(testData[1]);
		}
		else if(testData[0].equals("put"))
		{
			resp = given().body(createJsonObject(testData[2])).contentType(ContentType.JSON)
					.when().put(testData[1]);
		}
		else if(testData[0].equals("patch"))
		{
			resp = given().body(createJsonObject(testData[2])).contentType(ContentType.JSON)
					.when().patch(testData[1]);
		}
		else if(testData[0].equals("delete"))
		{
			resp = delete(testData[1]);
		}
		return resp;
	}

	public Response executeBulkPostRequest(String apiData)
	{
		String[] testData = apiData.split(";");
		Response resp = null;
		if(testData[0].equals("post"))
		{
			File data = new File(testData[2]);
			
			 resp = given().body(data).contentType(ContentType.JSON)
			.when().post(testData[1]);
		}
		return resp;
	}
	
	public ArrayList<String> dataSplitter(String testData) {
		String[] data = testData.split(",");
		ArrayList<String> l = new  ArrayList<String>();
		LinkedHashMap m = new LinkedHashMap();
		
		for(int i = 0 ; i < data.length ; i++)
		{
			String[] kvPair = data[i].split(":");
			m.put(kvPair[0], kvPair[1]);
		}
		Set es = m.entrySet();
		Iterator itr = es.iterator();
		while(itr.hasNext())
		{
			Object entry = itr.next();
			Map.Entry me = (Map.Entry)entry;
			l.add(me.getKey().toString());
			l.add(me.getValue().toString());
		}
	
		return l;
	}
	
	public String createJsonObject(String jsonData)
	{
		String[] data = jsonData.split(",");
		JSONObject jobj = new JSONObject();
		
		for(int i = 0 ; i < data.length ; i++)
		{
			String[] kvPair = data[i].split(":");
			jobj.put(kvPair[0], kvPair[1]);
		}
		
		return jobj.toJSONString();
	}
}


















