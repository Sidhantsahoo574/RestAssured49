package CrudWithBddWithRmgyantraUsingPojoClass;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojo.CreatePojoWithRmgYantra;

public class CreateProject {
	
	@Test
	
	public void createProject()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		//Creating Pojo class Object
		CreatePojoWithRmgYantra cp=new CreatePojoWithRmgYantra("Sam", "OnTimeLitePro", "On Going", 12);
		
		//Pre-Condition
		 given()
		.body(cp)
		.contentType(ContentType.JSON)
		
		//Actions
		.when()
		.post("/addProject")
		
		//Validation
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}

}
