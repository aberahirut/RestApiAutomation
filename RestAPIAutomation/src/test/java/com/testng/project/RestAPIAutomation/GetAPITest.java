package com.testng.project.RestAPIAutomation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import com.google.gson.Gson;
public class GetAPITest {

	public static void main(String[] args) {
	int pageNo = 2;
	RestAssured.baseURI="https://reqres.in/";
	String responseStr = given().log().all().when().get("/api/users?page="+pageNo)
	.then().assertThat().statusCode(200).extract().response().asString();
	System.out.println(responseStr);
	
	//JSONObject json = new JSONObject(responseStr);
	/*JsonPath parser = new JsonPath(responseStr);  
	System.out.println(parser.toString());*/
	 Gson g = new Gson();
	 Root root = g.fromJson(responseStr,Root.class);
	 
	Assert.assertEquals(root.getPage(),pageNo);
	Assert.assertEquals(root.getData().size(),root.per_page);
	 
	}
	
}
