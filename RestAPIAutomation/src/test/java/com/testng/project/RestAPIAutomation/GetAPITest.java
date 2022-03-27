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
	String firstPage = getInputResponse(1);
	String secondPage = getInputResponse(2);
	

	 Gson g = new Gson();
	 Root firstPageRoot = g.fromJson(firstPage,Root.class);
	 assertPageDetails(firstPageRoot,1);
	 Root secondPageRootObj =g.fromJson(secondPage,Root.class); 
	 assertPageDetails(secondPageRootObj,1);
	 
	 int totalDataCount = firstPageRoot.getData().size()+secondPageRootObj.getData().size();
	 Assert.assertEquals(totalDataCount,firstPageRoot.getTotal());
	 Assert.assertEquals(totalDataCount,secondPageRootObj.getTotal());

	 
	}
	
	public static String getInputResponse(int pageNumber) {
		RestAssured.baseURI="https://reqres.in/";
		return given().log().all().when().get("/api/users?page="+pageNumber)
		.then().assertThat().statusCode(200).extract().response().asString();
	}
	
	public static void assertPageDetails(Root root,int pageNumber) {
		Assert.assertEquals(root.getPage(),pageNumber);
		Assert.assertEquals(root.getData().size(),root.per_page);
	}
}
