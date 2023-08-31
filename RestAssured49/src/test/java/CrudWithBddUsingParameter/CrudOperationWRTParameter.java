package CrudWithBddUsingParameter;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojo.CreatePojoWithRmgYantra;

public class CrudOperationWRTParameter {
	
	@Test
	
	public void createProj()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		CreatePojoWithRmgYantra cp=new CreatePojoWithRmgYantra("Asley", "TrackOnn", "Completed", 10);
		
		//Precondition
		given().body(cp).contentType(ContentType.JSON)
		//Actions
		.when().post("/addProject")
		//Validation
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}
	
	@Test
	public void getProj()
	{
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given().pathParam("pid", "TY_PROJ_24686")
		
		.when().get("/projects/{pid}")
		
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
	}
	
	@Test
	public void updateProject()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		CreatePojoWithRmgYantra cp=new CreatePojoWithRmgYantra("Asley", "TrackOnLite", "Completed", 10);
		
		given().body(cp).contentType(ContentType.JSON).pathParam("pid", "TY_PROJ_24686")
		
		.when().put("/projects/{pid}")
		
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();	
	}
	@Test
	public void deleteProj()
	{
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given().pathParam("pid", "TY_PROJ_24686")
		
		.when().delete("/projects/{pid}")
		
		.then().assertThat().statusCode(204).log().all();
	}
	
	@Test
	public void getProj2()
	{
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given().queryParam("pid", "TY_PROJ_24686")
		
		.when().get("/projects")
		
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
	}
	
	
}
