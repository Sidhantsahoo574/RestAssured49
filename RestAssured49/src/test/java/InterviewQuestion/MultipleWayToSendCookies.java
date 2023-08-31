package InterviewQuestion;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import  io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Cookie;
import io.restassured.http.Cookie.Builder;
import io.restassured.specification.RequestSpecification;

public class MultipleWayToSendCookies {

	@Test
	public void firstWay()
	{
		//Using cookie() method
		RestAssured.given()
		.cookie("sessionId","abc123")
		.cookie("authToken","xyz987")
		.get("/endpoint");
	}
	
	@Test
	public void secondWay()//send multiple cookies at time 
	{
		//using cookies() method with a map
		Map<String, String> cookiesMap=new HashMap<String, String>();
		cookiesMap.put("sessionId", "abc123");
		cookiesMap.put("authToken", "xyz987");
		RestAssured.given()
		.cookies(cookiesMap)
		.get("/endpoint");
	}
	
	@Test
	public void thirdWay()
	{
		RestAssured.baseURI="https://reqres.in/";
		Cookie myCookie=new Cookie.Builder("session_id","12345")
				.setSecured(true)
				.setComment("session id cookies")
				.build();
		RestAssured.given().cookie(myCookie)
		.when().get("api/users/2")
		.then().statusCode(200);
	}
	
	@Test
	public void fourthWay()
	{
	    RequestSpecification reqstSpec = new RequestSpecBuilder()
	    		.addCookie("sessionId", "abc123")
	    		.addCookie("authToken", "xyz987")
	    		.build();
	    
	    RestAssured.given()
	    .spec(reqstSpec)
	    .get("/endpoint");
	}
}
