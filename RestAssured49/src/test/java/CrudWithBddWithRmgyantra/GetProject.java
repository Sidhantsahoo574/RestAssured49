package CrudWithBddWithRmgyantra;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetProject {
	
	@Test
	
	public void getProject()
	{
	   baseURI="http://rmgtestingserver";
	   port=8084;
		
		//Actions
	    when().get("/projects/TY_PROJ_24422")
	   //validation
	   .then()
	   .assertThat()
	   .statusCode(200)
	   .contentType(ContentType.JSON)
	   .log().all();
	}

}
