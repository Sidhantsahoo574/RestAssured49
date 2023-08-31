package CrudWithBddWithRmgyantraUsingPojoClass;

import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojo.CreatePojoWithRmgYantra;

public class UpdateProject {
	
	@Test
	
	public void updateProject()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		CreatePojoWithRmgYantra cp=new CreatePojoWithRmgYantra("RyanGosling", "Rider", "Completed", 8);
		
		//Pre-condition
		given()
		.body(cp)
		.contentType(ContentType.JSON)
		
		//Actions
		.when()
		.put("/projects/TY_PROJ_24635")
		
		//Validation
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}

}
