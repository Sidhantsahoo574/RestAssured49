package CrudWithBddWithRmgyantra;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteProject {
	
	@Test
	
	public void deleteProject()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
	    //Actions
		when().delete("/projects/TY_PROJ_24422")
		//Validation
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
		
	}

}
