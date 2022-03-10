package com.rest.api;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class Testclass {
	//	@BeforeClass
	//    public  void setup() {
	//        RestAssured.baseURI = "https://reqres.in/api/";
	//    }
//	@Test
//	public void get() {
//
//		given()
//		.contentType(ContentType.JSON)
//		.when()
//		.get("users?page=2")
//		.then().statusCode(200);
//
//		Assert.assertEquals(200,"200" );
//
//	}

	@Test(enabled = false)
	public void get1() {
		baseURI="https://reqres.in/api/";
		given().get("/users?page=2").then().statusCode(200).body("data[1].first_name", equalTo("Lindsay"));
	}
	@Test(enabled = false)
	public void postdata() {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name", "nirmal");
		map.put("job", "QA");
		
		JSONObject request=new JSONObject(map);
//		request.put("name", "nirmal");
//		request.put(map, request)
		baseURI="https://reqres.in/api/";
		given().contentType(ContentType.JSON).accept(ContentType.XML).body
		(request.toJSONString()).when().post("/users").then().statusCode(201).log().all();

		
		
	}
	@Test(enabled = false)
	public void putrequest() {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name", "nirmal");
		map.put("job", "QA1");
		JSONObject request=new JSONObject(map);
		baseURI="https://reqres.in/api/";
		given().contentType(ContentType.JSON).accept(ContentType.XML).body
		(request.toJSONString()).when().put("users/2").then().statusCode(200).log().all();
		
	}
	@Test(enabled = false)
	public void deletereq() {
		baseURI="https://reqres.in/api/";
		when().delete("/users/3").then().statusCode(204);
		
	}
	@Test
	public void getrequestbydoc() {
		baseURI="https://reqres.in/api/";
		get("/users?page=2").then().statusCode(200);
	}
}
