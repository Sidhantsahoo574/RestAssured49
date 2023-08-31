package CrudWithBddUsingAuthentication;

import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;

import genericUtility.JavaLibraries;
import io.restassured.http.ContentType;
import pojo.CreatePojoWithRmgYantra;

public class CrudOperationsWRTRmgYantra {
	
	@Test
	
	public void authentication()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given().auth().basic("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().statusCode(202).log().all();
	}
	
	@Test
	public void preemptiveAuth()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given().auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().statusCode(202).log().all();
	}
	
	@Test
	public void digestAuth()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		 given().auth().digest("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().statusCode(202).log().all();
	}
	
	

}
