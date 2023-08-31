package CrudWithBddWithRmgyantraUsingPojoClass;

import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteProject {
	
	@Test
	
	public void deleteProject()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		//Actions
		when().delete("/projects/TY_PROJ_24489")
		//Validation
		.then().assertThat().statusCode(204).contentType(ContentType.JSON).log().all();
	}

}
