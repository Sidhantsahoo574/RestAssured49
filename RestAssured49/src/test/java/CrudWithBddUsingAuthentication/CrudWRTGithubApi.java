package CrudWithBddUsingAuthentication;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import genericUtility.JavaLibraries;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class CrudWRTGithubApi {
	
	String nam=null;
	@Test
	public void create()
	{
		baseURI="https://api.github.com";
		
		JavaLibraries j=new JavaLibraries();
		
		HashMap map=new HashMap();
		map.put("name", "Sid"+j.getRandom());
		map.put("Designation", "Qa");
		
		Response resp = given().auth().oauth2("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").body(map).contentType(ContentType.JSON)
		
		.when().post("/user/repos");
		
		nam = resp.jsonPath().get("name");
		System.out.println(nam);
		
		resp.then().statusCode(201).time(Matchers.lessThan(3000l),TimeUnit.MILLISECONDS).contentType(ContentType.JSON).log().all();
		
	}
	
	@Test
	
	public void get()
	{
		baseURI="https://api.github.com";
		
		 given().auth().oauth2("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").pathParam("Owner", "Sidhantsahoo574").pathParam("Name", nam)
		.when().get("/repos/{Owner}/{Name}")
		.then().statusCode(200).log().all();
	}

}
